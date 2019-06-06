package com.platform.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdOrderMapper;
import com.platform.entity.ZdOrderVo;
import com.platform.entity.ZdUserVo;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

@Service
public class ApiZdOrderService {
	
	@Autowired
	private ApiZdOrderMapper apiZdOrderMapper;
	
	public Rp orderList(ZdUserVo nowUser,Integer payStatus) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请您重新登录");
		}
		if(payStatus==null) {
			return Rp.error("数据异常");
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userId", nowUser.getId());
		map.put("payStatus", payStatus);
		
		List<ZdOrderVo> orderList=apiZdOrderMapper.queryOrderList(map);
	
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		
		for (ZdOrderVo order : orderList) {
			Map<String , Object> mapData=new HashMap<String, Object>();
			mapData.put("id",order.getId());
			mapData.put("goodsName", order.getGoodsName());
			mapData.put("smallImgPath", order.getSmallImgPath());
			mapData.put("orderPrice", order.getOrderPrice());
			mapData.put("confirmTime", order.getConfirmTime());
			mapData.put("orderStatus", order.getOrderStatus());
			mapData.put("orderNumber", order.getOrderNumber());
			mapData.put("orderSn", order.getOrderSn());
			dataList.add(mapData);
		}
		
		return Rp.ok().putDt("orderList", dataList);
	}
	
	public Rp orderDetails(ZdUserVo nowUser,Integer id) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请您重新登录");
		}
		if(id==null) {
			return Rp.error("数据异常");
		}
		ZdOrderVo order=apiZdOrderMapper.queryOrderDetails(id);
		if(order.getUserId()!=nowUser.getId()) {
			return Rp.error("数据异常");
		}
		Map<String ,Object> map=new HashMap<String, Object>();
		map.put("goodsName", order.getGoodsName());
		map.put("orderNumber", order.getOrderNumber());
		map.put("goodsPrice", order.getPrice());
		map.put("orderPrice", order.getOrderPrice());
		map.put("orderSn", order.getOrderSn());
		map.put("confirmTime", order.getConfirmTime());
		map.put("bigImgPath", order.getBigImgPath());
		
		return Rp.ok().putAllDt(map);
	}
	
}
