package com.accp.service.impl;

import com.accp.domain.CarBrand;
import com.accp.mapper.CarBrandMapper;
import com.accp.service.ICarBrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-02
 */
@Service
public class CarBrandServiceImpl extends ServiceImpl<CarBrandMapper, CarBrand> implements ICarBrandService {

    @Autowired
    CarBrandMapper carBrandMapper;

    public int updateByKey(CarBrand carBrand){
        QueryWrapper<CarBrand> queryWrapper =new QueryWrapper();
        queryWrapper.lambda().eq(CarBrand::getCarId,carBrand.getBeforeId());
        return carBrandMapper.update(carBrand,queryWrapper);
    }
}
