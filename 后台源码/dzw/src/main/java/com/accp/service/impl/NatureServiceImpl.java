package com.accp.service.impl;

import com.accp.domain.Nature;
import com.accp.mapper.NatureMapper;
import com.accp.service.INatureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-01-31
 */
@Service
public class NatureServiceImpl extends ServiceImpl<NatureMapper, Nature> implements INatureService {

}
