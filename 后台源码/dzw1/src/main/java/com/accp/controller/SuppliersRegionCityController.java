package com.accp.controller;


import com.accp.domain.SuppliersRegion;
import com.accp.domain.SuppliersRegionCity;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.SuppliersRegionCityServiceImpl;
import com.accp.service.impl.SuppliersRegionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *  供货商
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/suppliersRegionCity")
public class SuppliersRegionCityController {

    /**
     * 供货商分类
     */
    @Autowired
    SuppliersRegionCityServiceImpl regionCityService;
    /**
     * 供货商信息
     */
    @Autowired
    SuppliersRegionServiceImpl regionService;

    /**
     * 查询tree菜单
     * @return
     */
    @GetMapping
    public ResultVO toFind(){
        return new ResultVO(regionCityService.toFind());
    }

    /**
     * 新增目录
     * @param regionCity
     * @return
     */
    @PostMapping("/ins")
    public ResultVO insClassify(@Valid  SuppliersRegionCity regionCity){
        //验证此编号是否存在
        SuppliersRegionCity one = regionCityService.getOne(new QueryWrapper<SuppliersRegionCity>().lambda().eq(SuppliersRegionCity::getRegionId, regionCity.getRegionId()));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        return new ResultVO(ResultCode.SUCCESS,regionCityService.save(regionCity));
    }

    /**
     * 修改供货商分类
     * @param regionCity
     * @return
     */
    @PostMapping("/upd")
    public ResultVO updClassify(@Valid  SuppliersRegionCity regionCity){
        if (!regionCity.getBeforeId().equals(regionCity.getRegionId())){
            SuppliersRegionCity one = regionCityService.getOne(new QueryWrapper<SuppliersRegionCity>().lambda().eq(SuppliersRegionCity::getRegionId, regionCity.getBeforeId()));
            if(one==null){
                //修改修改主键和父级Id
                regionCityService.update(regionCity,new QueryWrapper<SuppliersRegionCity>().lambda().eq(SuppliersRegionCity::getRegionId,regionCity.getBeforeId()));
                //修改供货商信息
                SuppliersRegion region = new SuppliersRegion();
                region.setRegionId(regionCity.getRegionId());
                regionService.update(new QueryWrapper<SuppliersRegion>().lambda().eq(SuppliersRegion::getRegionId,regionCity.getBeforeId()));
                return new ResultVO(ResultCode.SUCCESS);
            }
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        return new ResultVO(ResultCode.SUCCESS,regionCityService.update(regionCity,new QueryWrapper<SuppliersRegionCity>().lambda().eq(SuppliersRegionCity::getRegionId,regionCity.getRegionId())));
    }

    /**
     * 删除分类
     * @param regionId
     * @return
     */
    @PostMapping("/del")
    public ResultVO deleteRegion(String regionId){
        if (regionId == null || regionId == "") {
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        SuppliersRegion one = regionService.getOne(new QueryWrapper<SuppliersRegion>().lambda().eq(SuppliersRegion::getRegionId, regionId));
        if (one != null) {
            return new ResultVO(ResultCode.FAILED);
        }
        return new ResultVO(ResultCode.SUCCESS,regionCityService.remove(new QueryWrapper<SuppliersRegionCity>().lambda().eq(SuppliersRegionCity::getRegionId,regionId)));
    }
}

