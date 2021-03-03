package com.accp.mapper;

import com.accp.domain.Cargoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
public interface CargoodsMapper extends BaseMapper<Cargoods> {
    public Cargoods selByCloumn(String cloumn1);

    /**
     * 修改车辆单据该维修单的单据状态为工作中
     * @param cloumn1
     * @return
     */
    public  int updateCargoodsToWork(String cloumn1);
    /**
     * 修改车辆单据该维修单的单据状态为完工
     * @param cloumn1
     * @return
     */
    public  int updateCargoodsToSettlement(String cloumn1);
}
