package com.accp.service.impl;

import com.accp.domain.SysMenu;
import com.accp.mapper.SysMenuMapper;
import com.accp.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@Service
@Transactional
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    public List<SysMenu> findMenuC(Integer menu_id,Integer user_id){
        return sysMenuMapper.findMenuC(menu_id,user_id);
    }

    public List<SysMenu> findMenuM(Integer user_id){
        return sysMenuMapper.findMenuM(user_id);
    }

    public List<SysMenu> findPerms(Integer user_id){
        return sysMenuMapper.findPerms(user_id);
    }

    public List<SysMenu> findMenuByRole(Integer role_id){
        return sysMenuMapper.findMenuByRole(role_id);
    }
}
