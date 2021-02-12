package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="DzwColumnController对象", description="")
public class DzwColumnController extends Model<DzwColumnController> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "column_id", type = IdType.AUTO)
    private Integer columnId;

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "字段宽度")
    private Double columnWidth;

    @ApiModelProperty(value = "是否显示 0隐藏/1显示")
    private Integer columnVisible;

    @ApiModelProperty(value = "字段名")
    private String columnName;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "字段中文名")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String COLUMN_ID = "column_id";

    public static final String TABLE_NAME = "table_name";

    public static final String COLUMN_WIDTH = "column_width";

    public static final String COLUMN_VISIBLE = "column_visible";

    public static final String COLUMN_NAME = "column_name";

    public static final String USER_ID = "user_id";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.columnId;
    }

}
