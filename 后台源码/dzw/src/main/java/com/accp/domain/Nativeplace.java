package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Nativeplace对象", description="")
public class Nativeplace extends Model<Nativeplace> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "籍贯编号,主键，自增")
    @TableId(value = "nplaceId", type = IdType.AUTO)
    private Integer nplaceId;

    @ApiModelProperty(value = "籍贯名称")
    @TableField("nplaceName")
    private String nplaceName;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String NPLACEID = "nplaceId";

    public static final String NPLACENAME = "nplaceName";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.nplaceId;
    }

}
