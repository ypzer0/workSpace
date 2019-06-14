package com.platform.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.SmsLogVo;
import com.platform.entity.ZdUserVo;

public interface ApiZdUserMapper extends BaseDao<ZdUserVo>{
    /**
     * 根据平台id查询用户信息
     * @param openId 平台id
     * @return 用户信息
     */
    ZdUserVo queryByOpenId(@Param("openId") String openId);

	ZdUserVo queryByUserName(String username);
	
	 /**
     * 获取用户最后一条短信
     *
     * @param
     * @return
     */
    SmsLogVo querySmsCodeTodayLast(@Param("mobile") String mobile, @Param("type") Integer type);
    
    /**
     * 保存短信
     *
     * @param smsLogVo
     * @return
     */
    int saveSmsCodeLog(SmsLogVo smsLogVo);
    
    int updateSmsLog(@Param("is_used") Integer is_used, @Param("id") Long id);
    
    int updateMobile(Map<String, Object> map);
    
    Map<String, Object> queryByUserId(Integer id);
    
}
