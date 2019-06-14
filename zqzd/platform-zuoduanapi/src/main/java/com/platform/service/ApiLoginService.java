package com.platform.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.platform.entity.ZdUserVo;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.platform.util.ApiUserUtils;
import com.platform.util.CommonUtil;
import com.platform.utils.CharUtil;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

/**
 * @author 杨鹏
 */
@Service
public class ApiLoginService {

    protected Logger logger = Logger.getLogger(getClass());
    @Autowired
    private ApiZdUserService userService;

    @Autowired
    protected TokenService tokenService;

	/**
	 * 登录测试
	 */
	public Rp loginTest(String name, String ip) {
		if(StringUtils.isNullOrEmpty(name)) {
			return Rp.error("名字不能为空！");
		}
        Date nowTime = new Date();
        ZdUserVo userVo = userService.queryByOpenId(name);
        if (null == userVo) {
            
            String headImgUrl = "";
            Integer sex = 0;
            userVo = new ZdUserVo();

            userVo.setAge(0);
            userVo.setStatus(1);
            
            userVo.setUsername("微信用户" + CharUtil.getRandomString(12));
            userVo.setPassword(name);
            userVo.setRegisterTime(nowTime);
            
            userVo.setRegisterIp(ip);
            userVo.setLastLoginIp(userVo.getRegisterIp());
            userVo.setLastLoginTime(userVo.getRegisterTime());
            userVo.setWeixinOpenid(name);
            
            userVo.setAvatar(headImgUrl);
            userVo.setGender(sex);
            userVo.setNickname(name);
            
            userService.save(userVo);
            logger.info("--------------- 保存用户:");
        } else {
        	
        	//保存用户openid
            userVo.setLastLoginIp(ip);
            userVo.setLastLoginTime(nowTime);
            
            userService.update(userVo);
            logger.info("--------------- 更新用户:");
        }

        Map<String, Object> tokenMap = tokenService.createToken(userVo.getId());
        String token = MapUtils.getString(tokenMap, "token");

        return Rp.ok().putDt("token",token).putDt("userId", userVo.getId());
	}
	
	
}
