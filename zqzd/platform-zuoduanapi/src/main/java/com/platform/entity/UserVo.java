package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:41
 */
public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    // 性别
    private Integer gender;
    //生日
    private Date birthday;
    //注册时间
    private Date registerTime;
    //最后登录时间
    private Date lastLoginTime;
    //最后登录 ip
    private String lastLoginIp;
    //用户级别
    private Integer userLevelId;
    //昵称
    private String nickname;
    //手机
    private String mobile;
    //注册ip
    private String registerIp;
    //头像
    private String avatar;
    //微信openid
    private String weixinOpenid;
    //平台标识编码：1: 鼎鑫权益用户DX开头  2:惠友圈用户 HY开头
    private Integer platType;
    //微信号
    private String weixinCode;
    //用户编号id
    private Integer codeId;
    //推广倍数 分倍数
    private Integer multiple;
    //状态
    private Integer status;
    //支付宝
    private String zhifubao;
    //用户信用积分
    private Integer credit;
    //积分
    private BigDecimal integral;
    //用户年龄
    private Integer age;
    //用户编码
    private String uCode;
    //节省金额
    private BigDecimal saveMoney;
    //用户年龄
    private Integer number;
    
    
    public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public BigDecimal getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(BigDecimal saveMoney) {
		this.saveMoney = saveMoney;
	}

    public UserVo() {
		super();
		
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/**
     * 冻结金额
     * @return
     */
    private BigDecimal frozen;
    /**
     * 余额
     * @return
     */
    private BigDecimal money;
  //是否为平台推广员  0 否  1 是
    private Integer isExtend;
    

    //未售出
    private Integer notOut;
    //成功售出
    private Integer sucOut;
    //成功售出元
    private BigDecimal sucOutMoney;
    //成功购买(件)
    private Integer sucBuy;
    //一共消费(元)
    private BigDecimal sucBuyMoney;
    
	@Override
	public String toString() {
		return "{id:" + id + ", username:" + username + ", password:" + password + ", gender:" + gender + ", birthday:"
				+ birthday + ", registerTime:" + registerTime + ", lastLoginTime:" + lastLoginTime + ", lastLoginIp:"
				+ lastLoginIp + ", userLevelId:" + userLevelId + ", nickname:" + nickname + ", mobile:" + mobile
				+ ", registerIp:" + registerIp + ", avatar:" + avatar + ", weixinOpenid:" + weixinOpenid + ", platType:"
				+ platType + ", weixinCode:" + weixinCode + ", codeId:" + codeId + ", multiple:" + multiple
				+ ", status:" + status + ", zhifubao:" + zhifubao + ", credit:" + credit + ", integral:" + integral
				+ ", age:" + age + ", uCode:" + uCode + ", frozen:" + frozen + ", money:" + money + ", isExtend:"
				+ isExtend + ", notOut:" + notOut + ", sucOut:" + sucOut + ", sucOutMoney:" + sucOutMoney + ", sucBuy:"
				+ sucBuy + ", sucBuyMoney:" + sucBuyMoney + "}";
	}

	
	public Integer getNotOut() {
		return notOut;
	}

	public void setNotOut(Integer notOut) {
		this.notOut = notOut;
	}

	public Integer getSucOut() {
		return sucOut;
	}

	public void setSucOut(Integer sucOut) {
		this.sucOut = sucOut;
	}

	public BigDecimal getSucOutMoney() {
		return sucOutMoney;
	}

	public void setSucOutMoney(BigDecimal sucOutMoney) {
		this.sucOutMoney = sucOutMoney;
	}

	public Integer getSucBuy() {
		return sucBuy;
	}

	public void setSucBuy(Integer sucBuy) {
		this.sucBuy = sucBuy;
	}

	public BigDecimal getSucBuyMoney() {
		return sucBuyMoney;
	}

	public void setSucBuyMoney(BigDecimal sucBuyMoney) {
		this.sucBuyMoney = sucBuyMoney;
	}

	/**
     * 冻结金额
     * @return
     */
    public BigDecimal getFrozen() {
		return frozen;
	}

    /**
     * 冻结金额
     * @return
     */
	public void setFrozen(BigDecimal frozen) {
		this.frozen = frozen;
	}

    /**
     * 余额
     * @return
     */
	public BigDecimal getMoney() {
		return money;
	}

    /**
     * 余额
     * @return
     */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

    public Integer getIsExtend() {
		return isExtend;
	}

	public void setIsExtend(Integer isExtend) {
		this.isExtend = isExtend;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer endCredit) {
		this.credit = endCredit;
	}

	public BigDecimal getIntegral() {
		return integral;
	}

	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
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
     * 设置：
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取：
     */
    public Integer getGender() {
        return gender;
    }
    /**
     * 设置：生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取：生日
     */
    public Date getBirthday() {
        return birthday;
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
     * 设置：昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取：昵称
     */
    public String getNickname() {
        return nickname;
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
     * 设置：头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取：头像
     */
    public String getAvatar() {
        return avatar;
    }
    /**
     * 设置：微信openid
     */
    public void setWeixinOpenid(String weixinOpenid) {
        this.weixinOpenid = weixinOpenid;
    }

    /**
     * 获取：微信openid
     */
    public String getWeixinOpenid() {
        return weixinOpenid;
    }
    /**
     * 设置：平台标识编码：1: 鼎鑫权益用户DX开头  2:惠友圈用户 HY开头
     */
    public void setPlatType(Integer platType) {
        this.platType = platType;
    }

    /**
     * 获取：平台标识编码：1: 鼎鑫权益用户DX开头  2:惠友圈用户 HY开头
     */
    public Integer getPlatType() {
        return platType;
    }
    /**
     * 设置：微信号
     */
    public void setWeixinCode(String weixinCode) {
        this.weixinCode = weixinCode;
    }

    /**
     * 获取：微信号
     */
    public String getWeixinCode() {
        return weixinCode;
    }
    /**
     * 设置：用户编号id
     */
    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    /**
     * 获取：用户编号id
     */
    public Integer getCodeId() {
        return codeId;
    }
    /**
     * 设置：推广倍数 分倍数
     */
    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    /**
     * 获取：推广倍数 分倍数
     */
    public Integer getMultiple() {
        return multiple;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getZhifubao() {
		return zhifubao;
	}

	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}
    
    
}
