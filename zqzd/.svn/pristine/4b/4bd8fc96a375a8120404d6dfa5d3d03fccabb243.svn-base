package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.WalletInfoLogDao;
import com.platform.entity.WalletInfoLogEntity;
import com.platform.service.WalletInfoLogService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-18 10:21:34
 */
@Service("walletInfoLogService")
public class WalletInfoLogServiceImpl implements WalletInfoLogService {
    @Autowired
    private WalletInfoLogDao walletInfoLogDao;

    @Override
    public WalletInfoLogEntity queryObject(Integer id) {
        return walletInfoLogDao.queryObject(id);
    }

    @Override
    public List<WalletInfoLogEntity> queryList(Map<String, Object> map) {
        return walletInfoLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return walletInfoLogDao.queryTotal(map);
    }

    @Override
    public int save(WalletInfoLogEntity walletInfoLog) {
        return walletInfoLogDao.save(walletInfoLog);
    }

    @Override
    public int update(WalletInfoLogEntity walletInfoLog) {
        return walletInfoLogDao.update(walletInfoLog);
    }

    @Override
    public int delete(Integer id) {
        return walletInfoLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return walletInfoLogDao.deleteBatch(ids);
    }
}
