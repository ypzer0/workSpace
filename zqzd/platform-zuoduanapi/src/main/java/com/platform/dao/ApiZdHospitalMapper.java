package com.platform.dao;

import java.util.List;

import com.platform.entity.ZdHospitalVo;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:54:18
 */
public interface ApiZdHospitalMapper extends BaseDao<ZdHospitalVo> {
	List<ZdHospitalVo> queryHospitalList(Integer isDelete);
}
