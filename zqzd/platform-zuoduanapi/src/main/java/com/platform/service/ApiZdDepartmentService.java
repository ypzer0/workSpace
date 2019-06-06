package com.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdDepartmentMapper;
import com.platform.entity.ZdDepartmentVo;
import com.platform.utils.Rp;

@Service
public class ApiZdDepartmentService {

	@Autowired
	private ApiZdDepartmentMapper apiZdDepartmentMapper;
	
	public Rp getDepartment(Integer hospitalId) {
		if(hospitalId==null) {
			return Rp.error("数据异常");
		}
		
		List<ZdDepartmentVo> departmentList=apiZdDepartmentMapper.queryByhospitalId(hospitalId, 0);
		if(departmentList.size()==0) {
			return Rp.error("数据异常");
		}
		
		return Rp.ok().putDt("departmentList", departmentList);
		
	}
	
}
