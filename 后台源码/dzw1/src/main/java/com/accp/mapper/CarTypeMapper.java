package com.accp.mapper;

import com.accp.domain.CarType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
public interface CarTypeMapper extends BaseMapper<CarType> {
    List<CarType> find( @Param("ew") Wrapper wrapper);
}
