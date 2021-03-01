package com.accp.controller;


import com.accp.domain.SysUser;
import com.accp.service.impl.SysUserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    SysUserServiceImpl sysUserService;

    //登录
    @GetMapping("selectUser")
    public SysUser selectFind(SysUser sysUser, HttpSession httpSession){
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",sysUser.getLoginName()).eq("password", sysUser.getPassword());
        SysUser sysUser1 = sysUserService.getOne(queryWrapper);
        if(sysUser1 != null){
            httpSession.setAttribute("user",sysUser1);
        }
        return sysUser1 != null ? sysUser1 : new SysUser();
    }
    //判断是否已登录
    @PostMapping("isUser")
    public SysUser isUser(HttpSession httpSession){
        Object obj = httpSession.getAttribute("user");
        return obj != null ? (SysUser)obj : new SysUser();
    }
    //查询所有用户
    @PostMapping
    public List<SysUser> findUser(){
        return sysUserService.list();
    }


}

