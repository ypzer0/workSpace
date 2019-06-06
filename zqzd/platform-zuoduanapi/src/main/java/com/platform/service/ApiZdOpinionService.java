package com.platform.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdOpinionMapper;
import com.platform.entity.ZdOpinionVo;
import com.platform.entity.ZdUserVo;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

@Service
public class ApiZdOpinionService {

	@Autowired
	private ApiZdOpinionMapper apiZdOpinionMapper;
	
	public Rp opinionSub(ZdUserVo nowUser,String opinionName) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请重新登录");
		}
		if(StringUtils.isEmpty(opinionName)) {
			return Rp.error("请您填写需要提交的建议");
		}
		
		ZdOpinionVo opinionVo=new ZdOpinionVo();
		opinionVo.setUserId(nowUser.getId());
		opinionVo.setOpinion(opinionName);
		opinionVo.setAddTime(new Date());
		opinionVo.setIsDelete(0);
		Integer row=apiZdOpinionMapper.save(opinionVo);
		if(row != 1) {
			return Rp.error("数据操作异常");
		}
		return Rp.ok("成功");
	}
	
}
