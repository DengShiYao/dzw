package com.accp.service.impl;

import com.accp.domain.PaymentMethod;
import com.accp.mapper.PaymentMethodMapper;
import com.accp.service.IPaymentMethodService;
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
public class PaymentMethodServiceImpl extends ServiceImpl<PaymentMethodMapper, PaymentMethod> implements IPaymentMethodService {

}
