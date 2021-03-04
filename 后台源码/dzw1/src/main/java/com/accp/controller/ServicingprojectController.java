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
import org.springframework.web.bind.annotation.*;
import sun.security.smartcardio.SunPCSC;

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
    @GetMapping("/selProjectByChepai/{chepai}")
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

    /**
     *新增单个项目
     */
    @PostMapping("/addWxProject")
    public boolean  addWxProject(Servicingproject servicingproject){
         boolean a=servicingprojectService.save(servicingproject);
        return  a;
    }

    /**
     *新增多个维修项目
     */
    @PostMapping("/addProjectList")
    public boolean addProjectList(@RequestBody List<Servicingproject> list){
        boolean a= servicingprojectService.saveBatch(list);
        return  a;
    }

    @GetMapping("/selBySerNumber/{serNumber}")
    /**
     * 根据维修单号查询当前单号下的所有维修项目
     */
    public  List<Servicingproject> selBySerNumber(@PathVariable String serNumber){
        QueryWrapper<Servicingproject> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Servicingproject::getColumn1,serNumber);
        List<Servicingproject> list = servicingprojectService.list(queryWrapper);
        return  list;
    }

    /**
     * 计算当前维修单所有项目的金额
     * @param serNumber
     * @return
     */
    @GetMapping("/getPrice/{serNumber}")
    public Double selSumPrice(@PathVariable String serNumber){
        QueryWrapper<Servicingproject> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Servicingproject::getWxGdannumber,serNumber);
        List<Servicingproject> list = servicingprojectService.list(queryWrapper);
        Double price = 0.00;
        for(Servicingproject servicingproject:list){
            price+=servicingproject.getWxGsdanjia();
            price+=servicingproject.getWxJsjies();
        }
        return price;
    }

    /**
     * 根据id查询项目
     * @return
     */
    @GetMapping("/selById/{id}")
    public  Servicingproject selById(@PathVariable Integer id){
        return  servicingprojectService.getById(id);
    }

    /**
     * 修改项目
     * @return
     */
    @PostMapping("/updateServicingProject")
    public  boolean updateServicingProject(@RequestBody Servicingproject servicingproject){
        boolean a= servicingprojectService.updateById(servicingproject);
        return  a;
    }

    /**
     * 删除项目
     * @return
     */
    public boolean removeServicingProject(@PathVariable Integer id){
        return servicingprojectService.removeById(id);
    }
}

