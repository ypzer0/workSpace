package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 zd_category
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 14:28:27
 */
public class ZdCategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //种类名称
    private String name;
    //关键字
    private String keywords;
    //上级id
    private Integer parentId;

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
     * 设置：种类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：种类名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：关键字
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 获取：关键字
     */
    public String getKeywords() {
        return keywords;
    }
    /**
     * 设置：上级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：上级id
     */
    public Integer getParentId() {
        return parentId;
    }
}
