package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.dao.ZdDepartmentDao;
import com.platform.dao.ZdHospitalDao;
import com.platform.entity.ZdDepartmentEntity;
import com.platform.entity.ZdHospitalEntity;
import com.platform.service.ZdHospitalService;
import com.platform.utils.R;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 11:43:55
 */
@Service("ZdhospitalService")
public class ZdHospitalServiceImpl implements ZdHospitalService {
    @Autowired
    private ZdHospitalDao zdhospitalDao;
   

    @Override
    public ZdHospitalEntity queryObject(Integer id) {
        return zdhospitalDao.queryObject(id);
    }

    @Override
    public List<ZdHospitalEntity> queryList(Map<String, Object> map) {
        return zdhospitalDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return zdhospitalDao.queryTotal(map);
    }

    @Override
    public int save(ZdHospitalEntity zdhospital) {
    	zdhospital.setAddTime(new Date());
        return zdhospitalDao.save(zdhospital);
    }

    @Override
    public int update(ZdHospitalEntity Zdhospital) {
        return zdhospitalDao.update(Zdhospital);
    }

    @Override
    public int delete(Integer id) {
        return zdhospitalDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return zdhospitalDao.deleteBatch(ids);
    }
    
    
}
