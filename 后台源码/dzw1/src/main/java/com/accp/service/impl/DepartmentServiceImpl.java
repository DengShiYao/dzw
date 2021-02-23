package com.accp.service.impl;

import com.accp.domain.Department;
import com.accp.mapper.DepartmentMapper;
import com.accp.service.IDepartmentService;
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
 * @since 2021-02-01
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> selBySid(Integer sId) {
        return departmentMapper.selBySid(sId);
    }
}
