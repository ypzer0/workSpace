package com.platform.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.platform.dao.ApiUserMapper;
import com.platform.entity.SmsConfig;
import com.platform.entity.SmsLogVo;
import com.platform.entity.UserVo;
import com.platform.utils.AliyunSmsUtils;
import com.platform.utils.CharUtil;
import com.platform.utils.Constant;
import com.platform.utils.RRException;
import com.platform.utils.ResourceUtil;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


@Service
public class ApiUserService {

    protected Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ApiUserMapper userDao;
	@Autowired
	private SysConfigService sysConfigService;
	
	public UserVo queryByUserId(Integer userId) {
		return userDao.queryByUid(userId);
	}

	public UserVo queryObject(Long userId) {
		return userDao.queryObject(userId);
	}

	public UserVo queryByOpenId(String openId) {
		return userDao.queryByOpenId(openId);
	}

	public List<UserVo> queryList(Map<String, Object> map) {
		return userDao.queryList(map);
	}

	public int queryTotal(Map<String, Object> map) {
		return userDao.queryTotal(map);
	}

	public void save(String mobile, String password) {
		UserVo user = new UserVo();
		user.setMobile(mobile);
		user.setUsername(mobile);
		user.setPassword(DigestUtils.sha256Hex(password));
		user.setRegisterTime(new Date());
		userDao.save(user);
	}

	public void save(UserVo userVo) {
		userDao.save(userVo);
	}

	public void update(UserVo user) {
		userDao.update(user);
	}

	public void delete(Long userId) {
		userDao.delete(userId);
	}

	public void deleteBatch(Long[] userIds) {
		userDao.deleteBatch(userIds);
	}

	public UserVo queryByMobile(String mobile) {
		return userDao.queryByMobile(mobile);
	}

	public long login(String mobile, String password) {
		UserVo user = queryByMobile(mobile);
		//        Assert.isNull(user, "手机号或密码错误");

		//密码错误
		//zy not validate pwd
		//        if (!user.getPassword().equals(DigestUtils.sha256Hex(password))) {
		//            throw new RRException("手机号或密码错误");
		//        }

		//	    if (!user.getPassword().equals(DigestUtils.sha256Hex(password))) {
		//	        throw new RRException("手机号或密码错误");
		//	    }

		SmsLogVo smsLogVo = querySmsCodeTodayLast(mobile, 2);
		if(smsLogVo == null) {
			return -2;
		}
		String smsCode = smsLogVo.getSms_code();
		if(password.equals(smsCode)) {
			return user.getId().longValue();
		}
		return -1;
	}

	public SmsLogVo querySmsCodeByUserId(Long user_id) {
		return userDao.querySmsCodeByUserId(user_id);
	}

	public SmsLogVo querySmsCodeTodayLast(String mobile, Integer type) {
		return userDao.querySmsCodeTodayLast(mobile, type);
	}


	public int saveSmsCodeLog(SmsLogVo smsLogVo) {
		return userDao.saveSmsCodeLog(smsLogVo);
	}

	//    public String getUserLevel(UserVo loginUser) {
	//        String result = "普通用户";
	//        UserLevelVo userLevelVo = userLevelDao.queryObject(loginUser.getUser_level_id());
	//        if (null != userLevelVo) {
	//            result = userLevelVo.getName();
	//        }
	//        return result;
	//    }
	
	/**
	 * 发送阿里云短信
	 * @param smsLogVo
	 * @param tempCode
	 * @param code
	 * @param loginUser
	 * @return
	 */
	private int sendSmsAliyun(SmsLogVo smsLogVo, String tempCode, Map<String, Object> code, UserVo loginUser) {

		if (tempCode == null) {
			throw new RRException("tempCode不能为空");
		}

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
		if (StringUtils.isNullOrEmpty(config.getAliyunSign())) {
			throw new RRException("请先配置阿里云签名");
		}
		SendSmsResponse rt = new SendSmsResponse();

		try {
			rt = AliyunSmsUtils.sendSms(config.getAliyunPro(), config.getAliyunDomain(),
					config.getAliyunKey(), config.getAliyunKeySecret(), config.getAliyunSign(), tempCode,
					smsLogVo.getPhone(), code);
		} catch (Exception e) {

		}

		if (rt.getCode()!= null && rt.getCode().equals("OK")) {
			//            smsLogVo = new SmsLogVo();
			smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
			smsLogVo.setUser_id(loginUser.getId().longValue());
			smsLogVo.setSend_status(1);
			saveSmsCodeLog(smsLogVo);
			return 1;
		} else {
			smsLogVo.setSend_status(0);
			saveSmsCodeLog(smsLogVo);
			return 0;
		}
	}

	public Rp myDetail(UserVo loginUser) {
		UserVo user = userDao.queryObject(loginUser.getId());
		int ptype = user.getPlatType();
		String type = ptype == 1 ? "DX" : "HY";
		String userid = type + user.getuCode();
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("userid",userid);
		Map.put("portraitImg", user.getAvatar());
		Map.put("myname",user.getUsername());
		Map.put("credit", user.getCredit());
		Map.put("remainingSum", user.getMoney());
		Map.put("CanWithdrawal",user.getMoney());
		Map.put("amountFrozen", user.getFrozen());
		Map.put("registerTime", user.getRegisterTime());
		Map.put("copiesSold", user.getSucBuy());
		Map.put("soldAmount", user.getSucBuyMoney());
		return Rp.ok().putAllDt(Map);
	}

	public Rp getMobile(UserVo loginUser) {
		UserVo user = userDao.queryObject(loginUser.getId());
		
		String mobileString = user.getMobile();
		Boolean valisuc = true;
		
		if(StringUtils.isEmpty(mobileString)) {
			valisuc = false;
		}
		else {
	    	String pattern = "^1\\d{10}$";
	    	valisuc = Pattern.matches(pattern, mobileString);
		}
    	
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("valisuc", valisuc);
		Map.put("mobile",user.getMobile());
		return Rp.ok("成功").putAllDt(Map);
	}

	/**
	 * 发送短信
	 * @param loginUser
	 * @param mobile
	 * @return
	 */
	public Rp mobileSend(UserVo loginUser, String mobile) {
		UserVo user = userDao.queryObject(loginUser.getId());
		if(StringUtils.isNullOrEmpty(user.getMobile())) {

			Boolean valisuc = true;
			if(StringUtils.isEmpty(mobile)) {
				valisuc = false;
			}
			else {
		    	String pattern = "^1\\d{10}$";
		    	valisuc = Pattern.matches(pattern, mobile);
			}
			if(!valisuc) {
				return Rp.error("手机号格式验证失败！");
			}
			user.setMobile(mobile);
			userDao.update(user);
		}
		
        // 一分钟之内不能重复发送短信
        SmsLogVo smsLogVo = userDao.querySmsCodeTodayLast(mobile, 2);
        if (null != smsLogVo && (System.currentTimeMillis() / 1000 - smsLogVo.getLog_date()) < 1 * 60) {
            return Rp.error("短信已发送");
        }
        else {
        	smsLogVo = new SmsLogVo();
        	smsLogVo.setPhone(mobile);

    		//生成验证码
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
        if(ResourceUtil.getConfigByName("sys.demo").equals("1")){
            smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
            smsLogVo.setUser_id(loginUser.getId().longValue());
            smsLogVo.setSend_status(1);
            smsLogVo.setIs_used(0);
            userDao.saveSmsCodeLog(smsLogVo);
        }
        else {
            rt = sendSmsAliyun(smsLogVo, "SMS_158415228", code, loginUser);
        }
        if(rt == 1) {
            return Rp.ok("短信发送成功");
        }
        return Rp.ok("短信发送成功");
	}
	
	

	public Rp mobileValidate(UserVo loginUser,String validate) {
		if (StringUtils.isEmpty(validate)) {
			return Rp.error("请输入验证码！");
		}
		
		UserVo user = userDao.queryObject(loginUser.getId());
		String mobile = user.getMobile();
		SmsLogVo smsLogVo = userDao.querySmsCodeTodayLast(mobile, 2);
		if(smsLogVo == null) {
			return Rp.error("验证码已经过期");
		}
		if (validate.equals(smsLogVo.getSms_code())) {
			userDao.updateSmsLog(1, smsLogVo.getId());
			return Rp.ok("成功").putDt("msg", "验证成功！");
		}else {
			return Rp.error("请输入正确的验证码！");
		}
	}
	
	public Rp userLoad(UserVo loginUser) {
		UserVo user=userDao.queryByUid(loginUser.getId());
		Map<String , Object> map=new HashMap<String, Object>();
		map.put("img", user.getAvatar());
		map.put("nickname", user.getNickname());
		map.put("sex", user.getGender()==0?"女":"男");
		map.put("age", user.getAge());
		map.put("time", new SimpleDateFormat("yyyy年MM月dd日").format(user.getRegisterTime()));
		return Rp.ok().putAllDt(map);
	}
	
	public Rp userUpdate(UserVo loginUser,String nickname,String sex,Integer age) {
		if(StringUtils.isNullOrEmpty(nickname)) {
			return Rp.error("请输入您要修改的昵称！");
		}
		if(StringUtils.isNullOrEmpty(sex)) {
			return Rp.error("请选择您要修改的性别！");
		}else if(!(sex.equals("男")||sex.equals("女"))) {
			return Rp.error("请您输入合法的性别！");
		}
		if(StringUtils.isNullOrEmpty(age)) {
			return Rp.error("请选择您要修改的年龄！");
		}
		Map<String , Object> map=new HashMap<String, Object>();
		map.put("nickname", nickname);
		map.put("gender", sex.equals("男")?1:0);
		map.put("age", age);
		map.put("id", loginUser.getId());
		userDao.update(map);
		return Rp.ok();
	}
	
		
	
}














