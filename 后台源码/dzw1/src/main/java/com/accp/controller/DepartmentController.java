package com.accp.controller;


import com.accp.domain.Department;
import com.accp.service.impl.DepartmentServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;
    @GetMapping("/findBySid/{sId}")
    /**
     * 根据不同门店有不同的部门
     */
    public List<Department> findListBySid(@PathVariable Integer sId){
        return departmentService.selBySid(sId);
    }
}

