package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="Departure对象", description="")
public class Departure extends Model<Departure> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    @JsonProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    @TableField("eId")
    @JsonProperty(value = "eId")
    private String eId;

    @ApiModelProperty(value = "离职时间")
    @TableField("dismissDate")
    @JsonProperty(value = "dismissDate")
    private String dismissDate;

    @ApiModelProperty(value = "离职原因")
    @TableField("dismissReason")
    @JsonProperty(value = "dismissReason")
    private String dismissReason;

    @ApiModelProperty(value = "登记人")
    @TableField("registId")
    @JsonProperty(value = "registId")
    private Integer registId;

    @ApiModelProperty(value = "性别")
    @JsonProperty(value = "sex")
    private String sex;

    @ApiModelProperty(value = "部门编号")
    @TableField("dId")
    @JsonProperty(value = "dId")
    private String dId;

    @ApiModelProperty(value = "所属门店")
    @TableField("sId")
    @JsonProperty(value = "sId")
    private Integer sId;

    @ApiModelProperty(value = "姓名")
    @JsonProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "岗位编码")
    @TableField("jobId")
    @JsonProperty(value = "jobId")
    private String jobId;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;

    @ApiModelProperty(value = "门店")
    @TableField(exist = false)
    @JsonProperty(value = "store")
    private  Store store;

    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    @JsonProperty(value = "department")
    private  Department department;

    @ApiModelProperty(value = "职位")
    @TableField(exist = false)
    @JsonProperty(value = "job")
    private  Job job;


    public static final String ID = "id";

    public static final String EID = "eId";

    public static final String DISMISSDATE = "dismissDate";

    public static final String DISMISSREASON = "dismissReason";

    public static final String REGISTID = "registId";

    public static final String SEX = "sex";

    public static final String DID = "dId";

    public static final String SID = "sId";

    public static final String NAME = "name";

    public static final String JOBID = "jobId";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
