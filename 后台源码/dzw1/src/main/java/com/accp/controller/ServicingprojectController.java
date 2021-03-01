package com.accp.controller;


import com.accp.domain.Acquisition;
import com.accp.domain.Cargoods;
import com.accp.domain.Servicing;
import com.accp.domain.Servicingproject;
import com.accp.service.impl.AcquisitionServiceImpl;
import com.accp.service.impl.CargoodsServiceImpl;
import com.accp.service.impl.ServicingServiceImpl;
import com.accp.service.impl.ServicingprojectServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/servicingproject")
public class ServicingprojectController {

    @Autowired
    ServicingprojectServiceImpl servicingprojectService;

    @Autowired
    ServicingServiceImpl servicingService;

    /**
     * 根据车牌查询维修项目
     * @param chepai
     * @return
     */
    @GetMapping("//selProjectByChepai/{chepai}")
    public  List<Servicingproject> selByChepai(@PathVariable String chepai){
        QueryWrapper<Servicing> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Servicing::getSerChepai,chepai);
        List<Servicing> list = servicingService.list(queryWrapper);
        String [] array = new String[list.size()];
        for(int i=0;i<array.length;i++){
            array[i]=list.get(i).getSerNumber();
        }
        List<Servicingproject> list1 =servicingprojectService.selByArray(array);
        return  list1;
    }
}

