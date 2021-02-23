package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
@ApiModel(value="EngineBrand对象", description="")
public class EngineBrand extends Model<EngineBrand> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "品牌id")
    @TableId("engine_id")
    private String engineId;

    @ApiModelProperty(value = "品牌名称")
    private String engineName;

    @ApiModelProperty(value = "逻辑删除 0真/1假")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @TableField(exist = false)
    private List<EngineBrand> children;

    @ApiModelProperty(value = "备用列")
    @TableField(exist = false)
    private String beforeName;


    public static final String ENGINE_ID = "engine_id";

    public static final String ENGINE_NAME = "engine_name";

    public static final String IS_DELETE = "is_delete";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.engineId;
    }

}
