package com.platform.dto;

import java.io.Serializable;

/**
 *提佣等级
 * 
 * @author Administrator
 *
 */
public class ConfigConDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 一级提成
	 */
	private Integer val1;

	/**
	 * 二级提成
	 */
	private Integer val2;

	/**
	 * 三级提成
	 */
	private Integer val3;

	
	@Override
	public String toString() {
		return "{val1:" + val1 + ", val2:" + val2 + ", val3:" + val3 + "}";
	}

	public Integer getVal1() {
		return val1;
	}

	public void setVal1(Integer val1) {
		this.val1 = val1;
	}

	public Integer getVal2() {
		return val2;
	}

	public void setVal2(Integer val2) {
		this.val2 = val2;
	}

	public Integer getVal3() {
		return val3;
	}

	public void setVal3(Integer val3) {
		this.val3 = val3;
	}
	
}
