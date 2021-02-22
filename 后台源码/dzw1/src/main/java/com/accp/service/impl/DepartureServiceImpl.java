package com.accp.service.impl;

import com.accp.domain.Departure;
import com.accp.domain.Employees;
import com.accp.mapper.DepartureMapper;
import com.accp.mapper.EmployeesMapper;
import com.accp.mapper.TechnicalMapper;
import com.accp.service.IDepartureService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
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
public class DepartureServiceImpl extends ServiceImpl<DepartureMapper, Departure> implements IDepartureService {

    @Autowired
    DepartureMapper  departureMapper;

    @Autowired
    EmployeesMapper employeesMapper;

    @Autowired
    TechnicalMapper technicalMapper;

    @Override
    public boolean lz(Departure departure) {
        try {
            int a1=employeesMapper.madeFire(departure.getEId());
            int a2=technicalMapper.madeFire(departure.getEId());
            int a=departureMapper.insert(departure);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean hg(String eId) {
        try {
            int a= employeesMapper.madeAssume(eId);
            int a2=technicalMapper.madeAssume(eId);
            QueryWrapper<Departure> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("eId",eId);
            int a1=departureMapper.delete(queryWrapper);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public List<Departure> selAllDeparture() {
        return departureMapper.selAllDeparture();
    }

    @Override
    public List<Departure> selBySid(Integer [] arry) {
        return departureMapper.selBySid(arry);
    }

    @Override
    public boolean removeEmploy(String empolyId) {
        try {
            QueryWrapper<Departure> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("eId",empolyId);
            int a2  =departureMapper.delete(queryWrapper);
            int a= employeesMapper.deleteById(empolyId);
            int a1= technicalMapper.deleteById(empolyId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Departure> selectByEidOrName(String parse) {
        return departureMapper.selectByEidOrName(parse);
    }

    @Override
    public List<Departure> selBySearch(Departure departure) {
        return departureMapper.selBySearch(departure);
    }


}
