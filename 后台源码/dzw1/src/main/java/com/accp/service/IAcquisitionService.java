package com.accp.service;

import com.accp.domain.Acquisition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
public interface IAcquisitionService extends IService<Acquisition> {
    /**
     * 根据车牌查询到的项目list得到领料
     * @param array
     * @return
     */
    public List<Acquisition> selByArray(Integer [] array);
}
