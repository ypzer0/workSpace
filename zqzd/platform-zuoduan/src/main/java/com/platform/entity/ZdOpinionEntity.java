package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_opinion
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 13:13:21
 */
public class ZdOpinionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //用户ID
    private Integer userId;
    //意见
    private String opinion;
    //添加时间
    private Date addTime;
    //是否删除  0-未删除，1-已删除
    private Integer isDelete;
    //用户昵称
    private String nickname;
    //用户名
	private String username;
	//性别
	private Integer gender;
	//年龄
	private Integer age;
	//电话
	private String mobile;

	
	
	
    @Override
	public String toString() {
		return "ZdOpinionEntity [id=" + id + ", userId=" + userId + ", opinion=" + opinion + ", addTime=" + addTime
				+ ", isDelete=" + isDelete + ", nickname=" + nickname + ", username=" + username + ", gender=" + gender
				+ ", age=" + age + ", mobile=" + mobile + "]";
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
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
     * 设置：用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户ID
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：意见
     */
    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    /**
     * 获取：意见
     */
    public String getOpinion() {
        return opinion;
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
