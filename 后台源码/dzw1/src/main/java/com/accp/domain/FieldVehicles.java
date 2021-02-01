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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FieldVehicles对象", description="")
public class FieldVehicles extends Model<FieldVehicles> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车牌号")
    private String plateNumber;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "车型")
    private String motorcycleType;

    @ApiModelProperty(value = "当前里程")
    private String currentMileage;

    @ApiModelProperty(value = "归属班组")
    private String attributionTeam;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String PLATE_NUMBER = "plate_number";

    public static final String BRAND = "brand";

    public static final String MOTORCYCLE_TYPE = "motorcycle_type";

    public static final String CURRENT_MILEAGE = "current_mileage";

    public static final String ATTRIBUTION_TEAM = "attribution_team";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.plateNumber;
    }

}
