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
@ApiModel(value="Technical对象", description="")
public class Technical extends Model<Technical> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "技工编号")
    private String technical-number;

    @ApiModelProperty(value = "技工姓名")
    private String technical-name;

    @ApiModelProperty(value = "性别")
    private String technical-sex;

    @ApiModelProperty(value = "是否是组长")
    private Integer headman;

    @ApiModelProperty(value = "所在班组")
    private String team-code;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "登陆账号")
    private String account-number;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "微信号")
    @TableField("Microsignal")
    private String Microsignal;

    @ApiModelProperty(value = "身份证号")
    private String id-number;

    @ApiModelProperty(value = "户口地址")
    private String address2;

    @ApiModelProperty(value = "开户银行")
    private String bank;

    @ApiModelProperty(value = "银行账号")
    private String bank-number;

    @ApiModelProperty(value = "等级编码")
    private String crade-code;

    @ApiModelProperty(value = "维修工种")
    @TableField("Maintenance-type")
    private String Maintenance-type;

    @ApiModelProperty(value = "维修品牌")
    @TableField("Maintenance brand")
    private String Maintenance brand;

    @ApiModelProperty(value = "是否离职")
    private Integer dimission;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String TECHNICAL-NUMBER = "technical-number";

    public static final String TECHNICAL-NAME = "technical-name";

    public static final String TECHNICAL-SEX = "technical-sex";

    public static final String HEADMAN = "headman";

    public static final String TEAM-CODE = "team-code";

    public static final String PHONE = "phone";

    public static final String ACCOUNT-NUMBER = "account-number";

    public static final String ADDRESS = "address";

    public static final String BIRTHDAY = "birthday";

    public static final String MICROSIGNAL = "Microsignal";

    public static final String ID-NUMBER = "id-number";

    public static final String ADDRESS2 = "address2";

    public static final String BANK = "bank";

    public static final String BANK-NUMBER = "bank-number";

    public static final String CRADE-CODE = "crade-code";

    public static final String MAINTENANCE-TYPE = "Maintenance-type";

    public static final String MAINTENANCE BRAND = "Maintenance brand";

    public static final String DIMISSION = "dimission";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.technical-number;
    }

}
