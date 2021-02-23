package com.accp.controller;


import com.accp.service.impl.GoodsIconServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *  商品图片
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/goodsIcon")
public class GoodsIconController {

    @Autowired
    GoodsIconServiceImpl iconService;

    public void selGoodsIcon(MultipartFile[] files){

    }
}

