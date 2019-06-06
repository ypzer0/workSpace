package com.platform.service;
	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdReportMapper;
import com.platform.entity.ZdReportVo;
import com.platform.entity.ZdUserVo;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

@Service
public class ApiZdReportService {

	@Autowired
	private ApiZdReportMapper apiZdReportMapper;
	
	public Rp reportList(ZdUserVo nowUser) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请重新登录");
		}
		List<ZdReportVo> list=apiZdReportMapper.queryReportList(nowUser.getId());
		if(StringUtils.isNullOrEmpty(list)) {
			return Rp.error("您还没有检查报告");
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		for (ZdReportVo report : list) {
			Map<String, Object> cMap = new HashMap<String, Object>();
			cMap.put("id", report.getId());
			cMap.put("reportName", report.getReportName());
			cMap.put("addTime", report.getAddTime());
			cMap.put("reportPath",report.getReportPath());
			dataList.add(cMap);
		}
		
		return Rp.ok().putDt("reportList", dataList);
		
	}
	
	public Rp reportView(ZdUserVo nowUser,Integer id) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请重新登录");
		}
		if(id==null) {
			return Rp.error("您还没有检查报告");
		}
		ZdReportVo report=apiZdReportMapper.queryById(id);
		if(StringUtils.isNullOrEmpty(report)) {
			return Rp.error("数据异常");
		}
		if(report.getUploadStatus()==0) {
			return Rp.error("医生还未将您的检查报告上传");
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("checkStatus", report.getCheckStatus());
		map.put("reportName", report.getReportName());
		map.put("reportPath", report.getReportPath());
		
		return Rp.ok().putAllDt(map);
	} 
	
	
}
