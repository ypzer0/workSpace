package com.platform.dao;

import java.util.List;

import com.platform.entity.ZdCategoryVo;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:54:18
 */
public interface ApiZdCategoryMapper extends BaseDao<ZdCategoryVo> {

	List<ZdCategoryVo> queryAll();
	
}
