package com.accp.service;

import com.accp.domain.PickUp;
import com.accp.domain.Servicing;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
public interface IServicingService extends IService<Servicing> {
    /**
     * 自动生成维修单号
     * @return
     */
    public String getServicingId(String servicingId);


    /**
     * 维修接车
     */
    public boolean  serviceAdviser(Servicing servicing);

    /**
     * 救援接车
     * @param pickUp
     * @return
     */
    public boolean rescueAdviser(PickUp pickUp);

    /**
     * 救援接车完成
     * @return
     */
    public boolean takeRescueFinish(String serNumber);

}
