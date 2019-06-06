package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ZdEptUserEdayDao;
import com.platform.entity.ZdEptUserEdayEntity;
import com.platform.service.ZdEptUserEdayService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
@Service("ZdeptUserEdayService")
public class ZdEptUserEdayServiceImpl implements ZdEptUserEdayService {
    @Autowired
    private ZdEptUserEdayDao ZdeptUserEdayDao;

    @Override
    public ZdEptUserEdayEntity queryObject(Integer id) {
        return ZdeptUserEdayDao.queryObject(id);
    }

    @Override
    public List<ZdEptUserEdayEntity> queryList(Map<String, Object> map) {
        return ZdeptUserEdayDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdeptUserEdayDao.queryTotal(map);
    }

    @Override
    public int save(ZdEptUserEdayEntity ZdeptUserEday) {
        return ZdeptUserEdayDao.save(ZdeptUserEday);
    }

    @Override
    public int update(ZdEptUserEdayEntity ZdeptUserEday) {
        return ZdeptUserEdayDao.update(ZdeptUserEday);
    }

    @Override
    public int delete(Integer id) {
        return ZdeptUserEdayDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdeptUserEdayDao.deleteBatch(ids);
    }
    
    @Override
    public int updateRptCustomer(String btime) {
        return ZdeptUserEdayDao.updateRptCustomer(btime);
    }
}
