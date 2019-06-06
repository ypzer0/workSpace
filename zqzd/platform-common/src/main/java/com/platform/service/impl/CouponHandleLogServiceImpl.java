package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.CouponHandleLogDao;
import com.platform.entity.CouponHandleLogEntity;
import com.platform.service.CouponHandleLogService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-15 14:53:46
 */
@Service("couponHandleLogService")
public class CouponHandleLogServiceImpl implements CouponHandleLogService {
    @Autowired
    private CouponHandleLogDao couponHandleLogDao;

    @Override
    public CouponHandleLogEntity queryObject(Integer id) {
        return couponHandleLogDao.queryObject(id);
    }

    @Override
    public List<CouponHandleLogEntity> queryList(Map<String, Object> map) {
        return couponHandleLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return couponHandleLogDao.queryTotal(map);
    }

    @Override
    public int save(CouponHandleLogEntity couponHandleLog) {
        return couponHandleLogDao.save(couponHandleLog);
    }

    @Override
    public int update(CouponHandleLogEntity couponHandleLog) {
        return couponHandleLogDao.update(couponHandleLog);
    }

    @Override
    public int delete(Integer id) {
        return couponHandleLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return couponHandleLogDao.deleteBatch(ids);
    }
}
