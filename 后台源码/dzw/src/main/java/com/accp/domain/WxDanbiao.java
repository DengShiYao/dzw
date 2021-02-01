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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="WxDanbiao对象", description="")
public class WxDanbiao extends Model<WxDanbiao> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修单Id")
    private Integer wxDanId;

    @ApiModelProperty(value = "项目名称")
    private String wxXmmc;

    @ApiModelProperty(value = "数量")
    private Double wxSl;

    @ApiModelProperty(value = "维修单价")
    private Double wxDj;

    @ApiModelProperty(value = "金额")
    private Double wxJe;

    @ApiModelProperty(value = "技师结算价")
    private Double wxJsJsj;

    @ApiModelProperty(value = "故障描述")
    private String wxGzms;

    @ApiModelProperty(value = "故障原因")
    private String wxWzyy;

    @ApiModelProperty(value = "维修班组")
    private String wxWxBz;

    @ApiModelProperty(value = "作业人员")
    private String wxZyry;

    @ApiModelProperty(value = "工单号")
    private String wxGdh;

    @ApiModelProperty(value = "面单原因")
    private String wxMdyy;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String WX_DAN_ID = "wx_dan_id";

    public static final String WX_XMMC = "wx_xmmc";

    public static final String WX_SL = "wx_sl";

    public static final String WX_DJ = "wx_dj";

    public static final String WX_JE = "wx_je";

    public static final String WX_JS_JSJ = "wx_js_jsj";

    public static final String WX_GZMS = "wx_gzms";

    public static final String WX_WZYY = "wx_wzyy";

    public static final String WX_WX_BZ = "wx_wx_bz";

    public static final String WX_ZYRY = "wx_zyry";

    public static final String WX_GDH = "wx_gdh";

    public static final String WX_MDYY = "wx_mdyy";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.wxDanId;
    }

}
