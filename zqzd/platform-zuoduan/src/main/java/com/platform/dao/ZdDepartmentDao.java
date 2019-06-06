package com.platform.dao;

import com.platform.entity.ZdDepartmentEntity;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 13:14:14
 */
public interface ZdDepartmentDao extends BaseDao<ZdDepartmentEntity> {
	ZdDepartmentEntity queryIdByDepartmentName(String departmentName);
}
