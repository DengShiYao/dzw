package com.accp.controller;


import com.accp.domain.Postition;
import com.accp.service.impl.PostitionServiceImpl;
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
 * @since 2021-02-24
 */
@RestController
@RequestMapping("/postition")
public class PostitionController {

    @Autowired
    PostitionServiceImpl postitionService;

    /**
     * 查询职务
     * @return
     */
    @GetMapping
    public List<Postition> selAll(){
        return postitionService.list();
    }
}

