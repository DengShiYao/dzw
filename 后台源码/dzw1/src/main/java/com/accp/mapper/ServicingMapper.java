package com.accp.mapper;

import com.accp.domain.Servicing;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
public interface ServicingMapper extends BaseMapper<Servicing> {
    public  Servicing selBySernumber(String serNumber);
}
