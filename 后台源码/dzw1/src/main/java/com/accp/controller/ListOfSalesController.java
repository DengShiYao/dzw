package com.accp.controller;


import com.accp.domain.Cargoods;
import com.accp.domain.ListOfSales;
import com.accp.domain.Servicing;
import com.accp.domain.Servicingproject;
import com.accp.service.impl.CargoodsServiceImpl;
import com.accp.service.impl.ListOfSalesServiceImpl;
import com.accp.service.impl.ServicingServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/listOfSales")
public class ListOfSalesController {
    @Autowired
    ListOfSalesServiceImpl listOfSalesService;

    @Autowired
    ServicingServiceImpl servicingService;

    @Autowired
    CargoodsServiceImpl cargoodsService;

    /**
     * 新增一个销售订单
     * @param serNumber
     */
    @PostMapping("/addListOfSale/{serNumber}")
    public boolean addListOfSale(@PathVariable String serNumber){
        QueryWrapper<Servicing> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Servicing::getSerNumber,serNumber);
        Servicing servicing =servicingService.getOne(queryWrapper);
        QueryWrapper<Cargoods>  queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(Cargoods::getColumn1,servicing.getSerNumber());
        Cargoods cargoods =cargoodsService.getOne(queryWrapper1);
        ListOfSales listOfSales = new ListOfSales();
        String saleOrderCode=this.AutoCreateSaleNumber();
        listOfSales.setSalesOrder(saleOrderCode);
        listOfSales.setBillsType(cargoods.getCarDjtype());
        listOfSales.setBalance(servicing.getSerJsfangshi());
        listOfSales.setBillstatus("完工");
        /*String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        listOfSales.setSettlementTime(timeStr);*/
        //listOfSales.setSettlementUser(servicing.getSerDriver());
        listOfSales.setSettlementMoney(servicing.getSerExpectmoney());
        listOfSales.setServiceType(cargoods.getCarServicetype());
        listOfSales.setUsername(cargoods.getCarUsername());
        listOfSales.setPlateNumber(servicing.getSerNumber());
        listOfSales.setMotorcycleType(servicing.getSerChexinhao());
        listOfSales.setFrame(servicing.getSerChejia());
        listOfSales.setPhone(servicing.getSerLianxiphone());
        listOfSales.setIndemnityCompany(servicing.getSerPeikuan());
        listOfSales.setServiceAdviser(servicing.getSerServiceguwen());
        listOfSales.setCompletionTime(servicing.getSerSgtime());
        boolean a= listOfSalesService.save(listOfSales);
        return a;
    }

    /**
     * 自动生成销售单号
     * @return
     */
    public String AutoCreateSaleNumber(){
        List<ListOfSales> list= listOfSalesService.list();
        if(list!=null&&list.size()>0){
            String number=list.get(list.size()-1).getSalesOrder();
            String prefix = number.substring(0,13);
            String suffix = number.substring(13);
            double parseCode = Double.parseDouble(suffix) + 1;
            DecimalFormat df = new DecimalFormat("000");
            String code = prefix.concat(df.format(parseCode));
            return code;
        }
        return "00000RE310200001";
    }

    /**
     * 查询所有的销售单记录
     * @return
     */
    @GetMapping("/selAll")
    public List<ListOfSales> selAll(){
        return  listOfSalesService.list();
    }

    @PostMapping("/updateListOfSale")
    /**
     * 修改销售单结算状态，结算时间，结算人
     */
    public  boolean updateListOfSale(ListOfSales listOfSales){
        QueryWrapper<ListOfSales> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(ListOfSales::getSalesOrder,listOfSales.getSalesOrder());
        boolean a= listOfSalesService.update(listOfSales,queryWrapper);
        return  a;
    }
//    @GetMapping("/selBy")
    /**
     * 多条件查询
     */
//    public List<ListOfSales> selBy(ListOfSales listOfSales){
//        QueryWrapper<ListOfSales> queryWrapper= new QueryWrapper<>();
//        if(listOfSales.getSalesOrder()!=null){
//            queryWrapper.lambda().like(listOfSales::getSalesOrder,1);
//        }
//        return null;
//    }
}

