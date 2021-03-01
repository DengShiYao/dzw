package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Dingdanxq对象", description="")
public class Dingdanxq extends Model<Dingdanxq> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "auto_id", type = IdType.AUTO)
    private Integer autoId;

    @ApiModelProperty(value = "外键到订单主键")
    private Integer orderAutoId;

    @ApiModelProperty(value = "订单内容")
    private String orderCentext;

    @ApiModelProperty(value = "金额")
    private Double price;

    @ApiModelProperty(value = "外键到订单状态")
    private Integer statusid;

    @ApiModelProperty(value = "退款金额")
    @TableField("tKprice")
    private Double tKprice;

    @ApiModelProperty(value = "退款时间")
    @TableField("tKdateTime")
    private LocalDateTime tKdateTime;

    @ApiModelProperty(value = "操作人")
    @TableField("tKpeople")
    private String tKpeople;

    @ApiModelProperty(value = "备用列1")
    private String column1;

    @ApiModelProperty(value = "备用列2")
    private String column2;

    @ApiModelProperty(value = "备用列3")
    private String column3;


    public static final String AUTO_ID = "auto_id";

    public static final String ORDER_AUTO_ID = "order_auto_id";

    public static final String ORDER_CENTEXT = "order_centext";

    public static final String PRICE = "price";

    public static final String STATUSID = "statusid";

    public static final String TKPRICE = "tKprice";

    public static final String TKDATETIME = "tKdateTime";

    public static final String TKPEOPLE = "tKpeople";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.autoId;
    }

}
