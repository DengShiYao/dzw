package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Cargoods对象", description="")
public class Cargoods extends Model<Cargoods> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单号")
    private String carNumber;

    @ApiModelProperty(value = "状态(0接车1作业中2完工）")
    private Integer carStatus;

    @ApiModelProperty(value = "业务类型")
    private String carServicetype;

    @ApiModelProperty(value = "客户名称")
    private String carUsername;

    @ApiModelProperty(value = "车牌号")
    private String carChepai;

    @ApiModelProperty(value = "手机")
    private String carPhone;

    @ApiModelProperty(value = "会员卡号")
    private String carVipnumber;

    @ApiModelProperty(value = "单据类型")
    private String carDjtype;

    @ApiModelProperty(value = "开单时间")
    private String carBegintime;

    @ApiModelProperty(value = "预计时间")
    private String carExpecttime;

    @ApiModelProperty(value = "完工时间")
    private String carEndtime;

    @ApiModelProperty(value = "结算时间")
    private String carJstime;

    @ApiModelProperty(value = "预计金额")
    private Double carExpectmoney;

    @ApiModelProperty(value = "服务顾问")
    private String carServiceguwen;

    @ApiModelProperty(value = "接车人")
    private String carJiecheuser;

    @ApiModelProperty(value = "备用列1")
    private String column1;

    @ApiModelProperty(value = "备用列2")
    private String column2;

    @ApiModelProperty(value = "备用列3")
    private String column3;


    public static final String CAR_NUMBER = "car_number";

    public static final String CAR_STATUS = "car_status";

    public static final String CAR_SERVICETYPE = "car_servicetype";

    public static final String CAR_USERNAME = "car_username";

    public static final String CAR_CHEPAI = "car_chepai";

    public static final String CAR_PHONE = "car_phone";

    public static final String CAR_VIPNUMBER = "car_vipnumber";

    public static final String CAR_DJTYPE = "car_djtype";

    public static final String CAR_BEGINTIME = "car_begintime";

    public static final String CAR_EXPECTTIME = "car_expecttime";

    public static final String CAR_ENDTIME = "car_endtime";

    public static final String CAR_JSTIME = "car_jstime";

    public static final String CAR_EXPECTMONEY = "car_expectmoney";

    public static final String CAR_SERVICEGUWEN = "car_serviceguwen";

    public static final String CAR_JIECHEUSER = "car_jiecheuser";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.carNumber;
    }

}
