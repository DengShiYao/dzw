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
@ApiModel(value="Field-vehicles对象", description="")
public class Field-vehicles extends Model<Field-vehicles> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车牌号")
    private String plate-number;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "车型")
    private String motorcycle-type;

    @ApiModelProperty(value = "当前里程")
    private String current-mileage;

    @ApiModelProperty(value = "归属班组")
    private String attribution-team;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String PLATE-NUMBER = "plate-number";

    public static final String BRAND = "brand";

    public static final String MOTORCYCLE-TYPE = "motorcycle-type";

    public static final String CURRENT-MILEAGE = "current-mileage";

    public static final String ATTRIBUTION-TEAM = "attribution-team";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.plate-number;
    }

}
