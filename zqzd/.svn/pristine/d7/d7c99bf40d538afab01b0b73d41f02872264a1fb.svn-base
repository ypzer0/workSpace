package com.platform.util;

import com.platform.utils.ResourceUtil;
import com.platform.utils.WeiXinUtil;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:58<br>
 * 描述: ApiUserUtils <br>
 */
public class ApiUserUtils {

    //替换字符串
    public static String getCode(String APPID, String REDIRECT_URI, String SCOPE) {
        return String.format(ResourceUtil.getConfigByName("wx.getCode"), APPID, REDIRECT_URI, SCOPE);
    }

    //替换字符串
    public static String getWebAccess(String CODE) {
        return String.format(ResourceUtil.getConfigByName("wx.webAccessTokenhttps"),
                ResourceUtil.getConfigByName("wxc.appId"),
                ResourceUtil.getConfigByName("wxc.secret"),
                CODE);
    }

    //替换字符串
    public static String getUserMessage(String access_token, String openid) {
        return String.format(ResourceUtil.getConfigByName("wx.userMessage"), access_token, openid);
    }
    
    //微信公众号相关参数拼接
    public static String getWeiXinGZHWebAccess(String CODE) {
        return String.format(ResourceUtil.getConfigByName("wx.webAccessTokenhttps"),
                ResourceUtil.getConfigByName("wx.appId"),
                ResourceUtil.getConfigByName("wx.secret"),
                CODE);
    }
    
    //优惠劵 微信公众号获取用户信息
    public static String couponGetWeiXinGZHUserMsg(String token, Integer plat) {
    	
    	String userMUrl = WeiXinUtil.getUserMsg(plat);
    	String appId = WeiXinUtil.getAppId(plat);
    	
    	return String.format(userMUrl, token, appId);
    }
    
    //优惠劵 微信公众号相关参数拼接
    public static String couponGetWeiXinGZHWebAccess(String CODE, int plat) {
    	
    	String accessToken = WeiXinUtil.getAccessTokenUrl(plat);
    	String appId = WeiXinUtil.getAppId(plat);
    	String secret = WeiXinUtil.getSecret(plat);
    	
        return String.format(accessToken, appId, secret, CODE);
    }
    
    
    
    
}