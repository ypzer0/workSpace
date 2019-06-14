package com.platform.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdGoodsInfoService;
import com.platform.service.ApiZdPayService;
import com.platform.util.ApiBaseAction;
import com.platform.utils.Rp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "支付接口")
@RestController
@RequestMapping("/zdapi/pay")
public class ApiZdPayController extends ApiBaseAction{
	
	@Autowired
	private ApiZdPayService apiZdPayService;
	@Autowired
	private ApiZdGoodsInfoService apiZdGoodsInfoService; 
	
	@ApiOperation(value = "微信支付", response = Map.class)
	@PostMapping("/buy")
	public Object payMoney(@LoginUser ZdUserVo nowUser, @RequestParam(value = "oid") Integer oid) {
		return apiZdPayService.payMoney(nowUser, oid,  getClientIp());
	}
	
	@ApiOperation(value = "微信支付响应", response = Map.class)
	@PostMapping("/wxpayback")
	public void wxpayback(HttpServletRequest request, HttpServletResponse response) {
		apiZdPayService.wxpayback(request, response, getClientIp());
	}
	
	@ApiOperation(value = "成功页面展示数据接口", response = Map.class)
	@PostMapping("/success")
	public Object success(@RequestParam(value = "oid") Integer oid) {
		Map<String, Object> cMap= apiZdGoodsInfoService.success(oid);
		return toResponsSuccess(cMap);
	}

}
