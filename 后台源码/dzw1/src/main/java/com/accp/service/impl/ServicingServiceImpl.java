package com.accp.service.impl;

import com.accp.domain.Servicing;
import com.accp.mapper.ServicingMapper;
import com.accp.service.IServicingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.text.DecimalFormat;
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
    @Override
    public String getServicingId(String servicingId) {
        String prefix = servicingId.substring(0,13);
        String suffix = servicingId.substring(13);
        double parseCode = Double.parseDouble(suffix) + 1;
        DecimalFormat df = new DecimalFormat("000");
        String code = prefix.concat(df.format(parseCode));
        return code;
    }
}
