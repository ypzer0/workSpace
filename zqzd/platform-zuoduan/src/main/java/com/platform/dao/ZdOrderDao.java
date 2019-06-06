package com.platform.dao;

import java.math.BigDecimal;

import com.platform.entity.ZdOrderEntity;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 10:04:31
 */
public interface ZdOrderDao extends BaseDao<ZdOrderEntity> {
	BigDecimal querySumOrderPrice();
	
	BigDecimal querySumOrderPrice(Integer payStatus);
	
	int orderClose24h();
}
