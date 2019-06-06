package com.platform.service;

import com.platform.entity.SysOperLogEntity;
import com.platform.utils.Constant.OperLogFlag;

import java.util.List;
import java.util.Map;

/**
 * 系统操作日志Service接口
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-15 14:53:46
 */
public interface SysOperLogService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    SysOperLogEntity queryObject(Long id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<SysOperLogEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param sysOperLog 实体
     * @return 保存条数
     */
    int save(SysOperLogEntity sysOperLog);

    /**
     * 根据主键更新实体
     *
     * @param sysOperLog 实体
     * @return 更新条数
     */
    int update(SysOperLogEntity sysOperLog);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Long id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Long[] ids);
    
    
    void AddOperLog(String operName, String title, String params, OperLogFlag operFlag, int operuid);
    void AddOperLog(String operName, String params, OperLogFlag operFlag, int operuid);
    void AddOperLog(String operName, StringBuffer params, OperLogFlag operFlag, int operuid);
    void AddOperLog(String operName, List list, OperLogFlag operFlag, int operuid);
    void AddOperLog_Obj(String operName, Object obj, OperLogFlag operFlag, int operuid);
    

    /**
     * 查询最后几条log日志
     *
     * @param ct
     */
    List<SysOperLogEntity> queryLastLog(Integer ct);
    
}
