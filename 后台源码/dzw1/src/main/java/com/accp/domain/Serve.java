package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value="Serve对象", description="")
public class Serve extends Model<Serve> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "项目编码")
    private String seId;

    @ApiModelProperty(value = "项目名称")
    private String seName;

    @ApiModelProperty(value = "收入种类")
    private String iId;

    @ApiModelProperty(value = "项目类别")
    private String brandId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "标准价")
    private Double price;

    @ApiModelProperty(value = "会员价")
    private Double memberPrice;

    @ApiModelProperty(value = "	VIP价")
    private Double vipPrice;

    @ApiModelProperty(value = "协议价")
    private Double protocolPrice;

    @ApiModelProperty(value = "索赔价")
    private Double claimPrice;

    @ApiModelProperty(value = "保险价格")
    private Double insurancePrice;

    @ApiModelProperty(value = "真假删除 0假/1真")
    @TableLogic
    private Integer booldel;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @ApiModelProperty(value = "修改前的ID")
    @TableField(exist = false)
    private String beforeId;


    public static final String SE_ID = "se_id";

    public static final String SE_NAME = "se_name";

    public static final String I_ID = "i_id";

    public static final String BRAND_ID = "brand_id";

    public static final String REMARK = "remark";

    public static final String PRICE = "price";

    public static final String MEMBER_PRICE = "member_price";

    public static final String VIP_PRICE = "vip_price";

    public static final String PROTOCOL_PRICE = "protocol_price";

    public static final String CLAIM_PRICE = "claim_price";

    public static final String INSURANCE_PRICE = "insurance_price";

    public static final String BOOLDEL = "booldel";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.seId;
    }

}
