package com.accp.controller;


import com.accp.domain.MechanicsstarLevel;
import com.accp.service.IMechanicsstarLevelService;
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
@RequestMapping("/mechanicsstarLevel")
public class MechanicsstarLevelController {
    @Autowired
    IMechanicsstarLevelService service;

    /**
     * 查询所有
     */
    @RequestMapping("/toFind")
    @ResponseBody
    public List<MechanicsstarLevel> toFind(){
        return service.list();
    }

    /**
     * 更新或保存
     */
    @RequestMapping("/update")
    @ResponseBody
    public boolean updateOrSave(@RequestBody MechanicsstarLevel mechan){
        return service.saveOrUpdate(mechan);
    }

    /**
     * 删除
     */
    @RequestMapping("/remove/{id}")
    public boolean remove(@PathVariable("id") Integer id){
        return service.removeById(id);
    }

    /**
     * 根据星级id车技工星级
     */
    @RequestMapping("/chajgId")
    @ResponseBody
    public MechanicsstarLevel chajgId(Integer id){
        return service.getById(id);
    }


}

