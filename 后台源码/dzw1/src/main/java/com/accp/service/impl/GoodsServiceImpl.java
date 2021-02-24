package com.accp.service.impl;

import com.accp.domain.Goods;
import com.accp.mapper.GoodsMapper;
import com.accp.service.IGoodsService;
import com.accp.vo.Page;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
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

    /**
     * 按条件查询分页
     * @param page
     * @param goods
     * @return
     */
    public Page<Goods> searchGoodsPage(Page<Goods> page,Goods goods){
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Goods::getBlockUp,goods.getBlockUp());
        //商品编号
        if (!StringUtils.isEmpty(goods.getGoodsId())) wrapper.like(Goods::getGoodsId,goods.getGoodsId());
        //商品名称
        if (!StringUtils.isEmpty(goods.getGoodsName())) wrapper.like(Goods::getGoodsName, goods.getGoodsName());
        //商品品牌
        if (goods.getGbId()!=null) wrapper.eq(Goods::getGbId, goods.getGbId());
        //使用车型
        if (!StringUtils.isEmpty(goods.getEngineType())) wrapper.like(Goods::getEngineType, goods.getEngineType());
        //商品分类
        if (goods.getGoodsCId()!=null) wrapper.eq(Goods::getGoodsCId, goods.getGoodsCId());
        //收入分类
        if (!StringUtils.isEmpty(goods.getIId())) wrapper.eq(Goods::getIId, goods.getIId());
        //原厂副厂
        if (!StringUtils.isEmpty(goods.getSpec5())) wrapper.eq(Goods::getSpec5, goods.getSpec5());
        //商品等级
        if (!StringUtils.isEmpty(goods.getSpec6())) wrapper.eq(Goods::getSpec6, goods.getSpec6());
        //商品产地
        if (goods.getProId()!=null) wrapper.eq(Goods::getProId, goods.getProId());
        //原厂编码
        if (!StringUtils.isEmpty(goods.getOldBM())) wrapper.like(Goods::getOldBM, goods.getOldBM());
        //条形码
        if (!StringUtils.isEmpty(goods.getItemTM())) wrapper.like(Goods::getItemTM, goods.getItemTM());
        //包装规格
        if (!StringUtils.isEmpty(goods.getPackSpec())) wrapper.like(Goods::getPackSpec, goods.getPackSpec());
        //体积
        if (!StringUtils.isEmpty(goods.getSpec())) wrapper.like(Goods::getSpec, goods.getSpec());
        //毛重
        if (!StringUtils.isEmpty(goods.getGrossWeight())) wrapper.eq(Goods::getGrossWeight, goods.getGrossWeight());
        //净重
        if (!StringUtils.isEmpty(goods.getNetWeight())) wrapper.eq(Goods::getNetWeight, goods.getNetWeight());
        return mapper.searchGoodsPage(page,wrapper);
    }

    /**
     * 查询全部
     * @return
     */
    public List<Goods> goodsListAll(){
        return mapper.goodsListAll();
    }
}
