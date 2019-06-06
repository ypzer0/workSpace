package com.platform.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.dao.OrderAskDao;
import com.platform.dto.HandlerOAskPDto;
import com.platform.entity.OrderAskEntity;
import com.platform.entity.OrderAskLogEntity;
import com.platform.entity.OrderAskMsgEntity;
import com.platform.entity.SysUserEntity;
import com.platform.entity.WalletInfoEntity;
import com.platform.entity.WalletInfoLogEntity;
import com.platform.service.OrderAskLogService;
import com.platform.service.OrderAskMsgService;
import com.platform.service.OrderAskService;
import com.platform.service.WalletInfoLogService;
import com.platform.service.WalletInfoService;
import com.platform.util.wechat.WechatRefundApiResult;
import com.platform.util.wechat.WechatUtil;
import com.platform.utils.DateUtils;
import com.platform.utils.R;
import com.platform.utils.RRException;
import com.platform.utils.StringUtils;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
@Service("orderAskService")
public class OrderAskServiceImpl implements OrderAskService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderAskDao orderAskDao;

    @Autowired
    private OrderAskMsgService orderAskMsgService;

    @Autowired
    private OrderAskLogService orderAskLogService;
    
    @Autowired
    private WalletInfoService walletInfoService;
    
    @Autowired
    private WalletInfoLogService walletInfoLogService;

    @Override
    public OrderAskEntity queryObject(Integer id) {
        return orderAskDao.queryObject(id);
    }

    @Override
    public List<OrderAskEntity> queryList(Map<String, Object> map) {
        return orderAskDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderAskDao.queryTotal(map);
    }

    @Override
    public int save(OrderAskEntity orderAsk) {
        return orderAskDao.save(orderAsk);
    }

    @Override
    public int update(OrderAskEntity orderAsk) {
        return orderAskDao.update(orderAsk);
    }

    @Override
    public int delete(Integer id) {
        return orderAskDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return orderAskDao.deleteBatch(ids);
    }
    
    
    /**
     * 处理申请
     * @param para
     * @return
     */

    @Override
    @Transactional
    public R handler(HandlerOAskPDto para, SysUserEntity sysUser) {

    	if(para.getId() == null || para.getId() <= 0)
    		return R.error("数据异常！");
    	if(StringUtils.isNullOrEmpty(para.getOtype()) || StringUtils.isNullOrEmpty(para.getOtype().trim())) {
    		return R.error("未知操作类型！");
    	}
    	if(StringUtils.isNullOrEmpty(para.getMsg()) || StringUtils.isNullOrEmpty(para.getMsg().trim())) {
    		return R.error("回复不能为空！");
    	}

    	OrderAskEntity dt = orderAskDao.queryObject(para.getId());
    	if(dt == null) {
    		return R.error("数据异常！");
    	}
    	
    	//非admin验证
    	if(!sysUser.getUsername().equals("admin")) {
	    	//判断是否为同一个人回复消息
	    	if(!sysUser.getUserId().equals(dt.getHanderId().longValue())) {
	    		logger.info(sysUser.getUsername() + " --" + sysUser.getUserId() + " 操作回复 " 
	    	+ dt.getHanderName() + " --" + dt.getHanderId() + " 的消息");
	    		return R.error("非同系统用户操作消息，操作将被报告！");
	    	}
    	}
    	
    	
    	dt.setUtime(new Date());
    	Integer oldStatus = dt.getStatus();
    	
    	if(para.getOtype().equals("pass")) {
    		//通过
			if(dt.getStatus() == null || dt.getStatus() != 2) {
	    		return R.error("你还未提交申请！");
			}
	    	dt.setStatus(3);

	    	Map<String, Object> mapOrder = orderAskDao.getOrder(dt.getOrderSn());
	    	
	    	if(mapOrder == null) {
	    		return R.error("订单异常不能退款！");
	    	}
	    	
        	Integer uId = Integer.parseInt(mapOrder.getOrDefault("user_id", -1).toString());
        	if(uId != dt.getUid()) {
	    		return R.error("订单异常不能退款！");
        	}
	    	
	    	Integer orderStatus = Integer.parseInt(mapOrder.getOrDefault("order_status", -1).toString());
	    	Integer orderId = Integer.parseInt(mapOrder.getOrDefault("id", -1).toString());
        	Double price = Double.parseDouble(mapOrder.getOrDefault("actual_price", 0).toString());
        	Double orderPrice = Double.parseDouble(mapOrder.getOrDefault("order_price", 0).toString());
        	
        	if(orderStatus != 403) {
	    		return R.error("订单未申请退款！");
        	}
        	if(orderId <= 0) {
	    		return R.error("订单异常！");
        	}
        	price = Math.abs(price);
        	orderPrice = Math.abs(orderPrice);

        	Integer endOrderStatus = 0;
        	Integer endPayStatus = 4;
        	
//	    	//退款处理
            WechatRefundApiResult result = new WechatRefundApiResult();
            //WechatUtil.wxRefund(dt.getOrderSn(), orderPrice, price);
            result.setResult_code("SUCCESS");
            result.setOut_trade_no("123123981289");
            
            if (result.getResult_code().equals("SUCCESS")) {
                if (dt.getOrderStatus() == 201) {
                	endOrderStatus = 401;
                } else if (dt.getOrderStatus() == 300 || dt.getOrderStatus() == 301) {
                	endOrderStatus = 402;
                }
                endPayStatus = 4;
                
                //更新订单状态
                Map<String, Object> maplist = new HashMap<>();
                maplist.put("orderStatus", endOrderStatus);
                maplist.put("payStatus", endPayStatus);
                maplist.put("orderSn", dt.getOrderSn());
                orderAskDao.updateOrderStatus(maplist);
                
                //写入资金流水
                //插入流水信息  zy 2019-03-05
                WalletInfoEntity walletInfo = new WalletInfoEntity();
                walletInfo.setUid(dt.getUid().longValue());
                walletInfo.setMoney(new BigDecimal(price));
                walletInfo.setWtype1(2);
                walletInfo.setWtype2(4);
                walletInfo.setOrderSn(dt.getOrderSn());
                walletInfo.setCouponId(0);
                walletInfo.setTransactionId(result.getOut_trade_no());
                walletInfo.setOutTradeNo(result.getOut_trade_no());
                walletInfo.setActivityId("");
                walletInfo.setCtime(new Date());
                
                walletInfoService.save(walletInfo);

                WalletInfoLogEntity walletInfoLog = new WalletInfoLogEntity();
                walletInfoLog.setContent("用户:" + dt.getUName() + " 申请退款通过：" + price );
                walletInfoLog.setCtime(new Date());
                walletInfoLog.setMoney(new BigDecimal(price));
                walletInfoLog.setWtype1(walletInfo.getWtype1());
                walletInfoLog.setWtype2(walletInfo.getWtype2());
                walletInfoLog.setTitle(walletInfoLog.getWtype2Str() + " " + walletInfoLog.getWtype1Str());
                walletInfoLog.setUid(walletInfo.getUid().intValue());
                walletInfoLog.setWid(walletInfo.getId());
                
                walletInfoLogService.save(walletInfoLog);
                
            } else {
            	logger.info("调用支付接口失败：" + result.toString());
	    		return R.error("调用退款接口失败！");
            }
    		
    	}else if(para.getOtype().equals("refuse")) {
			//拒绝
			if(dt.getStatus() == null || dt.getStatus() != 2) {
	    		return R.error("你还未提交申请！");
			}

	    	dt.setStatus(4);
        		
    	}else if(para.getOtype().equals("close")) {
			//关闭
	    	dt.setStatus(5);
    		
    	}
    	else {
    		return R.error("unknow type！");
    	}
    	
    	orderAskDao.update(dt);
    	
    	// 写入操作日志
		OrderAskLogEntity olog = new OrderAskLogEntity();
		olog.setCtime(new Date());
		olog.setHanderId(Integer.parseInt(sysUser.getUserId()+""));
		olog.setHanderName(sysUser.getUsername());
		olog.setMsg(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " "
		+ sysUser.getUsername() + " 操作 :" + OrderAskEntity.getStatusNameById(oldStatus)
		+ " --> " + OrderAskEntity.getStatusNameById(dt.getStatus()) + " ");
		olog.setUid(dt.getUid());
		olog.setUName(dt.getUName());
		
		orderAskLogService.save(olog);
		
    	//写入消息表
		OrderAskMsgEntity oame = new OrderAskMsgEntity();
		oame.setAskid(dt.getId());
		oame.setCtime(new Date());
		oame.setHanderId(Integer.parseInt(sysUser.getUserId()+""));
		oame.setHanderName(sysUser.getUsername());
		oame.setMsg(para.getMsg());
		oame.setStatus(1);
		
		oame.setMsgType(1);
		oame.setMsgWay(2);
		oame.setReadStatus(0);
		
		oame.setUid(dt.getUid());
		oame.setUName(dt.getUName());
		
		orderAskMsgService.save(oame);

		//清空消息未读状态
		if(para.getClean() != null && para.getClean() == 1) {
			orderAskMsgService.cleanNotRead(sysUser.getUserId(), dt.getUid().longValue());
		}
		
    	return R.ok();
    	
    }
    

    /**
     * 发送消息
     * @param para
     * @return
     */
    @Transactional
    public R sendmsg(HandlerOAskPDto para, SysUserEntity sysUser) {

    	if(para.getId() == null || para.getId() <= 0)
    		return R.error("数据异常！");
    	if(StringUtils.isNullOrEmpty(para.getMsg()) || StringUtils.isNullOrEmpty(para.getMsg().trim())) {
    		return R.error("回复不能为空！");
    	}

    	OrderAskEntity dt = orderAskDao.queryObject(para.getId());
    	if(dt == null) {
    		return R.error("数据异常！");
    	}

    	//判断是否为同一个人回复消息
    	if(!sysUser.getUserId().equals(dt.getHanderId().longValue())) {
    		logger.info(sysUser.getUsername() + " --" + sysUser.getUserId() + " 操作回复 " 
    	+ dt.getHanderName() + " --" + dt.getHanderId() + " 的消息");
    		return R.error("非同用户操作消息，操作将被报告！");
    	}
    	
    	// 写入操作日志
		OrderAskLogEntity olog = new OrderAskLogEntity();
		olog.setCtime(new Date());
		olog.setHanderId(Integer.parseInt(sysUser.getUserId()+""));
		olog.setHanderName(sysUser.getUsername());
		olog.setMsg(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " "
		+ sysUser.getUsername() + "操作 给" + dt.getUName() + "回复消息");
		olog.setUid(dt.getUid());
		olog.setUName(dt.getUName());
		
		orderAskLogService.save(olog);
		
    	//写入消息表
		OrderAskMsgEntity oame = new OrderAskMsgEntity();
		oame.setAskid(dt.getId());
		oame.setCtime(new Date());
		oame.setHanderId(Integer.parseInt(sysUser.getUserId()+""));
		oame.setHanderName(sysUser.getUsername());
		oame.setMsg(para.getMsg());
		oame.setStatus(1);

		oame.setMsgType(1);
		oame.setMsgWay(2);
		oame.setReadStatus(0);
		
		oame.setUid(dt.getUid());
		oame.setUName(dt.getUName());
		
		orderAskMsgService.save(oame);
		
		
		//清空消息未读状态
		if(para.getClean() != null && para.getClean() == 1) {
			logger.info("准备清空！");
			orderAskMsgService.cleanNotRead(sysUser.getUserId(), dt.getUid().longValue());
			logger.info("准备清空！");
		}
    	
    	return R.ok();
    }

    /**
     * 获取订单信息
     * @param para
     * @return
     */
    public R getOrder(String orderSn) {
    	Map<String, Object> mapOrder = orderAskDao.getOrder(orderSn);
    	return R.okData(mapOrder);
    }

    /**
     * 获取订单信息
     * @param para
     * @return
     */
    public R updateOrderStatus(Map<String, Object> paras) {
    	int rt = orderAskDao.updateOrderStatus(paras);
    	return R.okData(rt);
    }
}
