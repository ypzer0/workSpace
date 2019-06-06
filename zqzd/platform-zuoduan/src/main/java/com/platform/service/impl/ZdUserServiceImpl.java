package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ZdUserDao;
import com.platform.entity.ZdUserEntity;
import com.platform.service.ZdUserService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 15:31:22
 */
@Service("ZduserService")
public class ZdUserServiceImpl implements ZdUserService {
    @Autowired
    private ZdUserDao ZduserDao;

    @Override
    public ZdUserEntity queryObject(Integer id) {
        return ZduserDao.queryObject(id);
    }

    @Override
    public List<ZdUserEntity> queryList(Map<String, Object> map) {
        return ZduserDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZduserDao.queryTotal(map);
    }

    @Override
    public int save(ZdUserEntity Zduser) {
        return ZduserDao.save(Zduser);
    }

    @Override
    public int update(ZdUserEntity Zduser) {
        return ZduserDao.update(Zduser);
    }

    @Override
    public int delete(Integer id) {
        return ZduserDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZduserDao.deleteBatch(ids);
    }
}
