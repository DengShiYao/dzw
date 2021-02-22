package com.accp.mapper;

import com.accp.domain.School;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface SchoolMapper extends BaseMapper<School> {
    public  School selById(Integer schoolId);
}
