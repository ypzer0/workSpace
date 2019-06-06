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

import com.platform.entity.ZdUserEntity;
import com.platform.service.ZdUserService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 15:31:22
 */
@RestController
@RequestMapping("Zduser")
public class ZdUserController {
    @Autowired
    private ZdUserService ZduserService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zduser:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ZdUserEntity> ZduserList = ZduserService.queryList(query);
        int total = ZduserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(ZduserList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("Zduser:info")
    public R info(@PathVariable("id") Integer id) {
        ZdUserEntity Zduser = ZduserService.queryObject(id);

        return R.ok().put("Zduser", Zduser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("Zduser:save")
    public R save(@RequestBody ZdUserEntity Zduser) {
        ZduserService.save(Zduser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("Zduser:update")
    public R update(@RequestBody ZdUserEntity Zduser) {
        ZduserService.update(Zduser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("Zduser:delete")
    public R delete(@RequestBody Integer[] ids) {
        ZduserService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ZdUserEntity> list = ZduserService.queryList(params);

        return R.ok().put("list", list);
    }
}
