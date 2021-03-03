package com.accp.service.impl;

import com.accp.domain.Cargoods;
import com.accp.mapper.CargoodsMapper;
import com.accp.service.ICargoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
@Service
public class CargoodsServiceImpl extends ServiceImpl<CargoodsMapper, Cargoods> implements ICargoodsService {

    @Autowired
    CargoodsMapper cargoodsMapper;

    @Override
    public boolean updateCargoodsToWork(String cloumn1) {
        boolean a=false;
        int b=cargoodsMapper.updateCargoodsToWork(cloumn1);
        if(b>0){
            a=true;
        }
        return a;
    }

    @Override
    public boolean updateCargoodsToSettlement(String cloumn1) {
        boolean a=false;
        int b= cargoodsMapper.updateCargoodsToSettlement(cloumn1);
        if(b>0){
            a=true;
        }
        return a;
    }
}
