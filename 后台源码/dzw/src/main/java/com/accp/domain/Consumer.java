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
@ApiModel(value="Consumer对象", description="")
public class Consumer extends Model<Consumer> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户编号")
    private Integer khid;

    @ApiModelProperty(value = "客户名称")
    @TableField("khName")
    private String khName;

    @ApiModelProperty(value = "详细地址")
    private String adress;

    @ApiModelProperty(value = "联系人")
    private String lxpeople;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "客户生日")
    private String birthday;

    @ApiModelProperty(value = "客户类别")
    private String khcategory;

    @ApiModelProperty(value = "会员卡号")
    private String yhnumber;

    @ApiModelProperty(value = "入会日期")
    private String rhtime;

    @ApiModelProperty(value = "会员到期")
    private String dqtime;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "建档日期")
    private String jdtime;

    @ApiModelProperty(value = "服务顾问")
    private String fwgw;

    @ApiModelProperty(value = "业务员电话")
    private String ywphone;

    @ApiModelProperty(value = "账期")
    private String zq;

    @ApiModelProperty(value = "挂账额度")
    private Integer gzmoeny;

    @ApiModelProperty(value = "客户省")
    private String khsheng;

    @ApiModelProperty(value = "客户市")
    private String khshi;

    @ApiModelProperty(value = "客户区")
    private String khq;

    @ApiModelProperty(value = "纳税人识别号")
    private Integer nsr;

    @ApiModelProperty(value = "注册电话")
    private String zcdh;

    @ApiModelProperty(value = "开户银行")
    private String khyh;

    @ApiModelProperty(value = "注册地址")
    private String zcadress;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String ID = "id";

    public static final String KHID = "khid";

    public static final String KHNAME = "khName";

    public static final String ADRESS = "adress";

    public static final String LXPEOPLE = "lxpeople";

    public static final String PHONE = "phone";

    public static final String BIRTHDAY = "birthday";

    public static final String KHCATEGORY = "khcategory";

    public static final String YHNUMBER = "yhnumber";

    public static final String RHTIME = "rhtime";

    public static final String DQTIME = "dqtime";

    public static final String REMARKS = "remarks";

    public static final String JDTIME = "jdtime";

    public static final String FWGW = "fwgw";

    public static final String YWPHONE = "ywphone";

    public static final String ZQ = "zq";

    public static final String GZMOENY = "gzmoeny";

    public static final String KHSHENG = "khsheng";

    public static final String KHSHI = "khshi";

    public static final String KHQ = "khq";

    public static final String NSR = "nsr";

    public static final String ZCDH = "zcdh";

    public static final String KHYH = "khyh";

    public static final String ZCADRESS = "zcadress";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
