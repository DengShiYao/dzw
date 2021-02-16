package com.accp.service.impl;

import com.accp.domain.Goods;
import com.accp.mapper.GoodsMapper;
import com.accp.service.IGoodsService;
import com.accp.vo.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    GoodsMapper mapper;

    /**
     * 查询商品列表
     * @param blockUp   停用启用
     * @param column1   分类
     * @return
     */
    public Page<Goods> selGoodsPage(Page<Goods> page, Integer blockUp, Integer column1){
        return mapper.selGoodsPage(page, blockUp, column1);
    }
}
