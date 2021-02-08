package com.accp.mapper;

import com.accp.domain.SuppliersContacts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface SuppliersContactsMapper extends BaseMapper<SuppliersContacts> {
    List<SuppliersContacts> toFind(Integer sid);
}
