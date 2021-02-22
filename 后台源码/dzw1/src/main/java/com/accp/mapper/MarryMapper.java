package com.accp.mapper;

import com.accp.domain.Marry;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface MarryMapper extends BaseMapper<Marry> {
    public Marry selById(Integer marryId);

}
