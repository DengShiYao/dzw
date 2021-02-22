package com.accp.controller;


import com.accp.domain.Departure;
import com.accp.domain.Employees;
import com.accp.domain.EmployeesQuery;
import com.accp.service.impl.EmployeesServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.io.InputStream;
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
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeesServiceImpl employeesService;
    @GetMapping("/selAllEmployees")
    /**
     * 查询全部员工
     */
    public List<Employees> selInfo(){
        List<Employees> li = employeesService.selInfo();
        return  li;
    }
    @PostMapping("/selByManyConditions")
    /**
     * 多条件查询
     */
    public List<Employees>  selBy(@RequestBody  EmployeesQuery employeesQuery){
        return employeesService.selByManyConditions(employeesQuery);
    }
    @GetMapping("/selByParse/{parse}")
    /**
     * 匹配工号/姓名/手机
     */
    public List<Employees> selByParse(@PathVariable  String parse){
        if(parse.equals("我是空查询")){
            /*return employeesService.selInfo();*/
            System.out.println("全部查询");
            parse="";
        }
        return  employeesService.selByParse(parse);
    }
    @PostMapping("/add")
    /**
     * 新增员工
     * @param employees
     * @return
     */
    public boolean addEmployee(@RequestBody Employees employees){
        return employeesService.save(employees);
    }
    @PutMapping("/update")
    /**
     * 修改员工
     * @param employees
     * @return
     */
    public  boolean updateEmployee(@RequestBody Employees employees){
        return employeesService.updateById(employees);
    }
    @DeleteMapping("/remove/{eId}")
    /**
     * 删除员工
     * @param eId
     * @return
     */
    public boolean remoceEmployee(@PathVariable String eId){
        return employeesService.removeById(eId);
    }

    /**
     * 根据员工id查找单个员工
     * @param eId
     * @return
     */
    @GetMapping("/findById/{eId}")
    public Employees findById(@PathVariable String eId){
        return employeesService.getById(eId);
    }

    /**
     * 获取生成的员工编号
     * @return
     */
    @GetMapping("/findEid")
    public String getEmployId(){
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("eId");
        String eId= employeesService.list(wrapper).get(0).getEId();
        return  employeesService.getEmployId(eId);
    }

    /**
     * 置空密码
     * @param eId
     * @return
     */
    @PutMapping("/clearPwd/{eId}")
    public boolean clearPwd(@PathVariable String eId){
        return employeesService.clearEmployeePwd(eId)>0?true:false;
    }

    /**
     * 根据门店查询
     * @param mId
     * @return
     */
    @GetMapping("selByMid/{mId}")
    public List<Employees> selByMid(@PathVariable Integer mId){
        return employeesService.selByMid(mId);
    }

    @PutMapping("/saveOrUpdate")
    public  boolean saveOrUpdate(@RequestBody List<Employees> employeesList){
        return employeesService.saveOrUpdateBatch(employeesList);
    }
    @PostMapping("/selByMidAndDid")
    /**
     * 根据门店和部门查询
     */
    public List<Employees> selByMidAndDid(@RequestBody Employees employees){
        System.out.println("1111");
        return employeesService.selEmployByMidAndDid(employees);
    }
    /**
     *导出员工excel
     */
    @RequestMapping("/downLoadExportExcel")
    public ResponseEntity<byte []> downLoadExportExcel() throws IOException {
        List<Employees> list = employeesService.selInfo();
        Workbook book = new XSSFWorkbook();
        Sheet sheet= book.createSheet();
        System.out.println("进入导出");
        //导出excel头部
        Row row= sheet.createRow(0);
        Cell emplpyStoreNameTitle =row.createCell(0);
        Cell employDepartmentIdTitle =row.createCell(1);
        Cell employDepartmentNameTitle =row.createCell(2);
        Cell employIdTitle =row.createCell(3);
        Cell employNameTitle =row.createCell(4);
        Cell employSexTitle =row.createCell(5);
        Cell employJobNameTitle =row.createCell(6);
        Cell employHeathTitle =row.createCell(7);
        Cell employHeightTitle =row.createCell(8);
        Cell employNplaceTitle =row.createCell(9);
        Cell employNationalTitle =row.createCell(10);
        Cell employMarryTitle =row.createCell(11);
        Cell employEducationTitle =row.createCell(12);
        Cell employSchoolTitle =row.createCell(13);
        Cell employMajorTitle =row.createCell(14);
        Cell employPqTitle =row.createCell(15);
        Cell employDegreeTitle =row.createCell(16);
        Cell employEstablishTitle =row.createCell(17);
        Cell employCardIdTitle =row.createCell(18);
        Cell employHaddressTitle =row.createCell(19);
        emplpyStoreNameTitle.setCellValue("机构");
        employDepartmentIdTitle.setCellValue("部门代码");
        employDepartmentNameTitle.setCellValue("部门名称");
        employIdTitle.setCellValue("工号");
        employNameTitle.setCellValue("姓名");
        employSexTitle.setCellValue("性别");
        employJobNameTitle.setCellValue("岗位名称");
        employHeathTitle.setCellValue("身体状况");
        employHeightTitle.setCellValue("身高");
        employNplaceTitle.setCellValue("籍贯");
        employNationalTitle.setCellValue("民族");
        employMarryTitle.setCellValue("婚姻状态");
        employEducationTitle.setCellValue("学历");
        employSchoolTitle.setCellValue("毕业学校");
        employMajorTitle.setCellValue("专业");
        employPqTitle.setCellValue("专业资格");
        employDegreeTitle.setCellValue("学位");
        employEstablishTitle.setCellValue("编制");
        employCardIdTitle.setCellValue("身份证号");
        employHaddressTitle.setCellValue("户口地址");

        //组装导出数据
        if (list!=null) {
            for (int i = 0; i <list.size() ; i++) {
                Employees employees = list.get(i);
                Row rowValue= sheet.createRow(i+1);
                Cell emplpyStoreNameValue =rowValue.createCell(0);
                Cell employDepartmentIdValue =rowValue.createCell(1);
                Cell employDepartmentNameValue =rowValue.createCell(2);
                Cell employIdValue =rowValue.createCell(3);
                Cell employNameValue =rowValue.createCell(4);
                Cell employSexValue =rowValue.createCell(5);
                Cell employJobNameValue =rowValue.createCell(6);
                Cell employHeathValue =rowValue.createCell(7);
                Cell employHeightValue =rowValue.createCell(8);
                Cell employNplaceValue =rowValue.createCell(9);
                Cell employNationalValue =rowValue.createCell(10);
                Cell employMarryValue =rowValue.createCell(11);
                Cell employEducationValue =rowValue.createCell(12);
                Cell employSchoolValue =rowValue.createCell(13);
                Cell employMajorValue =rowValue.createCell(14);
                Cell employPqValue =rowValue.createCell(15);
                Cell employDegreeValue =rowValue.createCell(16);
                Cell employEstablishValue =rowValue.createCell(17);
                Cell employCardIdValue =rowValue.createCell(18);
                Cell employHaddressValue =rowValue.createCell(19);
                emplpyStoreNameValue.setCellValue(employees.getStore().getStoreName());
                employDepartmentIdValue.setCellValue(employees.getDId());
                employDepartmentNameValue.setCellValue(employees.getDepartment().getDName());
                employIdValue.setCellValue(employees.getEId());
                employNameValue.setCellValue(employees.getEName());
                employSexValue.setCellValue(employees.getSex().getSexName());
                employJobNameValue.setCellValue(employees.getJob().getJobName());
                employHeathValue.setCellValue(employees.getHealth());
                employHeightValue.setCellValue(employees.getHeight());
                employNplaceValue.setCellValue(employees.getNativeplace().getNplaceName());
                employNationalValue.setCellValue(employees.getNational().getNationalName());
                employMarryValue.setCellValue(employees.getMarry().getMarryName());
                employEducationValue.setCellValue(employees.getEducation().getEducationName());
                employSchoolValue.setCellValue(employees.getSchool().getSchoolName());
                employMajorValue.setCellValue(employees.getMajor().getMajorName());
                employPqValue.setCellValue(employees.getPq().getPQName());
                employDegreeValue.setCellValue(employees.getDegree().getDegreeName());
                employEstablishValue.setCellValue(employees.getEstablish());
                employCardIdValue.setCellValue(employees.getCardId());
                employHaddressValue.setCellValue(employees.getHAddress());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流格式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String flieName= new String("员工导出数据.xlsx".getBytes("utf-8"));
        //设置响应文件名称
        headers.setContentDispositionFormData("attachment",flieName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),headers, HttpStatus.OK);
    }
    /**
     * 导入
     */
    @RequestMapping("/downLoadImportExcel")
    public ResponseEntity<byte []> downLoadImportExcel() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/template/aa.xlsx");
        byte [] bytes = new byte[is.available()];
        is.read(bytes);
        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流格式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String flieName= new String("员工导入模板.xlsx".getBytes("utf-8"));
        //设置响应文件名称
        headers.setContentDispositionFormData("attachment",flieName);
        return new ResponseEntity(bytes,headers, HttpStatus.OK);
    }
    /**
     *导出通讯名录excel
     */
    @RequestMapping("/downLoadCommunicationExportExcel")
    public ResponseEntity<byte []> downLoadCommunicationExportExcel() throws IOException {
        List<Employees> list = employeesService.selInfo();
        Workbook book = new XSSFWorkbook();
        Sheet sheet= book.createSheet();
        System.out.println("进入导出");
        //导出excel头部
        Row row= sheet.createRow(0);
        Cell emplpyDepartmentNameTitle =row.createCell(0);
        Cell employEidTitle =row.createCell(1);
        Cell employEnameTitle =row.createCell(2);
        Cell employExtensionTitle =row.createCell(3);
        Cell employDirectTitle =row.createCell(4);
        Cell employPhoneTitle =row.createCell(5);
        Cell employEmailTitle =row.createCell(6);
        emplpyDepartmentNameTitle.setCellValue("部门");
        employEidTitle.setCellValue("员工编号");
        employEnameTitle.setCellValue("姓名");
        employExtensionTitle.setCellValue("分机/短号");
        employDirectTitle.setCellValue("直拨");
        employPhoneTitle.setCellValue("手机");
        employEmailTitle.setCellValue("邮箱");
        //组装导出数据
        if (list!=null) {
            for (int i = 0; i <list.size() ; i++) {
                Employees employees = list.get(i);
                Row rowValue= sheet.createRow(i+1);
                Cell emplpyDepartmentNameValue =rowValue.createCell(0);
                Cell employEidValue =rowValue.createCell(1);
                Cell employEnameValue =rowValue.createCell(2);
                Cell employExtensionValue =rowValue.createCell(3);
                Cell employDirectValue =rowValue.createCell(4);
                Cell employPhoneValue =rowValue.createCell(5);
                Cell employEmailValue =rowValue.createCell(6);
                emplpyDepartmentNameValue.setCellValue(employees.getDepartment().getDName());
                employEidValue.setCellValue(employees.getEId());
                employEnameValue.setCellValue(employees.getEName());
                employExtensionValue.setCellValue(employees.getExtension());
                employDirectValue.setCellValue(employees.getDirect());
                employPhoneValue.setCellValue(employees.getPhone());
                employEmailValue.setCellValue(employees.getEmail());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流格式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String flieName= new String("通讯导出数据.xlsx".getBytes("utf-8"));
        //设置响应文件名称
        headers.setContentDispositionFormData("attachment",flieName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),headers, HttpStatus.OK);
    }
}

