package com.platform.service;

import com.platform.entity.ZdGoodsInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 13:59:14
 */
public interface ZdGoodsInfoService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ZdGoodsInfoEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ZdGoodsInfoEntity> queryList(Map<String, Object> map);

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
     * @param ZdgoodsInfo 实体
     * @return 保存条数
     */
    int save(ZdGoodsInfoEntity ZdgoodsInfo);

    /**
     * 根据主键更新实体
     *
     * @param ZdgoodsInfo 实体
     * @return 更新条数
     */
    int update(ZdGoodsInfoEntity ZdgoodsInfo);

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
    
    /**
     * 根据主键批量修改商品状态
     *
     * @param ids
     * @return 删除条数
     */
    int updateStatus(Integer status, Integer[] ids);
}
