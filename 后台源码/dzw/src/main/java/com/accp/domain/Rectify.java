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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Rectify对象", description="")
public class Rectify extends Model<Rectify> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号,自增，主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "会员号，外键会员表")
    @TableField("mId")
    private Integer mId;

    @ApiModelProperty(value = "操作人,外键员工表")
    @TableField("eId")
    private String eId;

    @ApiModelProperty(value = "矫正时间")
    @TableField("rectifyDate")
    private String rectifyDate;

    @ApiModelProperty(value = "矫正金额")
    private Double money;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String ID = "id";

    public static final String MID = "mId";

    public static final String EID = "eId";

    public static final String RECTIFYDATE = "rectifyDate";

    public static final String MONEY = "money";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
