package com.accp.controller;


import com.accp.domain.Car;
import com.accp.domain.Cargoods;
import com.accp.domain.Servicing;
import com.accp.service.impl.CargoodsServiceImpl;
import com.accp.service.impl.ServicingServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

