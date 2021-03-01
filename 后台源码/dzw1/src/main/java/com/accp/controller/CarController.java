package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.*;
import com.accp.service.impl.SuppliersRegionServiceImpl;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    ICarService zz;
    @Autowired
    ICarTypeService ss;
    @Autowired
    IVehicleOwnershipService dd;
    @Autowired
    IQbxgsService bb;
    @Autowired
    ISybxgsService aa;
    @Autowired
    IConsumerService cc;
    @Autowired
    IEngineBrandService  ll;
    @Autowired
    SuppliersRegionServiceImpl service;
    @Autowired
    ILinliaoBiaoService service2;
    //查询车辆
    @RequestMapping("/selectPage")
    @ResponseBody
    public List<Car> select(String  car){
        System.out.println("查询数据"+car);
        QueryWrapper<Car> query = new QueryWrapper<>();
        query.lambda().like(Car::getCarCph, car);
        List<Car> list = zz.list(query);
        return list;
    }
    //新增车辆
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody Car user){
        System.out.println(user);
        return zz.save(user);
    }
    //修改车辆
    @RequestMapping("/update")
    @ResponseBody
    public boolean updata(@RequestBody Car user){
        System.out.println(user);
        return zz.updateById(user);
    }
    //删除车辆
    @RequestMapping("delect")
    @ResponseBody
    public boolean delect(int id){
        System.out.println(id);
        return zz.removeById(id);
    }

    //查询车型表
    @RequestMapping("SelectCx")
    public List<CarType> selectCx(){
        QueryWrapper<CarType> query =  new QueryWrapper<>();
        List<CarType> list = ss.list(query);
        return list;
    }

    //查询车辆归属
    @RequestMapping("SelectCxGs")
    public List<VehicleOwnership> selectCxGs(){
        QueryWrapper<VehicleOwnership> query =  new QueryWrapper<>();
        List<VehicleOwnership> list = dd.list(query);
        return list;
    }
    //查询强险公司
    @RequestMapping("SelectQxgs")
    public List<Qbxgs> SelectQxgs(){
        QueryWrapper<Qbxgs> query =  new QueryWrapper<>();
        List<Qbxgs> list =bb.list(query);
        return list;
    }
    //查询商业险公司
    @RequestMapping("Selectsyxgs")
    public List<Sybxgs> Selectsyxgs(){
        QueryWrapper<Sybxgs> query =  new QueryWrapper<>();
        List<Sybxgs> list =aa.list(query);
        return list;
    }
    //查询所有客户
    @RequestMapping("SelectKh")
    public List<Consumer> SelectKh(){
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        List<Consumer> list =cc.list(query);
        return list;
    }

    //根据车辆id查询客户
    @RequestMapping("SelectKhID")
    public List<Consumer> SelectKhID(int id){
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        query.lambda().like(Consumer::getId,id);
        List<Consumer> list =cc.list(query);
        return list;
    }
    //根据客户id查询车辆
    @RequestMapping("SelectClID")
    public List<Car> SelectClID(int id){
        QueryWrapper<Car> query =  new QueryWrapper<>();
        query.lambda().like(Car::getColumn3,id);
        List<Car> list =zz.list(query);
        return list;
    }
    //今日提醒：engine_brand查询EngineBrand
    @RequestMapping("Selectbrand")
    public List<EngineBrand> Selectbrand(){
        List<EngineBrand> list =ll.list();
        return list;
    }
    //今日提醒：suppliers_region查询SuppliersRegion  service
    @RequestMapping("Selectregion")
    public List<SuppliersRegion> Selectregion(){
        List<SuppliersRegion> list =service.list();
        return list;
    }

    //今日提醒：linliao_biao查询
    @RequestMapping("SelectLinliaoBiao")
    public List<LinliaoBiao> SelectLinliaoBiao(){
        List<LinliaoBiao> list =service2.list();
        return list;
    }
}

