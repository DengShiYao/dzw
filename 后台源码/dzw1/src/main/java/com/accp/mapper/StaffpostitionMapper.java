package com.accp.mapper;

import com.accp.domain.Staffpostition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-24
 */
public interface StaffpostitionMapper extends BaseMapper<Staffpostition> {
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
    public int insertEidPidBeatch(List<Staffpostition> list);
}
