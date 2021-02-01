package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="WeiXiubiao对象", description="")
public class WeiXiubiao extends Model<WeiXiubiao> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修单号")
    @TableId("wx_No")
    private String wxNo;

    @ApiModelProperty(value = "接车时间")
    private LocalDateTime wxJcsj;

    @ApiModelProperty(value = "业务类型")
    private String wxYwlx;

    @ApiModelProperty(value = "完工时间")
    private LocalDateTime wxWgsj;

    @ApiModelProperty(value = "客户名称")
    private String wxKhmcc;

    @ApiModelProperty(value = "车牌号")
    private String wxChephao;

    @ApiModelProperty(value = "手机号")
    private String wxSjh;

    @ApiModelProperty(value = "会员卡号")
    private String wxHykh;

    @ApiModelProperty(value = "结算时间")
    private LocalDateTime wxJssj;

    @ApiModelProperty(value = "消费金额")
    private Double wxXhje;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String WX_NO = "wx_No";

    public static final String WX_JCSJ = "wx_jcsj";

    public static final String WX_YWLX = "wx_ywlx";

    public static final String WX_WGSJ = "wx_wgsj";

    public static final String WX_KHMCC = "wx_khmcc";

    public static final String WX_CHEPHAO = "wx_chephao";

    public static final String WX_SJH = "wx_sjh";

    public static final String WX_HYKH = "wx_hykh";

    public static final String WX_JSSJ = "wx_jssj";

    public static final String WX_XHJE = "wx_xhje";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.wxNo;
    }

}
