package com.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.ZdDepartmentVo;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:54:18
 */
public interface ApiZdDepartmentMapper extends BaseDao<ZdDepartmentVo> {
	/*
	 * 根据医院id查询科室id
	 */
	List<ZdDepartmentVo> queryByhospitalId(@Param(value="hospitalId")Integer hospitalId,@Param(value="isDelete") Integer isDelete);
}
