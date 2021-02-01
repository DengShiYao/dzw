package com.accp.service.impl;

import com.accp.domain.Employees;
import com.accp.mapper.EmployeesMapper;
import com.accp.service.IEmployeesService;
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
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements IEmployeesService {

}
