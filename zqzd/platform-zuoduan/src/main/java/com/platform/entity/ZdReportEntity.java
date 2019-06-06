package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_report
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 11:36:26
 */
public class ZdReportEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    private Integer uId;
    //报表名称
    private String reportName;
    //是否检查过  0 :没有,  1: 有
    private Integer checkStatus;
    //是否上传  0 :没有, 1:有
    private Integer uploadStatus;
    //报告文件路径(加密)
    private String reportPath;
    //用户昵称
    private String nickname;
    //用户姓名
    private String username;
    //年龄
    private Integer age;
    //性别
    private Integer gender;
    //电话
    private String mobile;
    
    private Date addTime;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：报表名称
     */
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    /**
     * 获取：报表名称
     */
    public String getReportName() {
        return reportName;
    }
    /**
     * 设置：是否检查过  0 :没有,  1: 有
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取：是否检查过  0 :没有,  1: 有
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }
    /**
     * 设置：是否上传  0 :没有, 1:有
     */
    public void setUploadStatus(Integer uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    /**
     * 获取：是否上传  0 :没有, 1:有
     */
    public Integer getUploadStatus() {
        return uploadStatus;
    }
    /**
     * 设置：报告文件路径(加密)
     */
    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    /**
     * 获取：报告文件路径(加密)
     */
    public String getReportPath() {
        return reportPath;
    }

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
