package com.platform.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.ZdGoodsInfoVo;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:54:18
 */
public interface ApiZdGoodsInfoMapper extends BaseDao<ZdGoodsInfoVo> {

	List<ZdGoodsInfoVo> queryGoodsList();
	
	List<ZdGoodsInfoVo> goodsCategoryList(Map<String ,Object> map);
	
	Integer queryGoodsTotal();
	
	Map<String , Object >  queryByGoodsId(Integer id);
	
	ZdGoodsInfoVo queryBuyGoods(@Param(value="count")Integer count,@Param(value="id")Integer id);
	
	/**
	 * 查询订单绑定的商品信息
	 * @param oid
	 * @return
	 */
	List<ZdGoodsInfoVo> queryGoodsByOId(@Param(value = "oid") Integer oid, @Param(value = "uid") Integer uid);
	
	HashMap<String, Object> payquerySuccess(Integer oid);
	
}
