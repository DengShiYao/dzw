package com.accp.service.impl;

import com.accp.domain.Cargoods;
import com.accp.domain.Servicing;
import com.accp.mapper.CargoodsMapper;
import com.accp.mapper.ServicingMapper;
import com.accp.service.IServicingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
@Service
public class ServicingServiceImpl extends ServiceImpl<ServicingMapper, Servicing> implements IServicingService {

    @Autowired
    ServicingMapper servicingMapper;

    @Autowired
    CargoodsMapper cargoodsMapper;

    @Override
    public String getServicingId(String servicingId) {
        String prefix = servicingId.substring(0,13);
        String suffix = servicingId.substring(13);
        double parseCode = Double.parseDouble(suffix) + 1;
        DecimalFormat df = new DecimalFormat("000");
        String code = prefix.concat(df.format(parseCode));
        return code;
    }



    @Override
    public boolean serviceAdviser(Servicing servicing) {
        try {
            //新增servicing表
            int a= servicingMapper.insert(servicing);
            //新增cargoods表
            Cargoods cargoods =new Cargoods();
            cargoods.setCarNumber(servicing.getSerNumber());
            cargoods.setColumn1(servicing.getSerNumber());
            cargoods.setCarUsername(servicing.getSerDriver());
            cargoods.setCarPhone(servicing.getSerLianxiphone());
            cargoods.setCarChepai(servicing.getSerChepai());
            String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String timeStr1= LocalDateTime.now().minusDays(-3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            cargoods.setCarExpecttime(timeStr1);
            cargoods.setCarBegintime(timeStr);
            cargoods.setCarServicetype(servicing.getYwlx());
            cargoods.setCarDjtype(servicing.getDjlx());
            int a1= cargoodsMapper.insert(cargoods);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
}
