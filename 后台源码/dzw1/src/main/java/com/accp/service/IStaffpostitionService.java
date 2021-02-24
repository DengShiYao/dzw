package com.accp.service;

import com.accp.domain.Staffpostition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-24
 */
public interface IStaffpostitionService extends IService<Staffpostition> {
    /**
     * 根据员工id查询他的职务
     * @param eId
     * @return
     */
    public List<Staffpostition> selByEid(String eId);

    /**
     * 批量新增
     * @return
     */
    public boolean updateEidPidBeatch(String eId,List<Integer> list);
}
