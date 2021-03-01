package com.accp.controller;


import com.accp.domain.Acquisition;
import com.accp.domain.Servicing;
import com.accp.domain.Servicingproject;
import com.accp.service.impl.AcquisitionServiceImpl;
import com.accp.service.impl.ServicingServiceImpl;
import com.accp.service.impl.ServicingprojectServiceImpl;
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
@RequestMapping("/acquisition")
public class AcquisitionController {

    @Autowired
    ServicingServiceImpl servicingService;

    @Autowired
    ServicingprojectServiceImpl servicingprojectService;

    @Autowired
    AcquisitionServiceImpl acquisitionService;

    @GetMapping("selAcquisitionByChepai/{chepai}")
    /**
     * 根据车牌查询领料
     */
    public List<Acquisition> selByChepai(@PathVariable String chepai){
        QueryWrapper<Servicing> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Servicing::getSerChepai,chepai);
        List<Servicing> list = servicingService.list(queryWrapper);
        String [] array = new String[list.size()];
        for(int i=0;i<array.length;i++){
            array[i]=list.get(i).getSerNumber();
        }
        List<Servicingproject> list1 =servicingprojectService.selByArray(array);
        Integer [] array1= new Integer[list1.size()];
        for (int i=0;i<array1.length;i++){
            array1[i]=list1.get(i).getWxId();
        }
        List<Acquisition> list2 =acquisitionService.selByArray(array1);
        for(int i=0;i<list2.size();i++){
            list2.get(i).setServicingproject(list1.get(i));
        }
        return  list2;
    }
}

