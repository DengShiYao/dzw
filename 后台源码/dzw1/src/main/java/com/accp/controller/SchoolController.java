package com.accp.controller;


import com.accp.domain.School;
import com.accp.service.impl.SchoolServiceImpl;
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
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    SchoolServiceImpl schoolService;
    @GetMapping
    public List<School> selAll(){
        return  schoolService.list();
    }
    @PostMapping
    public boolean addSchool(@RequestBody School school){
        return schoolService.save(school);
    }
    @PutMapping
    public boolean updateSchool(@RequestBody School school){
        return  schoolService.updateById(school);
    }
    @DeleteMapping("/remove/{schoolId}")
    public  boolean removeSchool(@PathVariable Integer schoolId){
        return schoolService.removeById(schoolId);
    }
    @PutMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody List<School> schoolList){
        return  schoolService.saveOrUpdateBatch(schoolList);
    }
}

