package com.platform.dao;

import com.platform.entity.ZdEptUserEdayEntity;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
public interface ZdEptUserEdayDao extends BaseDao<ZdEptUserEdayEntity> {
	int updateRptCustomer(String btime);
}
