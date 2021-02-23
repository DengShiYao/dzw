package com.accp.controller;


import com.accp.domain.TeamForm;
import com.accp.domain.Technical;
import com.accp.domain.Tuandui;
import com.accp.service.ITeamFormService;
import com.accp.service.ITechnicalService;
import com.accp.service.ITuanduiService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.io.output.ByteArrayOutputStream;
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
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-03
 */
@RestController
@RequestMapping("/tuandui")
public class TuanduiController {

    @Autowired
    ITuanduiService tdService;

    @Autowired
    ITeamFormService tfService;

    @Autowired
    ITechnicalService jgService;

    /**
     * 树形菜单
     */
    @RequestMapping("/find")
    @ResponseBody
    public List<Tuandui> toFind(){
        List<Tuandui> tdList = tdService.list();
        for (Tuandui t:tdList) {
            QueryWrapper<TeamForm> query = new QueryWrapper<>();
            query.lambda().eq(TeamForm::getColumn2,t.getTdId());
            List<TeamForm> bzList = tfService.list(query);
            for (TeamForm tf:bzList) {
                QueryWrapper<Technical> jgQuery = new QueryWrapper<>();
                jgQuery.lambda().eq(Technical::getColumn1,tf.getColumn1());
                List<Technical> jgList = jgService.list(jgQuery);
                tf.setJgList(jgList);
            }
            t.setTfList(bzList);
        }
        return tdList;
    }

    /*
    增加班组
     */
    @RequestMapping("/createbz")
    @ResponseBody
    public boolean createTeamFrom(TeamForm teamform){
        return tfService.save(teamform);
    }

    /*
   修改班组
    */
    @RequestMapping("/updateBz")
    @ResponseBody
    public boolean updateBz(TeamForm teamform){
        return tfService.updateById(teamform);
    }

    /*
    删除班组
   */
    @RequestMapping("/removeBz")
    @ResponseBody
    public boolean removeBz(TeamForm teamform){
        return tfService.removeById(teamform);
    }

    /**
     * 新增技工
     */
    @RequestMapping("/jgcreate")
    @ResponseBody
    public boolean jgcreate(Technical tech){
        return jgService.save(tech);
    }

    /**
     * 修改技工
     */
    @RequestMapping("/jgUpdate")
    @ResponseBody
    public boolean jgUpdate(Technical tech){
        return jgService.updateById(tech);
    }

    /**
     * 删除技工
     */
    @RequestMapping("/removejg")
    @ResponseBody
    public boolean removeJg(Technical tech){
        return jgService.removeById(tech.getTechnicalNumber());
    }

    /**
     * 模糊查询
     */
    @RequestMapping("/findByLike")
    @ResponseBody
    public List<Technical> findByLike(String condition){
        QueryWrapper<Technical> query = new QueryWrapper<>();
        query.lambda().like(Technical::getTechnicalNumber,condition).or().like(Technical::getTechnicalName,condition).or().eq(Technical::getPhone,condition);
        List<Technical> tech = jgService.list(query);
        for (Technical t:tech) {
            TeamForm bz = tfService.getById(t.getColumn1());
            t.setCore(bz.getTeamCode());
            t.setName(bz.getTeamName());
        }
        return tech;
    }

    /**
     * 导出数据
     */
//    @RequestMapping("/daochu")
//    public ResponseEntity<byte []> daoChu(List<Technical> tech) throws IOException {
//         Workbook book = new XSSFWorkbook();
//         Sheet sheet = book.createSheet();
//
//         Row rowTitle = sheet.createRow(0);
//         Cell technicalNumber = rowTitle.createCell(0);
//         technicalNumber.setCellValue("技工编号");
//         Cell technicalName = rowTitle.createCell(1);
//         technicalName.setCellValue("技工姓名");
//         Cell technicalSex = rowTitle.createCell(2);
//         technicalSex.setCellValue("性别");
//         Cell headman = rowTitle.createCell(3);
//         headman.setCellValue("是否是组长");
//         Cell phone = rowTitle.createCell(4);
//         phone.setCellValue("手机");
//         Cell accountNumber = rowTitle.createCell(5);
//         accountNumber.setCellValue("登陆账号");
//         Cell address = rowTitle.createCell(6);
//         address.setCellValue("地址");
//         Cell birthday = rowTitle.createCell(7);
//         birthday.setCellValue("出生日期");
//         Cell microsignal = rowTitle.createCell(8);
//         microsignal.setCellValue("微信号");
//         Cell idNumber = rowTitle.createCell(9);
//         idNumber.setCellValue("身份证号");
//         Cell address2 = rowTitle.createCell(10);
//         address2.setCellValue("户口地址");
//         Cell bank = rowTitle.createCell(11);
//         bank.setCellValue("开户银行");
//         Cell bankNumber = rowTitle.createCell(12);
//         bankNumber.setCellValue("银行账号");
//         Cell maintenanceType = rowTitle.createCell(13);
//         maintenanceType.setCellValue("维修工种");
//         Cell maintenanceBrand = rowTitle.createCell(14);
//         maintenanceBrand.setCellValue("维修品牌");
//         Cell dimission = rowTitle.createCell(15);
//         dimission.setCellValue("是否离职");
//
//        if(tech!=null){
//            int i = 0;
//            for (Technical t:tech) {
//                if(i > 0){
//                    Row rowValue = sheet.createRow(i);
//                    Cell technicalNumberValue = rowTitle.createCell(0);
//                    technicalNumberValue.setCellValue(t.getTechnicalNumber());
//                    Cell technicalNameValue = rowTitle.createCell(1);
//                    technicalNameValue.setCellValue(t.getTechnicalName());
//                    Cell technicalSexValue = rowTitle.createCell(2);
//                    technicalSexValue.setCellValue(t.getTechnicalSex());
//                    Cell headmanValue = rowTitle.createCell(3);
//                    headmanValue.setCellValue(t.getHeadman());
//                    Cell phoneValue = rowTitle.createCell(4);
//                    phoneValue.setCellValue(t.getPhone());
//                    Cell accountNumberValue = rowTitle.createCell(5);
//                    accountNumberValue.setCellValue(t.getAccountNumber());
//                    Cell addressValue = rowTitle.createCell(6);
//                    addressValue.setCellValue(t.getAddress());
//                    Cell birthdayValue = rowTitle.createCell(7);
//                    birthdayValue.setCellValue(t.getBirthday());
//                    Cell microsignalValue = rowTitle.createCell(8);
//                    microsignalValue.setCellValue(t.getMicrosignal());
//                    Cell idNumberValue = rowTitle.createCell(9);
//                    idNumberValue.setCellValue(t.getIdNumber());
//                    Cell address2Value = rowTitle.createCell(10);
//                    address2Value.setCellValue(t.getAddress2());
//                    Cell bankValue = rowTitle.createCell(11);
//                    bankValue.setCellValue(t.getBank());
//                    Cell bankNumberValue = rowTitle.createCell(12);
//                    bankNumberValue.setCellValue(t.getBankNumber());
//                    Cell maintenanceTypeValue = rowTitle.createCell(13);
//                    maintenanceTypeValue.setCellValue(t.getMaintenanceType());
//                    Cell maintenanceBrandValue = rowTitle.createCell(14);
//                    maintenanceBrandValue.setCellValue(t.getMaintenanceBrand());
//                    Cell dimissionValue = rowTitle.createCell(15);
//                    dimissionValue.setCellValue(t.getDimission());
//                }
//                i++;
//            }
//
//        }
//
//         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//         book.write(byteArrayOutputStream);
//
//         HttpHeaders headers = new HttpHeaders();
//         //设置响应内容为文件流模式
//         headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//         String fileName = new String("技工导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
//         //设置响应的文件的名称
//         headers.setContentDispositionFormData("attachment",fileName);
//         return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
//
//
//    }



    /**
     * 导出数据
     */
    @RequestMapping("/daochu1")
    public ResponseEntity<byte []> daoChu(String jglist) throws IOException {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();

        Row rowTitle = sheet.createRow(0);
        Cell technicalNumber = rowTitle.createCell(0);
        technicalNumber.setCellValue("技工编号");
        Cell technicalName = rowTitle.createCell(1);
        technicalName.setCellValue("技工姓名");
        Cell technicalSex = rowTitle.createCell(2);
        technicalSex.setCellValue("性别");
        Cell headman = rowTitle.createCell(3);
        headman.setCellValue("是否是组长");
        Cell phone = rowTitle.createCell(4);
        phone.setCellValue("手机");
        Cell accountNumber = rowTitle.createCell(5);
        accountNumber.setCellValue("登陆账号");
        Cell address = rowTitle.createCell(6);
        address.setCellValue("地址");
        Cell birthday = rowTitle.createCell(7);
        birthday.setCellValue("出生日期");
        Cell microsignal = rowTitle.createCell(8);
        microsignal.setCellValue("微信号");
        Cell idNumber = rowTitle.createCell(9);
        idNumber.setCellValue("身份证号");
        Cell address2 = rowTitle.createCell(10);
        address2.setCellValue("户口地址");
        Cell bank = rowTitle.createCell(11);
        bank.setCellValue("开户银行");
        Cell bankNumber = rowTitle.createCell(12);
        bankNumber.setCellValue("银行账号");
        Cell maintenanceType = rowTitle.createCell(13);
        maintenanceType.setCellValue("维修工种");
        Cell maintenanceBrand = rowTitle.createCell(14);
        maintenanceBrand.setCellValue("维修品牌");
        Cell dimission = rowTitle.createCell(15);
        dimission.setCellValue("是否离职");


        String[] jg = jglist.split(",");
        int i = 1;
        for (String j: jg) {
            Technical t = jgService.getById(j);
            Row rowValue = sheet.createRow(i);
            Cell technicalNumberValue = rowValue.createCell(0);
            technicalNumberValue.setCellValue(t.getTechnicalNumber());
            Cell technicalNameValue = rowValue.createCell(1);
            technicalNameValue.setCellValue(t.getTechnicalName());
            Cell technicalSexValue = rowValue.createCell(2);
            technicalSexValue.setCellValue(t.getTechnicalSex());
            Cell headmanValue = rowValue.createCell(3);
            headmanValue.setCellValue(t.getHeadman());
            Cell phoneValue = rowValue.createCell(4);
            phoneValue.setCellValue(t.getPhone());
            Cell accountNumberValue = rowValue.createCell(5);
            accountNumberValue.setCellValue(t.getAccountNumber());
            Cell addressValue = rowValue.createCell(6);
            addressValue.setCellValue(t.getAddress());
            Cell birthdayValue = rowValue.createCell(7);
            birthdayValue.setCellValue(t.getBirthday());
            Cell microsignalValue = rowValue.createCell(8);
            microsignalValue.setCellValue(t.getMicrosignal());
            Cell idNumberValue = rowValue.createCell(9);
            idNumberValue.setCellValue(t.getIdNumber());
            Cell address2Value = rowValue.createCell(10);
            address2Value.setCellValue(t.getAddress2());
            Cell bankValue = rowValue.createCell(11);
            bankValue.setCellValue(t.getBank());
            Cell bankNumberValue = rowValue.createCell(12);
            bankNumberValue.setCellValue(t.getBankNumber());
            Cell maintenanceTypeValue = rowValue.createCell(13);
            maintenanceTypeValue.setCellValue(t.getMaintenanceType());
            Cell maintenanceBrandValue = rowValue.createCell(14);
            maintenanceBrandValue.setCellValue(t.getMaintenanceBrand());
            Cell dimissionValue = rowValue.createCell(15);
            dimissionValue.setCellValue(t.getDimission());
            i++;
        }




        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("技工导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);


    }

}

