package com.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.ZdDoctorVo;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:54:18
 */
public interface ApiZdDoctorMapper extends BaseDao<ZdDoctorVo> {

	List<ZdDoctorVo> queryBydepartmentId(@Param(value="departmentId")Integer departmentId,@Param(value="isDelete") Integer isDelete);
	
}
