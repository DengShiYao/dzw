package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Acquisition对象", description="")
public class Acquisition extends Model<Acquisition> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id，主键，编号")
    @TableId(value = "ac_id", type = IdType.AUTO)
    private Integer acId;

    @ApiModelProperty(value = "维修单号,外加维修表")
    private String acRepairid;

    @ApiModelProperty(value = "领料日期")
    private String acTime;

    @ApiModelProperty(value = "物料id，外键商品表")
    private String acGoods;

    @ApiModelProperty(value = "备用列1")
    private String column1;

    @ApiModelProperty(value = "备用列2")
    private String column2;

    @ApiModelProperty(value = "备用列3")
    private String column3;


    public static final String AC_ID = "ac_id";

    public static final String AC_REPAIRID = "ac_repairid";

    public static final String AC_TIME = "ac_time";

    public static final String AC_GOODS = "ac_goods";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.acId;
    }

}
