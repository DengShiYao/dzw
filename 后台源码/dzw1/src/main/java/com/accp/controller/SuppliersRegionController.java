package com.accp.controller;


import com.accp.domain.DzwColumnController;
import com.accp.domain.Goods;
import com.accp.domain.SuppliersContacts;
import com.accp.domain.SuppliersRegion;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.SuppliersContactsServiceImpl;
import com.accp.service.impl.SuppliersRegionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
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

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * 供货商
 *
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/suppliersRegion")
public class SuppliersRegionController {

    @Autowired
    SuppliersRegionServiceImpl service;
    /**
     * 联系人
     */
    @Autowired
    SuppliersContactsServiceImpl contactsService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 查询厂商列表
     *
     * @param regionId
     * @return
     */
    @GetMapping("/{regionId}")
    public ResultVO toFind(@PathVariable String regionId) {
        List<SuppliersRegion> suppliersRegionCities = service.toFind(regionId);
        return new ResultVO(suppliersRegionCities);
    }

    /**
     * 新增供货商联系人
     *
     * @param supplier
     * @return
     */
    @PostMapping("/ins")
    public ResultVO insSupplier(@Valid @RequestBody SuppliersRegion supplier) {
        SuppliersRegion one = service.getOne(new QueryWrapper<SuppliersRegion>().lambda()
                .eq(SuppliersRegion::getProvCode, supplier.getProvCode()).last("LIMIT 1"));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        System.out.println(supplier);
        boolean save = service.save(supplier);
        if (save) {
            supplier.getContacts().setColumn1(supplier.getSid().toString());
            if ((supplier.getContacts().getScName() != null && !"".equals(supplier.getContacts().getScName()))
                    || (supplier.getContacts().getScTelephone() != null && !"".equals(supplier.getContacts().getScTelephone()))
                    || (supplier.getContacts().getScPhone() != null && !"".equals(supplier.getContacts().getScPhone()))) {
                contactsService.save(supplier.getContacts());
            }
        }
        return new ResultVO();
    }

    /**
     * 修改供货商资料
     *
     * @param supplier
     * @return
     */
    @PostMapping("/upd")
    public ResultVO updSupplier(@RequestBody SuppliersRegion supplier) {
        if (!supplier.getBeforeId().equals(supplier.getProvCode())) {
            SuppliersRegion byId = service.getOne(new QueryWrapper<SuppliersRegion>().lambda()
                    .eq(SuppliersRegion::getProvCode, supplier.getProvCode()));
            if (byId != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        boolean save = service.updateById(supplier);
        if (supplier.getContacts().getScId() != null) {
            contactsService.updateById(supplier.getContacts());
        }
        return new ResultVO();
    }

    /**
     * 逻辑删除 供货商
     *
     * @param sid
     * @return
     */
    @PostMapping("/del/{sid}")
    public ResultVO delSupplier(@PathVariable Integer sid) {
        if (sid != null) {
            service.removeById(sid);
            return new ResultVO(ResultCode.SUCCESS);
        }
        return new ResultVO(ResultCode.ID_NOT_NULL);
    }

    /**
     * 按条件搜索
     *
     * @param region
     * @return
     */
    @PostMapping("/searchsupplier")
    public ResultVO searchSupplier(SuppliersRegion region) {
//        System.out.println(region);
        return new ResultVO(ResultCode.SUCCESS, service.serachSupplier(region));
    }


    /**
     * 导出全部
     *
     * @param exportColumn
     * @return
     */
    @RequestMapping("/downloadexcelall")
    public ResponseEntity downloadExcelAll(String exportColumn) throws IOException {
        //查询要导出的数据
        return toExcel(exportColumn, service.list());
    }

    /**
     * 默认条件 按当前父级分类查询导出
     *
     * @param exportColumn
     * @return
     */
    @RequestMapping("/downloadexceleearch")
    public ResponseEntity downloadExcelSearch(String regionId, String exportColumn) throws IOException {
        List<SuppliersRegion> suppliersRegions = service.toFind(regionId);
        return toExcel(exportColumn, suppliersRegions);
    }

    /**
     * 按多条件查询结果导出
     *
     * @param jsonGoods
     * @param exportColumn
     * @return
     */
    @RequestMapping("/downloadexcel")
    public ResponseEntity downloadExcel(String jsonGoods, String exportColumn) throws IOException {
        jsonGoods = jsonGoods.substring(1, jsonGoods.length() - 1);
//        System.out.println(jsonGoods);
        SuppliersRegion suppliersRegion = objectMapper.readValue(jsonGoods, SuppliersRegion.class);
        List<SuppliersRegion> suppliersRegions = service.serachSupplier(suppliersRegion);
        return toExcel(exportColumn, suppliersRegions);
    }

    /**
     * 导出Excel方法
     *
     * @param exportColumn
     * @param suppliersRegionList
     * @return
     * @throws IOException
     */
    public ResponseEntity toExcel(String exportColumn, List<SuppliersRegion> suppliersRegionList) throws IOException {
        exportColumn = exportColumn.substring(1, exportColumn.length() - 1);
        List<DzwColumnController> list = objectMapper.readValue(exportColumn, new TypeReference<List<DzwColumnController>>() {/**/
        });
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();

        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        for (int i = 0; i < list.size(); i++) {
            rowTitle.createCell(i).setCellValue(list.get(i).getColumn1());
        }

        if (suppliersRegionList != null) {
            for (int i = suppliersRegionList.size() - 1; i >= 0; i--) {
                SuppliersRegion suppliersRegion = suppliersRegionList.get(i);
                List<SuppliersContacts> relation = suppliersRegion.getRelation();
                Row rowValue = sheet.createRow(i + 1);
                for (int k = 0; k < list.size(); k++) {
                    switch (list.get(k).getColumn1()) {
                        case "厂商代码":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getProvCode());
                            break;
                        case "厂商名称":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getProvName());
                            break;
                        case "地址":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getAddress());
                            break;
                        case "经营情况":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getOperation());
                            break;
                        case "网址":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getHttpA());
                            break;
                        case "开户行":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getKhyh());
                            break;
                        case "银行账号":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getYhzh());
                            break;
                        case "付款方式":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getPaymentMethod().getPmethod());
                            break;
                        case "厂商等级":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getFrimGrade().getFgrade());
                            break;
                        case "经营品牌":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getZd2());
                            break;
                        case "厂商类别":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getRegionCity().getRegionName());
                            break;
                        case "联系人":
                            if (relation != null || relation.size() > 0) {
                                rowValue.createCell(k).setCellValue(relation.get(0).getScName());
                            } else {
                                rowValue.createCell(k).setCellValue("");
                            }
                            break;
                        case "电话":
                            if (relation != null || relation.size() > 0) {
                                rowValue.createCell(k).setCellValue(relation.get(0).getScTelephone());
                            } else {
                                rowValue.createCell(k).setCellValue("");
                            }
                            break;
                        case "手机":
                            if (relation != null || relation.size() > 0) {
                                rowValue.createCell(k).setCellValue(relation.get(0).getScPhone());
                            } else {
                                rowValue.createCell(k).setCellValue("");
                            }
                            break;
                        case "Email":
                            if (relation != null || relation.size() > 0) {
                                rowValue.createCell(k).setCellValue(relation.get(0).getEmail());
                            } else {
                                rowValue.createCell(k).setCellValue("");
                            }
                            break;
                        case "账期（天）":
                            Integer preday = suppliersRegion.getPreDay();
                            String value = preday == null ? "" : preday.toString();
                            rowValue.createCell(k).setCellValue(value);
                            break;
                        case "备注":
                            rowValue.createCell(k).setCellValue(suppliersRegion.getRemark());
                            break;
                    }
                }
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        book.write(byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        //设置响应内容为文件流模式
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String("供货商信息导出.xlsx".getBytes("utf-8"), "iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }

}

