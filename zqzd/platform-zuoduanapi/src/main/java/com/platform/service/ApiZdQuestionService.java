package com.platform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdQuestionMapper;
import com.platform.entity.ZdQuestionVo;
import com.platform.entity.ZdUserVo;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

@Service
public class ApiZdQuestionService {
	
	@Autowired
	private ApiZdQuestionMapper apiZdQuestionMapper;
	
	public Rp questionSave(ZdUserVo nowUser,ZdQuestionVo zdQuestionVo) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请您重新登录！");
		}
		if(StringUtils.isEmpty(zdQuestionVo.getConsultation())||StringUtils.isEmpty(zdQuestionVo.getHelpInfo())) {
			return Rp.error("请填写完整信息！");
		}
		ZdQuestionVo question=new ZdQuestionVo();
		question.setAddTime(new Date());
		question.setUId(nowUser.getId());
		question.setConsultation(zdQuestionVo.getConsultation());
		question.setAnswerStatus(0);
		question.setHelpInfo(zdQuestionVo.getHelpInfo());
		
		if(zdQuestionVo.getCheckStatus() == 0 && StringUtils.isEmpty(zdQuestionVo.getCheckInfo())) {
			return Rp.error("请填写您检查或治疗的情况");
		}
		question.setCheckStatus(zdQuestionVo.getCheckStatus());
		question.setCheckInfo(zdQuestionVo.getCheckInfo());
		
		Integer row=apiZdQuestionMapper.save(question);
		
		if(row!=1) {
			return Rp.error("数据异常");
		}
		return Rp.ok("成功");
	}
	
	public Rp myQuestionList(ZdUserVo nowUser) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请您重新登录！");
		}
		List<ZdQuestionVo> questionList=apiZdQuestionMapper.queryQuestionList(nowUser.getId());
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		for (ZdQuestionVo question : questionList ) {
			Map<String , Object> mapData=new HashMap<String, Object>();
			mapData.put("answerStatus",question.getAnswerStatus());
			mapData.put("consultation",question.getConsultation() );
			mapData.put("checkStatus",question.getCheckStatus() );
			mapData.put("checkInfo", question.getCheckInfo());
			mapData.put("helpHnfo",question.getHelpInfo() );
			mapData.put("answerInfo", question.getAnswerInfo());
			dataList.add(mapData);
		}
		return Rp.ok().putDt("questionList",dataList);
	}
	
	public Rp myQuestion(ZdUserVo nowUser) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请您重新登录！");
		}
		
		Map<String , Object> question=apiZdQuestionMapper.queryMyQuestion(nowUser.getId());
		
		if(StringUtils.isNullOrEmpty(question)) {
			return Rp.error("你还没有问诊咨询");
		}
		return Rp.ok().putAllDt(question);
	}

}
