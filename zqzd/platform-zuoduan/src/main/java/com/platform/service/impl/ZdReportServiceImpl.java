package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.platform.dao.ZdReportDao;
import com.platform.entity.ZdReportEntity;
import com.platform.service.ZdReportService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 11:36:26
 */
@Service("ZdreportService")
public class ZdReportServiceImpl implements ZdReportService {
    @Autowired
    private ZdReportDao ZdreportDao;

    @Override
    public ZdReportEntity queryObject(Integer id) {
        return ZdreportDao.queryObject(id);
    }

    @Override
    public List<ZdReportEntity> queryList(Map<String, Object> map) {
        return ZdreportDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdreportDao.queryTotal(map);
    }

    @Override
    public int save(ZdReportEntity zdreport) {
    	if(StringUtils.isEmpty(zdreport.getReportPath())) {
    		zdreport.setUploadStatus(0);
    	}
    	System.out.println("================="+zdreport.getuId()+"======================");
    	zdreport.setAddTime(new Date());
        return ZdreportDao.save(zdreport);
    }

    @Override
    public int update(ZdReportEntity zdreport) {
    	if(StringUtils.isEmpty(zdreport.getReportPath())) {
    		zdreport.setUploadStatus(0);
    	}
        return ZdreportDao.update(zdreport);
    }

    @Override
    public int delete(Integer id) {
        return ZdreportDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdreportDao.deleteBatch(ids);
    }
}
