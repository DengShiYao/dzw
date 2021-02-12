package com.accp.controller;


import com.accp.domain.SuppliersRegion;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.SuppliersContactsServiceImpl;
import com.accp.service.impl.SuppliersRegionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *  供货商
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/suppliersRegion")
public class SuppliersRegionController {

    @Autowired
    SuppliersRegionServiceImpl service;
    /**
     * 联系人
     */
    @Autowired
    SuppliersContactsServiceImpl contactsService;

    /**
     * 查询厂商列表
     * @param regionId
     * @return
     */
    @GetMapping("/{regionId}")
    public ResultVO toFind(@PathVariable String regionId){
        List<SuppliersRegion> suppliersRegionCities = service.toFind(regionId);
        return new ResultVO(suppliersRegionCities);
    }

    /**
     * 新增供货商联系人
     * @param supplier
     * @return
     */
    @PostMapping("/ins")
    public ResultVO insSupplier (@Valid @RequestBody SuppliersRegion supplier){
        SuppliersRegion one = service.getOne(new QueryWrapper<SuppliersRegion>().lambda()
                .eq(SuppliersRegion::getProvCode, supplier.getProvCode()).last("LIMIT 1"));
        if (one!=null){return new ResultVO(ResultCode.PEY_EXIT); }
        System.out.println(supplier);
        boolean save = service.save(supplier);
        if (save) {
            supplier.getContacts().setColumn1(supplier.getSid().toString());
            if ((supplier.getContacts().getScName()!=null && !"".equals(supplier.getContacts().getScName()))
                    || (supplier.getContacts().getScTelephone()!=null && !"".equals(supplier.getContacts().getScTelephone()))
                    || (supplier.getContacts().getScPhone()!=null && !"".equals(supplier.getContacts().getScPhone()))){
                contactsService.save(supplier.getContacts());
            }
        }
        return new ResultVO();
    }

    /**
     * 修改供货商资料
     * @param supplier
     * @return
     */
    @PostMapping("/upd")
    public ResultVO updSupplier(@RequestBody SuppliersRegion supplier){
        System.out.println(supplier);
        boolean save = service.updateById(supplier);
        if (supplier.getContacts().getScId()!=null) {
            contactsService.updateById(supplier.getContacts());
        }
        return new ResultVO();
    }

    /**
     * 逻辑删除 供货商
     * @param sid
     * @return
     */
    @PostMapping("/del/{sid}")
    public ResultVO delSupplier(@PathVariable Integer sid){
        if (sid != null) {
            service.removeById(sid);
            return new ResultVO(ResultCode.SUCCESS);
        }
        return new ResultVO(ResultCode.ID_NOT_NULL);
    }

}

