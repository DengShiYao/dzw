package com.accp.mapper;

import com.accp.domain.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface MajorMapper extends BaseMapper<Major> {
    public Major selById(Integer majorId);
}
