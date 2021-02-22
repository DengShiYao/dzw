package com.accp.controller;


import com.accp.domain.Pq;
import com.accp.service.impl.PqServiceImpl;
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
@RequestMapping("/pq")
public class PqController {
    @Autowired
    PqServiceImpl pqService;
    @GetMapping
    public List<Pq> selAll(){
        return  pqService.list();
    }
    @PostMapping
    public boolean addPQ(@RequestBody Pq pq){
        return pqService.save(pq);
    }
    @PutMapping
    public boolean updatePQ(@RequestBody Pq pq){
        return  pqService.updateById(pq);
    }
    @DeleteMapping("/remove/{PQId}")
    public boolean removePQ(@PathVariable Integer PQId){
        return pqService.removeById(PQId);
    }
    @PutMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody List<Pq> pqList){
        return  pqService.saveOrUpdateBatch(pqList);
    }
}

