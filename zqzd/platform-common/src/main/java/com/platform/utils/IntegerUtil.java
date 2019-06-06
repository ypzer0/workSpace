package com.platform.utils;

public class IntegerUtil {

	/**
	 * 获取数据值，否则返回 自定义def值 
	 * @param money
	 * @param def
	 * @return
	 */
	public static Integer GetValueOrDefault(Integer dt, Integer def) {
		if(dt == null) return 0;
		return dt;
	}
	
	/**
	 * 获取数据值，否则返回0
	 * @param money
	 * @return
	 */
	public static Integer GetValueOrDefault(Integer dt) {
		if(dt == null) return 0;
		return dt;
	}
}
