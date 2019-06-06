package com.platform.dao;

import java.util.List;
import java.util.Map;

import com.platform.dto.RPTWalletCountDto;
import com.platform.dto.RPTWalletInfoDto;
import com.platform.entity.WalletInfoEntity;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-18 10:21:34
 */
public interface WalletInfoDao extends BaseDao<WalletInfoEntity> {
	
	List<RPTWalletInfoDto> rptQueryWallet(Map<String, Object> map);
	int rptQueryWalletTotal(Map<String, Object> map);
	Map<String, Object> rptQueryWalletSum(Map<String, Object> map);
	

    /**
     * 财务资金统计报表
     * @param map
     * @return
     */
    List<RPTWalletCountDto> rptQueryWalletCount(Map<String, Object> map);

    /**
     * 财务资金统计数据汇总
     * @param map
     * @return
     */
    int rptQueryWalletCountTotal(Map<String, Object> map);

    /**
     * 财务资金统计汇总
     * @param map
     * @return
     */
    Map<String, Object> rptQueryWalletCountSum(Map<String, Object> map);
}
