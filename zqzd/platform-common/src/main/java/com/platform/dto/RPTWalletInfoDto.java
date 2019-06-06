package com.platform.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class RPTWalletInfoDto implements Serializable {
	    private static final long serialVersionUID = 1L;
	    //
	    private Integer id;
	    //客户Id
	    private Integer uid;
	    //客户昵称
	    @Excel(name = "客户名")
	    private String nickname;
	    //金额
	    @Excel(name = "金额")
	    private BigDecimal money;
	    //类型:1.支出 2.收入 
	    private Integer wtype1;
	    //类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 
	    private Integer wtype2;

	    @Excel(name = "科目1")
	    private String w1;
	    @Excel(name = "科目2")
	    private String w2;
	    
	    //订单号
	    @Excel(name = "订单号")
	    private String orderSn;
	    //优惠劵Id
	    private Integer couponId;
	    //微信订单号
	    @Excel(name = "微信订单号")
	    private String transactionId;
	    //商户订单号
	    @Excel(name = "商户订单号")
	    private String outTradeNo;
	    //活动id
	    private String activityId;
	    //创建时间
	    @Excel(name = "创建时间")
	    private Date ctime;
	    
	    public RPTWalletInfoDto() {
			// TODO Auto-generated method stub
		}
	    
	    /**
		 * @return the w1
		 */
		public String getW1() {
			return w1;
		}

		/**
		 * @param w1 the w1 to set
		 */
		public void setW1(String w1) {
			this.w1 = w1;
		}

		/**
		 * @return the w2
		 */
		public String getW2() {
			return w2;
		}

		/**
		 * @param w2 the w2 to set
		 */
		public void setW2(String w2) {
			this.w2 = w2;
		}

		//获取W1
	    public static String getW1(Integer w1) {
	    	String rt = "";
	    	switch (w1) {
			case 1:
				rt = "支出";
				break;
			case 2:
				rt = "收入";
				break;
			default:
				break;
			}
	    	return rt;
	    }
	    
	    //获取W2
	    public static String getW2(Integer w2) {

	    	String rt = "";
	    	switch (w2) {
			case 3:
				rt = "微信支付";
				break;
			case 4:
				rt = "退款";
				break;
			case 5:
				rt = "优惠劵抵扣";
				break;
			case 6:
				rt = "活动折扣";
				break;
			case 7:
				rt = "配送费";
				break;
			default:
				break;
			}
	    	return rt;
	    }
	    
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the uid
		 */
		public Integer getUid() {
			return uid;
		}
		/**
		 * @param uid the uid to set
		 */
		public void setUid(Integer uid) {
			this.uid = uid;
		}
		/**
		 * @return the nick
		 */
		public String getNickname() {
			return nickname;
		}
		/**
		 * @param nick the nick to set
		 */
		public void setNickname(String nick) {
			this.nickname = nick;
		}
		/**
		 * @return the money
		 */
		public BigDecimal getMoney() {
			return money;
		}
		/**
		 * @param money the money to set
		 */
		public void setMoney(BigDecimal money) {
			this.money = money;
		}
		/**
		 * @return the wtype1
		 */
		public Integer getWtype1() {
			return wtype1;
		}
		/**
		 * @param wtype1 the wtype1 to set
		 */
		public void setWtype1(Integer wtype1) {
			this.wtype1 = wtype1;
		}
		/**
		 * @return the wtype2
		 */
		public Integer getWtype2() {
			return wtype2;
		}
		/**
		 * @param wtype2 the wtype2 to set
		 */
		public void setWtype2(Integer wtype2) {
			this.wtype2 = wtype2;
		}
		/**
		 * @return the orderSn
		 */
		public String getOrderSn() {
			return orderSn;
		}
		/**
		 * @param orderSn the orderSn to set
		 */
		public void setOrderSn(String orderSn) {
			this.orderSn = orderSn;
		}
		/**
		 * @return the couponId
		 */
		public Integer getCouponId() {
			return couponId;
		}
		/**
		 * @param couponId the couponId to set
		 */
		public void setCouponId(Integer couponId) {
			this.couponId = couponId;
		}
		/**
		 * @return the transactionId
		 */
		public String getTransactionId() {
			return transactionId;
		}
		/**
		 * @param transactionId the transactionId to set
		 */
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		/**
		 * @return the outTradeNo
		 */
		public String getOutTradeNo() {
			return outTradeNo;
		}
		/**
		 * @param outTradeNo the outTradeNo to set
		 */
		public void setOutTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
		}
		/**
		 * @return the activityId
		 */
		public String getActivityId() {
			return activityId;
		}
		/**
		 * @param activityId the activityId to set
		 */
		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}
		/**
		 * @return the ctime
		 */
		public Date getCtime() {
			return ctime;
		}
		/**
		 * @param ctime the ctime to set
		 */
		public void setCtime(Date ctime) {
			this.ctime = ctime;
		}
	    
	    
	    
}
