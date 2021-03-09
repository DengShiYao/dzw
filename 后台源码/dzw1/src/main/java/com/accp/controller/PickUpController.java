package com.accp.controller;


import com.accp.domain.FieldVehicles;
import com.accp.domain.PickUp;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.PickUpServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-03-03
 */
@RestController
@RequestMapping("/pickUp")
public class PickUpController {
    @Autowired
    PickUpServiceImpl pickUpService;

    @PostMapping
    public List<PickUp> findPickUp(){
        return pickUpService.list();
    }

    @Autowired
    PickUpServiceImpl service;

    /**
     * ‘查询当前手机号是否有接车
     * @return
     */
    @GetMapping("/find")
    public ResultVO selPicupList(){
//        PickUp one = service.getOne(new QueryWrapper<PickUp>().lambda().eq(PickUp::getPhone, phone));
//        if (one == null) {
//            return new ResultVO(ResultCode.SUCCESS,one );
//        }

        return new ResultVO(ResultCode.SUCCESS,service.list() );
    }

    @RequestMapping("/savepicup")
    public ResultVO insPuup(@RequestBody PickUp pickUp) {
        System.out.println(pickUp);
        pickUp.setColumn1("未读");
        service.save(pickUp);
        return new ResultVO(ResultCode.SUCCESS);
    }
    @PostMapping("findPickNum")
    public Integer findPickNum(){
        QueryWrapper<PickUp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("column1","未读");
        return pickUpService.count(queryWrapper);
    }

    @PostMapping("updatePick_upStatus")
    public boolean updatePick(Integer id,String carObj,Integer carObjId){
        QueryWrapper<FieldVehicles> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("column1",carObjId);
        FieldVehicles fieldVehicles = new FieldVehicles();
        fieldVehicles.setColumn3("接车中");
        fieldVehicles.update(queryWrapper1);
        QueryWrapper<PickUp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        PickUp pickUp = new PickUp();
        pickUp.setColumn2(carObj);
        pickUp.setStatus("接车中");
        pickUp.setColumn1("已读");
        return pickUp.update(queryWrapper);
    }

}

