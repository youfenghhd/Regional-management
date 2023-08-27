package com.hhd.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hhd.demo.entity.Region;
import com.hhd.demo.service.IRegionService;
import com.hhd.demo.untils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.xml.ws.BindingType;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author -无心
 * @since 2023-3-21
 */
@CrossOrigin
@RestController
@RequestMapping("/regions")
public class RegionController {
    @Resource
    private IRegionService regionService;

    @GetMapping
    public R getAll(@RequestParam(defaultValue = "1") Integer pageNum,
                    @RequestParam(defaultValue = "2") Integer pageSize) {
        return regionService.selectAll(new Page<>(pageNum, pageSize));
    }

    @PostMapping("/getLike")
    public R getLike(@RequestBody Region region,
                     @RequestParam(defaultValue = "1") Integer pageNum,
                     @RequestParam(defaultValue = "2") Integer pageSize) {
        return regionService.selectLike(region,new Page<>(pageNum, pageSize));
    }
    @GetMapping("/getOne")
    public R getOne(@RequestParam String rid){
        return regionService.getOne(rid);
    }

    @PostMapping
    public R save(@RequestBody Region region) {
        return regionService.saveOne(region) ;
    }

    @PutMapping
    public R update(@RequestBody Region region) {
        return regionService.updateById(region) ? R.ok() : R.error();
    }

    @DeleteMapping
    public R delete(@RequestParam String rid) {
        return regionService.delete(rid);
    }
}
