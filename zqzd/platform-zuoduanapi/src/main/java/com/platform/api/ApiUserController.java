package com.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdUserService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("用户模块")
@RestController
@RequestMapping("/zdapi")
public class ApiUserController  extends ApiBaseAction{
	
	@Autowired
	private ApiZdUserService apiZdUserService;
	
	@ApiOperation("获取用户信息接口")
	@PostMapping("/user/info")
	public Object userInfo(@LoginUser ZdUserVo nowUser) {
		return apiZdUserService.userInfo(nowUser);
	}
	
}
