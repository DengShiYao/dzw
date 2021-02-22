package com.accp.controller;


import com.accp.domain.Store;
import com.accp.service.impl.StoreServiceImpl;
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
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreServiceImpl storeService;
    @GetMapping
    /**
     * 查询所有
     */
    public List<Store> selAll(){
        return storeService.list();
    }
    @GetMapping("/selMyself")
    /**
     * 自查
     */
    public List<Store> selMySelf(){
        return storeService.selBySelf(0);
    }
    @GetMapping("/selById/{mId}")
    /**
     * 根据id查询
     */
    public Store selById(@PathVariable Integer mId){
        return storeService.selById(mId);
    }
    @PostMapping
    /**
     * 新增门店
     */
    public boolean addStore(@RequestBody Store store){
        return storeService.save(store);
    }
    @PutMapping
    /**
     * 修改门店
     */
    public  boolean updateStore(@RequestBody Store store){
        return  storeService.updateById(store);
    }
    @DeleteMapping("/remove/{mId}")
    /**
     * 删除门店
     */
    public boolean removeStore(@PathVariable Integer mId){
        return  storeService.removeById(mId);
    }

    @GetMapping("/selStoreFuzzy/{parse}")
    /**
     * 模糊查询门店
     */
    public List<Store> selStoreFuzzy(@PathVariable String parse){
        return  storeService.selStoreFuzzy(parse);
    }
}

