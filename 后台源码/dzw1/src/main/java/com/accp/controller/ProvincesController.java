package com.accp.controller;


import com.accp.result.ResultVO;
import com.accp.service.impl.ProvincesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *  商品产地
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/provinces")
public class ProvincesController {

    @Autowired
    ProvincesServiceImpl service;

    /**
     * 查询商品产地
     * @return
     */
    @GetMapping
    public ResultVO selProvinces(){
        return new ResultVO(service.list());
    }
}

