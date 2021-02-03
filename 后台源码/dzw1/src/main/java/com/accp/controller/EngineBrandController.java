package com.accp.controller;


import com.accp.domain.EngineBrand;
import com.accp.service.impl.EngineBrandServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/engineBrand")
public class EngineBrandController {
    @Autowired
    EngineBrandServiceImpl brandService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 查询发动机品牌
     * @return
     */
    @GetMapping
    public List<EngineBrand> engineFind(){
        return brandService.list();
    }

    /**
     * 查询总数据
     * @return
     */
    @GetMapping("/tocount")
    public int getEngineBrandCount(){
        return brandService.count();
    }

    /**
     * 编辑品牌，存在为修改反之为新增
     * @param json
     * @return
     */
    @PostMapping
    public String toInsert(String json) {
        System.out.println(json);
        try {
            System.out.println(json);
            EngineBrand engineBrand = objectMapper.readValue(json, EngineBrand.class);
            boolean b = brandService.saveOrUpdate(engineBrand);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "cg";
    }

}

