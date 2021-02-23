package com.accp.controller;


import com.accp.domain.Departure;
import com.accp.service.impl.DepartureServiceImpl;
import com.fasterxml.jackson.databind.JavaType;
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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
@RequestMapping("/departure")
public class DepartureController {
    @Autowired
    DepartureServiceImpl departureService;
    @PostMapping
    /**
     * 员工离职登记
     */
    public  boolean addDeparture(@RequestBody Departure departure){
        System.out.println("离职登记");
        return  departureService.lz(departure);
    }

    /**
     * 离职回滚
     * @param eId
     * @return
     */
    @PutMapping("/employBack/{eId}")
    public boolean employBack(@PathVariable String eId){
        return  departureService.hg(eId);
    }

    /**
     * 查询所有的离职记录
     * @return
     */
    @GetMapping("/selAll")
    public  List<Departure> selAllDeparture(){
        return  departureService.selAllDeparture();
    }

    /**
     * 根据门店进行筛选
     * @param arry1
     * @return
     */
    @PostMapping("/selBySid")
    public  List<Departure> selBySid(@RequestBody List<Integer> arry1){
        Integer [] arry =arry1.toArray(new Integer[arry1.size()]);
        System.out.println("门店筛选离职");
        List<Departure> a= departureService.selBySid(arry);
        return  a;
    }

    /**
     *离职中的删除
     * @param eId
     * @return
     */
    @DeleteMapping("/remove/{eId}")
    public boolean removeEmploy(@PathVariable  String eId){
        return  departureService.removeEmploy(eId);
    }

    /**
     * 根据名字工号模糊查询
     * @param parse
     * @return
     */
    @GetMapping("/selByEidOrName/{parse}")
    public  List<Departure> selByEidOrName(@PathVariable String parse){
        return  departureService.selectByEidOrName(parse);
    }

    /**
     * 搜索model查询
     * @param departure
     * @return
     */
    @PostMapping("/selBySearch")
    public List<Departure> selBySearch(@RequestBody Departure departure){
        return  departureService.selBySearch(departure);
    }

    /**
     *导出excel
     */
    @RequestMapping("/downLoadExportExcel")
    public  ResponseEntity<byte []>  downLoadExportExcel() throws IOException {
       /* ObjectMapper objectMapper = new ObjectMapper();
        List<Departure> list= objectMapper.readValue(json,objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Departure.class));*/
        List<Departure> list = departureService.selAllDeparture();
        Workbook book = new XSSFWorkbook();
        Sheet sheet= book.createSheet();
        System.out.println("进入导出");
        //导出excel头部
        Row row= sheet.createRow(0);
        Cell departureStoreTitle =row.createCell(0);
        Cell departureDepartmentTitle =row.createCell(1);
        Cell departureEidTitle =row.createCell(2);
        Cell departureNameTitle =row.createCell(3);
        Cell departureSexTitle =row.createCell(4);
        Cell departureJobTitle =row.createCell(5);
        Cell departureDateTitle =row.createCell(6);
        Cell departureReasonTitle =row.createCell(7);
        departureStoreTitle.setCellValue("所在门店");
        departureDepartmentTitle.setCellValue("部门");
        departureEidTitle.setCellValue("员工编号");
        departureNameTitle.setCellValue("姓名");
        departureSexTitle.setCellValue("性别");
        departureJobTitle.setCellValue("职位");
        departureDateTitle.setCellValue("离职日期");
        departureReasonTitle.setCellValue("离职原因");
        //组装导出数据
        if (list!=null) {
            for (int i = 0; i <list.size(); i++) {
                Departure departure = list.get(i);
                Row rowValue= sheet.createRow(i+1);
                Cell departureStoreValue =rowValue.createCell(0);
                Cell departureDepartmentValue =rowValue.createCell(1);
                Cell departureEidValue =rowValue.createCell(2);
                Cell departureNameValue =rowValue.createCell(3);
                Cell departureSexValue =rowValue.createCell(4);
                Cell departureJobValue =rowValue.createCell(5);
                Cell departureDateValue =rowValue.createCell(6);
                Cell departureReasonValue =rowValue.createCell(7);
                departureStoreValue.setCellValue(departure.getStore().getStoreName());
                departureDepartmentValue.setCellValue(departure.getDepartment().getDName());
                departureEidValue.setCellValue(departure.getEId());
                departureNameValue.setCellValue(departure.getName());
                departureSexValue.setCellValue(departure.getSex());
                departureJobValue.setCellValue(departure.getJob().getJobName());
                departureDateValue.setCellValue(departure.getDismissDate());
                departureReasonValue.setCellValue(departure.getDismissReason());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流格式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String flieName= new String("离职导出数据.xlsx".getBytes("utf-8"));
        //设置响应文件名称
        headers.setContentDispositionFormData("attachment",flieName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),headers, HttpStatus.OK);
    }
}

