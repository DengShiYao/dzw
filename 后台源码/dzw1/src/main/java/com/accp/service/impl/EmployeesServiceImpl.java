package com.accp.service.impl;

import com.accp.domain.Employees;
import com.accp.domain.EmployeesQuery;
import com.accp.mapper.EmployeesMapper;
import com.accp.service.IEmployeesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements IEmployeesService {
    @Autowired
    EmployeesMapper employeesMapper;

    @Override
    public List<Employees> selInfo() {
        return employeesMapper.selInfo();
    }

    @Override
    public List<Employees> selByParse(String parse) {
        return employeesMapper.selByParse(parse);
    }

    @Override
    public List<Employees> selByManyConditions(EmployeesQuery employeesQuery) {
        return employeesMapper.selByManyConditions(employeesQuery);
    }

    @Override
    public String getEmployId(String eId) {
        String prefix = eId.substring(0, 3);
        String suffix = eId.substring(3);
        double parseCode = Double.parseDouble(suffix)+1;
        DecimalFormat df = new DecimalFormat("000");
        String code = prefix.concat(df.format(parseCode));
        return code;
    }

    @Override
    public int clearEmployeePwd(String eId) {
        return employeesMapper.clearEmployeePwd(eId);
    }

    @Override
    public List<Employees> selByMid(Integer mId) {
        return employeesMapper.selByMid(mId);
    }

    @Override
    public List<Employees> selEmployByMidAndDid(Employees employees) {
        return employeesMapper.selEmployByMidAndDid(employees);
    }

    @Override
    public int madeFire(String eId) {
        return employeesMapper.madeFire(eId);
    }

    @Override
    public int madeAssume(String eId) {
        return employeesMapper.madeAssume(eId);
    }

    @Override
    public List<Employees> selDownLoadEmployList(String[] array) {
        return employeesMapper.selDownLoadEmployList(array);
    }

    @Override
    public List<Employees> selDownLoadCommunicationList(String[] array) {
        return employeesMapper.selDownLoadCommunicationList(array);
    }
}
