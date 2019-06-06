package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统操作日志实体
 * 表名 sys_oper_log
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-15 14:53:46
 */
public class SysOperLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //标志id
    private Integer flag;
    //操作人
    private Integer hid;
    //操作名称
    private String name;
    //请求方法
    private String title;
    //请求参数
    private String params;
    //创建时间
    private Date createDate;

    //用户名
    private String username;
    
    //部门名称
    private String deptName;
    
    
    
    
    public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", flag:" + flag + ", hid:" + hid + ", name:" + name + ", title:" + title + ", params:"
				+ params + ", createDate:" + createDate + ", username:" + username + "}";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：标志id
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取：标志id
     */
    public Integer getFlag() {
        return flag;
    }
    /**
     * 设置：操作人
     */
    public void setHid(Integer hid) {
        this.hid = hid;
    }

    /**
     * 获取：操作人
     */
    public Integer getHid() {
        return hid;
    }
    /**
     * 设置：操作名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：操作名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：请求方法
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：请求方法
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：请求参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取：请求参数
     */
    public String getParams() {
        return params;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }
}
