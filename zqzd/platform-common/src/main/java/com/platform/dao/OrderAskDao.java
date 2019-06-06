package com.platform.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.OrderAskEntity;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
public interface OrderAskDao extends BaseDao<OrderAskEntity> {
	
	Map<String, Object> getOrder(@Param("orderSn") String orderSn);
	int updateOrderStatus(Map<String, Object> paras);
}
