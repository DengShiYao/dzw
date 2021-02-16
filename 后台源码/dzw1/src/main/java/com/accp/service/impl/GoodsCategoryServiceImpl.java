package com.accp.service.impl;

import com.accp.domain.GoodsCategory;
import com.accp.mapper.GoodsCategoryMapper;
import com.accp.service.IGoodsCategoryService;
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
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements IGoodsCategoryService {

    @Autowired
    GoodsCategoryMapper mapper;

    public List<GoodsCategory> selByPrent(Integer prentId){
        return mapper.selByPrent(prentId);
    }
}
