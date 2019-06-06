package com.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.IgnoreAuth;
import com.platform.service.ApiZdDoctorService;
import com.platform.util.ApiBaseAction;
import com.platform.utils.Rp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("医生模块")
@RestController
@RequestMapping("/zdapi")
public class ApiZdDoctorController  extends ApiBaseAction{

	@Autowired
	private ApiZdDoctorService apiZdDoctorService;
	
	@ApiOperation("获取医生接口")
	@IgnoreAuth
	@PostMapping("/get/doctor")
	public Object getDoctor(@RequestParam(value = "departmentId")Integer departmentId) {
		return apiZdDoctorService.getDoctor(departmentId);
	}
	
	@ApiOperation("获取医生集合")
	@IgnoreAuth
	@PostMapping("/doctor/infoList")
	public Object getDoctorList() {
		try {
			Rp rp=Rp.ok();
			rp.putDt("doctorList", apiZdDoctorService.selectDoctor());
			rp.putDt("departmentList", apiZdDoctorService.selectDepartment());
			rp.putDt("hospitalList", apiZdDoctorService.selectHospital());
			return rp;
		} catch (Exception e) {
			e.printStackTrace();
			return Rp.error("获取医院集合失败");
		}
	}
}
