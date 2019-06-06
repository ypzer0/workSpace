package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_hospital
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:54:18
 */
public class ZdHospitalVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //医院id
    private Integer id;
    //医院名称
    private String hospitalName;
    //操作人
    private Integer handlerId;
    //添加时间
    private Date addTime;
    //是否删除  0-未删除，1-已删除
    private Integer isDelete;
    
    

    
    

	


	@Override
	public String toString() {
		return "ZdHospitalVo [id=" + id + ", hospitalName=" + hospitalName + ", handlerId=" + handlerId + ", addTime="
				+ addTime + ", isDelete=" + isDelete + "]";
	}

	/**
     * 设置：医院id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：医院id
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：医院名称
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * 获取：医院名称
     */
    public String getHospitalName() {
        return hospitalName;
    }
    /**
     * 设置：操作人
     */
    public void setHandlerId(Integer handlerId) {
        this.handlerId = handlerId;
    }

    /**
     * 获取：操作人
     */
    public Integer getHandlerId() {
        return handlerId;
    }
    /**
     * 设置：添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取：添加时间
     */
    public Date getAddTime() {
        return addTime;
    }
    /**
     * 设置：是否删除  0-未删除，1-已删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取：是否删除  0-未删除，1-已删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }
}
