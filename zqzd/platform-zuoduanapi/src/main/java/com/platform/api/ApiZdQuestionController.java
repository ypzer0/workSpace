package com.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdQuestionVo;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdQuestionService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 张桐
 *
 */
@Api("卓断一问多病")
@RestController
@RequestMapping("/zdapi")
public class ApiZdQuestionController  extends ApiBaseAction{
	
	@Autowired
	private ApiZdQuestionService apiZdQuestionService;
	
	@ApiOperation("一问多病提交接口")
	@PostMapping("/question/save")
	public Object questionSave(@LoginUser ZdUserVo nowUser,@RequestBody ZdQuestionVo zdQuestionVo) {
		return apiZdQuestionService.questionSave(nowUser, zdQuestionVo);
	}
	
	@ApiOperation("我的问诊列表接口")
	@PostMapping("/my/questionList")
	public Object myQuestionList(@LoginUser ZdUserVo nowUser) {
		return apiZdQuestionService.myQuestionList(nowUser);
	}
	
	@ApiOperation("我的问诊接口")
	@PostMapping("/my/question")
	public Object myQuestion(@LoginUser ZdUserVo nowUser) {
		return apiZdQuestionService.myQuestion(nowUser);
	}

}
