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
 * @since 2021-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Store对象", description="")
public class Store extends Model<Store> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "门店编号")
    @TableId(value = "storeId", type = IdType.AUTO)
    private Integer storeId;

    @ApiModelProperty(value = "门店名称")
    @TableField("storeName")
    private String storeName;

    @ApiModelProperty(value = "父门店编号")
    @TableField("pstoreId")
    private Integer pstoreId;

    @ApiModelProperty(value = "备用了")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String STOREID = "storeId";

    public static final String STORENAME = "storeName";

    public static final String PSTOREID = "pstoreId";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.storeId;
    }

}
