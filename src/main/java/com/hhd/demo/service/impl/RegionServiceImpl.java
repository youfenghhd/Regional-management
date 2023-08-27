package com.hhd.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hhd.demo.entity.Citys;
import com.hhd.demo.entity.Region;
import com.hhd.demo.mapper.CitysMapper;
import com.hhd.demo.mapper.RegionMapper;
import com.hhd.demo.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhd.demo.untils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author -无心
 * @since 2023-3-21
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {

    @Resource
    private RegionMapper regionMapper;
    @Resource
    private CitysMapper citysMapper;


    @Override
    public R selectLike(Region region, Page<Region> page) {
        System.out.println(region.getCreateTime());
        if (region.getCreateTime() != null && !Objects.equals(region.getCreateTime(), "")) {
            String[] split = region.getCreateTime().split(",");
            region.setCreateTime(split[0]);
            region.setModifiedTime(split[1]);
        }
        Page<Region> select;
        if (region.getCitys() != null) {
            Citys citys = region.getCitys().iterator().next();
            LambdaQueryWrapper<Citys> lqw = new LambdaQueryWrapper<>();
            lqw.like(citys.getCityName() != null, Citys::getCityName, citys.getCityName())
                    .like(citys.getAddr() != null, Citys::getAddr, citys.getAddr());
            List<Citys> citys1 = citysMapper.selectList(lqw);
            select = regionMapper.select(page, region);
            Iterator<Region> iter1 = select.getRecords().iterator();
            while (iter1.hasNext()) {
                Region region1 = iter1.next();
                List<Citys> citys3 = new ArrayList<>();
                for (Citys citys2 : citys1) {
                    if (Objects.equals(citys2.getRid(), region1.getRid())) {
                        citys3.add(citys2);
                    }
                }
                if (citys3.size() != 0) {
                    region1.setCitys(citys3);
                } else {
                    iter1.remove();
                }
            }
            return R.ok().data("like", select);
        }
        return R.ok().data("like", regionMapper.select(page, region));
    }


    @Override
    public R selectAll(Page<Region> page) {
        return R.ok().data("all", regionMapper.select(page, null));
    }


    @Override
    public R delete(String rid) {
        LambdaQueryWrapper<Citys> lqw = new LambdaQueryWrapper<>();
        citysMapper.delete(lqw.eq(Citys::getRid, rid));
        return regionMapper.deleteById(rid) > 0 ? R.ok() : R.error();
    }

    @Override
    public R getOne(String rid) {
        LambdaQueryWrapper<Region> lqw1 = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Citys> lqw2 = new LambdaQueryWrapper<>();
        Region region = regionMapper.selectOne(lqw1.eq(Region::getRid, rid));
        region.setCitys(citysMapper.selectList(lqw2.eq(Citys::getRid, rid)));
        return R.ok().data("one", region);
    }

    @Override
    public R saveOne(Region region) {
        if (regionMapper.insert(region) > 0) {
            LambdaQueryWrapper<Region> lqw = new LambdaQueryWrapper<>();
            Region region1 = regionMapper.selectOne(lqw.eq(Region::getRegionName, region.getRegionName()));
            List<Citys> citys = region.getCitys();
            for (Citys city : citys) {
                city.setRid(region1.getRid());
                citysMapper.insert(city);
            }
            return R.ok();
        }
        return R.error();
    }
}
