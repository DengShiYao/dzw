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
@ApiModel(value="Sybxgs对象", description="")
public class Sybxgs extends Model<Sybxgs> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "Id")
    private String sybxid;

    @ApiModelProperty(value = "商业保险公司名称")
    private String sybxname;


    public static final String SYBXID = "sybxid";

    public static final String SYBXNAME = "sybxname";

    @Override
    protected Serializable pkVal() {
        return this.sybxid;
    }

}
