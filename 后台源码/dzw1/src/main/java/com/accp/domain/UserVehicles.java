package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
@ApiModel(value="UserVehicles对象", description="")
public class UserVehicles extends Model<UserVehicles> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车辆编号")
    private Integer uvehicleid;

    @ApiModelProperty(value = "型号序号")
    private Integer vtypeid;

    @ApiModelProperty(value = "品牌序号")
    private Integer vbrandid;

    @ApiModelProperty(value = "用户序号")
    private Integer userid;

    @ApiModelProperty(value = "归属编号")
    private Integer affiliationid;

    @ApiModelProperty(value = "车牌号")
    private String ulicense;

    @ApiModelProperty(value = "驾驶员")
    private String resdriver;

    @ApiModelProperty(value = "驾驶员手机号")
    private String driverphone;

    @ApiModelProperty(value = "里程")
    private Integer umileage;

    @ApiModelProperty(value = "上牌日期")
    private LocalDate registereddate;

    @ApiModelProperty(value = "购买日期")
    private LocalDate buydate;

    @ApiModelProperty(value = "客户id")
    private Integer khid;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String UVEHICLEID = "uvehicleid";

    public static final String VTYPEID = "vtypeid";

    public static final String VBRANDID = "vbrandid";

    public static final String USERID = "userid";

    public static final String AFFILIATIONID = "affiliationid";

    public static final String ULICENSE = "ulicense";

    public static final String RESDRIVER = "resdriver";

    public static final String DRIVERPHONE = "driverphone";

    public static final String UMILEAGE = "umileage";

    public static final String REGISTEREDDATE = "registereddate";

    public static final String BUYDATE = "buydate";

    public static final String KHID = "khid";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
