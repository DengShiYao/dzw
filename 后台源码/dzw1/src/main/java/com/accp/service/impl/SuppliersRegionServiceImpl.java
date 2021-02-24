package com.accp.service.impl;

import com.accp.domain.SuppliersRegion;
import com.accp.mapper.SuppliersRegionMapper;
import com.accp.service.ISuppliersRegionService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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

    public List<SuppliersRegion> serachSupplier(SuppliersRegion region){
        LambdaQueryWrapper<SuppliersRegion> wrapper = new LambdaQueryWrapper();
        wrapper.eq(SuppliersRegion::getColumn1,"0");
        //厂商代码
        if(!StringUtils.isEmpty(region.getProvCode())) wrapper.like(SuppliersRegion::getProvCode,region.getProvCode());
        //厂商名称
        if(!StringUtils.isEmpty(region.getProvName())) wrapper.like(SuppliersRegion::getProvName,region.getProvName());
        //地址
        if(!StringUtils.isEmpty(region.getAddress())) wrapper.like(SuppliersRegion::getAddress,region.getAddress());
        //付款方式
        if(region.getPmId()!=null) wrapper.eq(SuppliersRegion::getPmId,region.getPmId());
        //厂商等级
        if(region.getFgId()!=null) wrapper.eq(SuppliersRegion::getFgId,region.getFgId());
        //经营品牌
        if(!StringUtils.isEmpty(region.getZd2())) wrapper.like(SuppliersRegion::getZd2,region.getZd2());
        //厂商类别
        if(!StringUtils.isEmpty(region.getProvType())) wrapper.eq(SuppliersRegion::getProvType,region.getProvType());
        //经营情况
        if(!StringUtils.isEmpty(region.getOperation())) wrapper.eq(SuppliersRegion::getOperation,region.getOperation());
        //备注
        if(!StringUtils.isEmpty(region.getRemark())) wrapper.like(SuppliersRegion::getRemark,region.getRemark());
        return mapper.serachSupplier(wrapper);
    }
}
