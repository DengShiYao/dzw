package com.accp.mapper;

import com.accp.domain.UserVehicles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface UserVehiclesMapper extends BaseMapper<UserVehicles> {
        public List<UserVehicles> findSelect(Page<UserVehicles> page);
}
