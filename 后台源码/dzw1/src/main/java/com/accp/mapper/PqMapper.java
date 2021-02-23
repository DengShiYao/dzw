package com.accp.mapper;

import com.accp.domain.Pq;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface PqMapper extends BaseMapper<Pq> {
    public  Pq selById(Integer pqId);
}
