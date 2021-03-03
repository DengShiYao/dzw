package com.accp.controller;



import com.accp.domain.Car;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.accp.domain.Consumer;
import com.accp.service.IConsumerService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    IConsumerService zz;
    @RequestMapping("/selectPage")
    @ResponseBody
    public List<Consumer> select(String kehu){
        System.out.println("查询条件"+kehu);
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        if (kehu!=null){
            query.lambda().like(Consumer::getKhName,kehu);
        }
        List<Consumer> list = zz.list(query);
        System.out.println("用户"+list);
        return list;
    }
    @RequestMapping("/selectcl")
    @ResponseBody
    public List<Consumer> selectcl(String kehu){
        System.out.println("查询条件"+kehu);
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        if (kehu!=null){
            query.lambda().like(Consumer::getKhid,kehu);
        }
        List<Consumer> list = zz.list(query);
        System.out.println("用户"+list);
        return list;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody Consumer user){
        return zz.save(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updata(@RequestBody Consumer user){
        return zz.updateById(user);
    }

    @RequestMapping("delect")
    @ResponseBody
    public boolean delect(int id){
        return zz.removeById(id);
    }


    @RequestMapping("/downloadExcelBy")
    public ResponseEntity<byte []> downloadExcelBy(Consumer stu) throws IOException {
        List<Consumer> list = zz.list();
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();
        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell id = rowTitle.createCell(0);
        Cell khid = rowTitle.createCell(1);
        Cell khName = rowTitle.createCell(2);
        Cell adress = rowTitle.createCell(3);
        Cell lxpeople = rowTitle.createCell(4);
        Cell phone = rowTitle.createCell(5);
        Cell birthday = rowTitle.createCell(6);
        Cell khcategory = rowTitle.createCell(7);
        Cell yhnumber = rowTitle.createCell(8);
        Cell rhtime = rowTitle.createCell(9);
        Cell dqtime = rowTitle.createCell(10);
        Cell remarks = rowTitle.createCell(11);
        Cell jdtime = rowTitle.createCell(12);
        Cell fwgw = rowTitle.createCell(13);
        Cell ywphone = rowTitle.createCell(14);
        Cell zq = rowTitle.createCell(15);
        Cell gzmoeny = rowTitle.createCell(16);
        Cell khsheng = rowTitle.createCell(17);
        Cell khshi = rowTitle.createCell(18);
        Cell khq = rowTitle.createCell(19);

        Cell zcdh = rowTitle.createCell(20);
        Cell khyh = rowTitle.createCell(21);
        Cell zcadress = rowTitle.createCell(22);
        Cell column1 = rowTitle.createCell(23);
        Cell column2 = rowTitle.createCell(24);
        Cell column3 = rowTitle.createCell(25);
        id.setCellValue("id");
        khid.setCellValue("客户编号");
        khName.setCellValue("客户名称");
        adress.setCellValue("详细地址");
        lxpeople.setCellValue("联系人");
        phone.setCellValue("手机号码");
        birthday.setCellValue("客户生日");
        khcategory.setCellValue("客户类别");
        yhnumber.setCellValue("会员卡号");
        rhtime.setCellValue("入会日期");
        dqtime.setCellValue("会员到期");
        remarks.setCellValue("备注");
        jdtime.setCellValue("建档日期");
        fwgw.setCellValue("服务顾问");
        ywphone.setCellValue("业务员电话");
        zq.setCellValue("账期");
        gzmoeny.setCellValue("挂账额度");
        khsheng.setCellValue("客户省");
        khshi.setCellValue("客户市");
        khq.setCellValue("客户区");

        zcdh.setCellValue("注册电话");
        khyh.setCellValue("开户银行");
        zcadress.setCellValue("注册地址");
        column1.setCellValue("银行号");
        column2.setCellValue("备用列1");
        column3.setCellValue("备用列2");


        //组装导出的学生数据，如果是其他业务，请根据业务情况进行编写
        if(list!=null){
            for (int i = 1; i < list.size()+1; i++) {
                Consumer stuValue = list.get(i-1);
                System.out.println("数据长度"+list.size());
                System.out.println("数据"+stuValue);
                //导出excel数据
                Row rowValue = sheet.createRow(i);
                Cell idValue = rowValue.createCell(0);
                Cell khidValue = rowValue.createCell(1);
                Cell khNameValue = rowValue.createCell(2);
                Cell adressValue = rowValue.createCell(3);
                Cell lxpeopleValue = rowValue.createCell(4);
                Cell phoneValue = rowValue.createCell(5);
                Cell birthdayValue = rowValue.createCell(6);
                Cell khcategoryValue = rowValue.createCell(7);
                Cell yhnumberValue = rowValue.createCell(8);
                Cell rhtimeValue = rowValue.createCell(9);
                Cell dqtimeValue = rowValue.createCell(10);
                Cell remarksValue = rowValue.createCell(11);
                Cell jdtimeValue = rowValue.createCell(12);
                Cell fwgwValue = rowValue.createCell(13);
                Cell ywphoneValue = rowValue.createCell(14);
                Cell zqValue = rowValue.createCell(15);
                Cell gzmoenyValue = rowValue.createCell(16);
                Cell khshengValue = rowValue.createCell(17);
                Cell khshiValue = rowValue.createCell(18);
                Cell khqValue = rowValue.createCell(19);
                Cell zcdhValue = rowValue.createCell(20);
                Cell khyhValue = rowValue.createCell(21);
                Cell zcadressValue = rowValue.createCell(22);
                Cell column1Value = rowValue.createCell(23);
                Cell column2Value = rowValue.createCell(24);
                Cell column3Value = rowValue.createCell(25);
                idValue.setCellValue(stuValue.getId());
                khidValue.setCellValue(stuValue.getKhid());
                khNameValue.setCellValue(stuValue.getKhName());
                adressValue.setCellValue(stuValue.getAdress());
                lxpeopleValue.setCellValue(stuValue.getLxpeople());
                phoneValue.setCellValue(stuValue.getPhone());
                birthdayValue.setCellValue(stuValue.getBirthday());
                khcategoryValue.setCellValue(stuValue.getKhcategory());
                yhnumberValue.setCellValue(stuValue.getYhnumber());
                rhtimeValue.setCellValue(stuValue.getRhtime());
                dqtimeValue.setCellValue(stuValue.getDqtime());
                remarksValue.setCellValue(stuValue.getRemarks());
                jdtimeValue.setCellValue(stuValue.getJdtime());
                fwgwValue.setCellValue(stuValue.getFwgw());
                ywphoneValue.setCellValue(stuValue.getYwphone());
                zqValue.setCellValue(stuValue.getZq());
                gzmoenyValue.setCellValue(stuValue.getGzmoeny());
                khshengValue.setCellValue(stuValue.getKhsheng());
                khshiValue.setCellValue(stuValue.getKhshi());
                khqValue.setCellValue(stuValue.getKhq());

                zcdhValue.setCellValue(stuValue.getZcdh());
                khyhValue.setCellValue(stuValue.getKhyh());
                zcadressValue.setCellValue(stuValue.getZcadress());
                column1Value.setCellValue(stuValue.getColumn1());
                column2Value.setCellValue(stuValue.getColumn2());
                column3Value.setCellValue(stuValue.getColumn3());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("客户导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }
}

