package com.platform;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.platform.service.SysOperLogService;
import com.platform.utils.R;

/**
 * 基于spring的单元测试基类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-09 10:06:23
 */
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
public class BaseSpringTestCase extends AbstractJUnit4SpringContextTests {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SysOperLogService sysOperLogService;
    
    //打印最后几条数据
    public void PrintLastOperLog(Integer ct) {
    	print(sysOperLogService.queryLastLog(ct));
    }

    //打印最后一条数据
    public void PrintLastOperLog() {
    	PrintLastOperLog(1);
    }
    
    

    /**
     * 获取Logger
     */
    public Logger getLogger() {
        return logger;
    }
    

    public void printL(List rt) {
    	if(rt.size() != 0) {
    		for (Object object : rt) {
    			logger.info(object.toString());
			}
    	}
    }
    public void print(Object obj) {
    	logger.info(obj.toString());
    }
    public void printR(R rt) {
    	print(rt);
    }
    
    public void print(Map rt) {
    	Set keys = rt.keySet();
    	
		for (Object key : keys) {
			logger.info(key+"="+rt.get(key));
		}
    }
   
}
