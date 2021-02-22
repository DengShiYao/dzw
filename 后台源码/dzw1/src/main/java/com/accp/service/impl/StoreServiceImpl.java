package com.accp.service.impl;

import com.accp.domain.Store;
import com.accp.mapper.StoreMapper;
import com.accp.service.IStoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements IStoreService {

    @Autowired
    StoreMapper storeMapper;

    @Override
    public List<Store> selBySelf(Integer pstoreId) {
        return storeMapper.selBySelf(pstoreId);
    }

    @Override
    public Store selById(Integer storeId) {
        return storeMapper.selById(storeId);
    }

    @Override
    public List<Store> selStoreFuzzy(String parse) {
        return storeMapper.selStoreFuzzy(parse);
    }
}
