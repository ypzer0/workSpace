package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_doctor
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 15:08:05
 */
public class ZdDoctorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //医生id
    private Integer id;
    //医生姓名
    private String doctorName;
    //科室id
    private Integer departmentId;
    //操作人
    private Integer handlerId;
    //添加时间
    private Date addTime;
    //是否删除  0-未删除，1-已删除
    private Integer isDelete;
    //科室名称
    private String departmentName;
    //医院名称
    private String hospitalName;

    /**
     * 设置：医生id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：医生id
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：医生姓名
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * 获取：医生姓名
     */
    public String getDoctorName() {
        return doctorName;
    }
    /**
     * 设置：科室id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取：科室id
     */
    public Integer getDepartmentId() {
        return departmentId;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
