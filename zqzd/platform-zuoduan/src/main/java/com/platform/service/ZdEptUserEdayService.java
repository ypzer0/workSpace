package com.platform.service;

import com.platform.entity.ZdEptUserEdayEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
public interface ZdEptUserEdayService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ZdEptUserEdayEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ZdEptUserEdayEntity> queryList(Map<String, Object> map);

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
     * @param ZdeptUserEday 实体
     * @return 保存条数
     */
    int save(ZdEptUserEdayEntity ZdeptUserEday);

    /**
     * 根据主键更新实体
     *
     * @param ZdeptUserEday 实体
     * @return 更新条数
     */
    int update(ZdEptUserEdayEntity ZdeptUserEday);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
    
    /**
     * 更新用户相关统计信息
     *
     * @param btime
     * @return 开始时间格式: 2019-2-15
     */
    int updateRptCustomer(String btime);
}
