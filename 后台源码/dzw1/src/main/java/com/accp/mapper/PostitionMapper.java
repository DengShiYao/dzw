package com.accp.mapper;

import com.accp.domain.Postition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-24
 */
public interface PostitionMapper extends BaseMapper<Postition> {
    /**
     * 根据id查询职务
     * @param postitionId
     * @return
     */
    public Postition selByPid(Integer postitionId);
}
