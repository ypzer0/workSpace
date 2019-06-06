package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.util.StringUtil;
import com.platform.dao.SysOperLogDao;
import com.platform.entity.SysOperLogEntity;
import com.platform.service.SysOperLogService;
import com.platform.utils.Constant.OperLogFlag;

/**
 * 系统操作日志Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-15 14:53:46
 */
@Service("sysOperLogService")
public class SysOperLogServiceImpl implements SysOperLogService {
    @Autowired
    private SysOperLogDao sysOperLogDao;

    @Override
    public SysOperLogEntity queryObject(Long id) {
        return sysOperLogDao.queryObject(id);
    }

    @Override
    public List<SysOperLogEntity> queryList(Map<String, Object> map) {
        return sysOperLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysOperLogDao.queryTotal(map);
    }

    @Override
    public int save(SysOperLogEntity sysOperLog) {
        return sysOperLogDao.save(sysOperLog);
    }

    @Override
    public int update(SysOperLogEntity sysOperLog) {
        return sysOperLogDao.update(sysOperLog);
    }

    @Override
    public int delete(Long id) {
        return sysOperLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        return sysOperLogDao.deleteBatch(ids);
    }
    

    /**
     * 添加操作日志
     */
    @Override
    public void AddOperLog(String operName, String title, String params, OperLogFlag operFlag, int operuid) {

    	if(StringUtil.isEmpty(title)) {
    		StackTraceElement[] eles = new Exception().getStackTrace();
    		title = eles[10].getMethodName();
    	}
    	
    	SysOperLogEntity sysOperLog = new SysOperLogEntity();
    	sysOperLog.setCreateDate(new Date());
    	sysOperLog.setFlag(operFlag.getValue());
    	sysOperLog.setHid(operuid);
    	sysOperLog.setName(operName);
    	sysOperLog.setParams(params);
    	sysOperLog.setTitle(title);
    	
    	sysOperLogDao.save(sysOperLog);
    }
    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    @Override
    public void AddOperLog(String operName, String params, OperLogFlag operFlag, int operuid) {
    	AddOperLog(operName, "", params, operFlag, operuid);
    }
    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    @Override
    public void AddOperLog(String operName, StringBuffer params, OperLogFlag operFlag, int operuid) {
    	AddOperLog(operName, "", params.toString(), operFlag, operuid);
    }
    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    @Override
    public void AddOperLog(String operName, List list, OperLogFlag operFlag, int operuid) {
    	StringBuffer sff = new StringBuffer();
    	for (Object object : list) {
    		sff.append(object);
		}
    	AddOperLog(operName, "", sff.toString(), operFlag, operuid);
    }

    /**
     * 添加操作日志
     * @param operName 操作名称
     * @param title 标题
     * @param operFlag 标识
     */
    @Override
    public void AddOperLog_Obj(String operName, Object obj, OperLogFlag operFlag, int operuid) {
    	AddOperLog(operName, "", obj.toString(), operFlag, operuid);
    }

    /**
     * 查询最后几条log日志
     *
     * @param ct
     */

    @Override
    public List<SysOperLogEntity> queryLastLog(Integer ct){
    	return sysOperLogDao.queryLastLog(ct);
    }
    
}
