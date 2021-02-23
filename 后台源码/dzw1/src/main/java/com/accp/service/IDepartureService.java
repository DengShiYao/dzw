package com.accp.service;

import com.accp.domain.Departure;
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
public interface IDepartureService extends IService<Departure> {
    /**
     * 离职员工
     * @return
     */
    public boolean lz(Departure departure);

    /**
     * 离职回滚
     * @param eId
     * @return
     */
    public  boolean hg(String eId);

    /**
     * 查询所有离职记录
     * @return
     */
    public List<Departure> selAllDeparture();

    /**
     * 根据门店筛选查询
     * @return
     */
    public List<Departure> selBySid(Integer [] arry);

    /**
     * 离职中的删除
     * @param eId
     * @return
     */
    public boolean removeEmploy(String eId);

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
