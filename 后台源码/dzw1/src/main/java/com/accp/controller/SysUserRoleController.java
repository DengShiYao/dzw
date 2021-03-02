package com.accp.controller;


import com.accp.domain.SysUserRole;
import com.accp.service.impl.SysUserRoleServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2021-02-26
 */
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    @Autowired
    SysUserRoleServiceImpl sysUserRoleService;

    @PostMapping("/selectUserRole")
    public List<SysUserRole> findSysROleList(Integer select_userId){
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",select_userId);
        return sysUserRoleService.list(queryWrapper);
    }


    @PostMapping("/addUserRole/{select_userId}")
    public boolean addUserRole(@PathVariable("select_userId") Integer select_userId,String [] array){
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",select_userId);
        boolean flag = sysUserRoleService.remove(queryWrapper);

        for (int i = 0; i < array.length; i++) {
            flag = sysUserRoleService.save(new SysUserRole().setRoleId(Integer.valueOf(array[i])).setUserId(select_userId));
        }
        return flag;
    }
}

