package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.platform.dao.SmsTempDao;
import com.platform.entity.SmsTempEntity;
import com.platform.service.SmsTempService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-01 17:22:31
 */
@Service("smsTempService")
public class SmsTempServiceImpl implements SmsTempService {
    @Autowired
    private SmsTempDao smsTempDao;

    @Override
    public SmsTempEntity queryObject(Integer id) {
        return smsTempDao.queryObject(id);
    }

    @Override
    public List<SmsTempEntity> queryList(Map<String, Object> map) {
        return smsTempDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return smsTempDao.queryTotal(map);
    }

    @Override
    public int save(SmsTempEntity smsTemp) {
    	smsTemp.setUtime(new Date());
    	smsTemp.setCtime(new Date());
        return smsTempDao.save(smsTemp);
    }

    @Override
    public int update(SmsTempEntity smsTemp) {
    	smsTemp.setUtime(new Date());
        return smsTempDao.update(smsTemp);
    }

    @Override
    public int delete(Integer id) {
        return smsTempDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return smsTempDao.deleteBatch(ids);
    }
}
