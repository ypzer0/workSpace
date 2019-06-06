package com.platform.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.platform.dao.ApiZdUserMapper;
import com.platform.entity.SmsConfig;
import com.platform.entity.SmsLogVo;
import com.platform.entity.SysSmsLogEntity;
import com.platform.entity.ZdUserVo;
import com.platform.utils.AliyunSmsUtils;
import com.platform.utils.CharUtil;
import com.platform.utils.Constant;
import com.platform.utils.RRException;
import com.platform.utils.ResourceUtil;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

/**
 * 
 * @author peter
 *
 */
@Service
public class MsgService {
	protected Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ApiZdUserMapper userMapper;
	@Autowired
	private SysConfigService sysConfigService;

	public Rp send(String telephone) {
		SysSmsLogEntity smsLogEntity = new SysSmsLogEntity();
		smsLogEntity.setMobile(telephone);
		Map<String, Object> code = new HashMap<>(2);
		code.put("code", CharUtil.getRandomNum(4));
		return Rp.ok();
	}

	public Rp mobileSend(String mobile) {

		if (StringUtils.isEmpty(mobile)) {
			return Rp.error("请输入您的手机号！");
		}

		String pattern = "^1\\d{10}$";
		if (!Pattern.matches(pattern, mobile)) {
			return Rp.error("手机号格式验证失败！");
		}

		System.err.println(new Date().getTime());
		// 二分钟之内不能重复发送短信
		SmsLogVo smsLogVo = userMapper.querySmsCodeTodayLast(mobile, 2);
		if (smsLogVo != null && (System.currentTimeMillis() / 1000 - smsLogVo.getLog_date()) < 60*2) {
			return Rp.error("短信已发送");
		} else {
			smsLogVo = new SmsLogVo();
			smsLogVo.setPhone(mobile);
			// 生成验证码
			String sms_code = CharUtil.getRandomNum(4);
			String msgContent = "您的验证码是：" + sms_code + "，请在页面中提交验证码完成验证。";
			smsLogVo.setSms_code(sms_code);
			smsLogVo.setSms_text(msgContent);
			smsLogVo.setLog_date((new Date()).getTime());
			smsLogVo.setType(2);
		}

		Map<String, Object> code = new HashMap<>();
		code.put("code", smsLogVo.getSms_code());
		int rt = 1;
		if (ResourceUtil.getConfigByName("sys.demo").equals("1")) {
			smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
			smsLogVo.setSend_status(1);
			smsLogVo.setIs_used(0);
			userMapper.saveSmsCodeLog(smsLogVo);
		} else {
			rt = sendSmsAliyun(smsLogVo, "", code);
		}
		if (rt == 1) {
			return Rp.ok("短信发送成功");
		} else {
			return Rp.error("短信发送失败！");
		}
	}

	

	/**
	 * 发送短信
	 * 
	 * @param nowUser
	 * @param mobile
	 * @return
	 */
	public Rp mobileSend(ZdUserVo nowUser, String mobile) {

		if (StringUtils.isEmpty(mobile)) {
			return Rp.error("请输入您的手机号！");
		}

		ZdUserVo user = userMapper.queryObject(nowUser.getId());

		if (StringUtils.isNullOrEmpty(user.getMobile())) {

			Boolean valisuc = true;
			if (StringUtils.isEmpty(mobile)) {
				valisuc = false;
			} else {
				String pattern = "^1\\d{10}$";
				valisuc = Pattern.matches(pattern, mobile);
			}
			if (!valisuc) {
				return Rp.error("手机号格式验证失败！");
			}
		}

		// 一分钟之内不能重复发送短信
		SmsLogVo smsLogVo = userMapper.querySmsCodeTodayLast(mobile, 2);
		if (smsLogVo != null && (System.currentTimeMillis() / 1000 - smsLogVo.getLog_date()) < 60) {
			return Rp.error("短信已发送");
		} else {
			smsLogVo = new SmsLogVo();
			smsLogVo.setPhone(mobile);
			// 生成验证码
			String sms_code = CharUtil.getRandomNum(4);
			String msgContent = "您的验证码是：" + sms_code + "，请在页面中提交验证码完成验证。";
			smsLogVo.setSms_code(sms_code);
			smsLogVo.setSms_text(msgContent);
			smsLogVo.setLog_date((new Date()).getTime());
			smsLogVo.setType(2);
		}

		Map<String, Object> code = new HashMap<>();
		code.put("code", smsLogVo.getSms_code());
		int rt = 1;
		if (ResourceUtil.getConfigByName("sys.demo").equals("1")) {
			smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
			smsLogVo.setUser_id(user.getId().longValue());
			smsLogVo.setSend_status(1);
			smsLogVo.setIs_used(0);
			userMapper.saveSmsCodeLog(smsLogVo);
		} else {
			rt = sendSmsAliyun(smsLogVo, "", code, user);
		}
		if (rt == 1) {
			return Rp.ok("短信发送成功");
		} else {
			return Rp.error("短信发送失败！");
		}
	}

	/**
	 * 验证短信验证码
	 * 
	 * @param nowUser
	 * @param validate
	 * @return
	 */
	public Rp mobileValidate(ZdUserVo nowUser, String validate) {
		if (StringUtils.isEmpty(validate)) {
			return Rp.error("请输入验证码！");
		}
		SmsLogVo smsLogVo = userMapper.querySmsCodeTodayLast(nowUser.getMobile(), 2);
		if (smsLogVo == null || (System.currentTimeMillis() / 1000 - smsLogVo.getLog_date()) > 60*2) {
			return Rp.error("验证码已经过期");
		}
		System.err.println(validate);
		if (validate.trim().equals(smsLogVo.getSms_code())) {
			userMapper.updateSmsLog(1, smsLogVo.getId());

			if (!StringUtils.isNullOrEmpty(userMapper.queryByUserName(nowUser.getUsername()))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", nowUser.getId());
				map.put("mobile", smsLogVo.getPhone());
				userMapper.updateMobile(map);
			}

			return Rp.ok("成功").putDt("msg", "验证成功！");
		} else {
			return Rp.error("请输入正确的验证码！");
		}
	}

	/**
	 * 发送阿里云短信
	 * 
	 * @param smsLogVo
	 * @param tempCode
	 * @param code
	 * @param nowUser
	 * @return
	 */
	private int sendSmsAliyun(SmsLogVo smsLogVo, String tempCode, Map<String, Object> code, ZdUserVo nowUser) {

		SendSmsResponse rt =configurationAliyun(smsLogVo,tempCode,code);
		if (rt.getCode() != null && rt.getCode().equals("OK")) {
			// smsLogVo = new SmsLogVo();
			smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
			smsLogVo.setUser_id(nowUser.getId().longValue());
			smsLogVo.setSend_status(1);
			smsLogVo.setIs_used(0);
			saveSmsCodeLog(smsLogVo);
			return 1;
		} else {

			smsLogVo.setIs_used(0);
			smsLogVo.setSend_status(0);
			saveSmsCodeLog(smsLogVo);
			return 0;
		}
	}
	
	private int sendSmsAliyun(SmsLogVo smsLogVo, String tempCode, Map<String, Object> code) {

		SendSmsResponse rt =configurationAliyun(smsLogVo,tempCode,code);

		if (rt.getCode() != null && rt.getCode().equals("OK")) {
			// smsLogVo = new SmsLogVo();
			smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
			smsLogVo.setSend_status(1);
			smsLogVo.setIs_used(0);
			saveSmsCodeLog(smsLogVo);
			return 1;
		} else {

			smsLogVo.setIs_used(0);
			smsLogVo.setSend_status(0);
			saveSmsCodeLog(smsLogVo);
			return 0;
		}
	}

	public int saveSmsCodeLog(SmsLogVo smsLogVo) {
		return userMapper.saveSmsCodeLog(smsLogVo);
	}

	private SendSmsResponse configurationAliyun(SmsLogVo smsLogVo, String tempCode, Map<String, Object> code) {
//		if (tempCode == null) {
//		throw new RRException("tempCode不能为空");
//	}

		// 获取云存储配置信息
		SmsConfig config = sysConfigService.getConfigObject(Constant.SMS_CONFIG_KEY, SmsConfig.class);

		if (StringUtils.isNullOrEmpty(config.getAliyunPro())) {
			throw new RRException("请先配置阿里云产品名称");
		}
		if (StringUtils.isNullOrEmpty(config.getAliyunDomain())) {
			throw new RRException("请先配置阿里云域名");
		}
		if (StringUtils.isNullOrEmpty(config.getAliyunKey())) {
			throw new RRException("请先配置阿里云Key");
		}
		if (StringUtils.isNullOrEmpty(config.getAliyunKeySecret())) {
			throw new RRException("请先配置阿里云Key密钥");
		}
//	if (StringUtils.isNullOrEmpty(config.getAliyunSign())) {
//		throw new RRException("请先配置阿里云签名");
//	}
		SendSmsResponse rt = new SendSmsResponse();

		try {
			rt = AliyunSmsUtils.sendSms(config.getAliyunPro(), config.getAliyunDomain(), config.getAliyunKey(),
					config.getAliyunKeySecret(), config.getAliyunSign(), tempCode, smsLogVo.getPhone(), code);
		} catch (Exception e) {

		}
		return rt;
	}

}
