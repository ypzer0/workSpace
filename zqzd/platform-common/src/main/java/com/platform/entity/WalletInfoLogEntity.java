package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 * 表名 wallet_info_log
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-18 10:21:34
 */
public class WalletInfoLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //流水Id
    private Integer wid;
    //操作人id
    private Integer uid;
    //类型:1.支出 2.收入 
    private Integer wtype1;
    //类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 
    private Integer wtype2;
    //金额
    private BigDecimal money;
    //标题
    private String title;
    //内容
    private String content;
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
     * 设置：流水Id
     */
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    /**
     * 获取：流水Id
     */
    public Integer getWid() {
        return wid;
    }
    /**
     * 设置：操作人id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取：操作人id
     */
    public Integer getUid() {
        return uid;
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
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
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
     * Wtype1中文名
     * @return
     */
    public String getWtype1Str() {
    	return WalletInfoLogEntity.getWtype1Name(wtype1);
    }

    /**
     * Wtype2中文名
     * @return
     */
    public String getWtype2Str() {
    	return WalletInfoLogEntity.getWtype2Name(wtype2);
    }
    
    //类型:1.支出 2.收入 
    public static String getWtype1Name(Integer status) {
    	String rt = "";
    	if(status == null) return rt;
    	switch (status) {
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

    //类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 
    public static String getWtype2Name(Integer status) {
    	String rt = "";
    	if(status == null) return rt;
    	switch (status) {
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
}
