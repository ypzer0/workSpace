package com.platform.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.IgnoreAuth;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdUserService;
import com.platform.service.MsgService;
import com.platform.util.ApiBaseAction;
import com.platform.utils.Rp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 杨鹏
 *
 */
@Api("卓断用户注册")
@RestController
@RequestMapping("/zdapi")
public class ApiRegisterController  extends ApiBaseAction{
	
	@Autowired
	private ApiZdUserService userService;
	@Autowired
	private MsgService service;
	
	
	@ApiOperation("用户注册接口")
	@IgnoreAuth
	@PostMapping("/user/register")
	public Rp register(ZdUserVo user) {
		return userService.register(user,getClientIp(),user.getCode());	
	}
	
	@ApiOperation(value = "用户注册发送短信验证码接口", response = Map.class)
	@IgnoreAuth
	@PostMapping("/register/send")
	public Object registerSend(@RequestParam(value = "mobile") String mobile) {
		Rp cMap= service.mobileSend(mobile);
		return cMap;
	}


}
