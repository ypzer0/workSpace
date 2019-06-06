package com.platform.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdCustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="客服接口")
@RestController
@RequestMapping("/zdapi/customer")
public class ApiZdCustomerController {
	
	@Autowired
	private ApiZdCustomerService apiZdCustomerService;
	
	@ApiOperation(value="加载客服信息",response=Map.class)
	@PostMapping("/load")
	public Object load(@LoginUser ZdUserVo nowUser) {
		return apiZdCustomerService.load(nowUser);
	}

}
