package com.accp.controller;


import com.accp.domain.EngineBrand;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.EngineBrandServiceImpl;
import com.accp.service.impl.ServeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *  发动机品牌
 * @author dsy
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/engineBrand")
public class EngineBrandController {
    @Autowired
    EngineBrandServiceImpl brandService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ServeServiceImpl serveService;



    /**
     * 查询发动机品牌
     * @return
     */
    @GetMapping
    public ResultVO engineFind(){
        return new ResultVO(ResultCode.SUCCESS, brandService.list());
    }

    /**
     * 查询总数据
     * @return
     */
    @GetMapping("/tocount")
    public ResultVO getEngineBrandCount(){
        return new ResultVO(ResultCode.SUCCESS, brandService.count());
    }

    /**
     * 编辑品牌，存在为修改反之为新增
     * @param json
     * @return
     */
    @PostMapping
    public ResultVO toInsert(String json) {
        System.out.println(json);
        try {
            EngineBrand engineBrand = objectMapper.readValue(json, EngineBrand.class);
            boolean b = brandService.saveOrUpdate(engineBrand);
//            Serve serve = new Serve().setBrandId(engineBrand.getEngineId()).setColumn1(engineBrand.getEngineName());
//            //修改维修项目
//            serve.update(new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,engineBrand.getEngineId()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResultVO(ResultCode.SUCCESS);
        }
        return new ResultVO(ResultCode.SUCCESS);
    }

    @PostMapping("/remove")
    public ResultVO toremove(Integer engineId){
        return new ResultVO(ResultCode.SUCCESS, brandService.removeById(engineId));
    }

}

