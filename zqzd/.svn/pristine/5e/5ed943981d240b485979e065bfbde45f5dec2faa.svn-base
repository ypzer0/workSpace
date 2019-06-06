package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.dao.ZdGoodsInfoDao;
import com.platform.entity.ZdGoodsInfoEntity;
import com.platform.service.ZdGoodsInfoService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 13:59:14
 */
@Service("ZdgoodsInfoService")
public class ZdGoodsInfoServiceImpl implements ZdGoodsInfoService {
    @Autowired
    private ZdGoodsInfoDao ZdgoodsInfoDao;

    @Override
    public ZdGoodsInfoEntity queryObject(Integer id) {
        return ZdgoodsInfoDao.queryObject(id);
    }

    @Override
    public List<ZdGoodsInfoEntity> queryList(Map<String, Object> map) {
        return ZdgoodsInfoDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdgoodsInfoDao.queryTotal(map);
    }

    @Override
    public int save(ZdGoodsInfoEntity ZdgoodsInfo) {
        return ZdgoodsInfoDao.save(ZdgoodsInfo);
    }

    @Override
    public int update(ZdGoodsInfoEntity ZdgoodsInfo) {
        return ZdgoodsInfoDao.update(ZdgoodsInfo);
    }

    @Override
    public int delete(Integer id) {
        return ZdgoodsInfoDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdgoodsInfoDao.deleteBatch(ids);
    }
    
    /**
     * 根据主键批量修改商品状态
     *
     * @param ids
     * @return 删除条数
     */
    @Override
    public int updateStatus(Integer status, Integer[] ids) {

    	Map<String, Object> maps = new HashMap<>();
    	maps.put("status", status);
    	maps.put("ids", ids);
    	return ZdgoodsInfoDao.updateStatus(maps);
    }
}
