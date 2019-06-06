package com.platform.dao;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.OrderAskMsgEntity;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
public interface OrderAskMsgDao extends BaseDao<OrderAskMsgEntity> {
	
	//清空消息未读状态
	int cleanNotRead(@Param("sysuid") Object sysuid, @Param("uid") Object uid);

}
