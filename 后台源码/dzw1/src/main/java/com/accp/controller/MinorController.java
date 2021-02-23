package com.accp.controller;


import com.accp.domain.Minor;
import com.accp.domain.Serve;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.MinorServiceImpl;
import com.accp.service.impl.ServeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *  修理
 * @author dsy
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/minor")
public class MinorController {
    /**
     * 小修
     */
    @Autowired
    MinorServiceImpl service;

    /**
     * 维修服务
     */
    @Autowired
    ServeServiceImpl serveService;

    /**
     * 新增小修
     * @param minor
     * @return
     */
    @PostMapping("/ins")
    public ResultVO saveInsMinor(@RequestBody Minor minor){
        if (minor.getMinorId()=="" || minor.getMinorName()==""){
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        Minor one = service.getOne(new QueryWrapper<Minor>().lambda().eq(Minor::getMinorId, minor.getMinorId()));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        return new ResultVO(ResultCode.SUCCESS,service.save(minor));
    }

    /**
     * 修改小修
     * @param minor
     * @return
     */
    @PostMapping("/upd")
    public ResultVO saveUpdMinor(@RequestBody Minor minor){
        if (minor.getMinorId()=="" || minor.getMinorName()==""){
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        if (!minor.getBeforeId().equals(minor.getMinorId())){
            Minor one = service.getOne(new QueryWrapper<Minor>().lambda().eq(Minor::getMinorId, minor.getMinorId()));
            if (one != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        new Serve().setBrandId(minor.getMinorId()).update(
                new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,minor.getBeforeId()));
        service.update(minor,new QueryWrapper<Minor>().lambda()
                .eq(Minor::getMinorId,minor.getBeforeId()));
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * remove minor
     * @param minorId
     * @return
     */
    @PostMapping("/del/{minorId}")
    public ResultVO delMinor(@PathVariable  String minorId){
        serveService.remove(new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,minorId));
        return new ResultVO(ResultCode.SUCCESS,service.remove(new QueryWrapper<Minor>().lambda()
                .eq(Minor::getMinorId, minorId)));
    }
}



