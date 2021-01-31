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
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="List-of-sales对象", description="")
public class List-of-sales extends Model<List-of-sales> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "销售单号")
    private String sales-order;

    @ApiModelProperty(value = "单据类型")
    @TableField("billsType")
    private String billsType;

    @ApiModelProperty(value = "结算方式")
    private String balance;

    @ApiModelProperty(value = "单据状态")
    private String billstatus;

    @ApiModelProperty(value = "结算状态")
    private String settlement-status;

    @ApiModelProperty(value = "结算时间")
    private String settlement-time;

    @ApiModelProperty(value = "结算人")
    private String settlement-user;

    @ApiModelProperty(value = "结算金额")
    private Integer settlement-money;

    @ApiModelProperty(value = "业务类型")
    private String service-type;

    @ApiModelProperty(value = "客户名称")
    private String username;

    @ApiModelProperty(value = "车牌号")
    private String plate-number;

    @ApiModelProperty(value = "车型")
    private String motorcycle-type;

    @ApiModelProperty(value = "车架号")
    private String frame;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "保险公司")
    private String insurer;

    @ApiModelProperty(value = "赔款公司")
    @TableField("Indemnity-company")
    private String Indemnity-company;

    @ApiModelProperty(value = "对方车牌")
    private String license-plate;

    @ApiModelProperty(value = "服务顾问")
    @TableField("service-Adviser")
    private String service-Adviser;

    @ApiModelProperty(value = "完工时间")
    private String completion-time;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String SALES-ORDER = "sales-order";

    public static final String BILLSTYPE = "billsType";

    public static final String BALANCE = "balance";

    public static final String BILLSTATUS = "billstatus";

    public static final String SETTLEMENT-STATUS = "settlement-status";

    public static final String SETTLEMENT-TIME = "settlement-time";

    public static final String SETTLEMENT-USER = "settlement-user";

    public static final String SETTLEMENT-MONEY = "settlement-money";

    public static final String SERVICE-TYPE = "service-type";

    public static final String USERNAME = "username";

    public static final String PLATE-NUMBER = "plate-number";

    public static final String MOTORCYCLE-TYPE = "motorcycle-type";

    public static final String FRAME = "frame";

    public static final String PHONE = "phone";

    public static final String INSURER = "insurer";

    public static final String INDEMNITY-COMPANY = "Indemnity-company";

    public static final String LICENSE-PLATE = "license-plate";

    public static final String SERVICE-ADVISER = "service-Adviser";

    public static final String COMPLETION-TIME = "completion-time";

    public static final String REMARKS = "remarks";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.sales-order;
    }

}
