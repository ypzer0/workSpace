package com.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.IgnoreAuth;
import com.platform.service.ApiZdGoodsInfoService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("商品模块")
@RestController
@RequestMapping("/zdapi")
public class ApiZdGoodsInfoController  extends ApiBaseAction{
	
	@Autowired
	private ApiZdGoodsInfoService apiZdGoodsInfoService;
	
	@ApiOperation("商品列表接口")
	@IgnoreAuth
	@PostMapping("/goods/list")
	public Object goodsList() {
		return apiZdGoodsInfoService.goodsList();
	}
	
	@ApiOperation("商品分类列表接口")
	@IgnoreAuth
	@PostMapping("/goods/category")
	public Object goodsCategory(@RequestParam(value = "cId") Integer cId) {
		return apiZdGoodsInfoService.goodsCategory(cId);
	}
	
	@ApiOperation("商品详情接口")
	@IgnoreAuth
	@PostMapping("/goods/details")
	public Object goodsDetails(@RequestParam(value = "gId") Integer gId) {
		return apiZdGoodsInfoService.goodsDetails(gId);
	}
	
	@ApiOperation("规格选择接口")
	@IgnoreAuth
	@PostMapping("/spec/choice")
	public Object specChoice(@RequestParam(value = "goodsId")Integer id) {
		return apiZdGoodsInfoService.specChoice(id);
	}
	

	
	
	
	

}
