package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_pay_log
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-30 11:03:37
 */
public class PayLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //请求ip
    private String ip;
    //申请人Id
    private Integer uId;
    //申请人昵称
    private String uName;
    //订单Id
    private Integer oId;
    //订单编号
    private String orderNo;
    //金额
    private BigDecimal money;
    //类型:1：用户申请 2: 平台返回
    private Integer traType;
    //类型:1：微信支付  11: 微信h5支付  2: 支付宝 
    private Integer payType;
    //类型:1：成功 2:失败 3:异常
    private Integer status;
    //创建时间
    private Date ctime;
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\\r\\n {id:'" + id + "', ip:'" + ip + "', uId:'" + uId + "', uName:'" + uName + "', oId:'" + oId
				+ "', orderNo:'" + orderNo + "', money:'" + money + "', traType:'" + traType + "', payType:'" + payType
				+ "', status:'" + status + "', ctime:'" + ctime + "}";
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
     * 设置：请求ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取：请求ip
     */
    public String getIp() {
        return ip;
    }
    /**
     * 设置：申请人Id
     */
    public void setUId(Integer uId) {
        this.uId = uId;
    }

    /**
     * 获取：申请人Id
     */
    public Integer getUId() {
        return uId;
    }
    /**
     * 设置：申请人昵称
     */
    public void setUName(String uName) {
        this.uName = uName;
    }

    /**
     * 获取：申请人昵称
     */
    public String getUName() {
        return uName;
    }
    /**
     * 设置：订单Id
     */
    public void setOId(Integer oId) {
        this.oId = oId;
    }

    /**
     * 获取：订单Id
     */
    public Integer getOId() {
        return oId;
    }
    /**
     * 设置：订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取：订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }
    /**
     * 设置：金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取：金额
     */
    public BigDecimal getMoney() {
        return money;
    }
    /**
     * 设置：类型:1：用户申请 2: 平台返回
     */
    public void setTraType(Integer traType) {
        this.traType = traType;
    }

    /**
     * 获取：类型:1：用户申请 2: 平台返回
     */
    public Integer getTraType() {
        return traType;
    }
    /**
     * 类型:1：微信支付  11: 微信h5支付  2: 支付宝 
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 类型:1：微信支付  11: 微信h5支付  2: 支付宝 
     */
    public Integer getPayType() {
        return payType;
    }
    /**
     * 设置：创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCtime() {
        return ctime;
    }

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
 	*      类型:1：成功 2:失败 3:异常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
    
	
	
}
