package com.accp.service;

import com.accp.domain.Store;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface IStoreService extends IService<Store> {
    /**
     * 自查
     * @param pstoreId
     * @return
     */
    public List<Store> selBySelf(Integer pstoreId);

    /**
     * 根据id查询门店
     * @param storeId
     * @return
     */
    public Store selById(Integer storeId);
    /**
     * 门店编号姓名模糊查询
     * @param parse
     * @return
     */
    public List<Store> selStoreFuzzy(String parse);
}
