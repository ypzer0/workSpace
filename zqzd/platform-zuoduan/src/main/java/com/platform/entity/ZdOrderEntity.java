package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 * 表名 zd_order
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 10:04:31
 */
public class ZdOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //商品id
    private Integer goodsId;
    //订单状态  0：未支付  1：支付成功  2：支付失败
    private Integer orderStatus;
    //购买成功0:未支付 1:支付成功
    private Integer payStatus;
    //用户ID
    private Integer userId;
    //下单数量
    private Integer orderNumber;
    //订单编号
    private String orderSn;
    //医院Id
    private Integer hospitalId;
    //科室Id
    private Integer departmentId;
    //医生Id
    private Integer doctorId;
    //下单时间
    private Date confirmTime;
    //支付时间
    private Date payTime;
    //商品名称
    private String goodsName;
    //用户昵称
    private String nickname;
    //订单价格
    private BigDecimal orderPrice;
    
    

    public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
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
     * 设置：商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：商品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }
    /**
     * 设置：订单状态  0：未支付  1：支付成功  2：支付失败
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取：订单状态  0：未支付  1：支付成功  2：支付失败
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }
    /**
     * 设置：购买成功0:未支付 1:支付成功
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取：购买成功0:未支付 1:支付成功
     */
    public Integer getPayStatus() {
        return payStatus;
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
     * 设置：下单数量
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取：下单数量
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }
    /**
     * 设置：订单编号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：订单编号
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：医院Id
     */
    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * 获取：医院Id
     */
    public Integer getHospitalId() {
        return hospitalId;
    }
    /**
     * 设置：科室Id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取：科室Id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
    /**
     * 设置：医生Id
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * 获取：医生Id
     */
    public Integer getDoctorId() {
        return doctorId;
    }
    /**
     * 设置：下单时间
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * 获取：下单时间
     */
    public Date getConfirmTime() {
        return confirmTime;
    }
    /**
     * 设置：支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取：支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
