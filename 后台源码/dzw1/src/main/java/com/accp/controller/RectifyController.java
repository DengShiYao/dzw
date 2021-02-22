package com.accp.controller;


import com.accp.domain.Rectify;
import com.accp.service.impl.RectifyServiceImpl;
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
@RequestMapping("/rectify")
public class RectifyController {
    @Autowired
    RectifyServiceImpl rectifyService;
    @GetMapping
    public List<Rectify> selAll(){
        return rectifyService.list();
    }
}

