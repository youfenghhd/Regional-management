package com.hhd.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hhd.demo.entity.Citys;
import com.hhd.demo.entity.Region;
import com.hhd.demo.mapper.CitysMapper;
import com.hhd.demo.mapper.RegionMapper;
import com.hhd.demo.service.ICitysService;
import com.hhd.demo.service.IRegionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class ApplicationTests {
    @Resource
    private ICitysService service;
    @Resource
    private IRegionService rservice;
    @Resource
    private RegionMapper mapper;
    @Resource
    private CitysMapper citysMapper;

    @Test
    void contextLoads() {
    }


    @Test
    void testtt(){
    }
}
