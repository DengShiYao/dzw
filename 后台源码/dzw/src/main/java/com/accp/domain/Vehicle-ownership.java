package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Vehicle-ownership对象", description="")
public class Vehicle-ownership extends Model<Vehicle-ownership> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "归属编号")
    @TableId(value = "affiliationid", type = IdType.AUTO)
    private Integer affiliationid;

    @ApiModelProperty(value = "归属名称")
    private String affiliationname;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String AFFILIATIONID = "affiliationid";

    public static final String AFFILIATIONNAME = "affiliationname";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.affiliationid;
    }

}
