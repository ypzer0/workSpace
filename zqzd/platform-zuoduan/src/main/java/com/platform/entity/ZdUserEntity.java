package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_user
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 15:31:22
 */
public class ZdUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //性别：0:女 1男
    private Integer gender;
    //注册时间
    private Date registerTime;
    //最后登录时间
    private Date lastLoginTime;
    //最后登录 ip
    private String lastLoginIp;
    //用户级别
    private Integer userLevelId;
    //手机
    private String mobile;
    //注册ip
    private String registerIp;
    //年龄
    private Integer age;
    //状态 0，正常 1，禁用 2，删除
    private Integer status;
    //
    private String remarks;
    //用户昵称
    private String nickname;
    
    

    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
     * 设置：用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：用户名
     */
    public String getUsername() {
        return username;
    }
    /**
     * 设置：密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     */
    public String getPassword() {
        return password;
    }
    /**
     * 设置：性别：0:女 1男
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取：性别：0:女 1男
     */
    public Integer getGender() {
        return gender;
    }
    /**
     * 设置：注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取：注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }
    /**
     * 设置：最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取：最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    /**
     * 设置：最后登录 ip
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取：最后登录 ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }
    /**
     * 设置：用户级别
     */
    public void setUserLevelId(Integer userLevelId) {
        this.userLevelId = userLevelId;
    }

    /**
     * 获取：用户级别
     */
    public Integer getUserLevelId() {
        return userLevelId;
    }
    /**
     * 设置：手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置：注册ip
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    /**
     * 获取：注册ip
     */
    public String getRegisterIp() {
        return registerIp;
    }
    /**
     * 设置：年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取：年龄
     */
    public Integer getAge() {
        return age;
    }
    /**
     * 设置：状态 0，正常 1，禁用 2，删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态 0，正常 1，禁用 2，删除
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取：
     */
    public String getRemarks() {
        return remarks;
    }
}
