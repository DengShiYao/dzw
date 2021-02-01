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
@ApiModel(value="Maintenance对象", description="")
public class Maintenance extends Model<Maintenance> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车牌号")
    @TableField("cheNumber")
    private String cheNumber;

    @ApiModelProperty(value = "保养计划")
    private String jh;

    @ApiModelProperty(value = "计划日期")
    private String jhtime;

    @ApiModelProperty(value = "计划里程")
    private String jhlc;

    @ApiModelProperty(value = "实际日期")
    private String sjtime;

    @ApiModelProperty(value = "实际里程")
    private String sjlc;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String ID = "id";

    public static final String CHENUMBER = "cheNumber";

    public static final String JH = "jh";

    public static final String JHTIME = "jhtime";

    public static final String JHLC = "jhlc";

    public static final String SJTIME = "sjtime";

    public static final String SJLC = "sjlc";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
