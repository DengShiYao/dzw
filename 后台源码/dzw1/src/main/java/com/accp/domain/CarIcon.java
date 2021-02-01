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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CarIcon对象", description="")
public class CarIcon extends Model<CarIcon> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "品牌编码")
    @TableId(value = "ic_id", type = IdType.AUTO)
    private Integer icId;

    @ApiModelProperty(value = "车型图片")
    private String icName;

    @ApiModelProperty(value = "车型ID")
    private String carId;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String IC_ID = "ic_id";

    public static final String IC_NAME = "ic_name";

    public static final String CAR_ID = "car_id";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.icId;
    }

}
