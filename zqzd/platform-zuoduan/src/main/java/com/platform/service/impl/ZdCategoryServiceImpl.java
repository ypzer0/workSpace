package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.dao.ZdCategoryDao;
import com.platform.entity.ZdCategoryEntity;
import com.platform.service.ZdCategoryService;
import com.platform.utils.R;

/**
 * Service实现类
 *
 * @author 杨鹏
 * @date 2019-05-30 14:28:27
 */
@Service("ZdcategoryService")
public class ZdCategoryServiceImpl implements ZdCategoryService {
    @Autowired
    private ZdCategoryDao ZdcategoryDao;

    @Override
    public ZdCategoryEntity queryObject(Integer id) {
        return ZdcategoryDao.queryObject(id);
    }

    @Override
    public List<ZdCategoryEntity> queryList(Map<String, Object> map) {
        return ZdcategoryDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdcategoryDao.queryTotal(map);
    }

    @Override
    public int save(ZdCategoryEntity Zdcategory) {
        return ZdcategoryDao.save(Zdcategory);
    }

    @Override
    public int update(ZdCategoryEntity Zdcategory) {
        return ZdcategoryDao.update(Zdcategory);
    }

    @Override
    public int delete(Integer id) {
        return ZdcategoryDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdcategoryDao.deleteBatch(ids);
    }

	@Override
	public R selectCategory() {
		try {
			//此处待扩展 
			//FIXME
			HashMap<String,Object> params=new HashMap<String,Object>();
			List<ZdCategoryEntity> categoryList=ZdcategoryDao.queryList(params);
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			for(ZdCategoryEntity categoryEntity:categoryList) {
				HashMap<String,Object> resultMap=new HashMap<String, Object>();
				resultMap.put("key",categoryEntity.getId());
				resultMap.put("val",categoryEntity.getName());
				resultList.add(resultMap);
			}
			return R.ok().put("list", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("获取目录名称失败");
		}
	}
}
