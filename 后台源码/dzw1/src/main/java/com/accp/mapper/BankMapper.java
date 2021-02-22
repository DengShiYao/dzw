package com.accp.mapper;

import com.accp.domain.Bank;
import com.accp.service.impl.BankServiceImpl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface BankMapper extends BaseMapper<Bank> {
        public  Bank selById(Integer bankId);
}
