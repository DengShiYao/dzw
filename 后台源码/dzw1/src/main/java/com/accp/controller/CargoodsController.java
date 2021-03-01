package com.accp.controller;


import com.accp.domain.Cargoods;
import com.accp.service.impl.CargoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
@RestController
@RequestMapping("/cargoods")
public class CargoodsController {

    @Autowired
    CargoodsServiceImpl service;

    @RequestMapping("/toFind")
    @ResponseBody
    public List<Cargoods> toFind(){
        return service.list();
    }


}

