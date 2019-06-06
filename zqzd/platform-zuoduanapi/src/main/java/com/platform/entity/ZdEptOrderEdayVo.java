package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_ept_order_eday
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
public class ZdEptOrderEdayVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //总下单数
    private Integer total;
    //完成订单数
    private Integer completed;
    //未完成订单数
    private Integer unfinished;
    //失败订单数
    private Integer failed;
    //统计时间
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
     * 设置：总下单数
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 获取：总下单数
     */
    public Integer getTotal() {
        return total;
    }
    /**
     * 设置：完成订单数
     */
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    /**
     * 获取：完成订单数
     */
    public Integer getCompleted() {
        return completed;
    }
    /**
     * 设置：未完成订单数
     */
    public void setUnfinished(Integer unfinished) {
        this.unfinished = unfinished;
    }

    /**
     * 获取：未完成订单数
     */
    public Integer getUnfinished() {
        return unfinished;
    }
    /**
     * 设置：失败订单数
     */
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    /**
     * 获取：失败订单数
     */
    public Integer getFailed() {
        return failed;
    }
    /**
     * 设置：统计时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取：统计时间
     */
    public Date getCtime() {
        return ctime;
    }
}
