package com.accp.service.impl;

import com.accp.domain.CarType;
import com.accp.mapper.CarTypeMapper;
import com.accp.service.ICarTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@Service
public class CarTypeServiceImpl extends ServiceImpl<CarTypeMapper, CarType> implements ICarTypeService {

    @Autowired
    ICarTypeService iCarTypeService;
    @Autowired
    CarTypeMapper carTypeMapper;

    public List<CarType> find(String carId) {
        QueryWrapper<CarType> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(CarType::getBrandName,carId);
        return carTypeMapper.find(queryWrapper);
    }
}
