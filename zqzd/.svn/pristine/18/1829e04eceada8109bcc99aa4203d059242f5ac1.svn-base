package com.platform.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdBuyService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "买家购买接口")
@RestController
@RequestMapping("/zdapi")
public class ApiZdBuyController  extends ApiBaseAction{
	
	@Autowired
	private ApiZdBuyService apiZdBuyService;

	@ApiOperation(value = "立即购买", response = Map.class)
	@PostMapping("/nowbuy")
	public Object nowBuy(@LoginUser ZdUserVo nowUser, @RequestParam(value = "goodsId") Integer goodsId, 
						@RequestParam(value = "count") Integer count,
						@RequestParam(value = "hospitalId") Integer hospitalId,
						@RequestParam(value = "departmentId") Integer departmentId,
						@RequestParam(value = "doctorId") Integer doctorId) {
		
		return apiZdBuyService.nowBuy(nowUser, goodsId, count, hospitalId, departmentId, doctorId);
	}
	
}
