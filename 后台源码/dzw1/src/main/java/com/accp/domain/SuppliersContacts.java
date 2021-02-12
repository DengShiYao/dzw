package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

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
@ApiModel(value="SuppliersContacts对象", description="")
public class SuppliersContacts extends Model<SuppliersContacts> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "sc_id", type = IdType.AUTO)
    private Integer scId;

    @ApiModelProperty(value = "联系人名称")
    @NotEmpty(message = "联系人名称不能为空")
    private String scName;

    @ApiModelProperty(value = "联系人职位")
    private String scPost;

    @ApiModelProperty(value = "联系人手机")
    private String scPhone;

    @ApiModelProperty(value = "联系人电话")
    private String scTelephone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String SC_ID = "sc_id";

    public static final String SC_NAME = "sc_name";

    public static final String SC_POST = "sc_post";

    public static final String SC_PHONE = "sc_phone";

    public static final String SC_TELEPHONE = "sc_telephone";

    public static final String EMAIL = "email";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.scId;
    }

}
