package com.accp.mapper;

import com.accp.domain.SuppliersRegion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface SuppliersRegionMapper extends BaseMapper<SuppliersRegion> {
    List<SuppliersRegion> toFind(String regionId);
}
