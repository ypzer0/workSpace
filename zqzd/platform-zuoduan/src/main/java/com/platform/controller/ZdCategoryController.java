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

import com.platform.entity.ZdCategoryEntity;
import com.platform.service.ZdCategoryService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author zy
 * @date 2019-05-30 14:28:27
 */
@RestController
@RequestMapping("Zdcategory")
public class ZdCategoryController {
    @Autowired
    private ZdCategoryService zdCategoryService;
    
    @RequestMapping("/selectCategory")
    public R selectCategory() {
        //查询商品目录
        return zdCategoryService.selectCategory();
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zdcategory:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ZdCategoryEntity> zdcategoryList = zdCategoryService.queryList(query);
        int total = zdCategoryService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(zdcategoryList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("Zdcategory:info")
    public R info(@PathVariable("id") Integer id) {
        ZdCategoryEntity zdcategory = zdCategoryService.queryObject(id);

        return R.ok().put("Zdcategory", zdcategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("Zdcategory:save")
    public R save(@RequestBody ZdCategoryEntity zdCategory) {
    	zdCategoryService.save(zdCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("Zdcategory:update")
    public R update(@RequestBody ZdCategoryEntity zdCategory) {
    	zdCategoryService.update(zdCategory);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("Zdcategory:delete")
    public R delete(@RequestBody Integer[] ids) {
    	zdCategoryService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ZdCategoryEntity> list = zdCategoryService.queryList(params);

        return R.ok().put("list", list);
    }
}
