package com.platform.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.platform.entity.SysUserEntity;
import com.platform.service.SysUserService;
import com.platform.service.ZdEptOrderEdayService;
import com.platform.service.ZdOrderService;


/**
 * 
 * <p>
 * 订单自动 任务
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019年2月15日 下午1:33
 */
@Component("OrderTask")
public class OrderTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ZdEptOrderEdayService eptOrderEdayService;
    @Autowired
    private ZdOrderService orderService;
    /*
     * 近期下单统计报表
     * */
    public void updateOrderReleaseRpt() {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String nowDateStr = sdf.format(new Date());
        int rt = eptOrderEdayService.updateRptOrder(nowDateStr);

        logger.info("执行结果返回：" + rt);
        
    }

    /*
     * 超过24h没有支付的订单进行关闭
     * */
    public void orderClose24h() {
    	
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	String nowDateStr = sdf.format(new Date());
        int rt = orderService.orderClose24h();
        logger.info("执行结果返回：" + rt);
    }
    
    
//    public void orderClose7d() {
//
//        int rt = orderService.orderClose7d();
//        logger.info("执行结果返回：" + rt);
//    }
//    
//    public void orderFinish1h() {
//    	
//    	int rt = orderService.orderFinish1h();
//    	logger.info("执行结果返回：" + rt);
//    }
    
    
}
