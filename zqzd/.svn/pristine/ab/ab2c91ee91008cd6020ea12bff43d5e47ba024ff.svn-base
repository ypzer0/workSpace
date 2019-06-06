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
import com.platform.service.ZdDepartmentService;
import com.platform.utils.R;

/**
 * Service实现类
 *
 * @author zy
 * @date 2019-06-01 13:14:14
 */
@Service("ZddepartmentService")
public class ZdDepartmentServiceImpl implements ZdDepartmentService {
    @Autowired
    private ZdDepartmentDao zddepartmentDao;
    @Autowired
    private ZdHospitalDao zdHospitalDao;

    @Override
    public ZdDepartmentEntity queryObject(Integer id) {
        return zddepartmentDao.queryObject(id);
    }

    @Override
    public List<ZdDepartmentEntity> queryList(Map<String, Object> map) {
        return zddepartmentDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return zddepartmentDao.queryTotal(map);
    }

    @Override
    public int save(ZdDepartmentEntity zddepartment) {
    	zddepartment.setAddTime(new Date());
        return zddepartmentDao.save(zddepartment);
    }

    @Override
    public int update(ZdDepartmentEntity Zddepartment) {
        return zddepartmentDao.update(Zddepartment);
    }

    @Override
    public int delete(Integer id) {
        return zddepartmentDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return zddepartmentDao.deleteBatch(ids);
    }

	@Override
	public R selectHospital() {
		try {
			HashMap<String,Object> params=new HashMap<>();
			List<ZdHospitalEntity> dataList=zdHospitalDao.queryList(params);
			List<HashMap<String,Object>> resultList=new ArrayList<>();
			for(ZdHospitalEntity entity:dataList) {
				HashMap<String,Object> resultMap=new HashMap<>(1);
				resultMap.put("key", entity.getId());
				resultMap.put("val", entity.getHospitalName());
				resultList.add(resultMap);
			}
			return R.ok().put("list", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("选择医院名称失败");
		}
	}
}
