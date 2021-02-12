package com.accp.service.impl;

import com.accp.domain.SuppliersRegion;
import com.accp.mapper.SuppliersRegionMapper;
import com.accp.service.ISuppliersRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@Service
public class SuppliersRegionServiceImpl extends ServiceImpl<SuppliersRegionMapper, SuppliersRegion> implements ISuppliersRegionService {

    @Autowired
    SuppliersRegionMapper mapper;

    public List<SuppliersRegion> toFind(String regionId){
        return mapper.toFind(regionId);
    }
}
