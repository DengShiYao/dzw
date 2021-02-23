package com.accp.controller;


import com.accp.domain.Recharge;
import com.accp.service.impl.RechargeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/recharge")
public class RechargeController {
    @Autowired
    RechargeServiceImpl rechargeService;
    @GetMapping
    public List<Recharge> selAll(){
        return rechargeService.list();
    }
}

