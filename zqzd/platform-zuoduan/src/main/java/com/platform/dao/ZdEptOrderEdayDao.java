package com.platform.dao;

import com.platform.entity.ZdEptOrderEdayEntity;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
public interface ZdEptOrderEdayDao extends BaseDao<ZdEptOrderEdayEntity> {
	int updateRptOrder(String btime);
}
