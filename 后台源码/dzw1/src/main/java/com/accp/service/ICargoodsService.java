package com.accp.service;

import com.accp.domain.Cargoods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
public interface ICargoodsService extends IService<Cargoods> {
    /**
     * 修改车辆单据该维修单的单据状态为工作中
     * @param cloumn1
     * @return
     */
    public  boolean updateCargoodsToWork(String cloumn1);
    /**
     * 修改车辆单据该维修单的单据状态为完工
     * @param cloumn1
     * @return
     */
    public  boolean updateCargoodsToSettlement(String cloumn1);
}
