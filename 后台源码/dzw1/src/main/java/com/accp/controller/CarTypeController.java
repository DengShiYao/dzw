package com.accp.controller;


import com.accp.domain.CarType;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.CarTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *  车型controller
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/carType")
public class CarTypeController {

    @Value("${file.upload.filepath}")
    String fileUpload;
    @Autowired
    CarTypeServiceImpl carTypeService;


    /**
     * 查询车型
     * @param carId
     * @return
     */
    @GetMapping("/{carId}")
    public ResultVO find(@PathVariable String carId){
        if (carId == null || carId=="") {
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        List<CarType> list = carTypeService.find(carId);
        return new ResultVO(ResultCode.SUCCESS,list);
    }

    @PostMapping("/upload")
    public String addCarTypeUpload(MultipartFile file, CarType carType){
        System.out.println(carType);
//        for (int i = 0; i < file.length; i++) {
            String uuid = UUID.randomUUID().toString();
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            File f = new File(fileUpload+uuid+suffix);
            try {
                file.transferTo(f);
//                System.out.println(carType);
                System.out.println("啦啦啦啦啦");
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                System.out.println("失败");
                e.printStackTrace();
            }
//        }
        return null;
    }
}

