package com.platform.utils;

public class ConfigUtils {

	/**
	 * 获取是否是demo环境
	 * @return
	 */
	public static Boolean getIsDemo() {
		return ResourceUtil.getConfigByName("sys.demo").equals("1");
	}
	
	/**
	 * 配置发送短信的有效请求ip
	 * @return
	 */
	public static String getValidIp() {
		return ResourceUtil.getConfigByName("sys.validIp");
	}
	
}
