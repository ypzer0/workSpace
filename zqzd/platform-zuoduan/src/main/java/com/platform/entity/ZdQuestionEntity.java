package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_question
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 10:38:46
 */
public class ZdQuestionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    //用户id
    private Integer uId;
    //回复状态  0：未回复  1：已回复 
    private Integer answerStatus;
    //基本问题
    private String consultation;
    // 0：接受过治疗  1：未接受过治疗 
    private Integer checkStatus;
    //检查或治疗的基本情况
    private String checkInfo;
    //想获得怎样的帮助
    private String helpInfo;
    //回复信息
    private String answerInfo;
    //用户姓名
    private String username;
    //性别
    private Integer gender;
  //用户昵称
    private String nickname;
  //用户年龄
    private Integer age;
  //电话
    private String mobile;
    
    //问题提交时间
    private Date addTime;
    //回复时间
    private Date backTime;
    
    

    public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
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
     * 设置：用户id
     */
    public void setUId(Integer uId) {
        this.uId = uId;
    }

    /**
     * 获取：用户id
     */
    public Integer getUId() {
        return uId;
    }
    /**
     * 设置：回复状态  0：未回复  1：已回复 
     */
    public void setAnswerStatus(Integer answerStatus) {
        this.answerStatus = answerStatus;
    }

    /**
     * 获取：回复状态  0：未回复  1：已回复 
     */
    public Integer getAnswerStatus() {
        return answerStatus;
    }
    /**
     * 设置：基本问题
     */
    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    /**
     * 获取：基本问题
     */
    public String getConsultation() {
        return consultation;
    }
    /**
     * 设置： 0：接受过治疗  1：未接受过治疗 
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取： 0：接受过治疗  1：未接受过治疗 
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }
    /**
     * 设置：检查或治疗的基本情况
     */
    public void setCheckInfo(String checkInfo) {
        this.checkInfo = checkInfo;
    }

    /**
     * 获取：检查或治疗的基本情况
     */
    public String getCheckInfo() {
        return checkInfo;
    }
    /**
     * 设置：想获得怎样的帮助
     */
    public void setHelpInfo(String helpInfo) {
        this.helpInfo = helpInfo;
    }

    /**
     * 获取：想获得怎样的帮助
     */
    public String getHelpInfo() {
        return helpInfo;
    }
    /**
     * 设置：回复信息
     */
    public void setAnswerInfo(String answerInfo) {
        this.answerInfo = answerInfo;
    }

    /**
     * 获取：回复信息
     */
    public String getAnswerInfo() {
        return answerInfo;
    }

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
