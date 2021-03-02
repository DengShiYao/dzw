package com.accp.service;

import com.accp.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface ISysMenuService extends IService<SysMenu> {
   List<SysMenu> findMenuC(Integer menu_id,Integer user_id);
    List<SysMenu> findMenuM(Integer user_id);
    List<SysMenu> findMenuByRole(Integer role_id);
    List<SysMenu> findPerms(Integer user_id);
}
