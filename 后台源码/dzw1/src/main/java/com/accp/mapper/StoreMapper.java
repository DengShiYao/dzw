package com.accp.mapper;

import com.accp.domain.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface StoreMapper extends BaseMapper<Store> {
        /**
         * 根据id查询
         * @param storeId
         * @return
         */
        public Store selById(Integer storeId);

        /**
         * 自查
         * @param pstoreId
         * @return
         */
        public List<Store> selBySelf(Integer pstoreId);

        /**
         * 门店编号姓名模糊查询
         * @param parse
         * @return
         */
        public List<Store> selStoreFuzzy(String parse);
}
