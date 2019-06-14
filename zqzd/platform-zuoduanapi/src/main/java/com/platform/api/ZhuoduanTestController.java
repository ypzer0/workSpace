package com.platform.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.IgnoreAuth;
import com.platform.annotation.LoginUser;
import com.platform.entity.UserVo;
import com.platform.service.ApiLoginService;
import com.platform.service.MsgService;
import com.platform.util.ApiBaseAction;

/**
 * 
 * @author peter
 *
 */
@RestController
@RequestMapping("/zdapi")
public class ZhuoduanTestController extends ApiBaseAction{
	
	@Autowired
	private MsgService msgService;
	@Autowired
	private ApiLoginService loginService;

	@IgnoreAuth
	@GetMapping("/mobile/send")
	public Object msSend(@RequestParam("telephone") String telephone) {
		return msgService.send(telephone);
	}
	
	/**
	 * 用户授权
	 * @param
	 * @return
	 */
	@PostMapping("/auth/loginTest")
	@IgnoreAuth
	public Object loginTest(@RequestParam(value = "name") String name) {
        return loginService.loginTest(name, getClientIp());
	}
	

}
