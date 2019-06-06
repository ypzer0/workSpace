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

import com.platform.entity.ZdDepartmentEntity;
import com.platform.service.ZdDepartmentService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author 杨鹏
 * @date 2019-06-01 13:14:14
 */
@RestController
@RequestMapping("Zddepartment")
public class ZdDepartmentController {
    @Autowired
    private ZdDepartmentService zddepartmentService;
    
    @RequestMapping("/selectHospital")
    public R selectHospital() {
        //查询医院目录  	
        return zddepartmentService.selectHospital();
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zddepartment:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ZdDepartmentEntity> ZddepartmentList = zddepartmentService.queryList(query);
        int total = zddepartmentService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(ZddepartmentList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("Zddepartment:info")
    public R info(@PathVariable("id") Integer id) {
        ZdDepartmentEntity Zddepartment = zddepartmentService.queryObject(id);

        return R.ok().put("Zddepartment", Zddepartment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("Zddepartment:save")
    public R save(@RequestBody ZdDepartmentEntity zddepartment) {
    	zddepartmentService.save(zddepartment);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("Zddepartment:update")
    public R update(@RequestBody ZdDepartmentEntity Zddepartment) {
    	zddepartmentService.update(Zddepartment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("Zddepartment:delete")
    public R delete(@RequestBody Integer[] ids) {
    	zddepartmentService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ZdDepartmentEntity> list = zddepartmentService.queryList(params);

        return R.ok().put("list", list);
    }
}
