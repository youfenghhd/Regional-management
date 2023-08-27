package com.hhd.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hhd.demo.entity.Region;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hhd.demo.untils.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author -无心
 * @since 2023-3-21
 */
public interface IRegionService extends IService<Region> {

    R selectLike(Region region,Page<Region> page);

    R selectAll(Page<Region> page);

    R delete(String rid);

    R getOne(String rid);

    R saveOne(Region region);
}
