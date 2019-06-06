package com.platform.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.ZdGoodsInfoEntity;
import com.platform.service.ZdGoodsInfoService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author 杨鹏

 * @date 2019-05-30 13:59:14
 */
@RestController
@RequestMapping("Zdgoodsinfo")
public class ZdGoodsInfoController {
    @Autowired
    private ZdGoodsInfoService ZdgoodsInfoService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zdgoodsinfo:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ZdGoodsInfoEntity> zdgoodsInfoList = ZdgoodsInfoService.queryList(query);
        int total = ZdgoodsInfoService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(zdgoodsInfoList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("Zdgoodsinfo:info")
    public R info(@PathVariable("id") Integer id) {
        ZdGoodsInfoEntity ZdgoodsInfo = ZdgoodsInfoService.queryObject(id);

        return R.ok().put("ZdgoodsInfo", ZdgoodsInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("Zdgoodsinfo:save")
    public R save(@RequestBody ZdGoodsInfoEntity ZdgoodsInfo) {
    	ZdgoodsInfo.setAddTime(new Date());
        ZdgoodsInfoService.save(ZdgoodsInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("Zdgoodsinfo:update")
    public R update(@RequestBody ZdGoodsInfoEntity ZdgoodsInfo) {
        ZdgoodsInfoService.update(ZdgoodsInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("Zdgoodsinfo:delete")
    public R delete(@RequestBody Integer[] ids) {
        ZdgoodsInfoService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ZdGoodsInfoEntity> list = ZdgoodsInfoService.queryList(params);

        return R.ok().put("list", list);
    }
    
    /**
     * 上架
     */
    @RequestMapping("/upperShelf")
    @RequiresPermissions("Zdgoodsinfo:upperShelf")
    public R upperShelf(@RequestBody Integer[] ids) {
    	
    	if(ids == null || ids.length == 0) {
    		return R.error("非法数据！");
    	}

    	Map<String, Object> query = new HashMap<String, Object>();
    	query.put("ids", ids);
		
		ZdgoodsInfoService.updateStatus(1, ids);
		
//    	for (Integer id : ids) {
//    		CouponGoodsInfoEntity CoupongoodsInfo = CoupongoodsInfoService.queryObject(id);
//    		CoupongoodsInfo.setIsOnSale(1);
//    		CoupongoodsInfoService.update(CoupongoodsInfo);
//		}

        return R.ok();
    }
    
    /**
     * 下架
     */
    @RequestMapping("/soldOut")
    @RequiresPermissions("Zdgoodsinfo:soldOut")
    public R soldOut(@RequestBody Integer[] ids) {
    	
    	if(ids == null || ids.length == 0) {
    		return R.error("非法数据！");
    	}

    	Map<String, Object> query = new HashMap<String, Object>();
    	query.put("ids", ids);
	
		
		ZdgoodsInfoService.updateStatus(0, ids);
    	
//    	for (Integer id : ids) {
//    		CouponGoodsInfoEntity CoupongoodsInfo = CoupongoodsInfoService.queryObject(id);
//    		CoupongoodsInfo.setIsOnSale(0);
//    		CoupongoodsInfoService.update(CoupongoodsInfo);
//		}

        return R.ok();
    }
}
