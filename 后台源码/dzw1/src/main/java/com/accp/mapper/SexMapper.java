package com.accp.mapper;

import com.accp.domain.Sex;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface SexMapper extends BaseMapper<Sex> {
    public Sex selById(Integer sexId);
}
