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
@ApiModel(value="Employees对象", description="")
public class Employees extends Model<Employees> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "员工编号")
    @TableId("eId")
    @JsonProperty(value = "eId")
    private String eId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("eName")
    @JsonProperty(value = "eName")
    private String eName;

    @ApiModelProperty(value = "员工性别")
    @TableField("sexId")
    @JsonProperty(value = "sexId")
    private Integer sexId;

    @ApiModelProperty(value = "所在门店")
    @TableField("mId")
    @JsonProperty(value = "mId")
    private Integer mId;

    @ApiModelProperty(value = "部门编号")
    @TableField("dId")
    @JsonProperty(value = "dId")
    private String dId;

    @ApiModelProperty(value = "登录账号")
    @JsonProperty(value = "login")
    private String login;

    @ApiModelProperty(value = "岗位编码")
    @TableField("jId")
    @JsonProperty(value ="jId")
    private String jId;

    @ApiModelProperty(value = "身体状态")
    @JsonProperty(value = "health")
    private String health;

    @ApiModelProperty(value = "身高(m)")
    @JsonProperty(value = "height")
    private Double height;

    @ApiModelProperty(value = "籍贯")
    @TableField("nplaceId")
    @JsonProperty(value = "nplaceId")
    private Integer nplaceId;

    @ApiModelProperty(value = "民族")
    @TableField("nationalId")
    @JsonProperty(value = "nationalId")
    private Integer nationalId;

    @ApiModelProperty(value = "婚姻状态")
    @TableField("marryId")
    @JsonProperty(value = "marryId")
    private Integer marryId;

    @ApiModelProperty(value = "学历编号")
    @TableField("educationId")
    @JsonProperty(value = "educationId")
    private Integer educationId;

    @ApiModelProperty(value = "毕业学校")
    @TableField("schoolId")
    @JsonProperty(value = "schoolId")
    private Integer schoolId;

    @ApiModelProperty(value = "专业id")
    @TableField("majorId")
    @JsonProperty(value = "majorId")
    private Integer majorId;

    @ApiModelProperty(value = "专业资格")
    @TableField("PQId")
    @JsonProperty(value = "PQId")
    private Integer PQId;

    @ApiModelProperty(value = "属性编号")
    @TableField("attId")
    @JsonProperty(value = "attId")
    private Integer attId;

    @ApiModelProperty(value = "学位")
    @TableField("degreeId")
    @JsonProperty(value = "degreeId")
    private Integer degreeId;

    @ApiModelProperty(value = "编制")
    @JsonProperty(value = "establish")
    private String establish;

    @ApiModelProperty(value = "身份证号")
    @TableField("cardId")
    @JsonProperty(value = "cardId")
    private String cardId;

    @ApiModelProperty(value = "户口地址")
    @TableField("hAddress")
    @JsonProperty(value = "hAddress")
    private String hAddress;

    @ApiModelProperty(value = "现住地址")
    @TableField("nAddress")
    @JsonProperty(value = "nAddress")
    private String nAddress;

    @ApiModelProperty(value = "电话")
    @JsonProperty(value = "tel")
    private String tel;

    @ApiModelProperty(value = "手机")
    @JsonProperty(value = "phone")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @JsonProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "开户银行编号")
    @JsonProperty(value = "bankId")
    @TableField("bankId")
    private Integer bankId;

    @ApiModelProperty(value = "银行账户")
    @TableField("bankAccount")
    @JsonProperty(value = "bankAccount")
    private String bankAccount;

    @ApiModelProperty(value = "紧急联系人")
    @JsonProperty(value = "contacts")
    private String contacts;

    @ApiModelProperty(value = "联系电话")
    @JsonProperty(value = "cphone")
    private String cphone;

    @ApiModelProperty(value = "入职日期")
    @TableField("entryDate")
    @JsonProperty(value = "entryDate")
    private String entryDate;

    @ApiModelProperty(value = "试用到期")
    @TableField("proDate")
    @JsonProperty(value = "proDate")
    private String proDate;

    @ApiModelProperty(value = "生日")
    @JsonProperty(value = "birth")
    private String birth;

    @ApiModelProperty(value = "合同开始")
    @TableField("pactBegin")
    @JsonProperty(value = "pactBegin")
    private String pactBegin;

    @ApiModelProperty(value = "合同结束")
    @TableField("pactEnd")
    @JsonProperty(value = "pactEnd")
    private String pactEnd;

    @ApiModelProperty(value = "卡自编号")
    @TableField("kzId")
    @JsonProperty(value = "kzId")
    private String kzId;

    @ApiModelProperty(value = "卡内编号")
    @TableField("knId")
    @JsonProperty(value = "knId")
    private String knId;

    @ApiModelProperty(value = "推荐人")
    @JsonProperty(value = "referrer")
    private String referrer;

    @ApiModelProperty(value = "整单折扣权")
    @TableField("billDiscount")
    @JsonProperty(value = "billDiscount")
    private Integer billDiscount;

    @ApiModelProperty(value = "工时折扣权")
    @TableField("hourDiscount")
    @JsonProperty(value = "hourDiscount")
    private Integer hourDiscount;

    @ApiModelProperty(value = "商品折扣权")
    @TableField("shopDiscount")
    @JsonProperty(value = "shopDiscount")
    private Integer shopDiscount;

    @ApiModelProperty(value = "减免权")
    @JsonProperty(value = "relief")
    private String relief;

    @ApiModelProperty(value = "离职标识(0/1)")
    @JsonProperty(value = "dismission")
    private Integer dismission;

    @ApiModelProperty(value = "员工密码")
    @JsonProperty(value = "pwd")
    private String pwd;

    @ApiModelProperty(value = "照片")
    @JsonProperty(value = "img")
    private String img;

    @ApiModelProperty(value = "教育经历")
    @TableField("educationBackground")
    @JsonProperty(value = "educationBackground")
    private String educationBackground;

    @ApiModelProperty(value = "奖罚记录")
    @TableField("jiangFa")
    @JsonProperty(value = "jiangFa")
    private String jiangFa;

    @ApiModelProperty(value = "聘用意见")
    @JsonProperty(value = "hire")
    private String hire;

    @ApiModelProperty(value = "工作简历")
    @JsonProperty(value = "resume")
    private String resume;

    @ApiModelProperty(value = "家庭成员")
    @JsonProperty(value = "family")
    private String family;

    @ApiModelProperty(value = "分机/短号")
    @JsonProperty(value = "extension")
    private String extension;

    @ApiModelProperty(value = "直拨")
    @JsonProperty(value = "direct")
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
    @JsonProperty("department")
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



    public static final String EID = "eId";

    public static final String ENAME = "eName";

    public static final String SEXID = "sexId";

    public static final String MID = "mId";

    public static final String DID = "dId";

    public static final String LOGIN = "login";

    public static final String JID = "jId";

    public static final String HEALTH = "health";

    public static final String HEIGHT = "height";

    public static final String NPLACEID = "nplaceId";

    public static final String NATIONALID = "nationalId";

    public static final String MARRYID = "marryId";

    public static final String EDUCATIONID = "educationId";

    public static final String SCHOOLID = "schoolId";

    public static final String MAJORID = "majorId";

    public static final String PQID = "PQId";

    public static final String ATTID = "attId";

    public static final String DEGREEID = "degreeId";

    public static final String ESTABLISH = "establish";

    public static final String CARDID = "cardId";

    public static final String HADDRESS = "hAddress";

    public static final String NADDRESS = "nAddress";

    public static final String TEL = "tel";

    public static final String PHONE = "phone";

    public static final String EMAIL = "email";

    public static final String BANKID = "bankId";

    public static final String BANKACCOUNT = "bankAccount";

    public static final String CONTACTS = "contacts";

    public static final String CPHONE = "cphone";

    public static final String ENTRYDATE = "entryDate";

    public static final String PRODATE = "proDate";

    public static final String BIRTH = "birth";

    public static final String PACTBEGIN = "pactBegin";

    public static final String PACTEND = "pactEnd";

    public static final String KZID = "kzId";

    public static final String KNID = "knId";

    public static final String REFERRER = "referrer";

    public static final String BILLDISCOUNT = "billDiscount";

    public static final String HOURDISCOUNT = "hourDiscount";

    public static final String SHOPDISCOUNT = "shopDiscount";

    public static final String RELIEF = "relief";

    public static final String DISMISSION = "dismission";

    public static final String PWD = "pwd";

    public static final String IMG = "img";

    public static final String EDUCATIONBACKGROUND = "educationBackground";

    public static final String JIANGFA = "jiangFa";

    public static final String HIRE = "hire";

    public static final String RESUME = "resume";

    public static final String FAMILY = "family";

    public static final String EXTENSION = "extension";

    public static final String DIRECT = "direct";

    public static final String COLUMN1 = "column1";

    public static final String COLUMN2 = "column2";

    public static final String COLUMN3 = "column3";

    @Override
    protected Serializable pkVal() {
        return this.eId;
    }

}
