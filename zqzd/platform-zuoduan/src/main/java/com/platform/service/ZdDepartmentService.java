package com.platform.service;

import com.platform.entity.ZdDepartmentEntity;
import com.platform.utils.R;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author zy
 * @date 2019-06-01 13:14:14
 */
public interface ZdDepartmentService {
	/**
	 * 选择医院集合
	 * @return 医院集合
	 */
	R selectHospital();

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ZdDepartmentEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ZdDepartmentEntity> queryList(Map<String, Object> map);

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
     * @param Zddepartment 实体
     * @return 保存条数
     */
    int save(ZdDepartmentEntity Zddepartment);

    /**
     * 根据主键更新实体
     *
     * @param Zddepartment 实体
     * @return 更新条数
     */
    int update(ZdDepartmentEntity Zddepartment);

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
}
