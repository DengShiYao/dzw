package com.accp.controller;


import com.accp.result.ResultVO;
import com.accp.service.impl.SuppliersRegionCityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    SuppliersRegionCityServiceImpl regionCityService;

    /**
     * 查询tree菜单
     * @return
     */
    @GetMapping
    public ResultVO toFind(){
        return new ResultVO(regionCityService.toFind());
    }
}

