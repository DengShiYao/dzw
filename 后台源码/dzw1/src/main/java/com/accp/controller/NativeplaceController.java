package com.accp.controller;


import com.accp.domain.Nativeplace;
import com.accp.service.impl.NativeplaceServiceImpl;
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
@RequestMapping("/nativeplace")
public class NativeplaceController {
    @Autowired
    NativeplaceServiceImpl nativeplaceService;
    @GetMapping
    public List<Nativeplace> selAll(){
        System.out.println("进入籍贯list");
        return  nativeplaceService.list();
    }
    @PostMapping
    public boolean addNativePlace(@RequestBody Nativeplace nativeplace){
        return  nativeplaceService.save(nativeplace);
    }
    @PutMapping
    public boolean updateNativePlace(@RequestBody Nativeplace nativeplace){
        return  nativeplaceService.updateById(nativeplace);
    }
    @DeleteMapping("/remove/{nplaceId}")
    public boolean removeNativePlace(Integer nplaceId){
        return  nativeplaceService.removeById(nplaceId);
    }
    @PutMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody List<Nativeplace> nativeplaceList){
        return  nativeplaceService.saveOrUpdateBatch(nativeplaceList);
    }
}

