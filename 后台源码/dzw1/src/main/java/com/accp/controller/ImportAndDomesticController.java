package com.accp.controller;


import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.ImportAndDomesticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *  进口国产
 * @author dsy
 * @since 2021-02-01
 */
@RestController
    @RequestMapping("/importAndDomestic")
public class ImportAndDomesticController {

    @Autowired
    ImportAndDomesticServiceImpl domesticService;

    @GetMapping
    public ResultVO tofind(){
        return new ResultVO(ResultCode.SUCCESS,domesticService.list());
    }
}

