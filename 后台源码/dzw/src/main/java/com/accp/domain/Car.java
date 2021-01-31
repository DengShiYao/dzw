package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Car对象", description="")
public class Car extends Model<Car> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车牌号码")
    private String carCph;

    @ApiModelProperty(value = "车辆品牌")
    private String carClpp;

    @ApiModelProperty(value = "车辆型号")
    private String carType;

    @ApiModelProperty(value = "驾驶员")
    private String carJsy;

    @ApiModelProperty(value = "驾驶员电话")
    @TableField("car_Phone")
    private String carPhone;

    @ApiModelProperty(value = "出生日期")
    private LocalDateTime carCsrq;

    @ApiModelProperty(value = "车辆归属")
    private String carClgs;

    @ApiModelProperty(value = "驾驶员地址")
    private String carJsydz;

    @ApiModelProperty(value = "驾照到期日期")
    private LocalDateTime carJzdq;

    @ApiModelProperty(value = "车架号")
    private String carCjh;

    @ApiModelProperty(value = "发动机号")
    private String carFdjh;

    @ApiModelProperty(value = "发动机品牌号")
    private String carFdjpph;

    @ApiModelProperty(value = "车辆年款")
    private String carCllk;

    @ApiModelProperty(value = "里程")
    private String carLc;

    @ApiModelProperty(value = "载重")
    private String carZz;

    @ApiModelProperty(value = "车系")
    private String carCx;

    @ApiModelProperty(value = "购买日期")
    private LocalDateTime carGmrq;

    @ApiModelProperty(value = "上牌日期")
    private LocalDateTime carSprq;

    @ApiModelProperty(value = "车检到期")
    private LocalDateTime carCjdq;

    @ApiModelProperty(value = "交强险保险公司")
    private String carjqxbxgs;

    @ApiModelProperty(value = "交强险到期日期")
    private LocalDateTime carJqxdq;

    @ApiModelProperty(value = "是否在我投保车中")
    private String carSf;

    @ApiModelProperty(value = "二维日期")
    private LocalDateTime carEwrq;

    @ApiModelProperty(value = "燃油类别")
    private String carRylb;

    @ApiModelProperty(value = "下次保养里程")
    private String carXcbylc;

    @ApiModelProperty(value = "下次保养日期")
    private LocalDateTime carXcbyrq;

    @ApiModelProperty(value = "会员码")
    private String carHym;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用给")
    private String column3;


    public static final String CAR_CPH = "car_cph";

    public static final String CAR_CLPP = "car_clpp";

    public static final String CAR_TYPE = "car_type";

    public static final String CAR_JSY = "car_jsy";

    public static final String CAR_PHONE = "car_Phone";

    public static final String CAR_CSRQ = "car_csrq";

    public static final String CAR_CLGS = "car_clgs";

    public static final String CAR_JSYDZ = "car_jsydz";

    public static final String CAR_JZDQ = "car_jzdq";

    public static final String CAR_CJH = "car_cjh";

    public static final String CAR_FDJH = "car_fdjh";

    public static final String CAR_FDJPPH = "car_fdjpph";

    public static final String CAR_CLLK = "car_cllk";

    public static final String CAR_LC = "car_lc";

    public static final String CAR_ZZ = "car_zz";

    public static final String CAR_CX = "car_cx";

    public static final String CAR_GMRQ = "car_gmrq";

    public static final String CAR_SPRQ = "car_sprq";

    public static final String CAR_CJDQ = "car_cjdq";

    public static final String CARJQXBXGS = "carjqxbxgs";

    public static final String CAR_JQXDQ = "car_jqxdq";

    public static final String CAR_SF = "car_sf";

    public static final String CAR_EWRQ = "car_ewrq";

    public static final String CAR_RYLB = "car_rylb";

    public static final String CAR_XCBYLC = "car_xcbylc";

    public static final String CAR_XCBYRQ = "car_xcbyrq";

    public static final String CAR_HYM = "car_hym";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.carCph;
    }

}
