package com.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.IgnoreAuth;
import com.platform.service.ApiZdDepartmentService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("科室模块")
@RestController
@RequestMapping("/zdapi")
public class ApiZdDepartmentController  extends ApiBaseAction{
	
	@Autowired
	private ApiZdDepartmentService apiZdDepartmentService;
	
	
	@ApiOperation("获取科室接口")
	@IgnoreAuth
	@PostMapping("/get/department")
	public Object getDepartment(@RequestParam(value = "hospitalId")Integer hospitalId) {
		return apiZdDepartmentService.getDepartment(hospitalId);
	}
}
