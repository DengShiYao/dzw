package com.accp.controller;


import com.accp.domain.Sex;
import com.accp.service.impl.SexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/sex")
public class SexController {
    @Autowired
    SexServiceImpl sexService;
    @GetMapping
    public List<Sex> selAll(){
        return sexService.list();
    }
    @PostMapping
    public boolean addSex(@RequestBody Sex sex){
        return sexService.save(sex);
    }
    @PutMapping
    public boolean updateSex(@RequestBody Sex sex){
        return sexService.updateById(sex);
    }
    @DeleteMapping("/remove/{sexId}")
    public boolean removeSex(@PathVariable Integer sexId){
        return sexService.removeById(sexId);
    }
    @PutMapping("/saveOrUpdate")
    /**
     * 对性别进行保存
     */
    public boolean saveOrUpdate(@RequestBody List<Sex> sexList){
       return sexService.saveOrUpdateBatch(sexList);
    }
}

