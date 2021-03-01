package com.accp.service;

import com.accp.domain.UserVehicles;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public interface IUserVehiclesService extends IService<UserVehicles> {
    public List<UserVehicles> findSelect(Page<UserVehicles> page);
}
