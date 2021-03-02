package com.accp.controller;


import com.accp.domain.SysMenu;
import com.accp.domain.SysRoleMenu;
import com.accp.domain.SysUser;
import com.accp.service.impl.SysMenuServiceImpl;
import com.accp.service.impl.SysRoleMenuServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Autowired
    SysMenuServiceImpl SysMenuService;
    @Autowired
    SysRoleMenuServiceImpl sysRoleMenuService;
    //按照父类id查询所有的子菜单
    @PostMapping("/{menu_id}")
    public List<SysMenu> findMenuInCAll(@PathVariable Integer menu_id, HttpSession httpSession){
        SysUser sysUser = (SysUser) httpSession.getAttribute("user");
        return SysMenuService.findMenuC(menu_id,sysUser.getUserId());
    }
    //查询所有的目录
    @PostMapping
    public List<SysMenu> findMenuInMAll(HttpSession httpSession) {
        SysUser sysUser = (SysUser) httpSession.getAttribute("user");
        return SysMenuService.findMenuM(sysUser.getUserId());
    }

    @PostMapping("findAll")
    public List<SysMenu> findAll(){
        return SysMenuService.list();
    }
    @PostMapping("sysByRoleId")
    public List<SysMenu> sysByRoleId(Integer roleId){
        return SysMenuService.findMenuByRole(roleId);
    }

    @PostMapping("addRole_menu/{roleId}")
    public boolean addRole_menu(@PathVariable("roleId")  Integer roleId, String [] array){
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        boolean result = sysRoleMenuService.remove(queryWrapper);
       for(int i = 0;i < array.length;i++){
            System.out.println(array[i]);
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(Integer.valueOf(array[i]));
            sysRoleMenuService.save(sysRoleMenu);
        }

        return true;
    }

    @PostMapping("selectFindAllM")
    public List<SysMenu> selectFindAllM(){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        return SysMenuService.list(queryWrapper);
    }

    @PostMapping("selectFindById")
    public SysMenu selectFindById(Integer menuId){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menu_id",menuId);
        return SysMenuService.getOne(queryWrapper);
    }
    @PostMapping("updateMenuById")
    public boolean updateMenuById(SysMenu updateMenu1){
        if ("".equals(updateMenu1.getCreateTime()) || updateMenu1.getCreateTime().length()==0 ) {
            updateMenu1.setCreateTime(null);
        }
        System.out.println(updateMenu1);
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menu_id",updateMenu1.getMenuId());

        return updateMenu1.update(queryWrapper);
    }

    @PostMapping("deleteMenu")
    public boolean deleteMenu(Integer menuId){
       SysMenu sysMenu = new SysMenu();
       sysMenu.setChar1("1");
       QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
       queryWrapper.eq("menu_id",menuId);
       return sysMenu.update(queryWrapper);
    }
    @PostMapping("findPerms")
    public List<SysMenu> findPerms(HttpSession session){
        SysUser user = (SysUser) session.getAttribute("user");
        return SysMenuService.findPerms(user.getUserId());
    }

    @PostMapping("selectMenuBySel")
    public List<SysMenu> selectMenuBySel(String menuType){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menu_type",menuType);
        return SysMenuService.list(queryWrapper);
    }

    @PostMapping("addSysMenu")
    public boolean addSysMenu(SysMenu addMenu){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = simpleDateFormat.format(date);
        addMenu.setCreateTime(dateTime);
        boolean flag= addMenu.insert();
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setRoleId(1);
        sysRoleMenu.setMenuId(addMenu.getMenuId());
        flag = sysRoleMenuService.save(sysRoleMenu);

        return flag;
    }
}