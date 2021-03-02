package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@ApiModel(value="Dingdan对象", description="")
public class Dingdan extends Model<Dingdan> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "order_auto_id", type = IdType.AUTO)
    private Integer orderAutoId;

    @ApiModelProperty(value = "订单号")
    private String orderid;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "支付时间")
    private String dealTime;

    @ApiModelProperty(value = "操作人")
    private Integer userid;

    @ApiModelProperty(value = "总金额")
    private Double column1;

    @ApiModelProperty(value = "订单状态")
    private Integer column2;

    @ApiModelProperty(value = "支付方式")
    private Integer column3;


    public static final String ORDER_AUTO_ID = "order_auto_id";

    public static final String ORDERID = "orderid";

    public static final String CREATE_TIME = "create_time";

    public static final String DEAL_TIME = "deal_time";

    public static final String USERID = "userid";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.orderAutoId;
    }

}
