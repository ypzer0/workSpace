package com.platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ZdDepartmentDao;
import com.platform.dao.ZdDoctorDao;
import com.platform.dao.ZdHospitalDao;
import com.platform.entity.ZdDepartmentEntity;
import com.platform.entity.ZdDoctorEntity;
import com.platform.entity.ZdHospitalEntity;
import com.platform.service.ZdDoctorService;
import com.platform.utils.R;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 15:08:05
 */
@Service("ZddoctorService")
public class ZdDoctorServiceImpl implements ZdDoctorService {
    @Autowired
    private ZdDoctorDao ZddoctorDao;
    @Autowired
    private ZdDepartmentDao zdDepartmentDao;
    @Autowired
    private ZdHospitalDao zdHospitalDao;
    
    @Override
    public ZdDoctorEntity queryObject(Integer id) {
    	ZdDoctorEntity zdDoctorEntity=ZddoctorDao.queryObject(id);
    	ZdDepartmentEntity zdDepartmentEntity=zdDepartmentDao.queryObject(zdDoctorEntity.getDepartmentId());
    	zdDoctorEntity.setDepartmentName(zdDepartmentEntity.getDepartmentName());
    	zdDoctorEntity.setHospitalName(zdHospitalDao.queryObject(zdDepartmentEntity.getHospitalId()).getHospitalName());
        return zdDoctorEntity;
    }

    @Override
    public List<ZdDoctorEntity> queryList(Map<String, Object> map) {
        return ZddoctorDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZddoctorDao.queryTotal(map);
    }

    @Override
    public R save(ZdDoctorEntity Zddoctor) {
    	Date date=new Date();
    	try {
			ZdHospitalEntity zdHospitalEntity=new ZdHospitalEntity();
			zdHospitalEntity.setHospitalName(Zddoctor.getHospitalName());
			zdHospitalEntity.setHandlerId(0);
			zdHospitalEntity.setIsDelete(0);
			zdHospitalEntity.setAddTime(date);
			zdHospitalDao.save(zdHospitalEntity);
			ZdHospitalEntity hospital=zdHospitalDao.queryIdByhospitalName(Zddoctor.getHospitalName());
			ZdDepartmentEntity zdDepartmentEntity=new ZdDepartmentEntity();
			zdDepartmentEntity.setDepartmentName(Zddoctor.getDepartmentName());
			zdDepartmentEntity.setAddTime(date);
			zdDepartmentEntity.setHandlerId(0);
			zdDepartmentEntity.setIsDelete(0);
			zdDepartmentEntity.setHospitalId(hospital.getId());
			zdDepartmentDao.save(zdDepartmentEntity);
			ZdDepartmentEntity department=zdDepartmentDao.queryIdByDepartmentName(Zddoctor.getDepartmentName());
			ZdDoctorEntity zdDoctorEntity=new ZdDoctorEntity();
			zdDoctorEntity.setDoctorName(Zddoctor.getDoctorName());
			zdDoctorEntity.setDepartmentId(department.getId());
			zdDoctorEntity.setAddTime(date);
			zdDoctorEntity.setHandlerId(0);
			zdDoctorEntity.setIsDelete(0);
			ZddoctorDao.save(zdDoctorEntity);
			return R.ok();
		} catch (Exception e) {
			return R.error("数据异常，请稍后再试");
		}
        
    }

    @Override
    public int update(ZdDoctorEntity Zddoctor) {
        return ZddoctorDao.update(Zddoctor);
    }

    @Override
    public int delete(Integer id) {
        return ZddoctorDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZddoctorDao.deleteBatch(ids);
    }
    
    @Override
	public R selectDepartment() {
		try {
			HashMap<String,Object> params=new HashMap<>();
			List<ZdDepartmentEntity> dataList=zdDepartmentDao.queryList(params);
			List<HashMap<String,Object>> resultList=new ArrayList<>();
			for(ZdDepartmentEntity entity:dataList) {
				HashMap<String,Object> resultMap=new HashMap<>(1);
				resultMap.put("key", entity.getId());
				resultMap.put("val", entity.getDepartmentName());
				resultList.add(resultMap);
			}
			return R.ok().put("list", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("选择科室名称失败");
		}
	}
}
