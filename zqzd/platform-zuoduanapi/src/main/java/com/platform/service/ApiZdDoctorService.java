package com.platform.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdDepartmentMapper;
import com.platform.dao.ApiZdDoctorMapper;
import com.platform.dao.ApiZdHospitalMapper;
import com.platform.entity.ZdDepartmentVo;
import com.platform.entity.ZdDoctorVo;
import com.platform.entity.ZdHospitalVo;
import com.platform.utils.Rp;

@Service
public class ApiZdDoctorService {

	@Autowired
	private ApiZdDoctorMapper apiZdDoctorMapper;
	@Autowired
	private ApiZdDepartmentMapper apiZdDepartmentMapper;
	@Autowired
	private ApiZdHospitalMapper apiZdHospitalMapper;
	
	public Rp getDoctor(Integer departmentId) {
		if(departmentId==null) {
			return Rp.error("数据异常");
		}
		
		List<ZdDoctorVo> doctorList=apiZdDoctorMapper.queryBydepartmentId(departmentId, 0);
		if(doctorList.size()==0) {
			return Rp.error("数据异常");
		}
		
		return Rp.ok().putDt("doctorList", doctorList);
		
	}
	
	public List<HashMap<String,Object>> selectDoctor() {
		HashMap<String,Object> params=new HashMap<>();
		List<ZdDoctorVo> dataList=apiZdDoctorMapper.queryList(params);
		List<HashMap<String,Object>> resultList=new ArrayList<>();
		for(ZdDoctorVo entity:dataList) {
			HashMap<String,Object> resultMap=new HashMap<>(1);
			resultMap.put("key", entity.getId());
			resultMap.put("value", entity.getDoctorName());
			resultList.add(resultMap);
		}
		return resultList;
	}
	
	public List<HashMap<String,Object>> selectDepartment() {
		HashMap<String,Object> params=new HashMap<>();
		List<ZdDepartmentVo> dataList=apiZdDepartmentMapper.queryList(params);
		List<HashMap<String,Object>> resultList=new ArrayList<>();
		for(ZdDepartmentVo entity:dataList) {
			HashMap<String,Object> resultMap=new HashMap<>(1);
			resultMap.put("key", entity.getId());
			resultMap.put("value", entity.getDepartmentName());
			resultList.add(resultMap);
		}
		return resultList;
	}
	
	
	public List<HashMap<String,Object>> selectHospital() {
		HashMap<String,Object> params=new HashMap<>();
		List<ZdHospitalVo> dataList=apiZdHospitalMapper.queryList(params);
		List<HashMap<String,Object>> resultList=new ArrayList<>();
		for(ZdHospitalVo entity:dataList) {
			HashMap<String,Object> resultMap=new HashMap<>(1);
			resultMap.put("key", entity.getId());
			resultMap.put("value", entity.getHospitalName());
			resultList.add(resultMap);
		}
		return resultList;
	}
	
}
