package com.accp.controller;


import com.accp.domain.CoinSpray;
import com.accp.domain.Serve;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.CoinSprayServiceImpl;
import com.accp.service.impl.ServeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *  钣喷
 * @author dsy
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/coinSpray")
public class CoinSprayController {

    /**
     * 钣喷
     */
    @Autowired
    CoinSprayServiceImpl service;
    /**
     * 维修项目
     */
    ServeServiceImpl serveService;

    /**
     * 增加钣喷分类
     * @param coinSpray
     * @return
     */
    @PostMapping("/ins")
    public ResultVO saveInsCoinSpray(@RequestBody  CoinSpray coinSpray){
        if (coinSpray.getCoinName() == null || coinSpray.getCoinName() == "" || coinSpray.getCoinId()==null || coinSpray.getCoinId()=="") {
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        CoinSpray one = service.getOne(new QueryWrapper<CoinSpray>().lambda()
                .eq(CoinSpray::getCoinId, coinSpray.getCoinId()));
        if (one!=null){
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        return new ResultVO(ResultCode.SUCCESS,service.save(coinSpray));
    }

    /**
     * 修改钣喷分类
     * @param coinSpray
     * @return
     */
    @PostMapping("/upd")
    public ResultVO saveUpdCoinSpray(@RequestBody  CoinSpray coinSpray){
        if (coinSpray.getCoinName() == null || coinSpray.getCoinName() == "" || coinSpray.getCoinId()==null || coinSpray.getCoinId()=="") {
            return new ResultVO(ResultCode.VALIDATE_FAILED);
        }
        if (!coinSpray.getBeforeId().equals(coinSpray.getCoinId())){
            CoinSpray one = service.getOne(new QueryWrapper<CoinSpray>().lambda()
                    .eq(CoinSpray::getCoinId, coinSpray.getCoinId()));
            if (one!=null){
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        new Serve().setBrandId(coinSpray.getCoinId()).update(
                new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,coinSpray.getBeforeId()));
        service.update(coinSpray,new QueryWrapper<CoinSpray>().lambda()
                .eq(CoinSpray::getCoinId,coinSpray.getBeforeId()));
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 删除分类
     * @param coinId
     * @return
     */
    @PostMapping("/del")
    public ResultVO delCoinSpray(String coinId){
        serveService.remove(new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,coinId));
        return new ResultVO(ResultCode.SUCCESS,service.remove(new QueryWrapper<CoinSpray>().lambda()
                .eq(CoinSpray::getCoinId, coinId)));
    }
}

