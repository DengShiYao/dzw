package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@ApiModel(value="Staffpostition对象", description="")
public class Staffpostition extends Model<Staffpostition> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号，主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id")
    @TableField("eId")
    private String eId;

    @ApiModelProperty(value = "职位id")
    @TableField("postitonId")
    private Integer postitonId;

    @ApiModelProperty(value = "职务实体")
    @TableField(exist = false)
    private Postition postition;


    public static final String ID = "id";

    public static final String EID = "eId";

    public static final String POSTITONID = "postitonId";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
