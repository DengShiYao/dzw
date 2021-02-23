package com.accp.service;

import com.accp.domain.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface IDepartmentService extends IService<Department> {
    public List<Department> selBySid(Integer sId);
}
