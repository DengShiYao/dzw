package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ListOfSales对象", description="")
public class ListOfSales extends Model<ListOfSales> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "销售单号")
    private String salesOrder;

    @ApiModelProperty(value = "单据类型")
    @TableField("billsType")
    private String billsType;

    @ApiModelProperty(value = "结算方式")
    private String balance;

    @ApiModelProperty(value = "单据状态")
    private String billstatus;

    @ApiModelProperty(value = "结算状态")
    private String settlementStatus;

    @ApiModelProperty(value = "结算时间")
    private String settlementTime;

    @ApiModelProperty(value = "结算人")
    private String settlementUser;

    @ApiModelProperty(value = "结算金额")
    private Integer settlementMoney;

    @ApiModelProperty(value = "业务类型")
    private String serviceType;

    @ApiModelProperty(value = "客户名称")
    private String username;

    @ApiModelProperty(value = "车牌号")
    private String plateNumber;

    @ApiModelProperty(value = "车型")
    private String motorcycleType;

    @ApiModelProperty(value = "车架号")
    private String frame;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "保险公司")
    private String insurer;

    @ApiModelProperty(value = "赔款公司")
    @TableField("Indemnity_company")
    private String indemnityCompany;

    @ApiModelProperty(value = "对方车牌")
    private String licensePlate;

    @ApiModelProperty(value = "服务顾问")
    @TableField("service_Adviser")
    private String serviceAdviser;

    @ApiModelProperty(value = "完工时间")
    private String completionTime;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String SALES_ORDER = "sales_order";

    public static final String BILLSTYPE = "billsType";

    public static final String BALANCE = "balance";

    public static final String BILLSTATUS = "billstatus";

    public static final String SETTLEMENT_STATUS = "settlement_status";

    public static final String SETTLEMENT_TIME = "settlement_time";

    public static final String SETTLEMENT_USER = "settlement_user";

    public static final String SETTLEMENT_MONEY = "settlement_money";

    public static final String SERVICE_TYPE = "service_type";

    public static final String USERNAME = "username";

    public static final String PLATE_NUMBER = "plate_number";

    public static final String MOTORCYCLE_TYPE = "motorcycle_type";

    public static final String FRAME = "frame";

    public static final String PHONE = "phone";

    public static final String INSURER = "insurer";

    public static final String INDEMNITY_COMPANY = "Indemnity_company";

    public static final String LICENSE_PLATE = "license_plate";

    public static final String SERVICE_ADVISER = "service_Adviser";

    public static final String COMPLETION_TIME = "completion_time";

    public static final String REMARKS = "remarks";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.salesOrder;
    }

}
