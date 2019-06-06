package com.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdReportVo;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdReportService;
import com.platform.util.ApiBaseAction;
import com.platform.entity.ZdReportVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 张桐
 *
 */
@Api("卓断检查报告")
@RestController
@RequestMapping("/zdapi")
public class ApiZdReportController extends ApiBaseAction {

	@Autowired
	private ApiZdReportService apiZdReportService;

	@ApiOperation("检查报告列表接口")
	@PostMapping("/report/list")
	public Object reportList(@LoginUser ZdUserVo nowUser) {
		return apiZdReportService.reportList(nowUser);
	}

	
	@ApiOperation("检查报告查看接口")
	@PostMapping("/report/view")
	public Object reportView(@LoginUser ZdUserVo nowUser, @RequestBody ZdReportVo report) {
		return apiZdReportService.reportView(nowUser, report.getId());
	}

	

}
