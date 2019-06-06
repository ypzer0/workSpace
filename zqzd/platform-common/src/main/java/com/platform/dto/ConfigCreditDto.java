package com.platform.dto;

import java.io.Serializable;

/**
 * 信用分配置
 * 
 * @author Administrator
 *
 */
public class ConfigCreditDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 最低多少分不能购买和上传
	 */
	private Integer low;

	/**
	 * 最高展示多少信用分
	 */
	private Integer hight;

	/**
	 * 增加量
	 */
	private Integer change;
	
	/**
	 * 可增加的上传数
	 */
	private Integer chgoods;

	@Override
	public String toString() {
		return "{low:" + low + ", hight:" + hight + ", change:" + change + ", chgoods:" + chgoods + "}";
	}

	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public Integer getHight() {
		return hight;
	}

	public void setHight(Integer hight) {
		this.hight = hight;
	}

	public Integer getChange() {
		return change;
	}

	public void setChange(Integer change) {
		this.change = change;
	}

	public Integer getChgoods() {
		return chgoods;
	}

	public void setChgoods(Integer chgoods) {
		this.chgoods = chgoods;
	}
	
}
