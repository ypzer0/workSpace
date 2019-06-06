package com.platform.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.platform.entity.ZdEptUserEdayEntity;
import com.platform.service.ZdEptUserEdayService;
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
@RequestMapping("Zdeptusereday")
public class ZdEptUserEdayController {
    @Autowired
    private ZdEptUserEdayService ZdeptUserEdayService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zdeptusereday:list")
    public R list(@RequestBody Integer[] tp) {
    	if(tp == null || tp.length == 0)
    		return R.error("error!");
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	
    	Calendar cl = Calendar.getInstance();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String nowDateStr = sdf.format(new Date());
    	Date nowDt = null;
		try {
			nowDt = sdf.parse(nowDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cl.setTime(nowDt);
        cl.add(Calendar.DATE, -tp[0]);
    	params.put("ctime", cl.getTime());
    	params.put("sidx", "ctime");
    	params.put("order", "asc");
    	List<ZdEptUserEdayEntity> eptOrderEdayList = ZdeptUserEdayService.queryList(params);
        Map<String, Object> rt = new HashMap<String, Object>();
        
        rt.put("fit", "");

		Map<String, Object> crt = new HashMap<String, Object>();
    	rt.put("src", crt);
		 
		List<String> product = new ArrayList<String>();
		crt.put("pro", product);
		List<Integer> reg = new ArrayList<Integer>();
		crt.put("reg", reg);
		List<Integer> online = new ArrayList<Integer>();
		crt.put("online", online);
    	for (ZdEptUserEdayEntity eoee : eptOrderEdayList) {
    		
    		String x_ = "";
    		if(eoee.getCtime() != null) {
    			x_ = sdf.format(eoee.getCtime());
    		}
    		product.add(x_);
        	
    		reg.add(eoee.getReg());
    		online.add(eoee.getOnline());
    		
		}
    	if(product.size() > 0) {
            rt.put("fit", product.get(0));
    	}
        
        return R.ok().put("data", rt);
    }

//    /**
//     * 查看信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("Zdeptusereday:info")
//    public R info(@PathVariable("id") Integer id) {
//        ZdEptUserEdayEntity ZdeptUserEday = ZdeptUserEdayService.queryObject(id);
//
//        return R.ok().put("ZdeptUserEday", ZdeptUserEday);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("Zdeptusereday:save")
//    public R save(@RequestBody ZdEptUserEdayEntity ZdeptUserEday) {
//        ZdeptUserEdayService.save(ZdeptUserEday);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("Zdeptusereday:update")
//    public R update(@RequestBody ZdEptUserEdayEntity ZdeptUserEday) {
//        ZdeptUserEdayService.update(ZdeptUserEday);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("Zdeptusereday:delete")
//    public R delete(@RequestBody Integer[] ids) {
//        ZdeptUserEdayService.deleteBatch(ids);
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
//        List<ZdEptUserEdayEntity> list = ZdeptUserEdayService.queryList(params);
//
//        return R.ok().put("list", list);
//    }
}
