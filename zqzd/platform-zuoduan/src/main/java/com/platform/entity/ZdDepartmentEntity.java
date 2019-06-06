package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_department
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 13:14:14
 */
public class ZdDepartmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //科室id
    private Integer id;
    //科室名称
    private String departmentName;
    //医院id
    private Integer hospitalId;
    //操作人
    private Integer handlerId;
    //添加时间
    private Date addTime;
    //是否删除  0-未删除，1-已删除
    private Integer isDelete;
    
    private String hospitalName;

    /**
     * 设置：科室id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：科室id
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：科室名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 获取：科室名称
     */
    public String getDepartmentName() {
        return departmentName;
    }
    /**
     * 设置：医院id
     */
    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * 获取：医院id
     */
    public Integer getHospitalId() {
        return hospitalId;
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
