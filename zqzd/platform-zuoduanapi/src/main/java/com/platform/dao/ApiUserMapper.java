package com.platform.dao;

import com.platform.entity.SmsLogVo;
import com.platform.entity.UserVo;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 用户
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:22:06
 */
public interface ApiUserMapper extends BaseDao<UserVo> {

	
    UserVo queryByMobile(@Param("mobile") String mobile);
//    UserVo queryByMobile(String mobile);
    

    UserVo queryByOpenId(@Param("openId") String openId);
    
    UserVo queryByUid(@Param("id") Integer id);

    /**
     * 获取用户最后一条短信
     *
     * @param user_id
     * @return
     */
    SmsLogVo querySmsCodeByUserId(@Param("user_id") Long user_id);
    
    int updateMobile(Map<String, Object> map);

    /**
     * 获取用户最后一条短信
     *
     * @param user_id
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
    
    int update(Map<String, Object> map);
    
}
