package com.accp.domain;

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
@ApiModel(value="Job对象", description="")
public class Job extends Model<Job> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "岗位编码")
    @TableId("jobId")
    private String jobId;

    @ApiModelProperty(value = "岗位名称")
    @TableField("jobName")
    private String jobName;

    @ApiModelProperty(value = "所属部门")
    @TableField("dId")
    private String dId;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


    public static final String JOBID = "jobId";

    public static final String JOBNAME = "jobName";

    public static final String DID = "dId";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.jobId;
    }

}
