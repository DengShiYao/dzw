package com.accp.controller;


import com.accp.domain.Staffpostition;
import com.accp.service.impl.StaffpostitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-24
 */
@RestController
@RequestMapping("/staffpostition")
public class StaffpostitionController {

    @Autowired
    StaffpostitionServiceImpl staffpostitionService;

    /**
     * 根据员工id查询职务
     * @param eId
     * @return
     */
    @GetMapping("/selByEid/{eId}")
    public List<Staffpostition> selByEid(@PathVariable String eId){
        return  staffpostitionService.selByEid(eId);
    }

    /**
     * 员工职务变更
     * @param eId
     * @param list
     * @return
     */
    @PutMapping("/updateStaffPostition/{eId}")
    public boolean updateStaffPostition(@PathVariable  String eId,@RequestBody List<Integer> list){
        return staffpostitionService.updateEidPidBeatch(eId,list);
    }
}

