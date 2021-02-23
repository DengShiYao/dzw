package com.accp.controller;


import com.accp.domain.Education;
import com.accp.service.impl.EducationServiceImpl;
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
@RequestMapping("/education")
public class EducationController {
    @Autowired
    EducationServiceImpl educationService;
    @GetMapping
    public List<Education> selAll(){
        return educationService.list();
    }
    @PostMapping
    public boolean addEducation(@RequestBody Education education){
        return  educationService.save(education);
    }
    @PutMapping
    public boolean updateEducation(@RequestBody Education education){
        return  educationService.updateById(education);
    }
    @DeleteMapping("/remove/{educationId}")
    public boolean removeEducation(@PathVariable Integer educationId){
        return  educationService.removeById(educationId);
    }
    @PutMapping("/saveOrUpdate")
    public  boolean saveOrUpdate(@RequestBody List<Education> educationList){
        return  educationService.saveOrUpdateBatch(educationList);
    }
}

