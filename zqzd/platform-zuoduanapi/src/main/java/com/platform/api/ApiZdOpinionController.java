package com.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdOpinionVo;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdOpinionService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 张桐
 *
 */
@Api("卓断客服售后")
@RestController
@RequestMapping("/zdapi")
public class ApiZdOpinionController  extends ApiBaseAction{
	
	@Autowired
	private ApiZdOpinionService apiZdOpinionService;
	
	@ApiOperation("用户意见提交接口")
	@PostMapping("/opinion/sub")
	public Object opinionSub(@LoginUser ZdUserVo nowUser,@RequestBody ZdOpinionVo opinion) {
		return apiZdOpinionService.opinionSub(nowUser, opinion.getOpinion());
	}

}
