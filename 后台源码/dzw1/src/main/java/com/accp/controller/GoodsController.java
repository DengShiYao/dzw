package com.accp.controller;


import com.accp.domain.Goods;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.GoodsServiceImpl;
import com.accp.vo.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *  商品详情
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsServiceImpl service;

    /**
     * 查询商品列表
     * @param blockUp
     * @param column1
     * @return
     */
    @PostMapping("/find")
    public ResultVO selGoodsPage(Integer current,Integer blockUp, Integer column1){
        Page<Goods> page = new Page();
        page.setCurrent(current==null ? 0 :current);
        page.setSize(5);
        Page<Goods> mapIPage = service.selGoodsPage(page, blockUp, column1);
        return new ResultVO(mapIPage);
    }

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @PostMapping("/ins")
    public ResultVO saveInsGoods(@Valid @RequestBody Goods goods){
        Goods one = service.getOne(new QueryWrapper<Goods>().lambda().eq(Goods::getGoodsId, goods.getGoodsId()));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        service.save(goods);
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @PostMapping("/upd")
    public ResultVO saveUpdGoods(@Valid @RequestBody Goods goods){
        if (!goods.getBeforeId().equals(goods.getGoodsId())) {
            Goods one = service.getOne(new QueryWrapper<Goods>().lambda().eq(Goods::getGoodsId, goods.getGoodsId()));
            if (one != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        service.updateById(goods);
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 逻辑删除商品
     * @param goodsAutoId
     * @return
     */
    @PostMapping("remove")
    public ResultVO removeGoods(Integer goodsAutoId){
        if (goodsAutoId==null){
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        return new ResultVO(ResultCode.SUCCESS,service.removeById(goodsAutoId));
    }

}

