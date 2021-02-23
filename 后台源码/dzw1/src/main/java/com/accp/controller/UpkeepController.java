package com.accp.controller;


import com.accp.domain.Serve;
import com.accp.domain.Upkeep;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.ServeServiceImpl;
import com.accp.service.impl.UpkeepServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *  保养
 * @author dsy
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/upkeep")
public class UpkeepController {

    /**
     * 保养
     */
    @Autowired
    UpkeepServiceImpl service;
    /**
     * 维修项目
     */
    ServeServiceImpl serveService;

    /**
     * 新增保养项目
     * @param upkeep
     * @return
     */
    @PostMapping("/ins")
    public ResultVO saveInsUpkeep(@RequestBody Upkeep upkeep){
        if (upkeep.getUpkeepId()=="" || upkeep.getUpkeepName()==""){
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        Upkeep one = service.getOne(new QueryWrapper<Upkeep>().lambda().eq(Upkeep::getUpkeepId, upkeep.getUpkeepId()));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        return new ResultVO(ResultCode.SUCCESS,service.save(upkeep));
    }

    /**
     * 修改保养项目
     * @param upkeep
     * @return
     */
    @PostMapping("/upd")
    public ResultVO saveUpdUpkeep(@RequestBody Upkeep upkeep){
        if (upkeep.getUpkeepId()=="" || upkeep.getUpkeepName()==""){
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        if (!upkeep.getBeforeId().equals(upkeep.getUpkeepId())){
            Upkeep one = service.getOne(new QueryWrapper<Upkeep>().lambda().eq(Upkeep::getUpkeepId, upkeep.getUpkeepId()));
            if (one != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        new Serve().setBrandId(upkeep.getUpkeepId()).update(
                new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,upkeep.getBeforeId()));
        service.update(upkeep,new QueryWrapper<Upkeep>().lambda()
                .eq(Upkeep::getUpkeepId,upkeep.getBeforeId()));
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 删除
     * @param upkeepId
     * @return
     */
    @PostMapping("/del/{upkeepId}")
    public ResultVO delUpkepp(@PathVariable String upkeepId){
        serveService.remove(
                new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,upkeepId));
        return new ResultVO(ResultCode.SUCCESS,service.remove(new QueryWrapper<Upkeep>().lambda()
                .eq(Upkeep::getUpkeepId, upkeepId)));
    }
}

