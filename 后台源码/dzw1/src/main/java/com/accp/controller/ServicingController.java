package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
@RestController
@RequestMapping("/servicing")
public class ServicingController {
    @Autowired
    ServicingServiceImpl servicingService;

    @Autowired
    ServicingprojectServiceImpl servicingprojectService;

    @Autowired
    CargoodsServiceImpl cargoodsService;

    @Autowired
    AcquisitionServiceImpl acquisitionService;

    @Autowired
    GoodsServiceImpl goodsService;

    @GetMapping("/getServicingId")
    /**
     * 自动生成维修订单号
     */
    public String getServicingId(){
        QueryWrapper<Servicing> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("serNumber");
        List<Servicing> list= servicingService.list(wrapper);
        if(list!=null&&list.size()!=0){
            String servicingId=list.get(0).getSerNumber();
            return servicingService.getServicingId(servicingId);
        }
        return "00000RE210200001";
    }
//    @GetMapping("/selProjectByChepai/{chepai}")
//    /**
//     * 根据车牌查询该车的维修项目
//     */
//    public List<Servicing> selProjectByChepai(@PathVariable String chepai){
//        QueryWrapper<Servicing> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(Servicing::getSerChepai,chepai);
//        List<Servicing> list = servicingService.list(queryWrapper);
//        for(Servicing servicing:list){
//            QueryWrapper<Cargoods> queryWrapper1 = new QueryWrapper<>();
//            queryWrapper1.lambda().eq(Cargoods::getColumn1,servicing.getSerNumber());
//            Cargoods cargoods = cargoodsService.getOne(queryWrapper1);
//            servicing.setCargoods(cargoods);
//            QueryWrapper<Servicingproject> queryWrapper2 = new QueryWrapper<>();
//            queryWrapper2.lambda().eq(Servicingproject::getWxGdannumber,servicing.getSerNumber());
//            servicing.setList(servicingprojectService.list(queryWrapper2));
//        }
//        return  list;
//    }

    /**
     * 作业中的车辆
     * @return
     */
    @GetMapping("/selAll")
    public  List<Servicing> selAll(){
        List<Servicing> list = servicingService.list();
        for(Servicing servicing :list){
            QueryWrapper<Cargoods> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(Cargoods::getColumn1,servicing.getSerNumber());
            Cargoods cargoods = cargoodsService.getOne(queryWrapper);
            //cargoods.selectOne(queryWrapper);
            servicing.setCargoods(cargoods);
        }
        return  list;
    }

    /*@GetMapping("selAcquisitionByChepai/{chepai}")
    *//**
     * 根据车牌查询领料
     *//*
    public  List<Servicing> selAcquisitionByChepai(@PathVariable String chepai){
        QueryWrapper<Servicing> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Servicing::getSerChepai,chepai);
        List<Servicing> list = servicingService.list(queryWrapper);
        for(Servicing servicing:list) {
            QueryWrapper<Cargoods> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.lambda().eq(Cargoods::getColumn1,servicing.getSerNumber());
            Cargoods cargoods = cargoodsService.getOne(queryWrapper1);
            servicing.setCargoods(cargoods);
            QueryWrapper<Servicingproject> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.lambda().eq(Servicingproject::getWxGdannumber,servicing.getSerNumber());
            List<Servicingproject> list1= servicingprojectService.list(queryWrapper2);
            for (Servicingproject servicingproject : list1){
                QueryWrapper<Acquisition> queryWrapper3 = new QueryWrapper<>();
                queryWrapper3.lambda().eq(Acquisition::getAcRepairid,servicingproject.getWxId());
                List<Acquisition> list2 = acquisitionService.list(queryWrapper3);
                servicingproject.setListAcquisition(list2);
                for (Acquisition acquisition:list2){
                    QueryWrapper<Goods> queryWrapper4 = new QueryWrapper<>();
                    queryWrapper4.lambda().eq(Goods::getGoodsAutoId,acquisition.getAcGoods());
                    acquisition.setGoods(goodsService.getOne(queryWrapper4));
                }
            }
            servicing.setList(list1);
        }
        return list;
    }*/

    /**
     * 根据车牌查询维修历史
     * @param chepai
     * @return
     */
    @GetMapping("/selHistoryByChepai/{chepai}")
    public  List<Servicing> selHistoryByChepai(@PathVariable String chepai){
        QueryWrapper<Servicing> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Servicing::getSerChepai,chepai);
        List<Servicing> list = servicingService.list(queryWrapper);
        for(Servicing servicing :list){
            QueryWrapper<Cargoods> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.lambda().eq(Cargoods::getColumn1,servicing.getSerNumber()).eq(Cargoods::getCarStatus,3);
            servicing.setCargoods(cargoodsService.getOne(queryWrapper1));
        }
        return  list;
    }

}

