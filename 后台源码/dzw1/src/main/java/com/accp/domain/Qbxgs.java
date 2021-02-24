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
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Qbxgs对象", description="")
public class Qbxgs extends Model<Qbxgs> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "Id")
    private String qbxid;

    @ApiModelProperty(value = "强险保险公司名称")
    private String qbxname;


    public static final String QBXID = "qbxid";

    public static final String QBXNAME = "qbxname";

    @Override
    protected Serializable pkVal() {
        return this.qbxid;
    }

}
