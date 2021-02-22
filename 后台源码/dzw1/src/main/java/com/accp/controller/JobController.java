package com.accp.controller;


import com.accp.domain.Job;
import com.accp.service.IJobService;
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
@RequestMapping("/job")
public class JobController {
    @Autowired
    IJobService jobService;
    @PostMapping
    public boolean addJob(@RequestBody Job job){
        return jobService.save(job);
    }
    @GetMapping
    public List<Job> selAll(){
        return  jobService.list();
    }
    @PutMapping
    public  boolean updateJob(@RequestBody Job job){
        return  jobService.updateById(job);
    }
    @DeleteMapping("/remove/{jobId}")
    public boolean removeJob(@PathVariable  String jobId){
        return jobService.removeById(jobId);
    }
    @GetMapping("/count")
    public int getCount(){
       return jobService.count();
    }
}

