package com.platform.controller;

import com.platform.entity.SysOperLogEntity;
import com.platform.entity.SysUserEntity;
import com.platform.service.SysOperLogService;
import com.platform.utils.ShiroUtils;
import com.platform.utils.Constant.OperLogFlag;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller公共组件
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {

    @Autowired
    protected SysOperLogService sysOperLogService;
	
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }

    protected Long getDeptId() {
        return getUser().getDeptId();
    }
    
    /**
     * 添加操作日志
     */
    protected void AddOperLog(String operName, String title, String params, OperLogFlag operFlag) {
    	
    	SysOperLogEntity sysOperLog = new SysOperLogEntity();
    	sysOperLog.setCreateDate(new Date());
    	sysOperLog.setFlag(operFlag.getValue());
    	sysOperLog.setHid(getUserId().intValue());
    	sysOperLog.setName(operName);
    	sysOperLog.setParams(params);
    	sysOperLog.setTitle(title);
    	
    	sysOperLogService.save(sysOperLog);
    }
    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    protected void AddOperLog(String operName, String params, OperLogFlag operFlag) {
    	
    	AddOperLog(operName, "", params, operFlag);
    }
    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    protected void AddOperLog(String operName, StringBuffer params, OperLogFlag operFlag) {
    	
    	AddOperLog(operName, "", params.toString(), operFlag);
    }
    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    protected void AddOperLog(String operName, List list, OperLogFlag operFlag) {
    	StringBuffer sff = new StringBuffer();
    	for (Object object : list) {
    		sff.append(object);
		}
    	AddOperLog(operName, "", sff.toString(), operFlag);
    }

    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    protected void AddOperLog_Obj(String operName, Object obj, OperLogFlag operFlag) {
    	AddOperLog(operName, "", obj.toString(), operFlag);
    }
    
}
