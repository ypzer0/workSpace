package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_report
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:58:56
 */
public class ZdReportVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //用户id
    private Integer uId;
    //报表名称
    private String reportName;
    //是否检查过  0 :没有,  1: 有
    private Integer checkStatus;
    //报告文件路径(加密)
    private String reportPath;
    //报告时间
    private Date addTime;
    //上传状态 0:没有, 1:有
    private Integer uploadStatus;
    

    
    
    public Integer getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(Integer uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}



	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

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

	@Override
	public String toString() {
		return "ZdReportVo [id=" + id + ", uId=" + uId + ", reportName=" + reportName + ", checkStatus=" + checkStatus
				+ ", reportPath=" + reportPath + ", addTime=" + addTime + ", uploadStatus=" + uploadStatus + "]";
	}




	
    
}
