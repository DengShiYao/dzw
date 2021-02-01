package com.accp.service.impl;

import com.accp.domain.Departure;
import com.accp.mapper.DepartureMapper;
import com.accp.service.IDepartureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@Service
public class DepartureServiceImpl extends ServiceImpl<DepartureMapper, Departure> implements IDepartureService {

}
