package com.platform.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dto.ConfigContactDto;
import com.platform.entity.ZdUserVo;
import com.platform.utils.Constant;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

@Service
public class ApiZdCustomerService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysConfigService sysConfigService;
    
	public Rp load(ZdUserVo loginUser) {
		if(StringUtils.isNullOrEmpty(loginUser)) {
			return Rp.error("您还没有登录");
		}
		ConfigContactDto configContact = sysConfigService.getConfigObject(Constant.KEY_CONTACT, ConfigContactDto.class);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("phone", configContact.getPhone());
		map.put("Wechat", configContact.getWechart());
		return Rp.ok().putAllDt(map);
	}
}
