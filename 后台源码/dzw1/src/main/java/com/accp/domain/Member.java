package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@ApiModel(value="Member对象", description="")
public class Member extends Model<Member> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "会员编号")
    @TableId("mId")
    @JsonProperty(value = "mId")
    private Integer mId;

    @ApiModelProperty(value = "会员姓名")
    @TableField("mName")
    @JsonProperty(value = "mName")
    private String mName;

    @ApiModelProperty(value = "会员余额")
    @TableField("mPrice")
    @JsonProperty(value = "mPrice")
    private Double mPrice;

    @ApiModelProperty(value = "注册时间")
    @TableField("createDate")
    @JsonProperty(value = "createDate")
    private String createDate;

    @ApiModelProperty(value = "会员密码")
    @TableField("mPwd")
    private String mPwd;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String MID = "mId";

    public static final String MNAME = "mName";

    public static final String MPRICE = "mPrice";

    public static final String CREATEDATE = "createDate";

    public static final String MPWD = "mPwd";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.mId;
    }

}
