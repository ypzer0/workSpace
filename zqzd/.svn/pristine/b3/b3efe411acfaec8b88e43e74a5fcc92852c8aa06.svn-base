package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.PayLogDao;
import com.platform.entity.PayLogEntity;
import com.platform.service.PayLogService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-30 11:03:37
 */
@Service("payLogService")
public class PayLogServiceImpl implements PayLogService {
    @Autowired
    private PayLogDao payLogDao;

    @Override
    public PayLogEntity queryObject(Integer id) {
        return payLogDao.queryObject(id);
    }

    @Override
    public List<PayLogEntity> queryList(Map<String, Object> map) {
        return payLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return payLogDao.queryTotal(map);
    }

    @Override
    public int save(PayLogEntity payLog) {
        return payLogDao.save(payLog);
    }

    @Override
    public int update(PayLogEntity payLog) {
        return payLogDao.update(payLog);
    }

    @Override
    public int delete(Integer id) {
        return payLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return payLogDao.deleteBatch(ids);
    }
}
