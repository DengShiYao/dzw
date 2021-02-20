package com.accp.controller;


import com.accp.domain.*;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *  维修项目
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/serve")
public class ServeController {

    /**
     * 维修服务
     */
    @Autowired
    ServeServiceImpl serveService;
    /**
     * 小修
     */
    @Autowired
    MinorServiceImpl minorService;
    /**
     * 保养
     */
    @Autowired
    UpkeepServiceImpl upkeepService;
    /**
     *  钣喷
     */
    @Autowired
    CoinSprayServiceImpl sprayService;
    /**
     * 发动机
     */
    @Autowired
    EngineBrandServiceImpl engineBrandService;
    /**
     * 车型
     */
    @Autowired
    CarBrandServiceImpl carBrandService;

    /**
     * 查询维修的类型
     * @return
     */
    @GetMapping("/findepairing")
    public ResultVO repairingService(){
        List<Minor> minorList = minorService.list();
        List<Upkeep> upkeepList = upkeepService.list();
        List<CoinSpray> sprayList = sprayService.list();
        List<EngineBrand> brandList = engineBrandService.list();
        List<CarBrand> typeList = carBrandService.list();
        Map<String, List> map = new HashMap();
        map.put("minorList",minorList);
        map.put("upkeepList",upkeepList);
        map.put("sprayList",sprayList);
        map.put("brandList",brandList);
        map.put("typeList",typeList);
        return new ResultVO(ResultCode.SUCCESS,map);
    }

    /**
     * 查询维修修服务列表
     * @param brandId
     * @return
     */
    @GetMapping("/selsarve/{brandId}")
    public ResultVO selSarveList(@PathVariable String brandId){
        QueryWrapper<Serve> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Serve::getBrandId,brandId);
        return new ResultVO(ResultCode.SUCCESS,serveService.list(wrapper));
    }

    /**
     * 查询维修修服务列表
     * @return
     */
    @GetMapping("/selsarve")
    public ResultVO selSarveAll(){
        return new ResultVO(ResultCode.SUCCESS,serveService.list());
    }

    /**
     * 新增维修项目
     * @param serve
     * @return
     */
    @PostMapping("/ins")
    public ResultVO saveInsServe(@RequestBody Serve serve){
        if (serve.getSeId()=="" || serve.getSeName()=="" || serve.getBeforeId()=="" || serve.getIId()==null){
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        Serve one = serveService.getOne(new QueryWrapper<Serve>().lambda().eq(Serve::getSeId, serve.getSeId()));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        return new ResultVO(ResultCode.SUCCESS,serveService.save(serve));
    }

    /**
     * 修改维修项目
     * @param serve
     * @return
     */
    @PostMapping("/upd")
    public ResultVO saveUpdServe(@RequestBody Serve serve){
        if (serve.getSeId()=="" || serve.getSeName()=="" || serve.getBeforeId()=="" || serve.getIId()==null){
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        if (!serve.getBeforeId().equals(serve.getSeId())){
            Serve one = serveService.getOne(new QueryWrapper<Serve>().lambda().eq(Serve::getSeId, serve.getSeId()));
            if (one != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        serveService.update(serve,new QueryWrapper<Serve>().lambda().eq(Serve::getSeId,serve.getBeforeId()));
        return new ResultVO(ResultCode.SUCCESS);
    }
}

