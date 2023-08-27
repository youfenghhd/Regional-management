package com.hhd.demo.controller;

import com.hhd.demo.entity.Citys;
import com.hhd.demo.service.ICitysService;
import com.hhd.demo.untils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

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
@RequestMapping("/citys")
public class CitysController {

    @Resource
    private ICitysService cityService;

    @PostMapping
    public R insert(@RequestBody Citys citys) {
        return cityService.save(citys) ? R.ok() : R.error();
    }

    @PostMapping("/list")
    public R insertList(@RequestBody List<Citys> citys) {
        return cityService.saveBatch(citys) ? R.ok() : R.error();
    }

    @GetMapping
    public R get() {
        return R.ok().data("citys", cityService.selectAddr());
    }

    @PutMapping
    public R update(@RequestBody Citys citys, @RequestParam String oldCityName) {
        return cityService.updateAll(citys, oldCityName) > 0 ? R.ok() : R.error();
    }

    @DeleteMapping
    public R del(@RequestParam String cityName) {
        return cityService.delete(cityName) > 0 ? R.ok() : R.error();
    }

}
