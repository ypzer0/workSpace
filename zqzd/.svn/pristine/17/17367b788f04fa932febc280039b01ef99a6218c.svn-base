package com.platform.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdCategoryMapper;
import com.platform.dao.ApiZdGoodsInfoMapper;
import com.platform.dao.ApiZdHospitalMapper;
import com.platform.entity.ZdCategoryVo;
import com.platform.entity.ZdGoodsInfoVo;
import com.platform.entity.ZdHospitalVo;
import com.platform.utils.MapUtils;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

@Service
public class ApiZdGoodsInfoService {

	@Autowired
	private ApiZdGoodsInfoMapper apiZdGoodsInfoMapper;
	@Autowired
	private ApiZdHospitalMapper apiZdHospitalMapper;
	@Autowired
	private ApiZdCategoryMapper apiZdCategoryMapper;

	public Rp goodsList() {

		List<ZdGoodsInfoVo> list = apiZdGoodsInfoMapper.queryGoodsList();
		List<ZdCategoryVo> categoryList=apiZdCategoryMapper.queryAll();
		
		Integer total = apiZdGoodsInfoMapper.queryGoodsTotal();
		if (list.size()==0|| total == null) {
			return Rp.error("没有商品");
		}
		if(categoryList.size()==0) {
			return Rp.error("没有商品");
		}

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

		for (ZdGoodsInfoVo goods : list) {
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("gid", goods.getId());
			mapData.put("goodsName", goods.getGoodsName());
			mapData.put("goodsSn", goods.getGoodsSn());
			mapData.put("smallImgPath", goods.getSmallImgPath());
			mapData.put("price", goods.getPrice());
			mapData.put("status", goods.getStatus());
			mapData.put("goodsNumber", goods.getGoodsNumber());
			mapData.put("goodsDesc", goods.getGoodsDesc());
			dataList.add(mapData);

		}

		return Rp.ok().putDt("goodsList", dataList).putDt("categoryList", categoryList);
	}

	public Rp goodsCategory(Integer cId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cId", cId);
		List<ZdGoodsInfoVo> list = apiZdGoodsInfoMapper.goodsCategoryList(map);

		Integer total = apiZdGoodsInfoMapper.queryGoodsTotal();
		if (StringUtils.isNullOrEmpty(list) || total == null) {
			return Rp.error("没有商品");
		}

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

		for (ZdGoodsInfoVo goods : list) {
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("gid", goods.getId());
			mapData.put("goodsName", goods.getGoodsName());
			mapData.put("goodsSn", goods.getGoodsSn());
			mapData.put("smallImgPath", goods.getSmallImgPath());
			mapData.put("price", goods.getPrice());
			mapData.put("status", goods.getStatus());
			mapData.put("goodsNumber", goods.getGoodsNumber());
			mapData.put("goodsDesc", goods.getGoodsDesc());
			dataList.add(mapData);

		}

		return Rp.ok().putDt("goodsList", dataList);
	}

	public Rp goodsDetails(Integer id) {
		Map<String, Object> goods = apiZdGoodsInfoMapper.queryByGoodsId(id);

		if (StringUtils.isNullOrEmpty(goods)) {
			return Rp.error("数据异常");
		}
		return Rp.ok().putAllDt(goods);
	}

	public Rp specChoice(Integer id) {

		if (id == null) {
			return Rp.error("数据异常");
		}

		Map<String, Object> goods = apiZdGoodsInfoMapper.queryByGoodsId(id);
		List<ZdHospitalVo> hospital = apiZdHospitalMapper.queryHospitalList(0);

		if (StringUtils.isNullOrEmpty(goods) || hospital.size() == 0) {
			return Rp.error("数据异常");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goods", goods);
		map.put("hospitalList", hospital);

		return Rp.ok().putAllDt(map);

	}

	public Map<String, Object> success(Integer oid) {
		HashMap<String, Object> Goods = apiZdGoodsInfoMapper.payquerySuccess(oid);
		Map<String, Object> cMap = new HashMap<String, Object>();
		cMap.put("goodsCode", MapUtils.getString("goods_sn", Goods));
		cMap.put("gimg", MapUtils.getString("small_img_path", Goods));
		cMap.put("cid", MapUtils.getString("c_id", Goods));
		cMap.put("gname", MapUtils.getString("cName", Goods) + ":" + MapUtils.getString("goods_name", Goods));
		cMap.put("price", MapUtils.getString("order_price", Goods));

		return cMap;
	}
}
