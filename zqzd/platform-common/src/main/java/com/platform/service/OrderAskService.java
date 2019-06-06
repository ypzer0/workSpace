package com.platform.service;

import com.platform.dto.HandlerOAskPDto;
import com.platform.entity.OrderAskEntity;
import com.platform.entity.SysUserEntity;
import com.platform.utils.R;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
public interface OrderAskService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    OrderAskEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<OrderAskEntity> queryList(Map<String, Object> map);

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
     * @param orderAsk 实体
     * @return 保存条数
     */
    int save(OrderAskEntity orderAsk);

    /**
     * 根据主键更新实体
     *
     * @param orderAsk 实体
     * @return 更新条数
     */
    int update(OrderAskEntity orderAsk);

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
     * 处理申请
     * @param para
     * @return
     */
    R handler(HandlerOAskPDto para, SysUserEntity sysUser);
    /**
     * 发送消息
     * @param para
     * @return
     */
    R sendmsg(HandlerOAskPDto para, SysUserEntity sysUser);
    /**
     * 获取订单信息
     * @param para
     * @return
     */
    R getOrder(String orderSn);
    /**
     * 获取订单信息
     * @param para
     * @return
     */
    R updateOrderStatus(Map<String, Object> para);
    
    
}
