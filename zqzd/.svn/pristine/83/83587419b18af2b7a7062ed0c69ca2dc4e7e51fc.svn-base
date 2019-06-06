package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ZdOpinionDao;
import com.platform.entity.ZdOpinionEntity;
import com.platform.service.ZdOpinionService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 13:13:21
 */
@Service("ZdopinionService")
public class ZdOpinionServiceImpl implements ZdOpinionService {
    @Autowired
    private ZdOpinionDao ZdopinionDao;

    @Override
    public ZdOpinionEntity queryObject(Integer id) {
        return ZdopinionDao.queryObject(id);
    }

    @Override
    public List<ZdOpinionEntity> queryList(Map<String, Object> map) {
        return ZdopinionDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdopinionDao.queryTotal(map);
    }

    @Override
    public int save(ZdOpinionEntity Zdopinion) {
        return ZdopinionDao.save(Zdopinion);
    }

    @Override
    public int update(ZdOpinionEntity Zdopinion) {
        return ZdopinionDao.update(Zdopinion);
    }

    @Override
    public int delete(Integer id) {
        return ZdopinionDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdopinionDao.deleteBatch(ids);
    }
}
