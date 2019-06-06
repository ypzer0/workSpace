package com.platform.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.SmsTempEntity;
import com.platform.service.SmsTempService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-01 17:22:31
 */
@RestController
@RequestMapping("smstemp")
public class SmsTempController {
    @Autowired
    private SmsTempService smsTempService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smstemp:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SmsTempEntity> smsTempList = smsTempService.queryList(query);
        int total = smsTempService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(smsTempList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smstemp:info")
    public R info(@PathVariable("id") Integer id) {
        SmsTempEntity smsTemp = smsTempService.queryObject(id);

        return R.ok().put("smsTemp", smsTemp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smstemp:save")
    public R save(@RequestBody SmsTempEntity smsTemp) {
        smsTempService.save(smsTemp);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smstemp:update")
    public R update(@RequestBody SmsTempEntity smsTemp) {
        smsTempService.update(smsTemp);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smstemp:delete")
    public R delete(@RequestBody Integer[] ids) {
        smsTempService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<SmsTempEntity> list = smsTempService.queryList(params);

        return R.ok().put("list", list);
    }
}
