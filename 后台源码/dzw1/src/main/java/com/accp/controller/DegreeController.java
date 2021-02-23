package com.accp.controller;


import com.accp.domain.Degree;
import com.accp.service.impl.DegreeServiceImpl;
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
@RequestMapping("/degree")
public class DegreeController {
    @Autowired
    DegreeServiceImpl degreeService;
    @GetMapping
    public List<Degree> selAll(){
        return  degreeService.list();
    }
    @PostMapping
    public boolean addDegree(@RequestBody Degree degree){
        return  degreeService.save(degree);
    }
    @PutMapping
    public boolean updateDegree(@RequestBody Degree degree){
        return degreeService.updateById(degree);
    }
    @DeleteMapping("/remove/{degreeId}")
    public boolean removeDegree(@PathVariable Integer degreeId){
        return degreeService.removeById(degreeId);
    }
    @PutMapping("/saveOrUpdate")
    public  boolean saveOrUpdate(@RequestBody List<Degree> degreeList){
        return  degreeService.saveOrUpdateBatch(degreeList);
    }
}

