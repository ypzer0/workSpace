package com.platform.service;

import com.platform.entity.ZdCategoryEntity;
import com.platform.utils.R;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author 杨鹏
 * @date 2019-05-30 14:28:27
 */
public interface ZdCategoryService {
	/**
	 * 	查询 	商品目录集合
	 * @return 目录集合
	 */
	R selectCategory();

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ZdCategoryEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ZdCategoryEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param Zdcategory 实体
     * @return 保存条数
     */
    int save(ZdCategoryEntity Zdcategory);

    /**
     * 根据主键更新实体
     *
     * @param Zdcategory 实体
     * @return 更新条数
     */
    int update(ZdCategoryEntity Zdcategory);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
}
