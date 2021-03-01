package com.accp.service.impl;

import com.accp.domain.Acquisition;
import com.accp.mapper.AcquisitionMapper;
import com.accp.service.IAcquisitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
@Service
public class AcquisitionServiceImpl extends ServiceImpl<AcquisitionMapper, Acquisition> implements IAcquisitionService {

    @Autowired
    AcquisitionMapper acquisitionMapper;

    @Override
    public List<Acquisition> selByArray(Integer[] array) {
        return acquisitionMapper.selByArray(array);
    }
}
