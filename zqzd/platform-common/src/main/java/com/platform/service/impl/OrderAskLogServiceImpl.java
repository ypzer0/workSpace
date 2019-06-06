package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.OrderAskLogDao;
import com.platform.entity.OrderAskLogEntity;
import com.platform.service.OrderAskLogService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:26
 */
@Service("orderAskLogService")
public class OrderAskLogServiceImpl implements OrderAskLogService {
    @Autowired
    private OrderAskLogDao orderAskLogDao;

    @Override
    public OrderAskLogEntity queryObject(Integer id) {
        return orderAskLogDao.queryObject(id);
    }

    @Override
    public List<OrderAskLogEntity> queryList(Map<String, Object> map) {
        return orderAskLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderAskLogDao.queryTotal(map);
    }

    @Override
    public int save(OrderAskLogEntity orderAskLog) {
        return orderAskLogDao.save(orderAskLog);
    }

    @Override
    public int update(OrderAskLogEntity orderAskLog) {
        return orderAskLogDao.update(orderAskLog);
    }

    @Override
    public int delete(Integer id) {
        return orderAskLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return orderAskLogDao.deleteBatch(ids);
    }
}
