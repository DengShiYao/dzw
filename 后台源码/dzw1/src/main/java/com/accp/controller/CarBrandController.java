package com.accp.controller;


import com.accp.domain.CarBrand;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.CarBrandServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 * 车型
 * @author dsy
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/carBrand")
public class CarBrandController {

    @Autowired
    CarBrandServiceImpl carBrandService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 查询车型
     * @return
     */
    @GetMapping
    public ResultVO find(){
        return new ResultVO(carBrandService.list());
    }

    /**
     * 新增车型品牌 主键为空校验失败
     * @param carBrand
     * @return
     */
    @PostMapping
    public ResultVO brandIns(@Valid  @RequestBody CarBrand carBrand){
        CarBrand byId = carBrandService.getById(carBrand.getCarId());
        System.out.println(carBrand);
        System.out.println(byId);
        if (byId == null) {
            return new ResultVO(ResultCode.SUCCESS,carBrandService.save(carBrand));
        }else {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
    }

    /**
     * 新增车型品牌 主键为空校验失败
     * @param carBrand
     * @return
     */
    @PostMapping("/upd")
    public ResultVO brandUpd(@Valid  @RequestBody CarBrand carBrand){
        //如果修改前主键与当前主键不一致
        if(!carBrand.getBeforeId().equals(carBrand.getCarId())){
            CarBrand byId = carBrandService.getById(carBrand.getCarId());
            System.out.println(carBrand);
            System.out.println(byId);
            if (byId != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        QueryWrapper<CarBrand> queryWrapper =new QueryWrapper();
        queryWrapper.lambda().eq(CarBrand::getCarId,carBrand.getBeforeId());
        return new ResultVO(ResultCode.SUCCESS,carBrandService.update(carBrand,queryWrapper));
    }
}

