package com.platform.dao;

import com.platform.entity.ZdHospitalEntity;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 11:43:55
 */
public interface ZdHospitalDao extends BaseDao<ZdHospitalEntity> {
	ZdHospitalEntity queryIdByhospitalName(String hospitalName);
}
