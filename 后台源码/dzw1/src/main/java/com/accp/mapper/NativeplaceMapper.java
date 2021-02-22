package com.accp.mapper;

import com.accp.domain.Nativeplace;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface NativeplaceMapper extends BaseMapper<Nativeplace> {
    public Nativeplace selById(Integer nplaceId);
}
