package com.platform.service;

import com.platform.entity.ZdDoctorEntity;
import com.platform.utils.R;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 15:08:05
 */
public interface ZdDoctorService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ZdDoctorEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ZdDoctorEntity> queryList(Map<String, Object> map);

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
     * @param Zddoctor 实体
     * @return 保存条数
     */
    R save(ZdDoctorEntity Zddoctor);

    /**
     * 根据主键更新实体
     *
     * @param Zddoctor 实体
     * @return 更新条数
     */
    int update(ZdDoctorEntity Zddoctor);

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
     * 选择科室集合
     * @return 科室集合
     */
    R selectDepartment();
}
