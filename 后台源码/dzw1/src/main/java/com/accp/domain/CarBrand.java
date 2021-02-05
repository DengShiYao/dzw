package com.accp.domain;

import com.baomidou.mybatisplus.annotation.*;
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
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CarBrand对象", description="")
public class CarBrand extends Model<CarBrand> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "汽车品牌id")
    @NotEmpty(message = "品牌编码不能为空")
//    @TableId(value = "car_id",type = IdType.INPUT)
//    @TableField(fill=FieldFill.INSERT_UPDATE)
    private String carId;

    @ApiModelProperty(value = "汽车品牌名称")
    private String carName;

    @ApiModelProperty(value = "首字母")
    private String initial;

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
    private String beforeId;


    public static final String CAR_ID = "car_id";

    public static final String CAR_NAME = "car_name";

    public static final String INITIAL = "initial";

    public static final String IS_DELETE = "is_delete";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.carId;
    }

}
