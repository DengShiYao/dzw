package com.accp.mapper;

import com.accp.domain.Nature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface NatureMapper extends BaseMapper<Nature> {
    public Nature selById(Integer attId);
}
