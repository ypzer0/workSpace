package com.platform.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

import com.platform.entity.ZdEptOrderEdayEntity;
import com.platform.service.ZdEptOrderEdayService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-06-01 15:25:04
 */
@RestController
@RequestMapping("Zdeptordereday")
public class ZdEptOrderEdayController {
    @Autowired
    private ZdEptOrderEdayService ZdeptOrderEdayService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zdeptordereday:list")
    public R list(@RequestBody Integer[] tp) {
    	System.err.println(Arrays.toString(tp));
    	if(tp == null || tp.length == 0)
    		return R.error("error!");
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	
    	Calendar cl = Calendar.getInstance();
    	System.err.println(cl);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String nowDateStr = sdf.format(new Date());// Data-->String 
    	Date nowDt = null;
		try {
			nowDt = sdf.parse(nowDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(nowDt);
        cl.setTime(nowDt);
        cl.add(Calendar.DATE, -tp[0]);
    	params.put("ctime", cl.getTime());
    	params.put("sidx", "ctime");
    	params.put("order", "asc");
    	
        List<ZdEptOrderEdayEntity> eptOrderEdayList = ZdeptOrderEdayService.queryList(params);
        Map<String, Object> rt = new HashMap<String, Object>();
        
        rt.put("fit", "");

		Map<String, Object> crt = new HashMap<String, Object>();
    	rt.put("src", crt);
		 
		List<String> product = new ArrayList<String>();
		crt.put("pro", product);
		List<Integer> unfinish = new ArrayList<Integer>();
		crt.put("unfinish", unfinish);
		List<Integer> failed = new ArrayList<Integer>();
		crt.put("failed", failed);
		List<Integer> completed = new ArrayList<Integer>();
		crt.put("comp", completed);
		List<Integer> total = new ArrayList<Integer>();
		crt.put("all", total);
    	for (ZdEptOrderEdayEntity eoee : eptOrderEdayList) {
    		
    		String x_ = "";
    		if(eoee.getCtime() != null) {
    			x_ = sdf.format(eoee.getCtime());
    		}
    		product.add(x_);
        	
    		unfinish.add(eoee.getUnfinished());
    		failed.add(eoee.getFailed());
    		completed.add(eoee.getCompleted());
    		total.add(eoee.getTotal());
    		
		}
    	if(product.size() > 0) {
            rt.put("fit", product.get(0));
    	}
        System.err.println(rt);
        return R.ok().put("data", rt);
    }

//    /**
//     * 查看信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("Zdeptordereday:info")
//    public R info(@PathVariable("id") Integer id) {
//        ZdEptOrderEdayEntity ZdeptOrderEday = ZdeptOrderEdayService.queryObject(id);
//
//        return R.ok().put("ZdeptOrderEday", ZdeptOrderEday);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("Zdeptordereday:save")
//    public R save(@RequestBody ZdEptOrderEdayEntity ZdeptOrderEday) {
//        ZdeptOrderEdayService.save(ZdeptOrderEday);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("Zdeptordereday:update")
//    public R update(@RequestBody ZdEptOrderEdayEntity ZdeptOrderEday) {
//        ZdeptOrderEdayService.update(ZdeptOrderEday);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("Zdeptordereday:delete")
//    public R delete(@RequestBody Integer[] ids) {
//        ZdeptOrderEdayService.deleteBatch(ids);
//
//        return R.ok();
//    }
//
//    /**
//     * 查看所有列表
//     */
//    @RequestMapping("/queryAll")
//    public R queryAll(@RequestParam Map<String, Object> params) {
//
//        List<ZdEptOrderEdayEntity> list = ZdeptOrderEdayService.queryList(params);
//
//        return R.ok().put("list", list);
//    }
}
