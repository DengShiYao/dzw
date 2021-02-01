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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Technical对象", description="")
public class Technical extends Model<Technical> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "技工编号")
    private String technicalNumber;

    @ApiModelProperty(value = "技工姓名")
    private String technicalName;

    @ApiModelProperty(value = "性别")
    private String technicalSex;

    @ApiModelProperty(value = "是否是组长")
    private Integer headman;

    @ApiModelProperty(value = "所在班组")
    private String teamCode;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "登陆账号")
    private String accountNumber;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "微信号")
    @TableField("Microsignal")
    private String Microsignal;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "户口地址")
    private String address2;

    @ApiModelProperty(value = "开户银行")
    private String bank;

    @ApiModelProperty(value = "银行账号")
    private String bankNumber;

    @ApiModelProperty(value = "等级编码")
    private String cradeCode;

    @ApiModelProperty(value = "维修工种")
    @TableField("Maintenance_type")
    private String maintenanceType;

    @ApiModelProperty(value = "维修品牌")
    @TableField("Maintenance_brand")
    private String maintenanceBrand;

    @ApiModelProperty(value = "是否离职")
    private Integer dimission;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String TECHNICAL_NUMBER = "technical_number";

    public static final String TECHNICAL_NAME = "technical_name";

    public static final String TECHNICAL_SEX = "technical_sex";

    public static final String HEADMAN = "headman";

    public static final String TEAM_CODE = "team_code";

    public static final String PHONE = "phone";

    public static final String ACCOUNT_NUMBER = "account_number";

    public static final String ADDRESS = "address";

    public static final String BIRTHDAY = "birthday";

    public static final String MICROSIGNAL = "Microsignal";

    public static final String ID_NUMBER = "id_number";

    public static final String ADDRESS2 = "address2";

    public static final String BANK = "bank";

    public static final String BANK_NUMBER = "bank_number";

    public static final String CRADE_CODE = "crade_code";

    public static final String MAINTENANCE_TYPE = "Maintenance_type";

    public static final String MAINTENANCE_BRAND = "Maintenance_brand";

    public static final String DIMISSION = "dimission";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.technicalNumber;
    }

}
