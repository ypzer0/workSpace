package com.platform.dao;

import java.util.List;

import com.platform.entity.ZdCategoryEntity;

/**
 * @author 杨鹏
 * @date 2019-05-30 14:28:27
 */
public interface ZdCategoryDao extends BaseDao<ZdCategoryEntity> {
	List<String> selectCategory();
}
