package com.hhd.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hhd.demo.entity.Region;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hhd.demo.untils.R;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author -无心
 * @since 2023-3-21
 */
@Mapper
public interface RegionMapper extends BaseMapper<Region> {
    /**
     * 查找/模糊查
     * @param region
     * @return
     */
//    List<Region> select(Region region);
    Page<Region> select(Page<Region> page, Region region);
}
