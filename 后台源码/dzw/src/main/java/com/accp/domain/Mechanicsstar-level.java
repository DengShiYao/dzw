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
@ApiModel(value="Mechanicsstar-level对象", description="")
public class Mechanicsstar-level extends Model<Mechanicsstar-level> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "等级编码")
    private String crade-code;

    @ApiModelProperty(value = "等级名称")
    private String crade-name;

    @ApiModelProperty(value = "提成权重")
    private Integer full-commission;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String CRADE-CODE = "crade-code";

    public static final String CRADE-NAME = "crade-name";

    public static final String FULL-COMMISSION = "full-commission";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.crade-code;
    }

}
