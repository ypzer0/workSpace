package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 * 表名 wallet_info
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-18 10:21:34
 */
public class WalletInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //客户Id
    private Long uid;
    //金额
    private BigDecimal money;
    //类型:1.支出 2.收入 
    private Integer wtype1;
    //类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 
    private Integer wtype2;
    //订单号
    private String orderSn;
    //优惠劵Id
    private Integer couponId;
    //微信订单号
    private String transactionId;
    //商户订单号
    private String outTradeNo;
    //活动id
    private String activityId;
    //创建时间
    private Date ctime;

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
     * 设置：客户Id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取：客户Id
     */
    public Long getUid() {
        return uid;
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
     * 设置：类型:1.支出 2.收入 
     */
    public void setWtype1(Integer wtype1) {
        this.wtype1 = wtype1;
    }

    /**
     * 获取：类型:1.支出 2.收入 
     */
    public Integer getWtype1() {
        return wtype1;
    }
    /**
     * 设置：类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 
     */
    public void setWtype2(Integer wtype2) {
        this.wtype2 = wtype2;
    }

    /**
     * 获取：类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 
     */
    public Integer getWtype2() {
        return wtype2;
    }
    /**
     * 设置：订单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：订单号
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：优惠劵Id
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取：优惠劵Id
     */
    public Integer getCouponId() {
        return couponId;
    }
    /**
     * 设置：微信订单号
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 获取：微信订单号
     */
    public String getTransactionId() {
        return transactionId;
    }
    /**
     * 设置：商户订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * 获取：商户订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }
    /**
     * 设置：活动id
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取：活动id
     */
    public String getActivityId() {
        return activityId;
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
}
