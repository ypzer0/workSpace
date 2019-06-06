package com.platform.dto;

import java.io.Serializable;

public class HandlerOAskPDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//主键id
	private Integer id;
	//操作类型
	private String otype;
	//消息
	private String msg;
	
	//清空消息状态
	private Integer clean;
	
	/**
	 * @return the clean
	 */
	public Integer getClean() {
		return clean;
	}
	/**
	 * @param clean the clean to set
	 */
	public void setClean(Integer clean) {
		this.clean = clean;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the otype
	 */
	public String getOtype() {
		return otype;
	}
	/**
	 * @param otype the otype to set
	 */
	public void setOtype(String otype) {
		this.otype = otype;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
