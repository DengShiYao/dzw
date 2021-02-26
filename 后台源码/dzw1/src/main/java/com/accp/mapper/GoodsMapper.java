package com.accp.mapper;

import com.accp.domain.Goods;
import com.accp.vo.Page;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<Goods> goodsList(@Param("blockUp") Integer blockUp,@Param("column1") Integer column1);

    Page<Goods> selGoodsPage(Page<Goods> page, @Param("blockUp") Integer blockUp, @Param("column1") Integer column1);

    Page<Goods> searchGoodsPage(Page<Goods> page,@Param("ew") Wrapper wrapper);
    //查询全部
    List<Goods> goodsListAll();
    //按条件查询
    List<Goods> goodsListSearch(@Param("ew") Wrapper wrapper);

}
