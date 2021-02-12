package com.accp.controller;


import com.accp.result.ResultVO;
import com.accp.service.impl.FirmGradeServiceImpl;
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
@RequestMapping("/firmGrade")
public class FirmGradeController {

    @Autowired
    FirmGradeServiceImpl service;

    /**
     * 查询厂商等级列表
     * @return
     */
    @GetMapping
    public ResultVO toFind(){
        return new ResultVO(service.list());
    }
}

