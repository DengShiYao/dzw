package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.CargoodsServiceImpl;
import com.accp.service.impl.ListOfSalesServiceImpl;
import com.accp.service.impl.ServicingServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
        listOfSales.setPlateNumber(servicing.getSerChepai());
        listOfSales.setMotorcycleType(servicing.getSerChexinhao());
        listOfSales.setFrame(servicing.getSerChejia());
        listOfSales.setPhone(servicing.getSerLianxiphone());
        listOfSales.setIndemnityCompany(servicing.getSerPeikuan());
        listOfSales.setServiceAdviser(servicing.getSerServiceguwen());
        listOfSales.setCompletionTime(servicing.getSerSgtime());
        listOfSales.setColumn1(servicing.getSerNumber());
        listOfSales.setColumn2("1");//默认总店编号
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

    /**
     * 修改销售单结算状态，结算时间，结算人
     */
    @PostMapping("/updateListOfSale")
    public  boolean updateListOfSale( String json) throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
         ListOfSales listOfSales= objectMapper.readValue(json,ListOfSales.class);
        System.out.println(listOfSales);
        String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        listOfSales.setSettlementTime(timeStr);
        QueryWrapper<ListOfSales> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(ListOfSales::getSalesOrder,listOfSales.getSalesOrder());
        boolean a= listOfSalesService.update(listOfSales,queryWrapper);
        return  a;
//        System.out.println(json);
//        return true;
    }
    @GetMapping("/selBy")
    /**
     * 多条件查询
     */
    public List<ListOfSales> selBy(String json) throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
        ListOfSales listOfSales1= objectMapper.readValue(json,ListOfSales.class);
        QueryWrapper<ListOfSales> queryWrapper= new QueryWrapper<>();
        if(listOfSales1.getSalesOrder()!=null){
            queryWrapper.lambda().eq(ListOfSales::getSalesOrder,listOfSales1.getSalesOrder());
        }
        if(listOfSales1.getSettlementStatus()!=null){
            queryWrapper.lambda().eq(ListOfSales::getSettlementStatus,listOfSales1.getSettlementStatus());
        }
        if(listOfSales1.getPlateNumber()!=null){
            queryWrapper.lambda().like(ListOfSales::getPlateNumber,listOfSales1.getPlateNumber());
        }
        if(listOfSales1.getUsername()!=null){
            queryWrapper.lambda().like(ListOfSales::getUsername,listOfSales1.getUsername());
        }
        if(listOfSales1.getServiceAdviser()!=null){
            queryWrapper.lambda().eq(ListOfSales::getServiceAdviser,listOfSales1.getServiceAdviser());
        }
        if(listOfSales1.getServiceType()!=null){
            queryWrapper.lambda().eq(ListOfSales::getServiceType,listOfSales1.getServiceType());
        }
        if(listOfSales1.getBillsType()!=null){
            queryWrapper.lambda().eq(ListOfSales::getBillsType,listOfSales1.getBillsType());
        }
        if(listOfSales1.getRemarks()!=null){
            queryWrapper.lambda().like(ListOfSales::getRemarks,listOfSales1.getRemarks());
        }
        if(listOfSales1.getSettlementBenginTime()!=null){
            queryWrapper.lambda().ge(ListOfSales::getCompletionTime,listOfSales1.getSettlementBenginTime());
        }
        if(listOfSales1.getSettlementEndTime()!=null){
            queryWrapper.lambda().le(ListOfSales::getCompletionTime,listOfSales1.getSettlementEndTime());
        }
        List<ListOfSales> list = listOfSalesService.list(queryWrapper);
        return list;
    }

    /**
     * 查询所有的业务类型
     * @return
     */
    @GetMapping("/selAllServiceType")
    public  List<ListOfSales> selAllServiceType(){
        QueryWrapper<ListOfSales> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().groupBy(ListOfSales::getServiceType);
        List<ListOfSales> list = listOfSalesService.list(queryWrapper);
        return  list;
    }

    /**
     * 根据门店查询
     * @return
     */
    @PostMapping("/selByStore")
    public List<ListOfSales> selByStore(@RequestBody List<Integer> arry1){
        QueryWrapper<ListOfSales> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(ListOfSales::getColumn2,arry1);
        List<ListOfSales> list = listOfSalesService.list(queryWrapper);
        return  list;
    }

    /**
     * 根据维修单号查询结算单信息
     * @param serNumber
     * @return
     */
    @GetMapping("/selBySernumber/{serNumber}")
    public List<ListOfSales> selBySerNumber(@PathVariable String serNumber){
        QueryWrapper<ListOfSales> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(ListOfSales::getColumn1,serNumber);
        return  listOfSalesService.list(queryWrapper);
    }

    /**
     *导出excel
     */
    @RequestMapping("/downLoadExportExcel")
    public ResponseEntity<byte []> downLoadExportExcel(String lzList) throws IOException {
        System.out.println(lzList);
        String []  arry = null;
        arry=lzList.split(",");
        List<String> selList= Arrays.asList(arry);
        /* ObjectMapper objectMapper = new ObjectMapper();
        List<Departure> list= objectMapper.readValue(json,objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Departure.class));*/
        QueryWrapper<ListOfSales> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().in(ListOfSales::getSalesOrder,selList);
        List<ListOfSales> list = listOfSalesService.list(queryWrapper);
        Workbook book = new XSSFWorkbook();
        Sheet sheet= book.createSheet();
        System.out.println("进入导出");
        //导出excel头部
        Row row= sheet.createRow(0);
        Cell salesaleOrderTitle =row.createCell(0);
        Cell salebillsTypeTitle =row.createCell(1);
        Cell salebalanceTitle =row.createCell(2);
        Cell salebillstatusTitle =row.createCell(3);
        Cell salesettlementStatusTitle =row.createCell(4);
        Cell salesettlementTimeTitle =row.createCell(5);
        Cell salesettlementUserTitle =row.createCell(6);
        Cell salesettlementMoneyTitle =row.createCell(8);
        Cell saleserviceTypeTitle =row.createCell(9);
        Cell saleusernameTitle =row.createCell(10);
        Cell saleplateNumberTitle =row.createCell(11);
        Cell salemotorcycleTypeTitle =row.createCell(12);
        Cell saleframeTitle =row.createCell(13);
        Cell salephoneTitle =row.createCell(14);
        Cell saleinsurerTitle =row.createCell(15);
        Cell saleindemnityCompanyTitle =row.createCell(16);
        Cell salelicensePlateTitle =row.createCell(17);
        Cell saleserviceAdviserTitle =row.createCell(18);
        Cell salecompletionTimeTitle =row.createCell(19);
        Cell saleremarksTitle =row.createCell(20);
        salesaleOrderTitle.setCellValue("销售单号");
        salebillsTypeTitle.setCellValue("单据类型");
        salebalanceTitle.setCellValue("结算方式");
        salebillstatusTitle.setCellValue("单据状态");
        salesettlementStatusTitle.setCellValue("结算状态");
        salesettlementTimeTitle.setCellValue("结算时间");
        salesettlementUserTitle.setCellValue("结算人");
        salesettlementMoneyTitle.setCellValue("结算金额");
        saleserviceTypeTitle.setCellValue("业务类型");
        saleusernameTitle.setCellValue("客户名称");
        saleplateNumberTitle.setCellValue("车牌号");
        salemotorcycleTypeTitle.setCellValue("车型");
        saleframeTitle.setCellValue("车架号");
        salephoneTitle.setCellValue("联系电话");
        saleinsurerTitle.setCellValue("保险公司");
        saleindemnityCompanyTitle.setCellValue("赔款公司");
        salelicensePlateTitle.setCellValue("对方车牌");
        saleserviceAdviserTitle.setCellValue("服务顾问");
        salecompletionTimeTitle.setCellValue("完工时间");
        saleremarksTitle.setCellValue("备注");
        //组装导出数据
        if (list!=null) {
            for (int i = 0; i <list.size(); i++) {
                ListOfSales listOfSales= list.get(i);
                Row rowValue= sheet.createRow(i+1);
                Cell salesaleOrderValue =rowValue.createCell(0);
                Cell salebillsTypeValue =rowValue.createCell(1);
                Cell salebalanceValue =rowValue.createCell(2);
                Cell salebillstatusValue =rowValue.createCell(3);
                Cell salesettlementStatusValue =rowValue.createCell(4);
                Cell salesettlementTimeValue =rowValue.createCell(5);
                Cell salesettlementUserValue =rowValue.createCell(6);
                Cell salesettlementMoneyValue =rowValue.createCell(8);
                Cell saleserviceTypeValue =rowValue.createCell(9);
                Cell saleusernameValue =rowValue.createCell(10);
                Cell saleplateNumberValue =rowValue.createCell(11);
                Cell salemotorcycleTypeValue =rowValue.createCell(12);
                Cell saleframeValue =rowValue.createCell(13);
                Cell salephoneValue =rowValue.createCell(14);
                Cell saleinsurerValue =rowValue.createCell(15);
                Cell saleindemnityCompanyValue =rowValue.createCell(16);
                Cell salelicensePlateValue =rowValue.createCell(17);
                Cell saleserviceAdviserValue =rowValue.createCell(18);
                Cell salecompletionTimeValue =rowValue.createCell(19);
                Cell saleremarksValue =rowValue.createCell(20);
                salesaleOrderValue.setCellValue(listOfSales.getSalesOrder());
                salebillsTypeValue.setCellValue(listOfSales.getBillstatus());
                salebalanceValue.setCellValue(listOfSales.getBalance());
                salebillstatusValue.setCellValue(listOfSales.getBillstatus());
                salesettlementStatusValue.setCellValue(listOfSales.getSettlementStatus());
                salesettlementTimeValue.setCellValue(listOfSales.getSettlementTime());
                salesettlementUserValue.setCellValue(listOfSales.getSettlementUser());
                salesettlementMoneyValue.setCellValue(listOfSales.getSettlementMoney());
                saleserviceTypeValue.setCellValue(listOfSales.getServiceType());
                saleusernameValue.setCellValue(listOfSales.getUsername());
                saleplateNumberValue.setCellValue(listOfSales.getPlateNumber());
                salemotorcycleTypeValue.setCellValue(listOfSales.getMotorcycleType());
                saleframeValue.setCellValue(listOfSales.getFrame());
                salephoneValue.setCellValue(listOfSales.getPhone());
                saleinsurerValue.setCellValue(listOfSales.getInsurer());
                saleindemnityCompanyValue.setCellValue(listOfSales.getIndemnityCompany());
                salelicensePlateValue.setCellValue(listOfSales.getLicensePlate());
                saleserviceAdviserValue.setCellValue(listOfSales.getServiceAdviser());
                salecompletionTimeValue.setCellValue(listOfSales.getCompletionTime());
                saleremarksValue.setCellValue(listOfSales.getRemarks());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流格式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String flieName= new String("结算中心导出数据.xlsx".getBytes("utf-8"));
        //设置响应文件名称
        headers.setContentDispositionFormData("attachment",flieName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),headers, HttpStatus.OK);
    }
}

