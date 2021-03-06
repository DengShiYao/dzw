package com.accp.mapper;

import com.accp.domain.Technical;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface TechnicalMapper extends BaseMapper<Technical> {
    /**
     * 离职
     * @return
     */
    public int madeFire(String technicalNumber);

    /**
     * 回滚
     * @param technicalNumber
     * @return
     */
    public int madeAssume(String technicalNumber);
}