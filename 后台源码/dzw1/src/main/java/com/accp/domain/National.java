package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@ApiModel(value="National对象", description="")
public class National extends Model<National> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "民族id,主键，自增")
    @TableId(value = "nationalId", type = IdType.AUTO)
    @JsonProperty(value = "nationalId")
    private Integer nationalId;

    @ApiModelProperty(value = "民族名称")
    @TableField("nationalName")
    @JsonProperty(value = "nationalName")
    private String nationalName;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String NATIONALID = "nationalId";

    public static final String NATIONALNAME = "nationalName";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.nationalId;
    }

}
