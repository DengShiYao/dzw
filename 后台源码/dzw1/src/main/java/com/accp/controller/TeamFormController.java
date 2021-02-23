package com.accp.controller;


import com.accp.domain.FieldVehicles;
import com.accp.domain.TeamForm;
import com.accp.service.IFieldVehiclesService;
import com.accp.service.ITeamFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/teamForm")
public class TeamFormController {
    @Autowired
    ITeamFormService service;

    @Autowired
    IFieldVehiclesService fService;


    @RequestMapping("/bzFind")
    @ResponseBody
    public List<TeamForm> bzFind(){
        return service.list();
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<FieldVehicles> find(){
        return fService.list();
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public boolean saveOrUpdate(FieldVehicles venic){
        return fService.saveOrUpdate(venic);
    }

    @RequestMapping("/remove/{id}")
    public boolean remove(@PathVariable("id") Integer id){
        return fService.removeById(id);
    }
}

