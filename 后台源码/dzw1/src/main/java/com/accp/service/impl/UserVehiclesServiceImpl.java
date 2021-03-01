package com.accp.service.impl;

import com.accp.domain.UserVehicles;
import com.accp.mapper.UserVehiclesMapper;
import com.accp.service.IUserVehiclesService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserVehiclesServiceImpl extends ServiceImpl<UserVehiclesMapper, UserVehicles> implements IUserVehiclesService {
    @Autowired(required=false)
    UserVehiclesMapper mapper;
    @Override
    public List<UserVehicles> findSelect(Page<UserVehicles> page) {
        return mapper.findSelect(page);
    }
}
