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
 * @since 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysUserRole对象", description="")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;


    public static final String USER_ID = "user_id";

    public static final String ROLE_ID = "role_id";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
