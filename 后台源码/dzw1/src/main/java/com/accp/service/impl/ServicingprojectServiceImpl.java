package com.accp.service.impl;

import com.accp.domain.Servicingproject;
import com.accp.mapper.ServicingprojectMapper;
import com.accp.service.IServicingprojectService;
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
public class ServicingprojectServiceImpl extends ServiceImpl<ServicingprojectMapper, Servicingproject> implements IServicingprojectService {

    @Autowired
    ServicingprojectMapper servicingprojectMapper;

    @Override
    public List<Servicingproject> selByArray(String[] array) {
        return servicingprojectMapper.selByArray(array);
    }
}
