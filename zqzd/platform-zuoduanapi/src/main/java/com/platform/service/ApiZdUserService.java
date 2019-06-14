package com.platform.service;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdUserMapper;
import com.platform.entity.ZdUserVo;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;


/**
 * 
 * @author 杨鹏
 *
 */
@Service
public class ApiZdUserService {
	@Autowired
	private ApiZdUserMapper userMapper;
	@Autowired
	private MsgService msgService;
	
	private final static String MOBILE_REGEX = "^1\\d{10}$";
	
	public ZdUserVo queryObject(Long userId) {
		return userMapper.queryObject(userId);
	}

	public int save(ZdUserVo userVo){
        return userMapper.save(userVo);
    }

    public int update(ZdUserVo userVo){
        return userMapper.update(userVo);
    }

	public ZdUserVo queryByOpenId(String openId){
		return userMapper.queryByOpenId(openId);
	}
	
	public Rp register(ZdUserVo user,String ip,String validate) {
		try {
			if(StringUtils.isEmpty(user.getUsername())) {
				return Rp.error("姓名不能为空");
			}
			if(StringUtils.isEmpty(user.getPassword())) {
				return Rp.error("密码不能为空");
			}
			String mobile=user.getMobile();
			if(StringUtils.isEmpty(mobile)) {
				return Rp.error("手机号码不能为空");
			}
			Pattern pattern=Pattern.compile(MOBILE_REGEX);
			Matcher matcher=pattern.matcher(mobile);
			if(!matcher.matches()) {
				return Rp.error("手机号码格式有误");
			}
			if(!("true".equals(msgService.mobileValidate(user, validate).get("success").toString()))) {
				 return Rp.error("请输入正确的验证码");
			}
			
			user.setRegisterTime(new Date());
			String password = new Sha256Hash(user.getPassword()).toHex();
			user.setPassword(password);
			user.setStatus(1);
			user.setRegisterIp(ip);
			userMapper.save(user);
			return Rp.ok();
		} catch (Exception e) {
			e.printStackTrace();
			user.setStatus(2);
			return Rp.error("注册失败");
		}
		
	}
	
	public Rp userInfo(ZdUserVo nowUser) {
		System.err.println(nowUser);
		if(com.platform.utils.StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请重新登录");
		}
		Map<String, Object> user=userMapper.queryByUserId(nowUser.getId());
		
		if(com.platform.utils.StringUtils.isNullOrEmpty(user)) {
			return Rp.error("数据异常");
		}
		return Rp.ok().putAllDt(user);
	}
	
	
	
	
	
	

}
