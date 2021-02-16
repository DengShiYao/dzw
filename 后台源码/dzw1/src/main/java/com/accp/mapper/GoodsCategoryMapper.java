package com.accp.mapper;

import com.accp.domain.GoodsCategory;
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
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

    List<GoodsCategory> selByPrent(Integer prentId);

    GoodsCategory selGdCategoryById(Integer column1);
}
