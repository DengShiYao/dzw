package com.accp.controller;


import com.accp.domain.DzwColumnController;
import com.accp.domain.Goods;
import com.accp.result.ResultCode;
import com.accp.result.ResultVO;
import com.accp.service.impl.DzwColumnControllerServiceImpl;
import com.accp.service.impl.GoodsServiceImpl;
import com.accp.vo.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
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
 *  前端控制器
 * </p>
 *  商品详情
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsServiceImpl service;
    @Autowired
    DzwColumnControllerServiceImpl dzwColumnControllerService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 查询商品列表
     * @param blockUp
     * @param column1
     * @return
     */
    @PostMapping("/find")
    public ResultVO selGoodsPage(Integer current,Integer blockUp, Integer column1){
        Page<Goods> page = new Page();
        page.setCurrent(current==null ? 0 :current);
        page.setSize(5);
        Page<Goods> mapIPage = service.selGoodsPage(page, blockUp, column1);
        return new ResultVO(mapIPage);
    }

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @PostMapping("/ins")
    public ResultVO saveInsGoods(@Valid @RequestBody Goods goods){
        Goods one = service.getOne(new QueryWrapper<Goods>().lambda().eq(Goods::getGoodsId, goods.getGoodsId()));
        if (one != null) {
            return new ResultVO(ResultCode.PEY_EXIT);
        }
        service.save(goods);
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @PostMapping("/upd")
    public ResultVO saveUpdGoods(@Valid @RequestBody Goods goods){
        if (!goods.getBeforeId().equals(goods.getGoodsId())) {
            Goods one = service.getOne(new QueryWrapper<Goods>().lambda().eq(Goods::getGoodsId, goods.getGoodsId()));
            if (one != null) {
                return new ResultVO(ResultCode.PEY_EXIT);
            }
        }
        service.updateById(goods);
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 逻辑删除商品
     * @param goodsAutoId
     * @return
     */
    @PostMapping("remove")
    public ResultVO removeGoods(Integer goodsAutoId){
        if (goodsAutoId==null){
            return new ResultVO(ResultCode.ID_NOT_NULL);
        }
        return new ResultVO(ResultCode.SUCCESS,service.removeById(goodsAutoId));
    }

    /**
     * 按条件查询商品分页
     * @param goods
     * @param current
     * @return
     */
    @PostMapping("/searchgoods")
    public ResultVO search(Goods goods, Integer current){
        System.out.println(goods);
        Page<Goods> page = new Page();
        page.setCurrent(current==null ? 0 :current);
        page.setSize(15);
        Page<Goods> mapIPage = service.searchGoodsPage(page,goods);
        return new ResultVO(mapIPage);
    }


    /**
     * 导出全部
     * @param exportColumn
     * @return
     */
    @RequestMapping("/downloadexcelall")
    public ResponseEntity downloadExcelAll(String exportColumn) throws IOException {
        exportColumn = exportColumn.substring(1,exportColumn.length()-1);
        List<DzwColumnController> list = objectMapper.readValue(exportColumn, new TypeReference<List<DzwColumnController>>() {/**/});
        System.out.println(exportColumn);
        //查询要导出的数据
        List<Goods> goodsList = service.goodsListAll();
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet();
//        Font font = book.createFont();
//        font.setBold(true);
//        CellStyle cellStyle = book.createCellStyle();
//        cellStyle.setFont(font);

        //导出excel头部
        Row rowTitle = sheet.createRow(0);
        for (int i = 0; i < list.size(); i++) {
            rowTitle.createCell(i).setCellValue(list.get(i).getColumn1());
        }

        if (goodsList != null) {
            for (int i = goodsList.size()-1; i >= 0; i--) {
                Goods goodsValue = goodsList.get(i);
                Row rowValue = sheet.createRow(i+1);
                for (int k = 0; k < list.size(); k++) {
                    switch(list.get(k).getColumn1()){
                        case "商品编码" :
                            rowValue.createCell(k).setCellValue(goodsValue.getGoodsId());
                            break;
                        case "商品名称" :
                            rowValue.createCell(k).setCellValue(goodsValue.getGoodsName());
                            break;
                        case "商品品牌" :
                            rowValue.createCell(k).setCellValue(goodsValue.getGoodsBrand().getGbName());
                            break;
                        case "适用车型" :
                            rowValue.createCell(k).setCellValue(goodsValue.getEngineType());
                            break;
                        case "数量单位" :
                            rowValue.createCell(k).setCellValue(goodsValue.getUnit());
                            break;
                        case "商品类别" :
                            rowValue.createCell(k).setCellValue(goodsValue.getGoodsCategory().getGoodsName());
                            break;
                        case "收入分类" :
                            rowValue.createCell(k).setCellValue(goodsValue.getIId());
                            break;
                        case "原厂副厂" :
                            rowValue.createCell(k).setCellValue(goodsValue.getSpec5());
                            break;
                        case "商品等级" :
                            rowValue.createCell(k).setCellValue(goodsValue.getSpec6());
                            break;
                        case "商品产地" :
                            rowValue.createCell(k).setCellValue(goodsValue.getProvinces().getProvince());
                            break;
                        case "厂商名称" :
                            rowValue.createCell(k).setCellValue(goodsValue.getSuppliersRegion().getProvName());
                            break;
                        case "原厂编码" :
                            rowValue.createCell(k).setCellValue(goodsValue.getOldBM());
                            break;
                        case "条形码" :
                            rowValue.createCell(k).setCellValue(goodsValue.getItemTM());
                            break;
                        case "包装规格" :
                            rowValue.createCell(k).setCellValue(goodsValue.getPackSpec());
                            break;
                        case "体积" :
                            rowValue.createCell(k).setCellValue(goodsValue.getSpec());
                            break;
                        case "毛重" :
                            rowValue.createCell(k).setCellValue(goodsValue.getGrossWeight());
                            break;
                        case "净重" :
                            rowValue.createCell(k).setCellValue(goodsValue.getNetWeight());
                            break;
                        case "加价率" :
                            rowValue.createCell(k).setCellValue(goodsValue.getMZScale());
                            break;
                        case "互换码" :
                            rowValue.createCell(k).setCellValue(goodsValue.getInterchangeNo());
                            break;
                        case "售价按" :
                            rowValue.createCell(k).setCellValue(goodsValue.getZd3());
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
        String fileName = new String("商品信息导出数据.xlsx".getBytes("utf-8"),"iso-8859-1");
        //设置响应的文件的名称
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);

    }

    @RequestMapping("/downloadexcel")
    public void downloadExcel(Goods goods, List<DzwColumnShowController> list){

    }

}

