package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_order_ask_log
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:26
 */
public class OrderAskLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //日志内容
    private String msg;
    //用户Id
    private Integer uid;
    //用户昵称
    private String uName;
    //回复人Id
    private Integer handerId;
    //操作人
    private String handerName;
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
     * 设置：日志内容
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取：日志内容
     */
    public String getMsg() {
        return msg;
    }
    /**
     * 设置：用户Id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取：用户Id
     */
    public Integer getUid() {
        return uid;
    }
    /**
     * 设置：用户昵称
     */
    public void setUName(String uName) {
        this.uName = uName;
    }

    /**
     * 获取：用户昵称
     */
    public String getUName() {
        return uName;
    }
    /**
     * 设置：回复人Id
     */
    public void setHanderId(Integer handerId) {
        this.handerId = handerId;
    }

    /**
     * 获取：回复人Id
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
