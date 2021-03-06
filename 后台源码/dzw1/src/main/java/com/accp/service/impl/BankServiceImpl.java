package com.accp.service.impl;

import com.accp.domain.Bank;
import com.accp.mapper.BankMapper;
import com.accp.service.IBankService;
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
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements IBankService {

}
