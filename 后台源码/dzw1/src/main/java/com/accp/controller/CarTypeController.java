package com.accp.controller;


import com.accp.domain.CarIcon;
import com.accp.domain.CarType;
import com.accp.domain.Serve;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.CarIconServiceImpl;
import com.accp.service.impl.CarTypeServiceImpl;
import com.accp.service.impl.ServeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.Valid;
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
    @Autowired
    ServeServiceImpl serveService;


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


    /**
     * 新增
     * @param file
     * @param carType
     * @return
     */
    @PostMapping("/upload")
    public ResultVO addCarTypeUpload(MultipartFile file, @Valid  CarType carType){
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

    /**
     * 修改车型
     * @param file
     * @param carType
     * @return
     */
    @PostMapping("/upd")
    public ResultVO updCarTypeUpload(MultipartFile file, @Valid  CarType carType){
        //先判断此id的合法性
        if (carType.getBeforeId()==null || carType.getBeforeId()=="" ) {
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        //如果相等代表id无变化 否则去数据库中查找有无此id存在
        if (!carType.getBeforeId().equals(carType.getCarId())){
            //查询有无此编号存在
            CarType one = carTypeService.getOne(new QueryWrapper<CarType>().lambda().eq(CarType::getCarId, carType.getCarId()));
            //nul 代表没有此编号纯在 可以进行修改
            return one==null ? carIdNotEq(file,carType) : new ResultVO(ResultCode.PEY_EXIT);
        }else {
            //编号未修改
            return carIdEq(file,carType);
        }
    }

    /**
     * 如果id没有修改
     * @param file
     * @param carType
     * @return
     */
    public ResultVO carIdEq(MultipartFile file, CarType carType){
        if (file != null) {
            String uuid = UUID.randomUUID().toString();
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            File f = new File(fileUpload+uuid+suffix);
            try {
                file.transferTo(f);
                //先删除图片表此条记录 然后修改类型iD后新增图片
                iconService.remove(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId,carType.getBeforeId()));
                //修改
                carTypeService.updateByKey(carType);
                //修改维修服务内信息
                Serve serve = new Serve().setBrandId(carType.getCarId()).setColumn1(carType.getCarName());
                serveService.update(serve,new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,carType.getCarId()).eq(Serve::getColumn2,"1"));
                boolean insert = new CarIcon().setCarId(carType.getCarId()).setIcName(uuid + suffix).insert();
                if (insert){
                    return new ResultVO(ResultCode.SUCCESS);
                }
                return new ResultVO(ResultCode.Failure);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                return new ResultVO(ResultCode.File_UPLOAD_ERROR);
            }
        }else {
            //如果没有上传图片,并且主键没有被修改
            carTypeService.update(carType,new QueryWrapper<CarType>().lambda().eq(CarType::getCarId,carType.getCarId()));
            //修改维修服务内信息
            Serve serve = new Serve().setBrandId(carType.getCarId()).setColumn1(carType.getCarName());
            serveService.update(serve,new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,carType.getCarId()).eq(Serve::getColumn2,"1"));
            return new ResultVO(ResultCode.SUCCESS);
        }
    }

    /**
     * 如果id变化 修改
     * @param file
     * @param carType
     * @return
     */
    public ResultVO carIdNotEq(MultipartFile file, CarType carType){
        //如果有上传文件
        if (file != null) {
            String uuid = UUID.randomUUID().toString();
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            File f = new File(fileUpload+uuid+suffix);
            try {
                file.transferTo(f);
                //先删除图片表此条记录 然后修改类型iD后新增图片
                iconService.remove(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId,carType.getBeforeId()));
                //修改
                carTypeService.updateByKey(carType);
                //修改维修服务内信息
                Serve serve = new Serve().setBrandId(carType.getCarId()).setColumn1(carType.getCarName());
                serveService.update(serve,new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,carType.getBeforeId()).eq(Serve::getColumn2,"1"));
                boolean insert = new CarIcon().setCarId(carType.getCarId()).setIcName(uuid + suffix).insert();
                if (insert){
                    return new ResultVO(ResultCode.SUCCESS);
                }
                return new ResultVO(ResultCode.Failure);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                return new ResultVO(ResultCode.File_UPLOAD_ERROR);
            }
        }else {
            //先查询图片
            CarIcon one1 = iconService.getOne(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId, carType.getBeforeId()));
            //如果图片表有这条数据先删除
            if (one1 != null) {
                iconService.remove(new QueryWrapper<CarIcon>().lambda().eq(CarIcon::getCarId,carType.getBeforeId()));
            }
            carTypeService.updateByKey(carType);
            //修改维修服务内信息
            Serve serve = new Serve().setBrandId(carType.getCarId()).setColumn1(carType.getCarName());
            serveService.update(serve,new QueryWrapper<Serve>().lambda().eq(Serve::getBrandId,carType.getCarId()).eq(Serve::getColumn2,"1"));
            CarIcon icon = new CarIcon();
            icon.setCarId(carType.getCarId());
            icon.setIcName(one1.getIcName());
            System.out.println(icon);
            iconService.save(icon);
            return new ResultVO(ResultCode.SUCCESS);
        }
    }


    /**
     * 上传单张图片，先删除后新增
     * @param file
     * @param carIcon
     * @return
     */
    @PostMapping("/iconUpload")
    public ResultVO icoUpload(MultipartFile file,CarIcon carIcon){
        if (file!=null){
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
               return new ResultVO(ResultCode.SUCCESS,iconService.save(carIcon));
            } catch (IOException e) {
                e.printStackTrace();
                return new ResultVO(ResultCode.File_UPLOAD_ERROR);
            }
        }
        return new ResultVO(ResultCode.Failure);
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

