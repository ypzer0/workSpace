package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.CouponLogDao;
import com.platform.entity.CouponLogEntity;
import com.platform.service.CouponLogService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-15 14:53:46
 */
@Service("couponLogService")
public class CouponLogServiceImpl implements CouponLogService {
    @Autowired
    private CouponLogDao couponLogDao;

    @Override
    public CouponLogEntity queryObject(Integer id) {
        return couponLogDao.queryObject(id);
    }

    @Override
    public List<CouponLogEntity> queryList(Map<String, Object> map) {
        return couponLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return couponLogDao.queryTotal(map);
    }

    @Override
    public int save(CouponLogEntity couponLog) {
        return couponLogDao.save(couponLog);
    }

    @Override
    public int update(CouponLogEntity couponLog) {
        return couponLogDao.update(couponLog);
    }

    @Override
    public int delete(Integer id) {
        return couponLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return couponLogDao.deleteBatch(ids);
    }
}
