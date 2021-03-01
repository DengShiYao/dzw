package com.accp.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.accp.domain.Maintenance;
import com.accp.service.IMaintenanceService;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    IMaintenanceService zz;
    @RequestMapping("/selectPage")
    @ResponseBody
    public List<Maintenance> select(String cph){
        System.out.println(cph);
        QueryWrapper<Maintenance> query = new QueryWrapper<>();
        query.lambda().like(Maintenance::getCheNumber,cph);
        List<Maintenance> list = zz.list(query);
        return list;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody Maintenance user){
        return zz.save(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updata(@RequestBody Maintenance user){
        return zz.updateById(user);
    }

    @RequestMapping("delect")
    @ResponseBody
    public boolean delect(Integer id){
        return zz.removeById(id);
    }


}

