package com.accp.mapper;

import com.accp.domain.FirmGrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface FirmGradeMapper extends BaseMapper<FirmGrade> {

    FirmGrade toFind(Integer fgId);
}
