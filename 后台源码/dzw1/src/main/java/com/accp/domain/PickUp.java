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
 * @since 2021-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PickUp对象", description="")
public class PickUp extends Model<PickUp> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "接车id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "车牌号")
    private String plateNumber;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "地理位置")
    private String position;

    @ApiModelProperty(value = "故障描述")
    private String faultDescription;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "备用列1")
    private String column1;

    @ApiModelProperty(value = "备用列2")
    private String column2;

    @ApiModelProperty(value = "备用列3")
    private String column3;

    @ApiModelProperty(value = "距离")
    private String distance;

    @ApiModelProperty(value = "价格")
    private double price;

    @ApiModelProperty(value = "时间")
    private String submissionTime;

    @ApiModelProperty(value = "维修单号")
    private  String sernumber;


    public static final String ID = "id";

    public static final String USERNAME = "userName";

    public static final String PLATE_NUMBER = "plate_number";

    public static final String PHONE = "phone";

    public static final String POSITION = "position";

    public static final String FAULT_DESCRIPTION = "fault_description";

    public static final String STATUS = "status";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    public static final String DISTANCE = "distance";

    public static final String PRICE = "price";

    public static final String SUBMISSIONTIME = "submissionTime";

    public static  String SERNUMBER="sernumber";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
