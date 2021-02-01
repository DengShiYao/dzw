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
@ApiModel(value="MechanicsstarLevel对象", description="")
public class MechanicsstarLevel extends Model<MechanicsstarLevel> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "等级编码")
    private String cradeCode;

    @ApiModelProperty(value = "等级名称")
    private String cradeName;

    @ApiModelProperty(value = "提成权重")
    private Integer fullCommission;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String CRADE_CODE = "crade_code";

    public static final String CRADE_NAME = "crade_name";

    public static final String FULL_COMMISSION = "full_commission";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.cradeCode;
    }

}
