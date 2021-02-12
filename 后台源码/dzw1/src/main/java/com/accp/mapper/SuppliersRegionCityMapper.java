package com.accp.mapper;

import com.accp.domain.SuppliersRegionCity;
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
public interface SuppliersRegionCityMapper extends BaseMapper<SuppliersRegionCity> {
    /**
     * 查询供货厂层级
     * @return
     */
    List<SuppliersRegionCity> toFind(String parentId);

    /**
     * 根据id查询厂商类别
     * @param regionId
     * @return
     */
    SuppliersRegionCity selById(String regionId);
}
