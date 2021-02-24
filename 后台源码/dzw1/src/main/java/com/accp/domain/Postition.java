package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author dsy
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Postition对象", description="")
public class Postition extends Model<Postition> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "职位id,主键，自增")
    @TableId(value = "postitionId", type = IdType.AUTO)
    @JsonProperty(value = "postitionId")
    private Integer postitionId;

    @ApiModelProperty(value = "职位")
    @TableField("postitionName")
    @JsonProperty(value = "postitionName")
    private String postitionName;


    public static final String POSTITIONID = "postitionId";

    public static final String POSTITIONNAME = "postitionName";

    @Override
    protected Serializable pkVal() {
        return this.postitionId;
    }

}
