package com.accp.controller;


import com.accp.domain.National;
import com.accp.service.impl.NationalServiceImpl;
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
@RequestMapping("/national")
public class NationalController {
    @Autowired
    NationalServiceImpl nationalService;
    @GetMapping
    public List<National> selAll(){
        return nationalService.list();
    }
    @PostMapping
    public boolean addNational(@RequestBody National national){
        return nationalService.save(national);
    }
    @PutMapping
    public boolean updateNational(@RequestBody National national){
        return  nationalService.updateById(national);
    }
    @DeleteMapping("/remove/{nationalId}")
    public boolean removeNational(@PathVariable Integer nationalId){
        return  nationalService.removeById(nationalId);
    }

    /**
     * 对民族进行保存
     * @param nationalList
     * @return
     */
    @PutMapping("/saveOrUpdate")
    public boolean saveOrUPdate(@RequestBody List<National> nationalList){
        return  nationalService.saveOrUpdateBatch(nationalList);
    }
}

