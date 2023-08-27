package com.hhd.demo.service;

import com.hhd.demo.entity.Citys;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hhd.demo.untils.R;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author -无心
 * @since 2023-3-21
 */
@Service
public interface ICitysService extends IService<Citys> {

    List<String> selectAddr();

    int updateAll(Citys citys,String oldCityName);

    int delete(String cityName);
}
