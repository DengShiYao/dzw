package com.accp.service.impl;

import com.accp.domain.Staffpostition;
import com.accp.mapper.StaffpostitionMapper;
import com.accp.service.IStaffpostitionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-24
 */
@Service
public class StaffpostitionServiceImpl extends ServiceImpl<StaffpostitionMapper, Staffpostition> implements IStaffpostitionService {

    @Autowired
    StaffpostitionMapper staffpostitionMapper;
    @Override
    public List<Staffpostition> selByEid(String eId) {
        return staffpostitionMapper.selByEid(eId);
    }

    @Override
    public boolean updateEidPidBeatch(String eId, List<Integer> list) {
        try {
            QueryWrapper<Staffpostition> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(Staffpostition::getEId,eId);
            int a = staffpostitionMapper.delete(queryWrapper);
            List<Staffpostition> list1 = new ArrayList<>();
            int [] arry =list.stream().mapToInt(i->i).toArray();
            for (int i = 0; i < arry.length; i++) {
                Staffpostition staffpostition = new Staffpostition();
                staffpostition.setEId(eId);
                staffpostition.setPostitonId(arry[i]);
                list1.add(staffpostition);
            }
            int a1= staffpostitionMapper.insertEidPidBeatch(list1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
