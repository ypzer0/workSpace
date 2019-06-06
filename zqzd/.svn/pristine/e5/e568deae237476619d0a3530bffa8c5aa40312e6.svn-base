package com.platform.aop;

import com.alibaba.fastjson.JSON;
import com.platform.annotation.SysLog;
import com.platform.annotation.SysOperLog;
import com.platform.entity.SysLogEntity;
import com.platform.entity.SysOperLogEntity;
import com.platform.entity.SysUserEntity;
import com.platform.service.SysLogService;
import com.platform.service.SysOperLogService;
import com.platform.utils.HttpContextUtils;
import com.platform.utils.IPUtils;
import com.platform.utils.ShiroUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志，切面处理类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019年3月18日 上午11:07:35
 */
@Aspect
@Component
public class SysOperLogAspect {
    @Autowired
    private SysOperLogService sysOperLogService;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 切点
     */
    @Pointcut("@annotation(com.platform.annotation.SysOperLog)")
    public void operLogPointCut() {
        logger.info("operLogPointCut");
    }

    /**
     * 前置通知
     *
     * @param joinPoint 连接点
     */
    @Before("operLogPointCut()")
    public void saveSysOperLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysOperLogEntity sysOperLog = new SysOperLogEntity();
        
        SysOperLog soAno = method.getAnnotation(SysOperLog.class);
        if (soAno != null) {
            //注解上的描述
            sysOperLog.setName(soAno.value());
            sysOperLog.setFlag(soAno.flg());
        }
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysOperLog.setTitle(className + "." + methodName + "()");
        
        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);
        sysOperLog.setParams(params);

//        signature.getMethod()
        
        //获取request
//        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
//        sysOperLog.setIp(IPUtils.getIpAddr(request));

        //用户名
        SysUserEntity sysUserEntity = ShiroUtils.getUserEntity();
        Long uid = 0L;
        if ("login".equals(methodName)) {
            uid = 0L;
        }
        if (null != sysUserEntity) {
            uid = ShiroUtils.getUserEntity().getUserId();
        }
        sysOperLog.setHid(uid.intValue());

        sysOperLog.setCreateDate(new Date());
        //保存系统日志
        sysOperLogService.save(sysOperLog);
        logger.info("保存操作日志");
    }

}
