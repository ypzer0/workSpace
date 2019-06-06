package com.platform.service;

import com.platform.entity.ZdEptOrderEdayEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
public interface ZdEptOrderEdayService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ZdEptOrderEdayEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ZdEptOrderEdayEntity> queryList(Map<String, Object> map);

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
     * @param ZdeptOrderEday 实体
     * @return 保存条数
     */
    int save(ZdEptOrderEdayEntity ZdeptOrderEday);

    /**
     * 根据主键更新实体
     *
     * @param ZdeptOrderEday 实体
     * @return 更新条数
     */
    int update(ZdEptOrderEdayEntity ZdeptOrderEday);

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
     * 更新近期订单报表
     *
     * @param btime
     * @return 开始时间
     */
    int updateRptOrder(String btime);
}
