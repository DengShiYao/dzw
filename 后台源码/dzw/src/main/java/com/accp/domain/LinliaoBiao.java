package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LinliaoBiao对象", description="")
public class LinliaoBiao extends Model<LinliaoBiao> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId("Ll_id")
    private Integer llId;

    @ApiModelProperty(value = "领料时间")
    @TableField("Ll_Time")
    private LocalDateTime llTime;

    @ApiModelProperty(value = "领料人")
    @TableField("Ll_Name")
    private String llName;

    @ApiModelProperty(value = "物料编码")
    @TableField("Ll_Wl_bm")
    private String llWlBm;

    @ApiModelProperty(value = "物料名称")
    @TableField("Ll_Wl_Name")
    private String llWlName;

    @ApiModelProperty(value = "单位名称")
    @TableField("Ll_Danwei_name")
    private String llDanweiName;

    @ApiModelProperty(value = "价类")
    @TableField("Ll_jl")
    private String llJl;

    @ApiModelProperty(value = "数量")
    @TableField("Ll_sl")
    private Double llSl;

    @ApiModelProperty(value = "单价")
    @TableField("Ll_dj")
    private Double llDj;

    @ApiModelProperty(value = "金额")
    @TableField("Ll_e")
    private Double llE;

    @ApiModelProperty(value = "免单原因")
    @TableField("Ll_mdyl")
    private String llMdyl;

    @ApiModelProperty(value = "回收状态")
    @TableField("Ll_hszt")
    private String llHszt;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String LL_ID = "Ll_id";

    public static final String LL_TIME = "Ll_Time";

    public static final String LL_NAME = "Ll_Name";

    public static final String LL_WL_BM = "Ll_Wl_bm";

    public static final String LL_WL_NAME = "Ll_Wl_Name";

    public static final String LL_DANWEI_NAME = "Ll_Danwei_name";

    public static final String LL_JL = "Ll_jl";

    public static final String LL_SL = "Ll_sl";

    public static final String LL_DJ = "Ll_dj";

    public static final String LL_E = "Ll_e";

    public static final String LL_MDYL = "Ll_mdyl";

    public static final String LL_HSZT = "Ll_hszt";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.llId;
    }

}
