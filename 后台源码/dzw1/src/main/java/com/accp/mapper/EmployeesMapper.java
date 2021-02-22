package com.accp.mapper;

import com.accp.domain.Employees;

import com.accp.domain.EmployeesQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface EmployeesMapper extends BaseMapper<Employees> {
    /**
     * 查询所有员工
     * @return
     */
    public List<Employees> selInfo();

    /**
     * 多条件查询员工
     * @param employeesQuery
     * @return
     */
    public List<Employees> selByManyConditions(EmployeesQuery employeesQuery);

    /**
     * 匹配手机/工号/姓名
     * @param parse
     * @return
     */
    public List<Employees> selByParse(String parse);

    /**
     * 置空员工密码
     * @param eId
     * @return
     */
    public int clearEmployeePwd(String eId);

    /**
     * 根据门店查询员工
     * @param mId
     * @return
     */
    public List<Employees> selByMid(Integer mId);

    /**
     * 根据门店和部门共同查询员工
     * @param employees
     * @return
     */
    public List<Employees> selEmployByMidAndDid(Employees employees);

    /**
     * 员工离职登记
     * @param eId
     * @return
     */
    public  int madeFire(String eId);

    /**
     * 员工离职回滚
     * @param eId
     * @return
     */
    public int madeAssume(String eId);
}
