package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CarType对象", description="")
public class CarType extends Model<CarType> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车型ID")
    @NotEmpty(message = "cadId参数不能为空")
    private String carId;

    @ApiModelProperty(value = "车型名称")
    private String carName;

    @ApiModelProperty(value = "发动机品牌")
    private String engineName;

    @ApiModelProperty(value = "参考价格")
    private Double referencePrice;

    @ApiModelProperty(value = "车辆年款")
    private String carStyle;

    @ApiModelProperty(value = "	功率")
    private Double power;

    @ApiModelProperty(value = "索赔厂商")
    private Integer sid;

    @ApiModelProperty(value = "进口国产")
    private Integer importAndDomestic;

    @ApiModelProperty(value = "燃油标号")
    private String fuelNumber;

    @ApiModelProperty(value = "载重")
    private Double loadbearing;

    @ApiModelProperty(value = "汽车品牌")
    private String brandName;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @ApiModelProperty(value = "进口国产")
    @TableField(exist = false)
    private String importName;

    @ApiModelProperty(value = "索赔厂商")
    @TableField(exist = false)
    private String regionName;

    @ApiModelProperty(value = "修改前的id")
    @TableField(exist = false)
    private  String beforeId;

    public static final String CAR_ID = "car_id";

    public static final String CAR_NAME = "car_name";

    public static final String ENGINE_NAME = "engine_name";

    public static final String REFERENCE_PRICE = "reference_price";

    public static final String CAR_STYLE = "car_style";

    public static final String POWER = "power";

    public static final String SID = "sid";

    public static final String IMPORT_AND_DOMESTIC = "import_and_domestic";

    public static final String FUEL_NUMBER = "fuel_number";

    public static final String LOADBEARING = "loadbearing";

    public static final String BRAND_NAME = "brand_name";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.carId;
    }

}
