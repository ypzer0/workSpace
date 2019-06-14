package com.platform.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdUserVo;
import com.platform.service.MsgService;
import com.platform.util.ApiBaseAction;
import com.platform.utils.Rp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 张桐
 *
 */
@Api(tags = "手机验证接口")
@RestController
@RequestMapping("/zdapi")
public class ApiZdMobileController  extends ApiBaseAction{
	@Autowired
	private MsgService service;
	
	@ApiOperation(value = "发送短信验证码接口", response = Map.class)
	@PostMapping("/mobile/send")
	public Object mobileSend(@LoginUser ZdUserVo nowUser, @RequestParam(value = "mobile") String mobile) {
		return service.mobileSend(nowUser, mobile);
	}
	
	
	@ApiOperation(value = "验证短信验证码接口", response = Map.class)
	@PostMapping("/mobile/validate")
	public Object mobileValidate(@LoginUser ZdUserVo nowUser,@RequestParam(value = "validate") String validate) {
		Rp cMap= service.mobileValidate(nowUser,validate);
		return cMap;
	}

}
