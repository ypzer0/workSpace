package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_coupon_log
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-15 14:53:46
 */
public class CouponLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //优惠劵id
    private Integer cid;
    //发放方式
    private Integer sendType;
    //变化原因
    private String reson;
    //类型 1:增加  2:减少
    private Integer changeType;
    //数量
    private Integer change;
    //客户
    private Integer uid;
    //客户昵称
    private String uname;
    //操作人
    private Integer handerId;
    //操作人
    private String handerName;
    //记录时间
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
     * 设置：优惠劵id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取：优惠劵id
     */
    public Integer getCid() {
        return cid;
    }
    /**
     * 设置：发放方式
     */
    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    /**
     * 获取：发放方式
     */
    public Integer getSendType() {
        return sendType;
    }
    /**
     * 设置：变化原因
     */
    public void setReson(String reson) {
        this.reson = reson;
    }

    /**
     * 获取：变化原因
     */
    public String getReson() {
        return reson;
    }
    /**
     * 设置：类型 1:增加  2:减少
     */
    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    /**
     * 获取：类型 1:增加  2:减少
     */
    public Integer getChangeType() {
        return changeType;
    }
    /**
     * 设置：数量
     */
    public void setChange(Integer change) {
        this.change = change;
    }

    /**
     * 获取：数量
     */
    public Integer getChange() {
        return change;
    }
    /**
     * 设置：客户
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取：客户
     */
    public Integer getUid() {
        return uid;
    }
    /**
     * 设置：客户昵称
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * 获取：客户昵称
     */
    public String getUname() {
        return uname;
    }
    /**
     * 设置：操作人
     */
    public void setHanderId(Integer handerId) {
        this.handerId = handerId;
    }

    /**
     * 获取：操作人
     */
    public Integer getHanderId() {
        return handerId;
    }
    /**
     * 设置：操作人
     */
    public void setHanderName(String handerName) {
        this.handerName = handerName;
    }

    /**
     * 获取：操作人
     */
    public String getHanderName() {
        return handerName;
    }
    /**
     * 设置：记录时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取：记录时间
     */
    public Date getCtime() {
        return ctime;
    }
}
