package com.accp.controller;


import com.accp.domain.CarBrand;
import com.accp.domain.CarIcon;
import com.accp.domain.CarType;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.CarBrandServiceImpl;
import com.accp.service.impl.CarIconServiceImpl;
import com.accp.service.impl.CarTypeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    /**
     * 车型
     */
    @Autowired
    CarTypeServiceImpl carTypeService;
    /**
     * 车型图片
     */
    @Autowired
    CarIconServiceImpl carIconService;

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
        CarBrand byId = carBrandService.getOne(new QueryWrapper<CarBrand>().lambda().eq(CarBrand::getCarId,carBrand.getCarId()));
        if (byId == null) {
            return new ResultVO(ResultCode.SUCCESS,carBrandService.save(carBrand));
        }else {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
    }

    /**
     * 修改车型品牌 主键为空校验失败
     * @param carBrand
     * @return
     */
    @PostMapping("/upd")
    public ResultVO brandUpd(@Valid  @RequestBody CarBrand carBrand){
        //如果修改前主键与当前主键不一致
        if(!carBrand.getBeforeId().equals(carBrand.getCarId())){
            CarBrand byId = carBrandService.getOne(new QueryWrapper<CarBrand>().lambda().eq(CarBrand::getCarId,carBrand.getBeforeId()));
            if (byId != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        return new ResultVO(ResultCode.SUCCESS,carBrandService.updateByKey(carBrand));
    }


    /**
     *  车型品牌删除，同时连同下车型一起删除
     * @param carBrand 传入的品牌ID
     * @return
     */
    @PostMapping("/remove")
    public ResultVO toRemove(String carBrand){

        System.out.println(carBrand);
        if (carBrand==null || carBrand==""){
            //如果参数为空返回提示
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        //反之先删除车型图片——车型——再删除品牌
        //删除车型前先删除其图片
        //先查询当前品牌下所有车型
        List<CarType> list = carTypeService.list(new QueryWrapper<CarType>().lambda().eq(CarType::getBrandName, carBrand));
        //利用循环删除品牌下车型所图片
        list.forEach(item->{
            carIconService.remove(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId,item.getCarId()));
        });
        carTypeService.remove(new QueryWrapper<CarType>().lambda().eq(CarType::getBrandName,carBrand));
        carBrandService.remove(new QueryWrapper<CarBrand>().lambda().eq(CarBrand::getCarId,carBrand));
        return new ResultVO();
    }

    @PostMapping("/search")
        public ResultVO search(String searchBrand){
            QueryWrapper<CarBrand> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().like(CarBrand::getCarId,searchBrand).or().like(CarBrand::getCarName,searchBrand).or().like(CarBrand::getInitial,searchBrand);
            return new ResultVO(carBrandService.list(queryWrapper));
    }
}

