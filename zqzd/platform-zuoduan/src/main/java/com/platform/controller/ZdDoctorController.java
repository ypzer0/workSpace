package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.ZdDoctorEntity;
import com.platform.service.ZdDoctorService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author 杨鹏
 * @date 2019-05-30 15:08:05
 */
@RestController
@RequestMapping("Zddoctor")
public class ZdDoctorController {
    @Autowired
    private ZdDoctorService zddoctorService;
    
    @RequestMapping("/selectDepartment")
    public R selectDepartment() {
		return zddoctorService.selectDepartment();	
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zddoctor:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ZdDoctorEntity> ZddoctorList = zddoctorService.queryList(query);
        int total = zddoctorService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(ZddoctorList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("Zddoctor:info")
    public R info(@PathVariable("id") Integer id) {
        ZdDoctorEntity Zddoctor = zddoctorService.queryObject(id);

        return R.ok().put("Zddoctor", Zddoctor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("Zddoctor:save")
    public R save(@RequestBody ZdDoctorEntity Zddoctor) {
    	

        return zddoctorService.save(Zddoctor);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("Zddoctor:update")
    public R update(@RequestBody ZdDoctorEntity Zddoctor) {
    	zddoctorService.update(Zddoctor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("Zddoctor:delete")
    public R delete(@RequestBody Integer[] ids) {
    	zddoctorService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ZdDoctorEntity> list = zddoctorService.queryList(params);

        return R.ok().put("list", list);
    }
}
