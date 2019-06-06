package com.platform.service;

import com.platform.dto.RPTWalletCountDto;
import com.platform.dto.RPTWalletInfoDto;
import com.platform.entity.WalletInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-18 10:21:34
 */
public interface WalletInfoService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    WalletInfoEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<WalletInfoEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param walletInfo 实体
     * @return 保存条数
     */
    int save(WalletInfoEntity walletInfo);

    /**
     * 根据主键更新实体
     *
     * @param walletInfo 实体
     * @return 更新条数
     */
    int update(WalletInfoEntity walletInfo);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
    
    /**
     * 财务资金流水明细报表
     * @param map
     * @return
     */
    List<RPTWalletInfoDto> rptQueryWallet(Map<String, Object> map);
    
    /**
     * 财务资金流水明细报表总数据大小
     * @param map
     * @return
     */
    int rptQueryWalletTotal(Map<String, Object> map);
    /**
     * 财务资金流水明细报表数据汇总
     * @param map
     * @return
     */
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
