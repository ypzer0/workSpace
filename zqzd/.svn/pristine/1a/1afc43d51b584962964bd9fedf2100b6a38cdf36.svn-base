package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ZdEptOrderEdayDao;
import com.platform.entity.ZdEptOrderEdayEntity;
import com.platform.service.ZdEptOrderEdayService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
@Service("ZdeptOrderEdayService")
public class ZdEptOrderEdayServiceImpl implements ZdEptOrderEdayService {
    @Autowired
    private ZdEptOrderEdayDao ZdeptOrderEdayDao;

    @Override
    public ZdEptOrderEdayEntity queryObject(Integer id) {
        return ZdeptOrderEdayDao.queryObject(id);
    }

    @Override
    public List<ZdEptOrderEdayEntity> queryList(Map<String, Object> map) {
        return ZdeptOrderEdayDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdeptOrderEdayDao.queryTotal(map);
    }

    @Override
    public int save(ZdEptOrderEdayEntity ZdeptOrderEday) {
        return ZdeptOrderEdayDao.save(ZdeptOrderEday);
    }

    @Override
    public int update(ZdEptOrderEdayEntity ZdeptOrderEday) {
        return ZdeptOrderEdayDao.update(ZdeptOrderEday);
    }

    @Override
    public int delete(Integer id) {
        return ZdeptOrderEdayDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdeptOrderEdayDao.deleteBatch(ids);
    }
    
    @Override
    public int updateRptOrder(String btime) {
        return ZdeptOrderEdayDao.updateRptOrder(btime);
    }
}
