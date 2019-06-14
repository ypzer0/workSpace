package com.platform.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdGoodsInfoMapper;
import com.platform.dao.ApiZdOrderMapper;
import com.platform.dao.ApiZdUserMapper;
import com.platform.entity.PayLogEntity;
import com.platform.entity.ZdGoodsInfoVo;
import com.platform.entity.ZdOrderVo;
import com.platform.entity.ZdUserVo;
import com.platform.util.wechat.MD5;
import com.platform.util.wechat.WechatRefundApiResult;
import com.platform.util.wechat.WechatUtil;
import com.platform.utils.CharUtil;
import com.platform.utils.MapUtils;
import com.platform.utils.ResourceUtil;
import com.platform.utils.Rp;
import com.platform.utils.WeiXinUtil;
import com.platform.utils.XmlUtil;

@Service
public class ApiZdPayService {
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ApiZdOrderMapper apiZdOrderMapper;
	@Autowired
	private ApiZdUserMapper apiZdUserMapper;
	@Autowired
	private PayLogService payLogService;
	@Autowired
	private ApiZdGoodsInfoMapper apiZdGoodsInfoMapper;

	public Rp payMoney(ZdUserVo nowUser, Integer oid, String ip) {
		if (oid == null || oid <= 0) {
			return Rp.error("支付失败!!");
		}
		if (ResourceUtil.getConfigByName("sys.demo").equals("1")) {
			return payMoney_WeiXin_Test(nowUser, oid, ip);
		}

		ZdUserVo user = apiZdUserMapper.queryObject(nowUser.getId());

		ZdOrderVo orderInfo = apiZdOrderMapper.queryObject(oid);
		if (null == orderInfo) {
			return Rp.error("订单已经取消！");
		}

		if (!(orderInfo.getOrderStatus() == 0 || orderInfo.getOrderStatus() == 2)) {
            return Rp.error("订单已经取消！");
		}

//        String nonceStr = CharUtil.getRandomString(32);
		// https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=7_7&index=3

		int pay_money = 0;
		int pay_status = 2;
		// 申请支付日志
		PayLogEntity payLog = new PayLogEntity();
		payLog.setCtime(new Date());
		payLog.setIp(ip);
		payLog.setOId(orderInfo.getId());
		payLog.setOrderNo(orderInfo.getOrderSn());
		payLog.setPayType(11);
		payLog.setTraType(1);
		payLog.setUId(user.getId());
		payLog.setUName(user.getNickname());

		try {

			Map<Object, Object> param = new TreeMap<Object, Object>();

            param.put("appid", WeiXinUtil.getAppId(2));
			// 商家账号。
            param.put("mch_id", WeiXinUtil.getMchId(2));
			
			String randomStr = CharUtil.getRandomNum(18).toUpperCase();
			// 随机字符串
            param.put("nonce_str", randomStr);
			// 商品描述
            param.put("body", "商城支付");

			logger.info("开始获取商品");
			// 订单的商品
			List<ZdGoodsInfoVo> orderGoods = apiZdGoodsInfoMapper.queryGoodsByOId(oid, user.getId());
			if (orderGoods.size() != 0) {
				logger.info(orderGoods.get(0).toString());
			}
			if (orderGoods != null && orderGoods.size() != 0) {
				String body = "卓断商城支付-";
				for (ZdGoodsInfoVo goodsVo : orderGoods) {
					body = body + goodsVo.getcName() + "、";
				}
				if (body.length() > 0) {
					body = body.substring(0, body.length() - 1);
				}
				// 商品描述
                param.put("body", body);
			}
			pay_money = orderInfo.getOrderPrice().multiply(new BigDecimal(100)).intValue();
			// 支付金额
            param.put("total_fee", pay_money);

			// 商户订单编号
            param.put("out_trade_no", orderInfo.getOrderSn());
			// 回调地址
            param.put("notify_url", WeiXinUtil.getNotifyUrl(2));
			// 交易类型APP
            param.put("trade_type", WeiXinUtil.getTradeType(2));

            param.put("spbill_create_ip", ip);
			// openId
            param.put("openid", user.getWeixinOpenid());

			String sign = WechatUtil.arraySign(param, WeiXinUtil.getPaySignKey(2));
			// 数字签证
            param.put("sign", sign);

			String xml = MapUtils.convertMap2Xml(param);
			logger.info("xml:" + xml);
			String rtXml = WechatUtil.requestOnceCoupon(WeiXinUtil.getUniformorder(2), xml, 2);
			logger.info("rtxml:" + rtXml);
			Map<String, Object> resultUn = XmlUtil.xmlStrToMap(rtXml);

			String return_code = MapUtils.getString("return_code", resultUn);
			String return_msg = MapUtils.getString("return_msg", resultUn);

			if (return_code.equalsIgnoreCase("FAIL")) {
				return Rp.error("支付失败," + return_msg);
			} else if (return_code.equalsIgnoreCase("SUCCESS")) {
				pay_status = 1;
				String result_code = MapUtils.getString("result_code", resultUn);
				String err_code_des = MapUtils.getString("err_code_des", resultUn);

				if (result_code.equalsIgnoreCase("FAIL")) {
					return Rp.error("支付失败," + err_code_des);
				} else if (result_code.equalsIgnoreCase("SUCCESS")) {

					String nonce_str = CharUtil.getRandomNum(18).toUpperCase();
					String timestamp = create_timestamp();
					String prepay_id = MapUtils.getString("prepay_id", resultUn);
					String md5Pre = String.format("appId=%s&nonceStr=%s&package=%s&signType=MD5&timeStamp=%s&key=%s",
							WeiXinUtil.getAppId(2), nonce_str, "prepay_id=" + prepay_id, timestamp,
							WeiXinUtil.getPaySignKey(2));
					logger.info("组织签名参数 " + md5Pre);

					String endSing = MD5.getMessageDigest(md5Pre);
					logger.info("加密后 " + endSing);

					Map<String, String> resultObj = new HashMap<String, String>();
					resultObj.put("timestamp", timestamp);
					resultObj.put("nonceStr", nonce_str);
					resultObj.put("package", prepay_id);
					resultObj.put("signType", "MD5");
					resultObj.put("paySign", endSing);
					logger.info("最终返回参数");
					for (Map.Entry<String, String> entry : resultObj.entrySet()) {
						logger.info("Key = " + entry.getKey() + ",value=" + entry.getValue());
					}

					return Rp.ok("微信统一订单下单成功").putDt("pay", resultObj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			pay_status = 3;
			return Rp.error("微信下单失败,error=" + e.getMessage());
		} finally {
			payLog.setStatus(pay_status);
			payLog.setMoney(new BigDecimal(pay_money));
			payLogService.save(payLog);
		}
		return Rp.error("下单失败");
	}
	
	/**
	 * 微信返回支付
	 * @param request
	 * @param response
	 * @param clientIp
	 * @return
	 */
	/**
	 * @param request
	 * @param response
	 * @param clientIp
	 */
	@SuppressWarnings("unused")
	public void wxpayback(HttpServletRequest request, HttpServletResponse response, String clientIp) {

        float pay_money = 0f;
        int pay_status = 2;
        //申请支付日志
        PayLogEntity payLog = new PayLogEntity();
        payLog.setCtime(new Date());
        payLog.setIp(clientIp);
        payLog.setPayType(11);
        payLog.setTraType(2);
        
    	logger.info("微信支付响应返回");
        try {
        	
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            InputStream in = request.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.close();
            in.close();
            //xml数据
            String reponseXml = new String(out.toByteArray(), "utf-8");

        	logger.info("响应数据:" + reponseXml);
        	
            WechatRefundApiResult result = (WechatRefundApiResult) XmlUtil.xmlStrToBean(reponseXml, WechatRefundApiResult.class);
            
        	logger.info("响应数据解析:" + result.toString());
        	
            String result_code = result.getResult_code();
            if (result_code.equalsIgnoreCase("FAIL")) {
                //订单编号
                String out_trade_no = result.getOut_trade_no();

                ZdOrderVo orderInfo = apiZdOrderMapper.queryOrderByNo1(out_trade_no);
                if(orderInfo != null) {
                    payLog.setOId(orderInfo.getId());
                    payLog.setUId(orderInfo.getUserId());
                    payLog.setUName(orderInfo.getNickname());
                }
                payLog.setOrderNo(out_trade_no);
                
                logger.error("订单" + out_trade_no + "响应支付失败");

                payLog.setStatus(pay_status);
                payLog.setMoney(new BigDecimal(pay_money));
                payLogService.save(payLog);
                
                response.getWriter().write(setXml("SUCCESS", "OK"));
            } else if (result_code.equalsIgnoreCase("SUCCESS")) {
            	
                //订单编号
            	pay_status = 1;
                String out_trade_no = result.getOut_trade_no();

                payLog.setOrderNo(out_trade_no);
                pay_money = Integer.parseInt(result.getTotal_fee());
                
                logger.info("订单" + out_trade_no + "支付成功");
                // 业务处理
                ZdOrderVo orderInfo = apiZdOrderMapper.queryOrderByNo1(out_trade_no);
                
                if(orderInfo.getPayStatus() == 2) {

                    logger.info("订单已付款无需修改状态!");
                    response.getWriter().write(setXml("SUCCESS", "OK"));
                    return;
                }
                
                if(orderInfo != null) {
                    payLog.setOId(orderInfo.getId());
                    payLog.setUId(orderInfo.getUserId());
                    payLog.setUName(orderInfo.getNickname());
                }
                else {
                	logger.info("异常查找的订单失败.");
                }
                
                orderInfo.setPayStatus(1);
                orderInfo.setOrderStatus(1);
                orderInfo.setPayTime(new Date());
                apiZdOrderMapper.update(orderInfo);

                logger.info("增加资金流水信息");

                logger.info("修改支付状态");
                payLog.setStatus(pay_status);
                payLog.setMoney(new BigDecimal(pay_money));
                payLogService.save(payLog);

                logger.info("增加资金流水信息成功！");
                
                response.getWriter().write(setXml("SUCCESS", "OK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            pay_status = 3;
            logger.info("支付返回异常:");
            logger.info(e.getMessage());

            payLog.setStatus(pay_status);
            payLog.setMoney(new BigDecimal(pay_money));
            payLogService.save(payLog);
            return;
        }
        finally {
		}
		
		
		return ;
	}

	/**
	 * 内网测试支付
	 * 
	 * @return
	 */
	private Rp payMoney_WeiXin_Test(ZdUserVo nowUser, Integer oid, String ip) {

		ZdUserVo user = apiZdUserMapper.queryObject(nowUser.getId());

		ZdOrderVo orderInfo = apiZdOrderMapper.queryObject(oid);
		if (null == orderInfo) {
			return Rp.error("订单已经取消！");
		}

		Boolean isSuccess = false;

		if (orderInfo.getOrderStatus() == 0 || orderInfo.getOrderStatus() == 2) {
			isSuccess = true;
		}

		if (!isSuccess) {
			return Rp.error("订单已经取消！");
		}

		int pay_money = 0;
		int pay_status = 2;
		// 申请支付日志
		PayLogEntity payLog = new PayLogEntity();
		payLog.setCtime(new Date());
		payLog.setIp(ip);
		payLog.setOId(orderInfo.getId());
		payLog.setOrderNo(orderInfo.getOrderSn());
		payLog.setPayType(11);
		payLog.setTraType(1);
		payLog.setUId(user.getId());
		payLog.setUName(user.getNickname());

		try {

			Map<String, String> resultObj = new HashMap<String, String>();
			resultObj.put("timestamp", "");
			resultObj.put("nonceStr", "");
			resultObj.put("package", "");
			resultObj.put("signType", "");
			resultObj.put("paySign", "TestEnv");

			WechatRefundApiResult result = new WechatRefundApiResult();
			result.setResult_code("SUCCESS");
			result.setOut_trade_no(orderInfo.getOrderSn());
			result.setTotal_fee(orderInfo.getOrderPrice().intValue() + "");
			wxpaybackTest(ip, result);

			return Rp.ok("微信统一订单下单成功").putDt("pay", resultObj);
		} catch (Exception e) {
			e.printStackTrace();
			pay_status = 3;
			return Rp.error("微信下单失败,error=" + e.getMessage());
		} finally {
			payLog.setStatus(pay_status);
			payLog.setMoney(new BigDecimal(pay_money));
			payLogService.save(payLog);
		}

	}

	@SuppressWarnings("unused")
	private void wxpaybackTest(String ip, WechatRefundApiResult result) {
		float pay_money = 0f;
		int pay_status = 2;
		// 申请支付日志
		PayLogEntity payLog = new PayLogEntity();
		payLog.setCtime(new Date());
		payLog.setIp(ip);
		payLog.setPayType(11);
		payLog.setTraType(2);

		logger.info("微信支付响应返回");
		try {
//	        	WechatRefundApiResult result = new WechatRefundApiResult();

			String result_code = result.getResult_code();
			if (result_code.equalsIgnoreCase("FAIL")) {
				// 订单编号
				String out_trade_no = result.getOut_trade_no();

				ZdOrderVo orderInfo = apiZdOrderMapper.queryOrderByNo1(out_trade_no);
				if (orderInfo != null) {
					payLog.setOId(orderInfo.getId());
					payLog.setUId(orderInfo.getUserId());
					payLog.setUName(orderInfo.getNickname());
				}
				payLog.setOrderNo(out_trade_no);

				logger.error("订单" + out_trade_no + "响应支付失败");

				payLog.setStatus(pay_status);
				payLog.setMoney(new BigDecimal(pay_money));
				payLogService.save(payLog);

			} else if (result_code.equalsIgnoreCase("SUCCESS")) {

				// 订单编号
				pay_status = 1;
				String out_trade_no = result.getOut_trade_no();

				payLog.setOrderNo(out_trade_no);
				pay_money = Integer.parseInt(result.getTotal_fee());

				logger.info("订单" + out_trade_no + "支付成功");
				// 业务处理
				ZdOrderVo orderInfo = apiZdOrderMapper.queryOrderByNo1(out_trade_no);

				if (orderInfo.getPayStatus() == 2) {

					logger.info("订单已付款无需修改状态!");
					return;
				}

				if (orderInfo != null) {
					payLog.setOId(orderInfo.getId());
					payLog.setUId(orderInfo.getUserId());
					payLog.setUName(orderInfo.getNickname());
				} else {
					logger.info("异常查找的订单失败.");
				}

				orderInfo.setPayStatus(1);
				orderInfo.setOrderStatus(1);
				orderInfo.setPayTime(new Date());
				apiZdOrderMapper.update(orderInfo);

				logger.info("增加资金流水信息");

				logger.info("修改支付状态");
				payLog.setStatus(pay_status);
				payLog.setMoney(new BigDecimal(pay_money));
				payLogService.save(payLog);

				logger.info("增加资金流水信息成功！");

			}
		} catch (Exception e) {
			e.printStackTrace();
			pay_status = 3;
			logger.info("支付返回异常:");
			logger.info(e.getMessage());

			payLog.setStatus(pay_status);
			payLog.setMoney(new BigDecimal(pay_money));
			payLogService.save(payLog);
			return;
		} finally {
		}
		return;

	}
	
	private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
	
	//返回微信服务
    public String setXml(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
    }

}
