package com.accp.mapper;

import com.accp.domain.Departure;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
public interface DepartureMapper extends BaseMapper<Departure> {
    /**
     * 查询所有离职记录
     * @return
     */
    public List<Departure> selAllDeparture();

    /**
     * 根据门店筛选查询
     * @return
     */
    public List<Departure> selBySid( Integer [] array);

    /**
     * 工号姓名模糊查询
     * @param parse
     * @return
     */
    public List<Departure> selectByEidOrName(String parse);

    /**
     * 搜索框查询
     * @param departure
     * @return
     */
    public  List<Departure> selBySearch(Departure departure);
}
