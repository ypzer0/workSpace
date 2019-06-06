package com.platform.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
/*
 * 添加对 Quartz 的监听
 */
public class QuartzContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
        Logger logger = LoggerFactory.getLogger(getClass());  
        logger.info("QuartzContextListener   is initializing");  
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
        WebApplicationContext webApplicationContext = (WebApplicationContext) arg0    
                .getServletContext()    
                .getAttribute(    
                        WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);    
        org.quartz.impl.StdScheduler schedulerFactoryBean = (org.quartz.impl.StdScheduler) webApplicationContext    
                .getBean("scheduler");//配置文件里配置的quartz的beanId   
        if(schedulerFactoryBean != null) {    
            schedulerFactoryBean.shutdown();    
        }    
        try {    
            Thread.sleep(5000);//主线程暂停一定时间让quartz schedular执行shutdown    
        } catch (InterruptedException e) {    
            e.printStackTrace();    
        }  
		
	}

}
