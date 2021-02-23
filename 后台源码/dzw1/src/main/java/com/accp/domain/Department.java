package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Department对象", description="")
public class Department extends Model<Department> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "部门编号")
    @JsonProperty(value = "dId")
    @TableId("dId")
    private String dId;

    @ApiModelProperty(value = "部门名称")
    @TableField("dName")
    @JsonProperty(value = "dName")
    private String dName;

    @ApiModelProperty(value = "部门类型编号")
    @TableField("tId")
    @JsonProperty(value = "tId")
    private Integer tId;

    @ApiModelProperty(value = "所属门店")
    @TableField("sId")
    private Integer sId;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @ApiModelProperty(value = "部门类型实体")
    @JsonProperty(value = "departmentType")
    @TableField(exist = false)
    private Departmenttype departmentType;


    public static final String DID = "dId";

    public static final String DNAME = "dName";

    public static final String TID = "tId";

    public static final String SID = "sId";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.dId;
    }

}
