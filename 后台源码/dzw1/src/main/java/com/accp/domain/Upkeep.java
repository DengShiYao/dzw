package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author dsy
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Upkeep对象", description="")
public class Upkeep extends Model<Upkeep> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "保养id")
    private String upkeepId;

    @ApiModelProperty(value = "保养项目名称")
    private String upkeepName;

    @ApiModelProperty(value = "逻辑删除 0真/1假")
    private Integer isDelete;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @ApiModelProperty(value = "修改前的id")
    @TableField(exist = false)
    private  String beforeId;

    public static final String UPKEEP_ID = "upkeep_id";

    public static final String UPKEEP_NAME = "upkeep_name";

    public static final String IS_DELETE = "is_delete";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
