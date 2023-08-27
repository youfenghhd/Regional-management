package com.hhd.demo.mapper;

import com.hhd.demo.entity.Citys;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

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
public interface CitysMapper extends BaseMapper<Citys> {

    @Select("select distinct cityname from citys")
    List<String> selectCityNameStrings();

}
