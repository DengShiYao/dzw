package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="JyBiao对象", description="")
public class JyBiao extends Model<JyBiao> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修单号")
    @TableId("jy_No")
    private String jyNo;

    @ApiModelProperty(value = "单据类型")
    private String jyDjlx;

    @ApiModelProperty(value = "业务类型")
    private String jyYwbc;

    @ApiModelProperty(value = "施工班次")
    private String jySgbc;

    @ApiModelProperty(value = "车主姓名")
    @TableField("jy_cz_Name")
    private String jyCzName;

    @ApiModelProperty(value = "车牌号")
    private String jyCph;

    @ApiModelProperty(value = "车型")
    private String jyCx;

    @ApiModelProperty(value = "车架号")
    private String jyCjh;

    @ApiModelProperty(value = "接车时间")
    private LocalDateTime jyJcsj;

    @ApiModelProperty(value = "预计完工")
    private LocalDateTime jyYjwj;

    @ApiModelProperty(value = "误工原因")
    private String jyWgyy;

    @ApiModelProperty(value = "责任人")
    private String jyZyr;

    @ApiModelProperty(value = "处罚金额")
    private Double jyCfje;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String JY_NO = "jy_No";

    public static final String JY_DJLX = "jy_djlx";

    public static final String JY_YWBC = "jy_ywbc";

    public static final String JY_SGBC = "jy_sgbc";

    public static final String JY_CZ_NAME = "jy_cz_Name";

    public static final String JY_CPH = "jy_cph";

    public static final String JY_CX = "jy_cx";

    public static final String JY_CJH = "jy_cjh";

    public static final String JY_JCSJ = "jy_jcsj";

    public static final String JY_YJWJ = "jy_yjwj";

    public static final String JY_WGYY = "jy_wgyy";

    public static final String JY_ZYR = "jy_zyr";

    public static final String JY_CFJE = "jy_cfje";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.jyNo;
    }

}
