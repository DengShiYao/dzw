
package com.accp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.accp.domain.UserVehicles;
import com.accp.service.IUserVehiclesService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
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
@RequestMapping("/userVehicles")
public class UserVehiclesController {
    @Autowired
    IUserVehiclesService zz;

    @RequestMapping("/selectPage")
    @ResponseBody
    public Page<UserVehicles> select(){
        Page<UserVehicles> page = new Page<>(1, 10);
        page.setRecords(zz.findSelect(page));
        /*QueryWrapper<UserVehicles> query =  new QueryWrapper<>();
        query.lambda().like(UserVehicles::getUvehicleid,User.getUvehicleid());
        page = zz.page(page,query);
        System.out.println("ssss");*/
        return page;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody UserVehicles user){
        System.out.println(user);
        return zz.save(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updata(@RequestBody UserVehicles user){
        System.out.println(user);
        return zz.updateById(user);
    }

    @RequestMapping("delect")
    @ResponseBody
    public boolean delect(int id){
        return zz.removeById(id);
    }
}