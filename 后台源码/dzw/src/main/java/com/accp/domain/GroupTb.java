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
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GroupTb对象", description="")
public class GroupTb extends Model<GroupTb> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "组id")
    private String groupId;

    @ApiModelProperty(value = "组名称")
    private String groupName;

    @ApiModelProperty(value = "首字母")
    private String initial;

    @ApiModelProperty(value = "父级id")
    private String parentid;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String GROUP_ID = "group_id";

    public static final String GROUP_NAME = "group_name";

    public static final String INITIAL = "initial";

    public static final String PARENTID = "parentid";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

}
