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

import com.platform.entity.ZdHospitalEntity;
import com.platform.service.ZdHospitalService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author 杨鹏
 * @date 2019-06-01 11:43:55
 */
@RestController
@RequestMapping("Zdhospital")
public class ZdHospitalController {
    @Autowired
    private ZdHospitalService zdhospitalService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zdhospital:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ZdHospitalEntity> ZdhospitalList = zdhospitalService.queryList(query);
        int total = zdhospitalService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(ZdhospitalList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("Zdhospital:info")
    public R info(@PathVariable("id") Integer id) {
        ZdHospitalEntity Zdhospital = zdhospitalService.queryObject(id);

        return R.ok().put("Zdhospital", Zdhospital);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("Zdhospital:save")
    public R save(@RequestBody ZdHospitalEntity Zdhospital) {
    	zdhospitalService.save(Zdhospital);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("Zdhospital:update")
    public R update(@RequestBody ZdHospitalEntity Zdhospital) {
    	zdhospitalService.update(Zdhospital);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("Zdhospital:delete")
    public R delete(@RequestBody Integer[] ids) {
    	zdhospitalService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ZdHospitalEntity> list = zdhospitalService.queryList(params);

        return R.ok().put("list", list);
    }
}
