package com.accp.mapper;

import com.accp.domain.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    public Department selById(String dId);
    public List<Department> selBySid(Integer sId);
}
