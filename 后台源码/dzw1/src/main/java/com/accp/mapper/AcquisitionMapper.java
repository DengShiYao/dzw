package com.accp.mapper;

import com.accp.domain.Acquisition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
public interface AcquisitionMapper extends BaseMapper<Acquisition> {
    /**
     * 根据车牌查询到的项目list得到领料
     * @param array
     * @return
     */
    public List<Acquisition> selByArray(Integer [] array);
}
