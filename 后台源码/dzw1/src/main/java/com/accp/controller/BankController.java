package com.accp.controller;


import com.accp.domain.Bank;
import com.accp.service.impl.BankServiceImpl;
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
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankServiceImpl bankService;
    @GetMapping
    public List<Bank> selAll(){
        return bankService.list();
    }
    @PostMapping
    public boolean addBank(@RequestBody Bank bank){
        return  bankService.save(bank);
    }
    @PutMapping
    public  boolean updateBank(@RequestBody Bank bank){
        return bankService.updateById(bank);
    }
    @DeleteMapping("/remove/{bankId}")
    public boolean removeBank(@PathVariable Integer bankId){
        return bankService.removeById(bankId);
    }
    @PutMapping("/saveOrUpdate")
    public  boolean saveOrUpdate(@RequestBody List<Bank> bankList){
        return  bankService.saveOrUpdateBatch(bankList);
    }
}

