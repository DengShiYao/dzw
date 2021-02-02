package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CoinSpray对象", description="")
public class CoinSpray extends Model<CoinSpray> {

    private static final long serialVersionUID=1L;

    private String coinId;

    @ApiModelProperty(value = "钣喷名称")
    private String coinName;

    @ApiModelProperty(value = "逻辑删除 0真/1假")
    private Integer isDelete;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String COIN_ID = "coin_id";

    public static final String COIN_NAME = "coin_name";

    public static final String IS_DELETE = "is_delete";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.coinId;
    }

}
