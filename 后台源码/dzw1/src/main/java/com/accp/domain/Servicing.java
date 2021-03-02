package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dsy
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Servicing对象", description="")
public class Servicing extends Model<Servicing> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修单号")
    private String serNumber;

    @ApiModelProperty(value = "车牌号")
    private String serChepai;

    @ApiModelProperty(value = "车架号")
    private String serChejia;

    @ApiModelProperty(value = "车辆型号")
    private String serChexinhao;

    @ApiModelProperty(value = "车辆品牌")
    private String serCarbrand;

    @ApiModelProperty(value = "发动机号")
    private String serMotornumber;

    @ApiModelProperty(value = "发动机品牌")
    private String serMotorbrand;

    @ApiModelProperty(value = "服务顾问")
    private String serServiceguwen;

    @ApiModelProperty(value = "车主姓名")
    private String serCarzhuname;

    @ApiModelProperty(value = "驾驶员")
    private String serDriver;

    @ApiModelProperty(value = "联系电话")
    private String serLianxiphone;

    @ApiModelProperty(value = "进厂里程")
    private String serJinchanglicheng;

    @ApiModelProperty(value = "进厂油量")
    private String serJinchangyl;

    @ApiModelProperty(value = "上次里程")
    private String serShangcilicheng;

    @ApiModelProperty(value = "进厂时间")
    private String serJctime;

    @ApiModelProperty(value = "业务类别")
    private String serServietype;

    @ApiModelProperty(value = "施工班次")
    private String serSgbanci;

    @ApiModelProperty(value = "接车人")
    private String serJiecaruser;

    @ApiModelProperty(value = "预计完工")
    private String serExpecttime;

    @ApiModelProperty(value = "结算方式")
    private String serJsfangshi;

    @ApiModelProperty(value = "赔款公司")
    private String serPeikuan;

    @ApiModelProperty(value = "完工时间")
    private String serSgtime;

    @ApiModelProperty(value = "上次进厂")
    private String serScjinchang;

    @ApiModelProperty(value = "预估金额")
    private Double serExpectmoney;

    @ApiModelProperty(value = "接待备注")
    private String serJdbeizu;

    @ApiModelProperty(value = "派工时间")
    private String serPaigtime;

    @ApiModelProperty(value = "当前里程")
    private String serDqlicheng;

    @ApiModelProperty(value = "派班机组")
    private String serPaigbz;

    @ApiModelProperty(value = "出发时间")
    private String serChufatime;

    @ApiModelProperty(value = "出发地址")
    private String serChufaadress;

    @ApiModelProperty(value = "驾驶车辆")
    private String serJiashicar;

    @ApiModelProperty(value = "行驶里程")
    private String serXinshilicheng;

    @ApiModelProperty(value = "施工时间")
    private String serShigongtime;

    @ApiModelProperty(value = "救援地址")
    private String serJyadess;

    @ApiModelProperty(value = "备用列1")
    private String column1;

    @ApiModelProperty(value = "备用列2")
    private String column2;

    @ApiModelProperty(value = "备用列3")
    private String column3;

    @TableField(exist = false)
    private  Cargoods cargoods;

    @TableField(exist = false)
    private List<Servicingproject> list;



    public static final String SER_NUMBER = "ser_number";

    public static final String SER_CHEPAI = "ser_chepai";

    public static final String SER_CHEJIA = "ser_chejia";

    public static final String SER_CHEXINHAO = "ser_chexinhao";

    public static final String SER_CARBRAND = "ser_carbrand";

    public static final String SER_MOTORNUMBER = "ser_motornumber";

    public static final String SER_MOTORBRAND = "ser_motorbrand";

    public static final String SER_SERVICEGUWEN = "ser_serviceguwen";

    public static final String SER_CARZHUNAME = "ser_carzhuname";

    public static final String SER_DRIVER = "ser_driver";

    public static final String SER_LIANXIPHONE = "ser_lianxiphone";

    public static final String SER_JINCHANGLICHENG = "ser_jinchanglicheng";

    public static final String SER_JINCHANGYL = "ser_jinchangyl";

    public static final String SER_SHANGCILICHENG = "ser_shangcilicheng";

    public static final String SER_JCTIME = "ser_jctime";

    public static final String SER_SERVIETYPE = "ser_servietype";

    public static final String SER_SGBANCI = "ser_sgbanci";

    public static final String SER_JIECARUSER = "ser_jiecaruser";

    public static final String SER_EXPECTTIME = "ser_expecttime";

    public static final String SER_JSFANGSHI = "ser_jsfangshi";

    public static final String SER_PEIKUAN = "ser_peikuan";

    public static final String SER_SGTIME = "ser_sgtime";

    public static final String SER_SCJINCHANG = "ser_scjinchang";

    public static final String SER_EXPECTMONEY = "ser_expectmoney";

    public static final String SER_JDBEIZU = "ser_jdbeizu";

    public static final String SER_PAIGTIME = "ser_paigtime";

    public static final String SER_DQLICHENG = "ser_dqlicheng";

    public static final String SER_PAIGBZ = "ser_paigbz";

    public static final String SER_CHUFATIME = "ser_chufatime";

    public static final String SER_CHUFAADRESS = "ser_chufaadress";

    public static final String SER_JIASHICAR = "ser_jiashicar";

    public static final String SER_XINSHILICHENG = "ser_xinshilicheng";

    public static final String SER_SHIGONGTIME = "ser_shigongtime";

    public static final String SER_JYADESS = "ser_jyadess";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.serNumber;
    }

}
