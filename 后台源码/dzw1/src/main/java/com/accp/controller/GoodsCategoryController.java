package com.accp.controller;


import com.accp.domain.Goods;
import com.accp.domain.GoodsCategory;
import com.accp.domain.GoodsIcon;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.GoodsCategoryServiceImpl;
import com.accp.service.impl.GoodsIconServiceImpl;
import com.accp.service.impl.GoodsServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *  商品分类
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {

    /**
     * 商品分类
     */
    @Autowired
    GoodsCategoryServiceImpl service;
    /**
     * 商品图片
     */
    @Autowired
    GoodsIconServiceImpl iconService;
    /**
     * 商品
     */
    @Autowired
    GoodsServiceImpl goodsService;

    /**
     * 递归查询分类列表
     * @return
     */
    @GetMapping
    public ResultVO find(){
        return new ResultVO(ResultCode.SUCCESS,service.selByPrent(0));
    }

    /**
     * 新增商品分类，如果编号重复返回 3000
     * @param category
     * @return
     */
    @PostMapping("/ins")
    public ResultVO insGoodsCategory(@Valid @RequestBody GoodsCategory category){
        GoodsCategory one = service.getOne(new QueryWrapper<GoodsCategory>().lambda().
                eq(GoodsCategory::getGoodsCId, category.getGoodsCId()));
        if (one == null) {
            return new ResultVO(ResultCode.SUCCESS,service.save(category));
        }
        return new ResultVO(ResultCode.PEY_EXIT);
    }

    /**
     * 修改分类 编号重复返回3000
     * @param category
     * @return
     */
    @PostMapping("/upd")
    public ResultVO updGoodsCategory(@Valid @RequestBody GoodsCategory category){
        System.out.println(category);
        if (!category.getBeforeId().equals(category.getGoodsCId())){
            GoodsCategory one = service.getOne(new QueryWrapper<GoodsCategory>().lambda().
                    eq(GoodsCategory::getGoodsCId, category.getGoodsCId()));
            if (one != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        return new ResultVO(ResultCode.SUCCESS,service.updateById(category));
    }

    /**
     * 删除分类
     * @param column1
     * @return
     */
    @PostMapping("/del/{column1}")
    public ResultVO delGoodsCategory(@PathVariable Integer column1){
        if (column1==null){
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        //先判断当当前分类下有其他分类关联
        List<GoodsCategory> list1 = service.list(new QueryWrapper<GoodsCategory>().lambda()
                .eq(GoodsCategory::getParentid, column1));
        if (list1.size()!=0) {
            return new ResultVO(ResultCode.Failure);
        }
        //先删除图片再删除商品最后删除分类
        QueryWrapper<Goods> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(Goods::getSId,column1);
        List<Goods> list = goodsService.list(queryWrapper);
        if (list != null) {
            QueryWrapper<GoodsIcon> wrapper = new QueryWrapper();
            list.forEach(item->{
                wrapper.lambda().eq(GoodsIcon::getGoodsId,item.getSId());
                iconService.remove(wrapper);
            });
        }
        //删除商品
        goodsService.remove(queryWrapper);
        //删除分类
        service.removeById(column1);
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 查询父级编号
     * @param parentid
     * @return
     */
    @GetMapping("/pid/{parentid}")
    public ResultVO findById(@PathVariable  Integer parentid){
        String goodsCId = service.getById(parentid).getGoodsCId();
        System.out.println(goodsCId);
        return new ResultVO(goodsCId);
    }
}

