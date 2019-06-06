package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.OrderAskMsgDao;
import com.platform.entity.OrderAskMsgEntity;
import com.platform.service.OrderAskMsgService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
@Service("orderAskMsgService")
public class OrderAskMsgServiceImpl implements OrderAskMsgService {
    @Autowired
    private OrderAskMsgDao orderAskMsgDao;

    @Override
    public OrderAskMsgEntity queryObject(Integer id) {
        return orderAskMsgDao.queryObject(id);
    }

    @Override
    public List<OrderAskMsgEntity> queryList(Map<String, Object> map) {
        return orderAskMsgDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderAskMsgDao.queryTotal(map);
    }

    @Override
    public int save(OrderAskMsgEntity orderAskMsg) {
        return orderAskMsgDao.save(orderAskMsg);
    }

    @Override
    public int update(OrderAskMsgEntity orderAskMsg) {
        return orderAskMsgDao.update(orderAskMsg);
    }

    @Override
    public int delete(Integer id) {
        return orderAskMsgDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return orderAskMsgDao.deleteBatch(ids);
    }

    /**
     * 清除未读消息状态
     *
     * @param ids
     * @return 删除条数
     */

    @Override
    public int cleanNotRead(Long sysuid, Long uid) {
        return orderAskMsgDao.cleanNotRead(sysuid, uid);
    }
}
