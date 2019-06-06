package com.platform.service;

import com.platform.entity.OrderAskMsgEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
public interface OrderAskMsgService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    OrderAskMsgEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<OrderAskMsgEntity> queryList(Map<String, Object> map);

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
     * @param orderAskMsg 实体
     * @return 保存条数
     */
    int save(OrderAskMsgEntity orderAskMsg);

    /**
     * 根据主键更新实体
     *
     * @param orderAskMsg 实体
     * @return 更新条数
     */
    int update(OrderAskMsgEntity orderAskMsg);

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
     * 清除未读消息状态
     *
     * @param ids
     * @return 删除条数
     */
    int cleanNotRead(Long sysuid, Long uid);
    
}
