package com.accp.controller;


import com.accp.domain.SysRole;
import com.accp.domain.SysUserRole;
import com.accp.service.impl.SysRoleServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    SysRoleServiceImpl sysRoleService;
    @GetMapping
    public List<SysRole> findRole(){
        return sysRoleService.list();
    }

    @GetMapping("/sysRole1")
    public List<SysRole> findRole1(){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("del_flag",2);
        return sysRoleService.list(queryWrapper);
    }
    @PostMapping("selectRoleIdById")
    public SysRole findRoleById(Integer roleId){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        return sysRoleService.getOne(queryWrapper);
    }

    @PostMapping("updateSysRoleById")
    public boolean updateSysRoleById(SysRole updateRole){
        System.out.println(updateRole.getRoleId());
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",updateRole.getRoleId());
        return updateRole.update(queryWrapper);
//        return sysRoleService.update(queryWrapper) ;
    }

    @PostMapping("deleteRole")
    public boolean deleteRole(Integer role_id){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",role_id);
        return new SysRole().setDelFlag(2).setStatus(1).update(queryWrapper);
    }

    @PostMapping("rollBack")
    public boolean rollBack(Integer role_id){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",role_id);
        return new SysRole().setDelFlag(0).setStatus(0).update(queryWrapper);
    }

    @PostMapping("addRole")
    public boolean addRole1(SysRole addRole){
        boolean flag = addRole.setDelFlag(0).insert();
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setRoleId(addRole.getRoleId());
        sysUserRole.setUserId(1);
        flag = sysUserRole.insert();
        return flag;
    }


}

