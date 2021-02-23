package com.accp.controller;


import com.accp.domain.Major;
import com.accp.service.impl.MajorServiceImpl;
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
@RequestMapping("/major")
public class MajorController {
    @Autowired
    MajorServiceImpl majorService;
    @GetMapping
    public List<Major> selAll(){
        return majorService.list();
    }
    @PostMapping
    public boolean addMajor(@RequestBody Major major){
        return  majorService.save(major);
    }
    @PutMapping
    public  boolean updateMajor(@RequestBody Major major){
        return  majorService.updateById(major);
    }
    @DeleteMapping("/remove/{majorId}")
    public boolean removeMajor(@PathVariable Integer majorId){
        return  majorService.removeById(majorId);
    }
    @PutMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody List<Major> majorList){
        return  majorService.saveOrUpdateBatch(majorList);
    }
}

