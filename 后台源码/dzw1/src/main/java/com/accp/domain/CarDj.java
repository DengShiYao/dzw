package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CarDj对象", description="")
public class CarDj extends Model<CarDj> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车辆ID")
    private Integer carId;

    @ApiModelProperty(value = "业务类型")
    private String carType;

    @ApiModelProperty(value = "客户名称")
    private String carName;

    @ApiModelProperty(value = "车牌号")
    private String carCph;

    @ApiModelProperty(value = "手机号")
    private String carSjh;

    @ApiModelProperty(value = "会员卡号")
    private String carHhkh;

    @ApiModelProperty(value = "维修单号")
    private String carWxdh;

    @ApiModelProperty(value = "单据类型")
    private String carDjlx;

    @ApiModelProperty(value = "开单时间")
    private LocalDateTime carKdsj;

    @ApiModelProperty(value = "完工时间")
    private LocalDateTime carWgsj;

    @ApiModelProperty(value = "结算时间")
    private LocalDateTime carJsjsj;

    @ApiModelProperty(value = "预估金额")
    private Double carYgjh;

    @ApiModelProperty(value = "服务顾问名称")
    private String carWhgwmc;

    @ApiModelProperty(value = "接车人名称")
    private String carJcr;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String CAR_ID = "car_id";

    public static final String CAR_TYPE = "car_type";

    public static final String CAR_NAME = "car_name";

    public static final String CAR_CPH = "car_cph";

    public static final String CAR_SJH = "car_sjh";

    public static final String CAR_HHKH = "car_hhkh";

    public static final String CAR_WXDH = "car_wxdh";

    public static final String CAR_DJLX = "car_djlx";

    public static final String CAR_KDSJ = "car_kdsj";

    public static final String CAR_WGSJ = "car_wgsj";

    public static final String CAR_JSJSJ = "car_jsjsj";

    public static final String CAR_YGJH = "car_ygjh";

    public static final String CAR_WHGWMC = "car_whgwmc";

    public static final String CAR_JCR = "car_jcr";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.carId;
    }

}
