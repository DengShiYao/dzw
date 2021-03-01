package com.accp.controller;


import com.accp.domain.TypeOfVehicle;
import com.accp.domain.UserVehicles;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.accp.service.ITypeOfVehicleService;

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
@RequestMapping("/typeOfVehicle")
public class TypeOfVehicleController {
    @Autowired
    ITypeOfVehicleService zz;
    @RequestMapping("/select")
    public List<TypeOfVehicle> select(){
        QueryWrapper<TypeOfVehicle> query =  new QueryWrapper<>();
        List<TypeOfVehicle> studentList = zz.list(query);
        return studentList;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody TypeOfVehicle user){
        return zz.save(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updata(@RequestBody TypeOfVehicle user){
        return zz.updateById(user);
    }

    @RequestMapping("delect")
    @ResponseBody
    public boolean delect(int id){
        return zz.removeById(id);
    }
}

