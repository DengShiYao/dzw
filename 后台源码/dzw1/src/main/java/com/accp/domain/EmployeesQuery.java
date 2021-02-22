package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 员工多条件查询条件类
 */
@Data
public class EmployeesQuery{
    @JsonProperty(value = "eId")
    @ApiModelProperty(value = "员工编号")
    @TableId("eId")
    private String eId;

    @JsonProperty(value = "eName")
    @ApiModelProperty(value = "员工姓名")
    @TableField("eName")
    private String eName;

    @JsonProperty(value = "sexId")
    @ApiModelProperty(value = "员工性别")
    @TableField("sexId")
    private Integer sexId;

    @JsonProperty(value = "mId")
    @ApiModelProperty(value = "所在门店")
    @TableField("mId")
    private Integer mId;

    @JsonProperty(value = "dId")
    @ApiModelProperty(value = "部门编号")
    @TableField("dId")
    private String dId;

    @JsonProperty(value = "login")
    @ApiModelProperty(value = "登录账号")
    private String login;

    @JsonProperty(value = "jId")
    @ApiModelProperty(value = "岗位编码")
    @TableField("jId")
    private String jId;

    @JsonProperty(value = "health")
    @ApiModelProperty(value = "身体状态")
    private String health;

    @JsonProperty(value = "height")
    @ApiModelProperty(value = "身高(m)")
    private Double height;

    @JsonProperty(value = "nplaceId")
    @ApiModelProperty(value = "籍贯")
    @TableField("nplaceId")
    private Integer nplaceId;

    @JsonProperty(value ="nationalId" )
    @ApiModelProperty(value = "民族")
    @TableField("nationalId")
    private Integer nationalId;

    @JsonProperty(value = "marryId")
    @ApiModelProperty(value = "婚姻状态")
    @TableField("marryId")
    private Integer marryId;

    @JsonProperty(value = "educationId")
    @ApiModelProperty(value = "学历编号")
    @TableField("educationId")
    private Integer educationId;

    @JsonProperty("schoolId")
    @ApiModelProperty(value = "毕业学校")
    @TableField("schoolId")
    private Integer schoolId;

    @JsonProperty("majorId")
    @ApiModelProperty(value = "专业id")
    @TableField("majorId")
    private Integer majorId;

    @JsonProperty(value = "PQId")
    @ApiModelProperty(value = "专业资格")
    @TableField("PQId")
    private Integer PQId;

    @JsonProperty(value = "attId")
    @ApiModelProperty(value = "属性编号")
    @TableField("attId")
    private Integer attId;

    @JsonProperty(value = "degreeId")
    @ApiModelProperty(value = "学位")
    @TableField("degreeId")
    private Integer degreeId;

    @JsonProperty(value = "establish")
    @ApiModelProperty(value = "编制")
    private String establish;

    @JsonProperty(value = "cardId")
    @ApiModelProperty(value = "身份证号")
    @TableField("cardId")
    private String cardId;

    @JsonProperty(value = "hAddress")
    @ApiModelProperty(value = "户口地址")
    @TableField("hAddress")
    private String hAddress;

    @JsonProperty(value = "nAddress")
    @ApiModelProperty(value = "现住地址")
    @TableField("nAddress")
    private String nAddress;

    @JsonProperty(value = "tel")
    @ApiModelProperty(value = "电话")
    private String tel;

    @JsonProperty(value = "phone")
    @ApiModelProperty(value = "手机")
    private String phone;

    @JsonProperty(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @JsonProperty(value = "bankId")
    @ApiModelProperty(value = "开户银行编号")
    @TableField("bankId")
    private Integer bankId;

    @JsonProperty(value = "bankAccount")
    @ApiModelProperty(value = "银行账户")
    @TableField("bankAccount")
    private String bankAccount;

    @JsonProperty(value = "contacts")
    @ApiModelProperty(value = "紧急联系人")
    private String contacts;

    @JsonProperty(value = "cphone")
    @ApiModelProperty(value = "联系电话")
    private String cphone;

    @JsonProperty(value = "entryDate")
    @ApiModelProperty(value = "入职日期")
    @TableField("entryDate")
    private String entryDate;

    @JsonProperty(value = "proDate")
    @ApiModelProperty(value = "试用到期")
    @TableField("proDate")
    private String proDate;

    @JsonProperty(value = "birth")
    @ApiModelProperty(value = "生日")
    private String birth;

    @JsonProperty(value = "pactBegin")
    @ApiModelProperty(value = "合同开始")
    @TableField("pactBegin")
    private String pactBegin;

    @JsonProperty(value = "pactEnd")
    @ApiModelProperty(value = "合同结束")
    @TableField("pactEnd")
    private String pactEnd;

    @JsonProperty(value = "kzId")
    @ApiModelProperty(value = "卡自编号")
    @TableField("kzId")
    private String kzId;

    @JsonProperty(value = "knId")
    @ApiModelProperty(value = "卡内编号")
    @TableField("knId")
    private String knId;

    @JsonProperty(value = "referrer")
    @ApiModelProperty(value = "推荐人")
    private String referrer;

    @JsonProperty(value ="billDiscount" )
    @ApiModelProperty(value = "整单折扣权")
    @TableField("billDiscount")
    private Integer billDiscount;

    @JsonProperty(value = "hourDiscount")
    @ApiModelProperty(value = "工时折扣权")
    @TableField("hourDiscount")
    private Integer hourDiscount;

    @JsonProperty(value = "shopDiscount")
    @ApiModelProperty(value = "商品折扣权")
    @TableField("shopDiscount")
    private Integer shopDiscount;

    @JsonProperty(value = "relief")
    @ApiModelProperty(value = "减免权")
    private String relief;

    @JsonProperty(value = "dismission")
    @ApiModelProperty(value = "离职标识(0/1)")
    private Integer dismission;

    @JsonProperty(value = "pwd")
    @ApiModelProperty(value = "员工密码")
    private String pwd;

    @JsonProperty(value = "img")
    @ApiModelProperty(value = "照片")
    private String img;

    @JsonProperty(value = "educationBackground")
    @ApiModelProperty(value = "教育经历")
    @TableField("educationBackground")
    private String educationBackground;

    @JsonProperty(value = "jiangFa")
    @ApiModelProperty(value = "奖罚记录")
    @TableField("jiangFa")
    private String jiangFa;

    @JsonProperty(value = "hire")
    @ApiModelProperty(value = "聘用意见")
    private String hire;

    @JsonProperty(value = "resume")
    @ApiModelProperty(value = "工作简历")
    private String resume;

    @JsonProperty(value = "family")
    @ApiModelProperty(value = "家庭成员")
    private String family;

    @JsonProperty(value = "extension")
    @ApiModelProperty(value = "分机/短号")
    private String extension;

    @JsonProperty(value = "direct")
    @ApiModelProperty(value = "直拨")
    private String direct;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;
    /*自定义*/
    @ApiModelProperty(value = "性别")
    @TableField(exist = false)
    private Sex sex;
    @ApiModelProperty(value = "门店")
    @TableField(exist = false)
    private Store store;
    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    private Department department;
    @ApiModelProperty(value = "岗位")
    @TableField(exist = false)
    private Job job;
    @ApiModelProperty(value = "籍贯实体")
    @TableField(exist = false)
    private Nativeplace nativeplace;
    @ApiModelProperty(value = "民族实体")
    @TableField(exist = false)
    private National national;
    @ApiModelProperty(value = "婚姻")
    @TableField(exist = false)
    private  Marry marry;
    @ApiModelProperty(value = "学历")
    @TableField(exist = false)
    private Education education;
    @ApiModelProperty(value = "毕业学校实体")
    @TableField(exist = false)
    private School school;
    @ApiModelProperty("专业")
    @TableField(exist = false)
    private  Major major;
    @ApiModelProperty("专业资格实体")
    @TableField(exist = false)
    private Pq pq;
    @ApiModelProperty("属性")
    @TableField(exist = false)
    private Nature nature;
    @ApiModelProperty("学位实体")
    @TableField(exist = false)
    private Degree degree;
    @ApiModelProperty("开户银行")
    @TableField(exist = false)
    private Bank bank;

    @JsonProperty(value = "entryDateStart")
    @ApiModelProperty(value = "入职开始时间")
    private String entryDateStart;
    @JsonProperty(value = "entryDateEnd")
    @ApiModelProperty(value = "入职结束时间")
    private String entryDateEnd;
    @JsonProperty(value = "proDateStart")
    @ApiModelProperty(value = "试用开始时间")
    private String proDateStart;
    @JsonProperty(value = "proDateEnd")
    @ApiModelProperty(value = "试用结束时间")
    private String proDateEnd;
}
