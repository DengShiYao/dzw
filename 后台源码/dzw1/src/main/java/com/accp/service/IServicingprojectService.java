package com.accp.service;

import com.accp.domain.Servicingproject;
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
public interface IServicingprojectService extends IService<Servicingproject> {
    /**
     * 根据车牌得到的维修单list查询维修项目
     * @param array
     * @return
     */
    public List<Servicingproject> selByArray(String [] array);
}
