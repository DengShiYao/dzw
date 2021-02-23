package com.accp.controller;


import com.accp.domain.Departure;
import com.accp.domain.Job;
import com.accp.service.IJobService;
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
@RequestMapping("/job")
public class JobController {
    @Autowired
    IJobService jobService;
    @PostMapping
    public boolean addJob(@RequestBody Job job){
        return jobService.save(job);
    }
    @GetMapping
    public List<Job> selAll(){
        return  jobService.list();
    }
    @PutMapping
    public  boolean updateJob(@RequestBody Job job){
        return  jobService.updateById(job);
    }
    @DeleteMapping("/remove/{jobId}")
    public boolean removeJob(@PathVariable  String jobId){
        return jobService.removeById(jobId);
    }
    @GetMapping("/count")
    public int getCount(){
       return jobService.count();
    }
    /**
     *导出excel
     */
    @RequestMapping("/downLoadExportExcel")
    public ResponseEntity<byte []> downLoadExportExcel() throws IOException {
       /* ObjectMapper objectMapper = new ObjectMapper();
        List<Departure> list= objectMapper.readValue(json,objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Departure.class));*/
        List<Job> list = jobService.list();
        Workbook book = new XSSFWorkbook();
        Sheet sheet= book.createSheet();
        System.out.println("进入导出");
        //导出excel头部
        Row row= sheet.createRow(0);
        Cell jobIdTitle =row.createCell(0);
        Cell jobNameTitle =row.createCell(1);
        jobIdTitle.setCellValue("所在门店");
        jobNameTitle.setCellValue("部门");
        //组装导出数据
        if (list!=null) {
            for (int i = 0; i <list.size(); i++) {
                Job job = list.get(i);
                Row rowValue= sheet.createRow(i+1);
                Cell jobIdValue =rowValue.createCell(0);
                Cell jobNameValue =rowValue.createCell(1);
                jobIdValue.setCellValue(job.getJobId());
                jobNameValue.setCellValue(job.getJobName());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流格式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String flieName= new String("岗位定义导出数据.xlsx".getBytes("utf-8"));
        //设置响应文件名称
        headers.setContentDispositionFormData("attachment",flieName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),headers, HttpStatus.OK);
    }
}

