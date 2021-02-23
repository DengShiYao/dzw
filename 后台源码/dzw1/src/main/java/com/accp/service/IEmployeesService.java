package com.accp.service;

import com.accp.domain.Employees;
import com.accp.domain.EmployeesQuery;
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
public interface IEmployeesService extends IService<Employees> {
    /**
     * 查询全部员工
     * @return
     */
    public List<Employees> selInfo();
    /**
     * 匹配手机/工号/姓名
     * @param parse
     * @return
     */
    public List<Employees> selByParse(String parse);
    /**
     * 多条件查询员工
     * @param employeesQuery
     * @return
     */
    public List<Employees> selByManyConditions(EmployeesQuery employeesQuery);

    /**
     * 生成员工编号
     * @param eId
     * @return
     */
    public String getEmployId(String eId);
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
     * 根据部门和门店共同查询员工
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

    /**
     * 导出员工
     * @return
     */
    public  List<Employees> selDownLoadEmployList(String [] array);

    /**
     * 导出通讯名录
     * @return
     */
    public  List<Employees> selDownLoadCommunicationList(String [] array);
}
