package com.accp.mapper;

import com.accp.domain.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    public List<SysMenu> findMenuC(@Param("menu_id1") Integer menu_id1,@Param("user_id1") Integer user_id1);
    public List<SysMenu> findMenuM(Integer user_id);
    public List<SysMenu> findMenuByRole(Integer role_id);
    public List<SysMenu> findPerms(Integer user_id);
}
