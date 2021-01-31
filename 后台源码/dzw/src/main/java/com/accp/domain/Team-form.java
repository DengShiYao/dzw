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
@ApiModel(value="Team-form对象", description="")
public class Team-form extends Model<Team-form> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "班组编码")
    private String team-code;

    @ApiModelProperty(value = "班组名称")
    private String team-name;

    @ApiModelProperty(value = "班组权重")
    private Integer team-commission;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String TEAM-CODE = "team-code";

    public static final String TEAM-NAME = "team-name";

    public static final String TEAM-COMMISSION = "team-commission";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.team-code;
    }

}
