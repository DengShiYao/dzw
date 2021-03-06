package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

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
@ApiModel(value="GoodsCategory对象", description="")
public class GoodsCategory extends Model<GoodsCategory> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分类编码")
    @NotEmpty(message = "分类编码不能为空")
    private String goodsCId;

    @ApiModelProperty(value = "分类名称")
    @NotEmpty(message = "分类名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "父级Id")
    private Integer parentid;

    @ApiModelProperty(value = "主键")
    @TableId(value = "column1", type = IdType.AUTO)
    private Integer column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @ApiModelProperty(value = "子级集合")
    @TableField(exist = false)
    private List<GoodsCategory> children;

    @ApiModelProperty(value = "修改前的id")
    @TableField(exist = false)
    private String beforeId;


    public static final String GOODS_C_ID = "goods_c_id";

    public static final String GOODS_NAME = "goods_name";

    public static final String PARENTID = "parentid";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.goodsCId;
    }

}
