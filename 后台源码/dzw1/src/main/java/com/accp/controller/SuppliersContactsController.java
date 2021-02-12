package com.accp.controller;


import com.accp.domain.SuppliersContacts;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.SuppliersContactsServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *  供货商联系人
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/suppliersContacts")
public class SuppliersContactsController {

    @Autowired
    SuppliersContactsServiceImpl service;

    /**
     * 查询联系人列表
     * @param sid
     * @return
     */
    @GetMapping("/{sid}")
    public ResultVO findRelation(@PathVariable String sid){
        List<SuppliersContacts> list = service.list(new QueryWrapper<SuppliersContacts>().lambda().eq(SuppliersContacts::getColumn1, sid));
        return new ResultVO(list);
    }

    /**
     * 编辑联系人
     * @param contacts
     * @return
     */
    @PostMapping("/save")
    public ResultVO saveContacts(@Valid @RequestBody SuppliersContacts contacts){
       return new ResultVO(service.saveOrUpdate(contacts));
    }

    /**
     * 删除联系人
     * @param scId
     * @return
     */
    @PostMapping("/del/{scId}")
    public ResultVO delContacts(@PathVariable Integer scId){
        if (scId == null) {
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        return new ResultVO(service.removeById(scId));
    }

}

