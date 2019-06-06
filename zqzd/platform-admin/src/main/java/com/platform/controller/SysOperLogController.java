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

import com.platform.entity.SysOperLogEntity;
import com.platform.service.SysOperLogService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * 系统操作日志Controller
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-15 14:53:46
 */
@RestController
@RequestMapping("sysoperlog")
public class SysOperLogController {
    @Autowired
    private SysOperLogService sysOperLogService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysoperlog:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysOperLogEntity> sysOperLogList = sysOperLogService.queryList(query);
        int total = sysOperLogService.queryTotal(query);
        
        //隐藏操作参数不可见
        for (SysOperLogEntity sysOperLogEntity : sysOperLogList) {
			sysOperLogEntity.setParams("");
		}
        
        PageUtils pageUtil = new PageUtils(sysOperLogList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sysoperlog:info")
    public R info(@PathVariable("id") Long id) {
        SysOperLogEntity sysOperLog = sysOperLogService.queryObject(id);

        return R.ok().put("sysOperLog", sysOperLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sysoperlog:save")
    public R save(@RequestBody SysOperLogEntity sysOperLog) {
        sysOperLogService.save(sysOperLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysoperlog:update")
    public R update(@RequestBody SysOperLogEntity sysOperLog) {
        sysOperLogService.update(sysOperLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysoperlog:delete")
    public R delete(@RequestBody Long[] ids) {
        sysOperLogService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<SysOperLogEntity> list = sysOperLogService.queryList(params);

        return R.ok().put("list", list);
    }
}
