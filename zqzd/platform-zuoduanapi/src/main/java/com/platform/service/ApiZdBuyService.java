package com.platform.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiZdDepartmentMapper;
import com.platform.dao.ApiZdDoctorMapper;
import com.platform.dao.ApiZdGoodsInfoMapper;
import com.platform.dao.ApiZdHospitalMapper;
import com.platform.dao.ApiZdOrderMapper;
import com.platform.entity.ZdDepartmentVo;
import com.platform.entity.ZdDoctorVo;
import com.platform.entity.ZdGoodsInfoVo;
import com.platform.entity.ZdHospitalVo;
import com.platform.entity.ZdOrderVo;
import com.platform.entity.ZdUserVo;
import com.platform.utils.DateUtils;
import com.platform.utils.DecimalUtil;
import com.platform.utils.Rp;
import com.platform.utils.StringUtils;

@Service
public class ApiZdBuyService {

	@Autowired
	private ApiZdGoodsInfoMapper apiZdGoodsInfoMapper;
	@Autowired
	private ApiZdOrderMapper apiZdOrderMapper; 
	@Autowired
	private ApiZdDoctorMapper apiZdDoctorMapper;
	@Autowired
	private ApiZdDepartmentMapper apiZdDepartmentMapper;
	@Autowired
	private ApiZdHospitalMapper apiZdHospitalMapper;
	
	public Rp nowBuy(ZdUserVo nowUser,Integer goodsId,Integer count,Integer hospitalId,Integer departmentId,Integer doctorId) {
		if(StringUtils.isNullOrEmpty(nowUser)) {
			return Rp.error("请您重新登录");
		}
		if(goodsId==null||count==null||hospitalId==null||departmentId==null||doctorId==null) {
			return Rp.error("数据异常");
		}
		ZdDoctorVo doctor=apiZdDoctorMapper.queryObject(doctorId);
		if(StringUtils.isNullOrEmpty(doctor)||doctor.getIsDelete()==1|| doctor.getDepartmentId()!=departmentId) {
			return Rp.error("数据异常");
		}
		ZdDepartmentVo department=apiZdDepartmentMapper.queryObject(departmentId);
		if(StringUtils.isNullOrEmpty(department)||department.getIsDelete()==1||department.getHospitalId()!=hospitalId) {
			return Rp.error("数据异常");
		}
		ZdHospitalVo hospital=apiZdHospitalMapper.queryObject(hospitalId);
		if(StringUtils.isNullOrEmpty(hospital)||hospital.getIsDelete()==1) {
			return Rp.error("数据异常");
		}
		
		
		ZdGoodsInfoVo goods=apiZdGoodsInfoMapper.queryBuyGoods(count, goodsId);
		if(StringUtils.isNullOrEmpty(goods)) {
			return Rp.error("商品库存不足");
		}
		
		Float totalPrice = count * DecimalUtil.GetValueOrDefault(goods.getPrice()).floatValue();
		
		//新增订单
		ZdOrderVo order=new ZdOrderVo();
		order.setGoodsId(goodsId);
		order.setOrderStatus(0);
		order.setPayStatus(0);
		order.setUserId(nowUser.getId());
		order.setOrderNumber(count);
		order.setOrderSn("O" + DateUtils.format(new Date(), "yyyyMMddHHmmssSS"));
		order.setConfirmTime(new Date());
		order.setOrderPrice(new BigDecimal(totalPrice));
		order.setHospitalId(hospitalId);
		order.setDepartmentId(departmentId);
		order.setDoctorId(doctorId);
		apiZdOrderMapper.save(order);
		
		
		Map< String, Object> goodsMap=new HashMap<String, Object>();
		goodsMap.put("id", goods.getId());
		Integer goodsNumber=goods.getGoodsNumber()-count;
		if(goodsNumber==0) {
			goodsMap.put("status", 0);
		}
		goodsMap.put("goodsNumber", goodsNumber);
		apiZdGoodsInfoMapper.update(goodsMap);
		
		Map<String , Object> result=new HashMap<String, Object>();
		result.put("goodsName", goods.getcName()+" "+goods.getGoodsName());
		result.put("count", count);
		result.put("goodsPrice", goods.getPrice());
		result.put("orderPrice", totalPrice);
		result.put("bigImgPath", goods.getBigImgPath());
		result.put("orderSn", order.getOrderSn());
		
		
		return Rp.ok().putAllDt(result);
	}
	
}
