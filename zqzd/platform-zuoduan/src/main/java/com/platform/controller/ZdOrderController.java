package com.platform.controller;

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

import com.platform.entity.ZdOrderEntity;
import com.platform.service.ZdOrderService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 10:04:31
 */
@RestController
@RequestMapping("Zdorder")
public class ZdOrderController {
    @Autowired
    private ZdOrderService ZdorderService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("Zdorder:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ZdOrderEntity> ZdorderList = ZdorderService.queryList(query);
        int total = ZdorderService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(ZdorderList, total, query.getLimit(), query.getPage());
        
        Map<String , Object > map=new HashMap<String, Object>();
        map.put("totalPrice", ZdorderService.querySumOrderPrice());
        map.put("successfulPrice", ZdorderService.querySumOrderPrice(1));

        return R.ok().put("page", pageUtil).put("total", map);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("Zdorder:info")
    public R info(@PathVariable("id") Integer id) {
        ZdOrderEntity Zdorder = ZdorderService.queryObject(id);

        return R.ok().put("Zdorder", Zdorder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("Zdorder:save")
    public R save(@RequestBody ZdOrderEntity Zdorder) {
        ZdorderService.save(Zdorder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("Zdorder:update")
    public R update(@RequestBody ZdOrderEntity Zdorder) {
        ZdorderService.update(Zdorder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("Zdorder:delete")
    public R delete(@RequestBody Integer[] ids) {
        ZdorderService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ZdOrderEntity> list = ZdorderService.queryList(params);

        return R.ok().put("list", list);
    }
}
