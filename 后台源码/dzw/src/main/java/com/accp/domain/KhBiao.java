package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="KhBiao对象", description="")
public class KhBiao extends Model<KhBiao> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "客户编码")
    private String khBm;

    @ApiModelProperty(value = "客户名称")
    private String khMc;

    @ApiModelProperty(value = "客户详细地址")
    private String khDz;

    @ApiModelProperty(value = "联系人")
    private String khLianxiren;

    @ApiModelProperty(value = "手机号")
    private String khSjh;

    @ApiModelProperty(value = "客户生日日期")
    private LocalDateTime khSr;

    @ApiModelProperty(value = "客户类别")
    private String khLb;

    @ApiModelProperty(value = "会员卡号")
    private String khHykh;

    @ApiModelProperty(value = "入会日期")
    private LocalDateTime khRhrq;

    @ApiModelProperty(value = "会员到期")
    private LocalDateTime khHydq;

    @ApiModelProperty(value = "备注")
    private String khBz;

    @ApiModelProperty(value = "建档日期")
    private LocalDateTime khJdrq;

    @ApiModelProperty(value = "服务顾问")
    private String khFwgw;

    @ApiModelProperty(value = "账期(天数)")
    private Integer khZqts;

    @ApiModelProperty(value = "挂账额度")
    private Double khGzEd;

    @ApiModelProperty(value = "累计积分")
    private Double khLjjf;

    @ApiModelProperty(value = "定金金额")
    private Double khDjje;

    @ApiModelProperty(value = "客户省")
    private String khKhs1;

    @ApiModelProperty(value = "客户市")
    private String khKhs2;

    @ApiModelProperty(value = "客户区")
    private String khKhq;

    @ApiModelProperty(value = "纳税人识别号")
    private String khNsrsbh;

    @ApiModelProperty(value = "注册电话")
    private String khZcdh;

    @ApiModelProperty(value = "开户银行")
    private String khKhyh;

    @ApiModelProperty(value = "银行账号")
    private String khYhzh;

    @ApiModelProperty(value = "注册地址")
    private String khZcdz;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String KH_BM = "kh_bm";

    public static final String KH_MC = "kh_mc";

    public static final String KH_DZ = "kh_dz";

    public static final String KH_LIANXIREN = "kh_lianxiren";

    public static final String KH_SJH = "kh_sjh";

    public static final String KH_SR = "kh_sr";

    public static final String KH_LB = "kh_lb";

    public static final String KH_HYKH = "kh_hykh";

    public static final String KH_RHRQ = "kh_rhrq";

    public static final String KH_HYDQ = "kh_hydq";

    public static final String KH_BZ = "kh_bz";

    public static final String KH_JDRQ = "kh_jdrq";

    public static final String KH_FWGW = "kh_fwgw";

    public static final String KH_ZQTS = "kh_zqts";

    public static final String KH_GZ_ED = "kh_gz_ed";

    public static final String KH_LJJF = "kh_ljjf";

    public static final String KH_DJJE = "kh_djje";

    public static final String KH_KHS1 = "kh_khs1";

    public static final String KH_KHS2 = "kh_khs2";

    public static final String KH_KHQ = "kh_khq";

    public static final String KH_NSRSBH = "kh_nsrsbh";

    public static final String KH_ZCDH = "kh_zcdh";

    public static final String KH_KHYH = "kh_khyh";

    public static final String KH_YHZH = "kh_yhzh";

    public static final String KH_ZCDZ = "kh_zcdz";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.khBm;
    }

}
