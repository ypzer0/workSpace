package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_ept_user_eday
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
public class ZdEptUserEdayVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //注册数
    private Integer reg;
    //活跃数
    private Integer online;
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
     * 设置：注册数
     */
    public void setReg(Integer reg) {
        this.reg = reg;
    }

    /**
     * 获取：注册数
     */
    public Integer getReg() {
        return reg;
    }
    /**
     * 设置：活跃数
     */
    public void setOnline(Integer online) {
        this.online = online;
    }

    /**
     * 获取：活跃数
     */
    public Integer getOnline() {
        return online;
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
