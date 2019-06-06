package com.platform.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.platform.service.ZdEptUserEdayService;



/**
 * 
 * <p>
 * 订单自动 任务
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019年2月15日 下午1:33
 */
@Component("CustomerTask")
public class CustomerTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ZdEptUserEdayService eptUserEdayService;
    /*
     * 用户信息统计
     * 统计注册情况
     * 
     * */
    public void updateCustomerMsgRpt() {

    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String nowDateStr = sdf.format(new Date());
        int rt = eptUserEdayService.updateRptCustomer(nowDateStr);

        logger.info("执行结果返回：" + rt);
        
    }
    
    
}
