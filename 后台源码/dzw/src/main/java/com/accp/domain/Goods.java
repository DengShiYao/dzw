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
@ApiModel(value="Goods对象", description="")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品编码")
    private String goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品品牌")
    private Integer gbId;

    @ApiModelProperty(value = "适用车型")
    private String engineType;

    @ApiModelProperty(value = "数量单位")
    @TableField("Unit")
    private String Unit;

    @ApiModelProperty(value = "商品类别")
    private String goodsCId;

    @ApiModelProperty(value = "收入分类")
    private Integer iId;

    @ApiModelProperty(value = "原厂副厂")
    @TableField("Spec5")
    private String Spec5;

    @ApiModelProperty(value = "商品等级")
    @TableField("Spec6")
    private String Spec6;

    @ApiModelProperty(value = "商品产地")
    private Integer proId;

    @ApiModelProperty(value = "厂商代码")
    @TableField("ProvCode")
    private String ProvCode;

    @ApiModelProperty(value = "厂商名称")
    @TableField("ProvName")
    private String ProvName;

    @ApiModelProperty(value = "原厂编码")
    @TableField("OldBM")
    private String OldBM;

    @ApiModelProperty(value = "条形码")
    @TableField("ItemTM")
    private String ItemTM;

    @ApiModelProperty(value = "包装规格")
    @TableField("PackSpec")
    private String PackSpec;

    @ApiModelProperty(value = "体积A")
    @TableField("Spec")
    private String Spec;

    @ApiModelProperty(value = "毛重")
    @TableField("GrossWeight")
    private String GrossWeight;

    @ApiModelProperty(value = "净重")
    @TableField("NetWeight")
    private String NetWeight;

    @ApiModelProperty(value = "加价率")
    @TableField("MZScale")
    private String MZScale;

    @ApiModelProperty(value = "互换码")
    @TableField("InterchangeNo")
    private String InterchangeNo;

    @ApiModelProperty(value = "售价按")
    @TableField("ZD3")
    private String zd3;

    @ApiModelProperty(value = "标准价")
    private Double price;

    @ApiModelProperty(value = "会员价")
    private Double memberPrice;

    @ApiModelProperty(value = "VIP价")
    private Double vipPrice;

    @ApiModelProperty(value = "协议价")
    private Double protocolPrice;

    @ApiModelProperty(value = "索赔价")
    private Double claimPrice;

    @ApiModelProperty(value = "保险价格")
    private Double insurancePrice;

    @ApiModelProperty(value = "0停用/1启用")
    private Integer blockUp;

    @ApiModelProperty(value = "字段宽度")
    private Double goodWidth;

    @ApiModelProperty(value = "0隐藏/1显示")
    private Integer goodShow;

    @ApiModelProperty(value = "真假删除 0假/1真")
    private Integer booldel;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String GOODS_ID = "goods_id";

    public static final String GOODS_NAME = "goods_name";

    public static final String GB_ID = "gb_id";

    public static final String ENGINE_TYPE = "engine_type";

    public static final String UNIT = "Unit";

    public static final String GOODS_C_ID = "goods_c_id";

    public static final String I_ID = "i_id";

    public static final String SPEC5 = "Spec5";

    public static final String SPEC6 = "Spec6";

    public static final String PRO_ID = "pro_id";

    public static final String PROVCODE = "ProvCode";

    public static final String PROVNAME = "ProvName";

    public static final String OLDBM = "OldBM";

    public static final String ITEMTM = "ItemTM";

    public static final String PACKSPEC = "PackSpec";

    public static final String SPEC = "Spec";

    public static final String GROSSWEIGHT = "GrossWeight";

    public static final String NETWEIGHT = "NetWeight";

    public static final String MZSCALE = "MZScale";

    public static final String INTERCHANGENO = "InterchangeNo";

    public static final String ZD3 = "ZD3";

    public static final String PRICE = "price";

    public static final String MEMBER_PRICE = "member_price";

    public static final String VIP_PRICE = "vip_price";

    public static final String PROTOCOL_PRICE = "protocol_price";

    public static final String CLAIM_PRICE = "claim_price";

    public static final String INSURANCE_PRICE = "insurance_price";

    public static final String BLOCK_UP = "block_up";

    public static final String GOOD_WIDTH = "good_width";

    public static final String GOOD_SHOW = "good_show";

    public static final String BOOLDEL = "booldel";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.goodsId;
    }

}
