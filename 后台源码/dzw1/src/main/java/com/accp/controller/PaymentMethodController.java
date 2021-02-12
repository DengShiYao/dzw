package com.accp.controller;


import com.accp.result.ResultVO;
import com.accp.service.impl.PaymentMethodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/paymentMethod")
public class PaymentMethodController {

    @Autowired
    PaymentMethodServiceImpl service;

    /**
     * 查询付款方式
     * @return
     */
    @GetMapping
    public ResultVO toFind(){
        return new ResultVO(service.list());
    }
}

