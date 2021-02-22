package com.accp.mapper;

import com.accp.domain.National;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface NationalMapper extends BaseMapper<National> {
    public National selById(Integer nationalId);
}
