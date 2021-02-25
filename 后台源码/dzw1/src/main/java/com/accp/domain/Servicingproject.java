package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Servicingproject对象", description="")
public class Servicingproject extends Model<Servicingproject> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "wx_id", type = IdType.AUTO)
    private Integer wxId;

    @ApiModelProperty(value = "项目名称")
    private String wxProjectnae;

    @ApiModelProperty(value = "价类")
    private String wxJialei;

    @ApiModelProperty(value = "免单原因")
    private String wxMiandan;

    @ApiModelProperty(value = "服务顾问")
    private String wxServiceuser;

    @ApiModelProperty(value = "技师结算标价")
    private Double wxJsjies;

    @ApiModelProperty(value = "数量")
    private Integer wxNumber;

    @ApiModelProperty(value = "工时单价")
    private Double wxGsdanjia;

    @ApiModelProperty(value = "故障描述")
    private String wxGzmiaoshu;

    @ApiModelProperty(value = "故障原因")
    private String wxGzyuanyin;

    @ApiModelProperty(value = "维修班组")
    private String wxWeixiubz;

    @ApiModelProperty(value = "工单号")
    private String wxGdannumber;

    @ApiModelProperty(value = "备用列1")
    private String column1;

    @ApiModelProperty(value = "备用列2")
    private String column2;

    @ApiModelProperty(value = "备用列3")
    private String column3;


    public static final String WX_ID = "wx_id";

    public static final String WX_PROJECTNAE = "wx_projectnae";

    public static final String WX_JIALEI = "wx_jialei";

    public static final String WX_MIANDAN = "wx_miandan";

    public static final String WX_SERVICEUSER = "wx_serviceuser";

    public static final String WX_JSJIES = "wx_jsjies";

    public static final String WX_NUMBER = "wx_number";

    public static final String WX_GSDANJIA = "wx_gsdanjia";

    public static final String WX_GZMIAOSHU = "wx_gzmiaoshu";

    public static final String WX_GZYUANYIN = "wx_gzyuanyin";

    public static final String WX_WEIXIUBZ = "wx_weixiubz";

    public static final String WX_GDANNUMBER = "wx_gdannumber";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.wxId;
    }

}
