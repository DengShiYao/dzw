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
@ApiModel(value="Employees对象", description="")
public class Employees extends Model<Employees> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "员工编号")
    @TableId("eId")
    private String eId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("eName")
    private String eName;

    @ApiModelProperty(value = "员工性别")
    @TableField("sexId")
    private Integer sexId;

    @ApiModelProperty(value = "所在门店")
    @TableField("mId")
    private Integer mId;

    @ApiModelProperty(value = "部门编号")
    @TableField("dId")
    private String dId;

    @ApiModelProperty(value = "登录账号")
    private String login;

    @ApiModelProperty(value = "岗位编码")
    @TableField("jId")
    private String jId;

    @ApiModelProperty(value = "身体状态")
    private String health;

    @ApiModelProperty(value = "身高(m)")
    private Double height;

    @ApiModelProperty(value = "籍贯")
    @TableField("nplaceId")
    private Integer nplaceId;

    @ApiModelProperty(value = "民族")
    @TableField("nationalId")
    private Integer nationalId;

    @ApiModelProperty(value = "婚姻状态")
    @TableField("marryId")
    private Integer marryId;

    @ApiModelProperty(value = "学历编号")
    @TableField("educationId")
    private Integer educationId;

    @ApiModelProperty(value = "毕业学校")
    @TableField("schoolId")
    private Integer schoolId;

    @ApiModelProperty(value = "专业id")
    @TableField("majorId")
    private Integer majorId;

    @ApiModelProperty(value = "专业资格")
    @TableField("PQId")
    private Integer PQId;

    @ApiModelProperty(value = "属性编号")
    @TableField("attId")
    private Integer attId;

    @ApiModelProperty(value = "学位")
    @TableField("degreeId")
    private Integer degreeId;

    @ApiModelProperty(value = "编制")
    private String establish;

    @ApiModelProperty(value = "身份证号")
    @TableField("cardId")
    private String cardId;

    @ApiModelProperty(value = "户口地址")
    @TableField("hAddress")
    private String hAddress;

    @ApiModelProperty(value = "现住地址")
    @TableField("nAddress")
    private String nAddress;

    @ApiModelProperty(value = "电话")
    private String tel;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "开户银行编号")
    @TableField("bankId")
    private Integer bankId;

    @ApiModelProperty(value = "银行账户")
    @TableField("bankAccount")
    private String bankAccount;

    @ApiModelProperty(value = "紧急联系人")
    private String contacts;

    @ApiModelProperty(value = "联系电话")
    private String cphone;

    @ApiModelProperty(value = "入职日期")
    @TableField("entryDate")
    private String entryDate;

    @ApiModelProperty(value = "试用到期")
    @TableField("proDate")
    private String proDate;

    @ApiModelProperty(value = "生日")
    private String birth;

    @ApiModelProperty(value = "合同开始")
    @TableField("pactBegin")
    private String pactBegin;

    @ApiModelProperty(value = "合同结束")
    @TableField("pactEnd")
    private String pactEnd;

    @ApiModelProperty(value = "卡自编号")
    @TableField("kzId")
    private String kzId;

    @ApiModelProperty(value = "卡内编号")
    @TableField("knId")
    private String knId;

    @ApiModelProperty(value = "推荐人")
    private String referrer;

    @ApiModelProperty(value = "整单折扣权")
    @TableField("billDiscount")
    private Integer billDiscount;

    @ApiModelProperty(value = "工时折扣权")
    @TableField("hourDiscount")
    private Integer hourDiscount;

    @ApiModelProperty(value = "商品折扣权")
    @TableField("shopDiscount")
    private Integer shopDiscount;

    @ApiModelProperty(value = "减免权")
    private String relief;

    @ApiModelProperty(value = "离职标识(0/1)")
    private Integer dismission;

    @ApiModelProperty(value = "员工密码")
    private String pwd;

    @ApiModelProperty(value = "照片")
    private String img;

    @ApiModelProperty(value = "教育经历")
    @TableField("educationBackground")
    private String educationBackground;

    @ApiModelProperty(value = "奖罚记录")
    @TableField("jiangFa")
    private String jiangFa;

    @ApiModelProperty(value = "聘用意见")
    private String hire;

    @ApiModelProperty(value = "工作简历")
    private String resume;

    @ApiModelProperty(value = "家庭成员")
    private String family;

    @ApiModelProperty(value = "分机/短号")
    private String extension;

    @ApiModelProperty(value = "直拨")
    private String direct;

    @ApiModelProperty(value = "备用列")
    private String column1;

    @ApiModelProperty(value = "备用列")
    private String column2;

    @ApiModelProperty(value = "备用列")
    private String column3;


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
