package com.accp.controller;


import com.accp.result.ResultVO;
import com.accp.service.impl.GoodsBrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *  商品品牌
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/goodsBrand")
public class GoodsBrandController {

    @Autowired
    GoodsBrandServiceImpl service;

    /**
     * 查询商品品牌列表
     * @return
     */
    @GetMapping
    public ResultVO selGoodsBrand(){
        return new ResultVO(service.list());
    }
}

