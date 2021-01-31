package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="SuppliersRegion对象", description="")
public class SuppliersRegion extends Model<SuppliersRegion> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    @ApiModelProperty(value = "厂商代码")
    @TableField("ProvCode")
    private String ProvCode;

    @ApiModelProperty(value = "厂商名称")
    @TableField("ProvName")
    private String ProvName;

    @ApiModelProperty(value = "地址")
    @TableField("Address")
    private String Address;

    @ApiModelProperty(value = "经营情况")
    @TableField("Operation")
    private String Operation;

    @ApiModelProperty(value = "经营情况")
    @TableField("HttpA")
    private String HttpA;

    @ApiModelProperty(value = "开户行")
    @TableField("KHYH")
    private String khyh;

    @ApiModelProperty(value = "银行账户")
    @TableField("YHZH")
    private String yhzh;

    @ApiModelProperty(value = "支付方式")
    private Integer pmId;

    @ApiModelProperty(value = "厂商等级")
    private Integer fgId;

    @ApiModelProperty(value = "经营品牌")
    @TableField("ZD2")
    private String zd2;

    @ApiModelProperty(value = "厂商类别")
    @TableField("ProvType")
    private String ProvType;

    @ApiModelProperty(value = "供货商联系人")
    private Integer scId;

    @ApiModelProperty(value = "账期（天）")
    @TableField("PreDay")
    private Integer PreDay;

    @ApiModelProperty(value = "备注")
    @TableField("Remark")
    private String Remark;

    @ApiModelProperty(value = "所属地区")
    private String regionId;

    @ApiModelProperty(value = "0停用/1启用")
    private Integer blockUp;

    @ApiModelProperty(value = "字段宽度")
    private Double suppliersWidth;

    @ApiModelProperty(value = "0隐藏/1显示")
    private Integer suppliersShow;

    @ApiModelProperty(value = "真假删除 0假/1真")
    private Integer booldel;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String SID = "sid";

    public static final String PROVCODE = "ProvCode";

    public static final String PROVNAME = "ProvName";

    public static final String ADDRESS = "Address";

    public static final String OPERATION = "Operation";

    public static final String HTTPA = "HttpA";

    public static final String KHYH = "KHYH";

    public static final String YHZH = "YHZH";

    public static final String PM_ID = "pm_id";

    public static final String FG_ID = "fg_id";

    public static final String ZD2 = "ZD2";

    public static final String PROVTYPE = "ProvType";

    public static final String SC_ID = "sc_id";

    public static final String PREDAY = "PreDay";

    public static final String REMARK = "Remark";

    public static final String REGION_ID = "region_id";

    public static final String BLOCK_UP = "block_up";

    public static final String SUPPLIERS_WIDTH = "suppliers_width";

    public static final String SUPPLIERS_SHOW = "suppliers_show";

    public static final String BOOLDEL = "booldel";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

}
