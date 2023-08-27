package com.hhd.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hhd.demo.entity.Citys;
import com.hhd.demo.mapper.CitysMapper;
import com.hhd.demo.service.ICitysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhd.demo.untils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author -无心
 * @since 2023-3-21
 */
@Service
public class CitysServiceImpl extends ServiceImpl<CitysMapper, Citys> implements ICitysService {

    @Resource
    private CitysMapper citysMapper;

    @Override
    public List<String> selectAddr() {
        return citysMapper.selectCityNameStrings();
    }

    @Override
    public int updateAll(Citys citys,String oldCityName) {
        LambdaUpdateWrapper<Citys> lqw = new LambdaUpdateWrapper<>();
        lqw.set(Citys::getCityName,citys.getCityName()).eq(Citys::getCityName,oldCityName);
        return citysMapper.update(null,lqw);
    }

    @Override
    public int delete(String cityName) {
        LambdaQueryWrapper<Citys> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Citys::getCityName,cityName);
        return citysMapper.delete(lqw);
    }

}
