package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.List;

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
@ApiModel(value="TeamForm对象", description="")
public class TeamForm extends Model<TeamForm> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "班组编码")
    private String teamCode;

    @ApiModelProperty(value = "班组名称")
    private String teamName;

    @ApiModelProperty(value = "班组权重")
    private Integer teamCommission;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "自增主键")
    private Integer column1;

    @ApiModelProperty(value = "团队id")
    private Integer column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @TableField(exist = false)
    private List<Technical> jgList;


    public static final String TEAM_CODE = "team_code";

    public static final String TEAM_NAME = "team_name";

    public static final String TEAM_COMMISSION = "team_commission";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.teamCode;
    }

}
