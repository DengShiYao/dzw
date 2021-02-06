package com.accp.controller;


import com.accp.domain.CarIcon;
import com.accp.domain.CarType;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.CarIconServiceImpl;
import com.accp.service.impl.CarTypeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.awt.image.BufferedImage;
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
    @Autowired
    CarIconServiceImpl iconService;


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
    public ResultVO addCarTypeUpload(MultipartFile file, @Valid  CarType carType){
        System.out.println(carType);
        //先判断此id的合法性
        if (carType.getCarId()==null || carType.getCarId()=="" ) {
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        CarType one = carTypeService.getOne(new QueryWrapper<CarType>().lambda().eq(CarType::getCarId, carType.getCarId()));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }else {
            //如果没有上传文件
            if (file != null) {
                String uuid = UUID.randomUUID().toString();
                String fileName = file.getOriginalFilename();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                File f = new File(fileUpload+uuid+suffix);
                try {
                    file.transferTo(f);
                    boolean save = carTypeService.save(carType);
                    if (save){
                        boolean insert = new CarIcon().setCarId(carType.getCarId()).setIcName(uuid + suffix).insert();
                        if (insert){
                            return new ResultVO(ResultCode.SUCCESS);
                        }
                    }
                    return new ResultVO(ResultCode.Failure);
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                    return new ResultVO(ResultCode.File_UPLOAD_ERROR);
                }
            }else {
                return new ResultVO(ResultCode.SUCCESS,carTypeService.save(carType));
            }
        }
    }


    @PostMapping("/upd")
    public Object updCarTypeUpload(){
        return null;
    }

    /**
     * 上传单张图片，先删除后新增
     * @param file
     * @param carIcon
     * @return
     */
    @PostMapping("/iconUpload")
    public ResultVO icoUpload(@Validated @NotEmpty(message = "上传文件失败") MultipartFile file, @Valid @RequestBody CarIcon carIcon){
        //判断文件类型
        this.checkedIcon(file);
        String uuid = UUID.randomUUID().toString();
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        File f = new File(fileUpload+uuid+suffix);
        try {
            file.transferTo(f);
            carIcon.setIcName(uuid+suffix);
            //上传图片时先删除清空
            iconService.remove(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId,carIcon.getCarId()));
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultVO(ResultCode.File_UPLOAD_ERROR);
        }
        return new ResultVO(ResultCode.SUCCESS,iconService.save(carIcon));
    }

    /**
     * 删除车型
     * @param carId
     * @return
     */
    @PostMapping("/remove")
    public ResultVO remove(String carId){
        if (carId == null || carId=="") {
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        //先删除图片
        iconService.remove(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId,carId));
        carTypeService.remove(new QueryWrapper<CarType>().lambda().eq(CarType::getCarId,carId));
        return new ResultVO();
    }


    /**
     * 查询匹配编号和名称
     * @param search
     * @return
     */
    @PostMapping("/search")
    public ResultVO toSearch(String search,String carId){
        QueryWrapper<CarType> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CarType::getBrandName,carId);
        queryWrapper.and(w->w.lambda().like(CarType::getCarId,search).or().like(CarType::getCarName,search));
        return new ResultVO(carTypeService.list(queryWrapper));
    }


    /**
     * 判断文件类型与大小
     * @param file
     * @return
     */
    private ResultVO checkedIcon(MultipartFile file){
        if ( file.getSize() > (1024 * 1024 * 5)){
            return new ResultVO(ResultCode.File_SIZE_ERROR);
        }
        try {
            BufferedImage read = ImageIO.read(file.getInputStream());
            if (read==null){
                return new ResultVO(ResultCode.File_TYPE_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultVO();
    }
}

