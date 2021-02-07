package com.accp.service.impl;

import com.accp.domain.SuppliersRegionCity;
import com.accp.mapper.SuppliersRegionCityMapper;
import com.accp.service.ISuppliersRegionCityService;
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
public class SuppliersRegionCityServiceImpl extends ServiceImpl<SuppliersRegionCityMapper, SuppliersRegionCity> implements ISuppliersRegionCityService {

    @Autowired
    SuppliersRegionCityMapper mapper;

    public List<SuppliersRegionCity> toFind(){
        return mapper.toFind("0");
    }
}
