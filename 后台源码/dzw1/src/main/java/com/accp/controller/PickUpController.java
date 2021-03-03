package com.accp.controller;


import com.accp.domain.PickUp;
import com.accp.service.impl.PickUpServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-03-03
 */
@RestController
@RequestMapping("/pickUp")
public class PickUpController {
    @Autowired
    PickUpServiceImpl pickUpService;

    @PostMapping
    public List<PickUp> findPickUp(){
        return pickUpService.list();
    }

    @PostMapping("findPickNum")
    public Integer findPickNum(){
        QueryWrapper<PickUp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("column1","未读");
        return pickUpService.count(queryWrapper);
    }
}

