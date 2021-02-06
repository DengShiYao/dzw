package com.accp.controller;


import com.accp.domain.CarIcon;
import com.accp.result.ResultVO;
import com.accp.service.impl.CarIconServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/carIcon")
public class CarIconController {

    @Autowired
    CarIconServiceImpl iconService;

    @GetMapping("/{carId}")
    public ResultVO findIcon( @PathVariable String carId){
        CarIcon one = iconService.getOne(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId, carId));
        return new ResultVO(one);
    }
}

