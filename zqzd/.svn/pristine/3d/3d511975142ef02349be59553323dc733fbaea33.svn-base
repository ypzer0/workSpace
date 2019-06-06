package com.platform.utils;

import java.math.BigDecimal;

public class DecimalUtil {

	
	/**
	 * 获取数据值，否则返回 自定义def值 
	 * @param money
	 * @param def
	 * @return
	 */
	public static BigDecimal GetValueOrDefault(BigDecimal money, Float def) {
		if(money == null) return new BigDecimal(def);
		return money;
	}
	
	/**
	 * 获取数据值，否则返回0
	 * @param money
	 * @return
	 */
	public static BigDecimal GetValueOrDefault(BigDecimal money) {
		if(money == null) return new BigDecimal(0);
		return money;
	}
	
	
}
