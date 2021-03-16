package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.*;
import com.accp.service.impl.SuppliersRegionServiceImpl;
import com.baomidou.mybatisplus.annotation.TableId;
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
@RequestMapping("/car")
public class CarController {
    @Autowired
    ICarService zz;
    @Autowired
    ICarTypeService ss;
    @Autowired
    IVehicleOwnershipService dd;
    @Autowired
    IQbxgsService bb;
    @Autowired
    ISybxgsService aa;
    @Autowired
    IConsumerService cc;
    @Autowired
    IEngineBrandService  ll;
    @Autowired
    SuppliersRegionServiceImpl service;
    @Autowired
    ILinliaoBiaoService service2;
    @Autowired
    IListOfSalesService js;
    @Autowired
    IWeiXiubiaoService wx;
    @Autowired
    IGoodsService sp;
    //查询车辆
    @RequestMapping("/selectPage")
    @ResponseBody
    public List<Car> select(String  car){
        System.out.println("查询数据"+car);
        QueryWrapper<Car> query = new QueryWrapper<>();
        query.lambda().like(Car::getCarCph, car);
        List<Car> list = zz.list(query);
        return list;
    }

    //查询所有车辆
    @RequestMapping("/selectPagecl")
    public List<Car> selectPagecl(String  car){
        List<Car> list = zz.list();
        return list;
    }
    //新增车辆
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody Car user){
        System.out.println("车辆新增"+user);
        return zz.save(user);
    }
    //修改车辆
    @RequestMapping("/update")
    @ResponseBody
    public boolean updata(@RequestBody Car user){
        System.out.println(user);
        return zz.updateById(user);
    }
    //删除车辆
    @RequestMapping("delect")
    @ResponseBody
    public boolean delect(String id){
        System.out.println(id);
        return zz.removeById(id);
    }

    //查询车型表
    @RequestMapping("SelectCx")
    public List<CarType> selectCx(){
        QueryWrapper<CarType> query =  new QueryWrapper<>();
        List<CarType> list = ss.list(query);
        return list;
    }

    //查询车辆归属
    @RequestMapping("SelectCxGs")
    public List<VehicleOwnership> selectCxGs(){
        QueryWrapper<VehicleOwnership> query =  new QueryWrapper<>();
        List<VehicleOwnership> list = dd.list(query);
        return list;
    }
    //查询强险公司
    @RequestMapping("SelectQxgs")
    public List<Qbxgs> SelectQxgs(){
        QueryWrapper<Qbxgs> query =  new QueryWrapper<>();
        List<Qbxgs> list =bb.list(query);
        return list;
    }
    //查询商业险公司
    @RequestMapping("Selectsyxgs")
    public List<Sybxgs> Selectsyxgs(){
        QueryWrapper<Sybxgs> query =  new QueryWrapper<>();
        List<Sybxgs> list =aa.list(query);
        return list;
    }
    //查询所有客户
    @RequestMapping("SelectKh")
    public List<Consumer> SelectKh(){
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        List<Consumer> list =cc.list(query);
        return list;
    }

    //根据车辆id查询客户
    @RequestMapping("SelectKhID")
    public List<Consumer> SelectKhID(int id){
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        query.lambda().like(Consumer::getId,id);
        List<Consumer> list =cc.list(query);
        return list;
    }
    //根据客户id查询车辆
    @RequestMapping("SelectClID")
    public List<Car> SelectClID(int id){
        QueryWrapper<Car> query =  new QueryWrapper<>();
        query.lambda().like(Car::getColumn3,id);
        List<Car> list =zz.list(query);
        return list;
    }
    //根据客户名字查询客户
    @RequestMapping("SelectKhName")
    @ResponseBody
    public List<Consumer> SelectKhName(@RequestBody Consumer user){
        System.out.println(user);
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        query.lambda().like(Consumer::getKhid,user.getKhid());
        List<Consumer> list =cc.list(query);
        System.out.println("查询数组"+list);
        return list;
    }
    //今日提醒：engine_brand查询EngineBrand
    @RequestMapping("Selectbrand")
    public List<EngineBrand> Selectbrand(){
        List<EngineBrand> list =ll.list();
        return list;
    }
    //今日提醒：suppliers_region查询SuppliersRegion  service
    @RequestMapping("Selectregion")
    public List<SuppliersRegion> Selectregion(){
        List<SuppliersRegion> list =service.list();
        return list;
    }

    //今日提醒：linliao_biao查询
    @RequestMapping("SelectLinliaoBiao")
    public List<LinliaoBiao> SelectLinliaoBiao(){
        List<LinliaoBiao> list =service2.list();
        return list;
    }
    @RequestMapping("/downloadExcel")
    public ResponseEntity<byte []> downloadExcel(Car stu) throws IOException {
        List<Car> list = zz.list();
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();
        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        Cell carCph = rowTitle.createCell(0);
        Cell carClpp = rowTitle.createCell(1);
        Cell carType = rowTitle.createCell(2);
        Cell carJsy = rowTitle.createCell(3);
        Cell carPhone = rowTitle.createCell(4);
        Cell carCsrq = rowTitle.createCell(5);
        Cell carClgs = rowTitle.createCell(6);
        Cell carJsydz = rowTitle.createCell(7);
        Cell carJzdq = rowTitle.createCell(8);
        Cell carCjh = rowTitle.createCell(9);
        Cell carFdjh = rowTitle.createCell(10);
        Cell carFdjpph = rowTitle.createCell(11);
        Cell carCllk = rowTitle.createCell(12);
        Cell carLc = rowTitle.createCell(13);
        Cell carZz = rowTitle.createCell(14);
        Cell carCx = rowTitle.createCell(15);
        Cell carGmrq = rowTitle.createCell(16);
        Cell carSprq = rowTitle.createCell(17);
        Cell carCjdq = rowTitle.createCell(18);
        Cell carjqxbxgs = rowTitle.createCell(19);
        Cell carJqxdq = rowTitle.createCell(20);
        Cell carSf = rowTitle.createCell(21);
        Cell carEwrq = rowTitle.createCell(22);
        Cell carRylb = rowTitle.createCell(23);
        Cell carXcbylc = rowTitle.createCell(24);
        Cell carXcbyrq = rowTitle.createCell(25);
        Cell carHym = rowTitle.createCell(26);
        Cell column1 = rowTitle.createCell(27);
        Cell column2 = rowTitle.createCell(28);
        Cell column3 = rowTitle.createCell(29);
        carCph.setCellValue("车牌号码");
        carClpp.setCellValue("车辆品牌");
        carType.setCellValue("车辆型号");
        carJsy.setCellValue("驾驶员");
        carPhone.setCellValue("驾驶员电话");
        carCsrq.setCellValue("出生日期");
        carClgs.setCellValue("车辆归属");
        carJsydz.setCellValue("驾驶员地址");
        carJzdq.setCellValue("驾照到期日期");
        carCjh.setCellValue("车架号");
        carFdjh.setCellValue("发动机号");
        carFdjpph.setCellValue("发动机品牌号");
        carCllk.setCellValue("车辆年款");
        carLc.setCellValue("里程");
        carZz.setCellValue("载重");
        carCx.setCellValue("车系");
        carGmrq.setCellValue("购买日期");
        carSprq.setCellValue("上牌日期");
        carCjdq.setCellValue("车检到期");
        carjqxbxgs.setCellValue("交强险保险公司");
        carJqxdq.setCellValue("交强险到期日期");
        carSf.setCellValue("是否在我投保车中");
        carEwrq.setCellValue("二维日期");
        carRylb.setCellValue("燃油类别");
        carXcbylc.setCellValue("下次保养里程");
        carXcbyrq.setCellValue("下次保养日期");
        carHym.setCellValue("会员码");
        column1.setCellValue("商业保险");
        column2.setCellValue("商业险到期");
        column3.setCellValue("客户");


        //组装导出的学生数据，如果是其他业务，请根据业务情况进行编写
        if(list!=null){
            for (int i = 1; i < list.size(); i++) {
                Car stuValue = list.get(i-1);

                //导出excel数据
                Row rowValue = sheet.createRow(i);
                Cell carCphValue = rowValue.createCell(0);
                Cell carClppValue = rowValue.createCell(1);
                Cell carTypeValue = rowValue.createCell(2);
                Cell carJsyValue = rowValue.createCell(3);
                Cell carPhoneValue = rowValue.createCell(4);
                Cell carCsrqValue = rowValue.createCell(5);
                Cell carClgsValue = rowValue.createCell(6);
                Cell carJsydzValue = rowValue.createCell(7);
                Cell carJzdqValue = rowValue.createCell(8);
                Cell carCjhValue = rowValue.createCell(9);
                Cell carFdjhValue = rowValue.createCell(10);
                Cell carFdjpphValue = rowValue.createCell(11);
                Cell carCllkValue = rowValue.createCell(12);
                Cell carLcValue = rowValue.createCell(13);
                Cell carZzValue = rowValue.createCell(14);
                Cell carCxValue = rowValue.createCell(15);
                Cell carGmrqValue = rowValue.createCell(16);
                Cell carSprqValue = rowValue.createCell(17);
                Cell carCjdqValue = rowValue.createCell(18);
                Cell carjqxbxgsValue = rowValue.createCell(19);
                Cell carJqxdqValue = rowValue.createCell(20);
                Cell carSfValue = rowValue.createCell(21);
                Cell carEwrqValue = rowValue.createCell(22);
                Cell carRylbValue = rowValue.createCell(23);
                Cell carXcbylcValue = rowValue.createCell(24);
                Cell carXcbyrqValue = rowValue.createCell(25);
                Cell carHymValue = rowValue.createCell(26);
                Cell column1Value = rowValue.createCell(27);
                Cell column2Value = rowValue.createCell(28);
                Cell column3Value = rowValue.createCell(29);
                carCphValue.setCellValue(stuValue.getCarCph());
                carClppValue.setCellValue(stuValue.getCarClpp());
                carTypeValue.setCellValue(stuValue.getCarType());
                carJsyValue.setCellValue(stuValue.getCarJsy());
                carPhoneValue.setCellValue(stuValue.getCarPhone());
                carCsrqValue.setCellValue(stuValue.getCarCsrq());
                carClgsValue.setCellValue(stuValue.getCarClgs());
                carJsydzValue.setCellValue(stuValue.getCarJsydz());
                carJzdqValue.setCellValue(stuValue.getCarJzdq());
                carCjhValue.setCellValue(stuValue.getCarCjh());
                carFdjhValue.setCellValue(stuValue.getCarFdjh());
                carFdjpphValue.setCellValue(stuValue.getCarFdjpph());
                carCllkValue.setCellValue(stuValue.getCarCllk());
                carLcValue.setCellValue(stuValue.getCarLc());
                carZzValue.setCellValue(stuValue.getCarZz());
                carCxValue.setCellValue(stuValue.getCarCx());
                carGmrqValue.setCellValue(stuValue.getCarGmrq());
                carSprqValue.setCellValue(stuValue.getCarSprq());
                carCjdqValue.setCellValue(stuValue.getCarCjdq());
                carjqxbxgsValue.setCellValue(stuValue.getCarjqxbxgs());
                carJqxdqValue.setCellValue(stuValue.getCarJqxdq());
                carSfValue.setCellValue(stuValue.getCarSf());
                carEwrqValue.setCellValue(stuValue.getCarEwrq());
                carRylbValue.setCellValue(stuValue.getCarRylb());
                carXcbylcValue.setCellValue(stuValue.getCarXcbylc());
                carXcbyrqValue.setCellValue(stuValue.getCarXcbyrq());
                carHymValue.setCellValue(stuValue.getCarHym());
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
        String fileName = new String("车辆导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }


    //结算中心查询
    @RequestMapping("Selectjs")
    public List<ListOfSales> Selectjs(){
        QueryWrapper<ListOfSales> query =  new QueryWrapper<>();
        List<ListOfSales> list =js.list(query);
        return list;
    }
    //维修表查询wei_xiubiao
    @RequestMapping("Selectwx")
    public List<WeiXiubiao> Selectwx(){
        QueryWrapper<WeiXiubiao> query =  new QueryWrapper<>();
        List<WeiXiubiao> list =wx.list(query);
        return list;
    }

    //商品表查询goods
    @RequestMapping("Selectsp")
    public List<Goods> Selectsp(){
        QueryWrapper<Goods> query =  new QueryWrapper<>();
        List<Goods> list =sp.list(query);
        return list;
    }
}

