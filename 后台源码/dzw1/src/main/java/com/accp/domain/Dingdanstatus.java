package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Dingdanstatus对象", description="")
public class Dingdanstatus extends Model<Dingdanstatus> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增id列")
    @TableId(value = "statusId", type = IdType.AUTO)
    private Integer statusId;

    @ApiModelProperty(value = "状态名称")
    @TableField("statusName")
    private String statusName;

    @ApiModelProperty(value = "备用列1")
    private String column1;

    @ApiModelProperty(value = "备用列2")
    private String column2;

    @ApiModelProperty(value = "备用列3")
    private String column3;


    public static final String STATUSID = "statusId";

    public static final String STATUSNAME = "statusName";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.statusId;
    }

}
