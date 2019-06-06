package com.platform.entity;

import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Map;

/**
 * 名称：SmsConfig <br>
 * 描述：短信配置信息<br>
 *
 * @author 李鹏军
 * @version 1.0
 * @since 1.0.0
 */
public class SmsConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型 1：创瑞   类型2：阿里云
     */
    @Range(min = 1, max = 3, message = "类型错误")
    private Integer type;

    /**
     * 短信发送域名
     */
    private String domain;

    /**
     * 用户名  product
     */
    private String name;

    /**
     * 密码(md5加密)
     */
    private String pwd;

    /**
     * 签名
     */
    private String sign;
    
    /**
     * aliyun 域名
     */
    private String aliyunDomain;
    /**
     * aliyun 产品
     */
    private String aliyunPro;
    /**
     * aliyun Key
     */
    private String aliyunKey;
    /**
     * aliyun Key密钥
     */
    private String aliyunKeySecret;
    /**
     * aliyun 签名
     */
    private String aliyunSign;

	/**
	 * @return the aliyunDomain
	 */
	public String getAliyunDomain() {
		return aliyunDomain;
	}

	/**
	 * @param aliyunDomain the aliyunDomain to set
	 */
	public void setAliyunDomain(String aliyunDomain) {
		this.aliyunDomain = aliyunDomain;
	}

	/**
	 * @return the aliyunPro
	 */
	public String getAliyunPro() {
		return aliyunPro;
	}

	/**
	 * @param aliyunPro the aliyunPro to set
	 */
	public void setAliyunPro(String aliyunPro) {
		this.aliyunPro = aliyunPro;
	}

	/**
	 * @return the aliyunKey
	 */
	public String getAliyunKey() {
		return aliyunKey;
	}

	/**
	 * @param aliyunKey the aliyunKey to set
	 */
	public void setAliyunKey(String aliyunKey) {
		this.aliyunKey = aliyunKey;
	}

	/**
	 * @return the aliyunKeySecret
	 */
	public String getAliyunKeySecret() {
		return aliyunKeySecret;
	}

	/**
	 * @param aliyunKeySecret the aliyunKeySecret to set
	 */
	public void setAliyunKeySecret(String aliyunKeySecret) {
		this.aliyunKeySecret = aliyunKeySecret;
	}

	/**
	 * @return the aliyunSign
	 */
	public String getAliyunSign() {
		return aliyunSign;
	}

	/**
	 * @param aliyunSign the aliyunSign to set
	 */
	public void setAliyunSign(String aliyunSign) {
		this.aliyunSign = aliyunSign;
	}

	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
