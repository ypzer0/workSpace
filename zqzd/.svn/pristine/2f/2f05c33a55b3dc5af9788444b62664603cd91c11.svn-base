package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.WalletInfoDao;
import com.platform.dto.RPTWalletCountDto;
import com.platform.dto.RPTWalletInfoDto;
import com.platform.entity.WalletInfoEntity;
import com.platform.service.WalletInfoService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-18 10:21:34
 */
@Service("walletInfoService")
public class WalletInfoServiceImpl implements WalletInfoService {
    @Autowired
    private WalletInfoDao walletInfoDao;

    @Override
    public WalletInfoEntity queryObject(Integer id) {
        return walletInfoDao.queryObject(id);
    }

    @Override
    public List<WalletInfoEntity> queryList(Map<String, Object> map) {
        return walletInfoDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return walletInfoDao.queryTotal(map);
    }

    @Override
    public int save(WalletInfoEntity walletInfo) {
        return walletInfoDao.save(walletInfo);
    }

    @Override
    public int update(WalletInfoEntity walletInfo) {
        return walletInfoDao.update(walletInfo);
    }

    @Override
    public int delete(Integer id) {
        return walletInfoDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return walletInfoDao.deleteBatch(ids);
    }
    
    @Override
    public List<RPTWalletInfoDto> rptQueryWallet(Map<String, Object> map) {
    	List<RPTWalletInfoDto> result = walletInfoDao.rptQueryWallet(map);
    	for (RPTWalletInfoDto rptWalletInfoDto : result) {
    		rptWalletInfoDto.setW1(RPTWalletInfoDto.getW1(rptWalletInfoDto.getWtype1()));
    		rptWalletInfoDto.setW2(RPTWalletInfoDto.getW2(rptWalletInfoDto.getWtype2()));
		}
    	return result;
    }
    

    @Override
    public int rptQueryWalletTotal(Map<String, Object> map) {
        return walletInfoDao.rptQueryWalletTotal(map);
    }
    

    /**
     * 财务资金流水明细报表数据汇总
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> rptQueryWalletSum(Map<String, Object> map){
        return walletInfoDao.rptQueryWalletSum(map);
    }
    
    
    

    /**
     * 财务资金统计报表
     * @param map
     * @return
     */
    @Override
    public List<RPTWalletCountDto> rptQueryWalletCount(Map<String, Object> map){

    	List<RPTWalletCountDto> result = walletInfoDao.rptQueryWalletCount(map);
    	return result;
    }

    /**
     * 财务资金统计数据汇总
     * @param map
     * @return
     */
    @Override
    public int rptQueryWalletCountTotal(Map<String, Object> map) {
        return walletInfoDao.rptQueryWalletCountTotal(map);
    }

    /**
     * 财务资金统计汇总
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> rptQueryWalletCountSum(Map<String, Object> map){
        return walletInfoDao.rptQueryWalletCountSum(map);
    }
    
    
}
