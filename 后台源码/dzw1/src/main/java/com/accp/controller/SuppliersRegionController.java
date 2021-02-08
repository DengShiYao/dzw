package com.accp.controller;


import com.accp.domain.SuppliersRegion;
import com.accp.result.ResultVO;
import com.accp.service.impl.SuppliersRegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *  供货商
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/suppliersRegion")
public class SuppliersRegionController {

    @Autowired
    SuppliersRegionServiceImpl service;

    @GetMapping
    public ResultVO toFind(@Nullable SuppliersRegion region){
        List<SuppliersRegion> suppliersRegionCities = service.toFind("1001");
        System.out.println(suppliersRegionCities);
        return new ResultVO(suppliersRegionCities);
    }
}

