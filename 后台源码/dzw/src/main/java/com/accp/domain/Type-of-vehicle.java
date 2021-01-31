package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Type-of-vehicle对象", description="")
public class Type-of-vehicle extends Model<Type-of-vehicle> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "型号序号")
    @TableId(value = "vtypeid", type = IdType.AUTO)
    private Integer vtypeid;

    @ApiModelProperty(value = "发动机品牌")
    private Integer enginetypeid;

    @ApiModelProperty(value = "型号编号")
    private String vtypeno;

    @ApiModelProperty(value = "型号名称")
    private String vtypename;

    @ApiModelProperty(value = "参考价格")
    private Float vprice;

    @ApiModelProperty(value = "车辆年款")
    private LocalDate vdate;

    @ApiModelProperty(value = "功率")
    private Integer vpower;

    @ApiModelProperty(value = "燃油标号")
    private String fuelmark;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String VTYPEID = "vtypeid";

    public static final String ENGINETYPEID = "enginetypeid";

    public static final String VTYPENO = "vtypeno";

    public static final String VTYPENAME = "vtypename";

    public static final String VPRICE = "vprice";

    public static final String VDATE = "vdate";

    public static final String VPOWER = "vpower";

    public static final String FUELMARK = "fuelmark";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.vtypeid;
    }

}
