package com.accp.mapper;

import com.accp.domain.Servicingproject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
public interface ServicingprojectMapper extends BaseMapper<Servicingproject> {
    /**
     * 根据车牌查询到的维修单list查询维修项目
     * @param array
     * @return
     */
    public List<Servicingproject>  selByArray(String [] array);

    public Servicingproject selByServicingProjectId(Integer wxId);
}
