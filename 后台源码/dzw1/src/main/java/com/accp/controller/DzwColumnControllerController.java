package com.accp.controller;


import com.accp.domain.DzwColumnController;
import com.accp.domain.SysUser;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.DzwColumnControllerServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *  显示字段
 * @author dsy
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/dzwColumnController")
public class DzwColumnControllerController {

    @Autowired
    DzwColumnControllerServiceImpl service;

    /**
     * 查询表 —— suppliers_region 显示字段
     * @param session
     * @return
     */
    @GetMapping("/showColumn")
    public ResultVO toFind(HttpSession session){
        session.setAttribute("user",new SysUser().setUserId(1));
        SysUser user = (SysUser)session.getAttribute("user");
        if (user == null){ return new ResultVO(ResultCode.USER_NOT_LOGIN);}
        List<DzwColumnController> suppliersColumnList = service.list(new QueryWrapper<DzwColumnController>().lambda()
                .eq(DzwColumnController::getTableName, "suppliers_region")
                .eq(DzwColumnController::getUserId, user.getUserId()));
        return new ResultVO(ResultCode.SUCCESS,suppliersColumnList);
    }


    /**
     * 修改列显示信息
     * @param list
     * @return
     */
    @PostMapping("/upd")
    public ResultVO updShowTableColumn(@RequestBody List<DzwColumnController> list){
        service.updateBatchById(list);
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 查询表 —— goods 显示字段
     * @param session
     * @return
     */
    @GetMapping("/showcolumngoods")
    public ResultVO toFindGoods(HttpSession session){
        SysUser user = (SysUser)session.getAttribute("user");
        if (user == null){ return new ResultVO(ResultCode.USER_NOT_LOGIN);}
        List<DzwColumnController> goodsColumnList = service.list(new QueryWrapper<DzwColumnController>().lambda()
                .eq(DzwColumnController::getTableName, "goods")
                .eq(DzwColumnController::getUserId, user.getUserId()));
        return new ResultVO(ResultCode.SUCCESS,goodsColumnList);
    }
}

