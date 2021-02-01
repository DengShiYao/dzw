/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.60 : Database - dzw
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dzw` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dzw`;

/*Table structure for table `bank` */

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `bankId` int(10) NOT NULL AUTO_INCREMENT COMMENT '银行编号',
  `bankName` varchar(200) NOT NULL COMMENT '银行名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`bankId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bank` */

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `car_cph` varchar(50) NOT NULL COMMENT '车牌号码',
  `car_clpp` varchar(50) NOT NULL COMMENT '车辆品牌',
  `car_type` varchar(100) NOT NULL COMMENT '车辆型号',
  `car_jsy` varchar(100) NOT NULL COMMENT '驾驶员',
  `car_Phone` varchar(100) NOT NULL COMMENT '驾驶员电话',
  `car_csrq` datetime NOT NULL COMMENT '出生日期',
  `car_clgs` varchar(100) NOT NULL COMMENT '车辆归属',
  `car_jsydz` varchar(500) NOT NULL COMMENT '驾驶员地址',
  `car_jzdq` datetime NOT NULL COMMENT '驾照到期日期',
  `car_cjh` varchar(50) NOT NULL COMMENT '车架号',
  `car_fdjh` varchar(50) NOT NULL COMMENT '发动机号',
  `car_fdjpph` varchar(50) NOT NULL COMMENT '发动机品牌号',
  `car_cllk` varchar(50) NOT NULL COMMENT '车辆年款',
  `car_lc` varchar(50) NOT NULL COMMENT '里程',
  `car_zz` varchar(50) NOT NULL COMMENT '载重',
  `car_cx` varchar(50) NOT NULL COMMENT '车系',
  `car_gmrq` datetime NOT NULL COMMENT '购买日期',
  `car_sprq` datetime NOT NULL COMMENT '上牌日期',
  `car_cjdq` datetime NOT NULL COMMENT '车检到期',
  `carjqxbxgs` varchar(100) NOT NULL COMMENT '交强险保险公司',
  `car_jqxdq` datetime NOT NULL COMMENT '交强险到期日期',
  `car_sf` varchar(100) NOT NULL COMMENT '是否在我投保车中',
  `car_ewrq` datetime NOT NULL COMMENT '二维日期',
  `car_rylb` varchar(100) NOT NULL COMMENT '燃油类别',
  `car_xcbylc` varchar(100) NOT NULL COMMENT '下次保养里程',
  `car_xcbyrq` datetime NOT NULL COMMENT '下次保养日期',
  `car_hym` varchar(100) NOT NULL COMMENT '会员码',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用给',
  PRIMARY KEY (`car_cph`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car` */

/*Table structure for table `car_dj` */

DROP TABLE IF EXISTS `car_dj`;

CREATE TABLE `car_dj` (
  `car_id` int(4) NOT NULL COMMENT '车辆ID',
  `car_type` varchar(100) NOT NULL COMMENT '业务类型',
  `car_name` varchar(100) NOT NULL COMMENT '客户名称',
  `car_cph` varchar(100) NOT NULL COMMENT '车牌号',
  `car_sjh` varchar(100) NOT NULL COMMENT '手机号',
  `car_hhkh` varchar(100) NOT NULL COMMENT '会员卡号',
  `car_wxdh` varchar(100) NOT NULL COMMENT '维修单号',
  `car_djlx` varchar(100) NOT NULL COMMENT '单据类型',
  `car_kdsj` datetime NOT NULL COMMENT '开单时间',
  `car_wgsj` datetime NOT NULL COMMENT '完工时间',
  `car_jsjsj` datetime NOT NULL COMMENT '结算时间',
  `car_ygjh` double NOT NULL COMMENT '预估金额',
  `car_whgwmc` varchar(100) NOT NULL COMMENT '服务顾问名称',
  `car_jcr` varchar(100) NOT NULL COMMENT '接车人名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_dj` */

/*Table structure for table `car_icon` */

DROP TABLE IF EXISTS `car_icon`;

CREATE TABLE `car_icon` (
  `ic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌编码',
  `ic_name` varchar(200) DEFAULT NULL COMMENT '车型图片',
  `car_id` varchar(100) DEFAULT NULL COMMENT '车型ID',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`ic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_icon` */

/*Table structure for table `car_type` */

DROP TABLE IF EXISTS `car_type`;

CREATE TABLE `car_type` (
  `car_id` varchar(100) NOT NULL COMMENT '车型ID',
  `car_name` varchar(100) DEFAULT NULL COMMENT '车型名称',
  `engine_name` varchar(100) NOT NULL COMMENT '发动机品牌',
  `reference_price` double DEFAULT NULL COMMENT '参考价格',
  `car_style` varchar(100) DEFAULT NULL COMMENT '车辆年款',
  `power` double DEFAULT NULL COMMENT '	功率',
  `sid` int(11) NOT NULL COMMENT '索赔厂商',
  `import_and_domestic` int(11) NOT NULL COMMENT '进口国产',
  `fuel_number` varchar(100) DEFAULT NULL COMMENT '燃油标号',
  `loadbearing` double DEFAULT NULL COMMENT '载重',
  `brand_name` varchar(100) NOT NULL COMMENT '汽车品牌',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`car_id`),
  KEY `sid` (`sid`),
  KEY `import_and_domestic` (`import_and_domestic`),
  CONSTRAINT `car_type_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `suppliers_region` (`sid`),
  CONSTRAINT `car_type_ibfk_2` FOREIGN KEY (`import_and_domestic`) REFERENCES `import_and_domestic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_type` */

/*Table structure for table `consumer` */

DROP TABLE IF EXISTS `consumer`;

CREATE TABLE `consumer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `khid` int(11) DEFAULT NULL COMMENT '客户编号',
  `khName` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `adress` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `lxpeople` varchar(100) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `birthday` varchar(100) DEFAULT NULL COMMENT '客户生日',
  `khcategory` varchar(100) DEFAULT NULL COMMENT '客户类别',
  `yhnumber` varchar(100) DEFAULT NULL COMMENT '会员卡号',
  `rhtime` varchar(100) DEFAULT NULL COMMENT '入会日期',
  `dqtime` varchar(100) DEFAULT NULL COMMENT '会员到期',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `jdtime` varchar(100) DEFAULT NULL COMMENT '建档日期',
  `fwgw` varchar(100) DEFAULT NULL COMMENT '服务顾问',
  `ywphone` varchar(100) DEFAULT NULL COMMENT '业务员电话',
  `zq` varchar(100) DEFAULT NULL COMMENT '账期',
  `gzmoeny` int(11) DEFAULT NULL COMMENT '挂账额度',
  `khsheng` varchar(100) DEFAULT NULL COMMENT '客户省',
  `khshi` varchar(100) DEFAULT NULL COMMENT '客户市',
  `khq` varchar(100) DEFAULT NULL COMMENT '客户区',
  `nsr` int(11) DEFAULT NULL COMMENT '纳税人识别号',
  `zcdh` varchar(100) DEFAULT NULL COMMENT '注册电话',
  `khyh` varchar(100) DEFAULT NULL COMMENT '开户银行',
  `zcadress` varchar(100) DEFAULT NULL COMMENT '注册地址',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `consumer` */

/*Table structure for table `degree` */

DROP TABLE IF EXISTS `degree`;

CREATE TABLE `degree` (
  `degreeId` int(10) NOT NULL AUTO_INCREMENT COMMENT '学位id,主键，自增',
  `degreeName` varchar(200) DEFAULT NULL COMMENT '学位名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`degreeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `degree` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `dId` varchar(200) NOT NULL COMMENT '部门编号',
  `dName` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `tId` int(10) DEFAULT NULL COMMENT '部门类型编号',
  `sId` int(10) DEFAULT NULL COMMENT '所属门店',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`dId`),
  KEY `sId` (`sId`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `store` (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

/*Table structure for table `departmenttype` */

DROP TABLE IF EXISTS `departmenttype`;

CREATE TABLE `departmenttype` (
  `tId` int(10) NOT NULL COMMENT '部门类型编号',
  `tName` varchar(200) DEFAULT NULL COMMENT '部门类型名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`tId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `departmenttype` */

/*Table structure for table `departure` */

DROP TABLE IF EXISTS `departure`;

CREATE TABLE `departure` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `eId` varchar(200) DEFAULT NULL COMMENT '员工编号',
  `dismissDate` varchar(200) DEFAULT NULL COMMENT '离职时间',
  `dismissReason` varchar(300) DEFAULT NULL COMMENT '离职原因',
  `registId` int(11) DEFAULT NULL COMMENT '登记人',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `dId` varchar(200) DEFAULT NULL COMMENT '部门编号',
  `sId` int(10) DEFAULT NULL COMMENT '所属门店',
  `name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `jobId` varchar(200) DEFAULT NULL COMMENT '岗位编码',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`id`),
  KEY `eId` (`eId`),
  KEY `sId` (`sId`),
  KEY `registId` (`registId`),
  KEY `dId` (`dId`),
  KEY `jobId` (`jobId`),
  CONSTRAINT `departure_ibfk_1` FOREIGN KEY (`eId`) REFERENCES `employees` (`eId`),
  CONSTRAINT `departure_ibfk_2` FOREIGN KEY (`sId`) REFERENCES `store` (`storeId`),
  CONSTRAINT `departure_ibfk_3` FOREIGN KEY (`registId`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `departure_ibfk_4` FOREIGN KEY (`dId`) REFERENCES `department` (`dId`),
  CONSTRAINT `departure_ibfk_5` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `departure` */

/*Table structure for table `education` */

DROP TABLE IF EXISTS `education`;

CREATE TABLE `education` (
  `educationId` int(10) NOT NULL AUTO_INCREMENT COMMENT '学历编号',
  `educationName` varchar(200) NOT NULL COMMENT '学历',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`educationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `education` */

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `eId` varchar(200) NOT NULL COMMENT '员工编号',
  `eName` varchar(200) NOT NULL COMMENT '员工姓名',
  `sexId` int(10) DEFAULT NULL COMMENT '员工性别',
  `mId` int(10) DEFAULT NULL COMMENT '所在门店',
  `dId` varchar(200) DEFAULT NULL COMMENT '部门编号',
  `login` varchar(200) DEFAULT NULL COMMENT '登录账号',
  `jId` varchar(50) DEFAULT NULL COMMENT '岗位编码',
  `health` varchar(200) DEFAULT NULL COMMENT '身体状态',
  `height` double DEFAULT NULL COMMENT '身高(m)',
  `nplaceId` int(10) DEFAULT NULL COMMENT '籍贯',
  `nationalId` int(10) DEFAULT NULL COMMENT '民族',
  `marryId` int(10) DEFAULT NULL COMMENT '婚姻状态',
  `educationId` int(10) DEFAULT NULL COMMENT '学历编号',
  `schoolId` int(10) DEFAULT NULL COMMENT '毕业学校',
  `majorId` int(10) DEFAULT NULL COMMENT '专业id',
  `PQId` int(10) DEFAULT NULL COMMENT '专业资格',
  `attId` int(10) DEFAULT NULL COMMENT '属性编号',
  `degreeId` int(10) DEFAULT NULL COMMENT '学位',
  `establish` varchar(200) DEFAULT NULL COMMENT '编制',
  `cardId` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `hAddress` varchar(255) DEFAULT NULL COMMENT '户口地址',
  `nAddress` varchar(255) DEFAULT NULL COMMENT '现住地址',
  `tel` varchar(200) DEFAULT NULL COMMENT '电话',
  `phone` varchar(200) DEFAULT NULL COMMENT '手机',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `bankId` int(10) DEFAULT NULL COMMENT '开户银行编号',
  `bankAccount` varchar(200) DEFAULT NULL COMMENT '银行账户',
  `contacts` varchar(200) DEFAULT NULL COMMENT '紧急联系人',
  `cphone` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `entryDate` varchar(200) DEFAULT NULL COMMENT '入职日期',
  `proDate` varchar(200) DEFAULT NULL COMMENT '试用到期',
  `birth` varchar(200) DEFAULT NULL COMMENT '生日',
  `pactBegin` varchar(200) DEFAULT NULL COMMENT '合同开始',
  `pactEnd` varchar(200) DEFAULT NULL COMMENT '合同结束',
  `kzId` varchar(200) DEFAULT NULL COMMENT '卡自编号',
  `knId` varchar(200) DEFAULT NULL COMMENT '卡内编号',
  `referrer` varchar(200) DEFAULT NULL COMMENT '推荐人',
  `billDiscount` int(10) DEFAULT NULL COMMENT '整单折扣权',
  `hourDiscount` int(10) DEFAULT NULL COMMENT '工时折扣权',
  `shopDiscount` int(10) DEFAULT NULL COMMENT '商品折扣权',
  `relief` varchar(200) DEFAULT NULL COMMENT '减免权',
  `dismission` int(10) DEFAULT '0' COMMENT '离职标识(0/1)',
  `pwd` varchar(200) DEFAULT NULL COMMENT '员工密码',
  `img` varchar(200) DEFAULT NULL COMMENT '照片',
  `educationBackground` text COMMENT '教育经历',
  `jiangFa` text COMMENT '奖罚记录',
  `hire` text COMMENT '聘用意见',
  `resume` text COMMENT '工作简历',
  `family` text COMMENT '家庭成员',
  `extension` varchar(200) DEFAULT NULL COMMENT '分机/短号',
  `direct` varchar(200) DEFAULT NULL COMMENT '直拨',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`eId`),
  KEY `sexId` (`sexId`),
  KEY `nplaceId` (`nplaceId`),
  KEY `nationalId` (`nationalId`),
  KEY `marryId` (`marryId`),
  KEY `educationId` (`educationId`),
  KEY `schoolId` (`schoolId`),
  KEY `majorId` (`majorId`),
  KEY `PQId` (`PQId`),
  KEY `attId` (`attId`),
  KEY `degreeId` (`degreeId`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`sexId`) REFERENCES `sex` (`sexId`),
  CONSTRAINT `employees_ibfk_10` FOREIGN KEY (`degreeId`) REFERENCES `degree` (`degreeId`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`nplaceId`) REFERENCES `nativeplace` (`nplaceId`),
  CONSTRAINT `employees_ibfk_3` FOREIGN KEY (`nationalId`) REFERENCES `national` (`nationalId`),
  CONSTRAINT `employees_ibfk_4` FOREIGN KEY (`marryId`) REFERENCES `marry` (`marryId`),
  CONSTRAINT `employees_ibfk_5` FOREIGN KEY (`educationId`) REFERENCES `education` (`educationId`),
  CONSTRAINT `employees_ibfk_6` FOREIGN KEY (`schoolId`) REFERENCES `school` (`schoolId`),
  CONSTRAINT `employees_ibfk_7` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`),
  CONSTRAINT `employees_ibfk_8` FOREIGN KEY (`PQId`) REFERENCES `pq` (`PQId`),
  CONSTRAINT `employees_ibfk_9` FOREIGN KEY (`attId`) REFERENCES `nature` (`attId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employees` */

/*Table structure for table `field_vehicles` */

DROP TABLE IF EXISTS `field_vehicles`;

CREATE TABLE `field_vehicles` (
  `plate_number` varchar(255) NOT NULL COMMENT '车牌号',
  `brand` varchar(50) NOT NULL COMMENT '品牌',
  `motorcycle_type` varchar(50) DEFAULT NULL COMMENT '车型',
  `current_mileage` varchar(255) DEFAULT NULL COMMENT '当前里程',
  `attribution_team` varchar(50) DEFAULT NULL COMMENT '归属班组',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`plate_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `field_vehicles` */

/*Table structure for table `firm_grade` */

DROP TABLE IF EXISTS `firm_grade`;

CREATE TABLE `firm_grade` (
  `fg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级id',
  `fgrade` varchar(50) DEFAULT NULL COMMENT '等级',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`fg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `firm_grade` */

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `goods_id` varchar(100) NOT NULL COMMENT '商品编码',
  `goods_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `gb_id` int(11) DEFAULT NULL COMMENT '商品品牌',
  `engine_type` varchar(100) DEFAULT NULL COMMENT '适用车型',
  `Unit` varchar(100) DEFAULT NULL COMMENT '数量单位',
  `goods_c_id` varchar(100) DEFAULT NULL COMMENT '商品类别',
  `i_id` int(11) DEFAULT NULL COMMENT '收入分类',
  `Spec5` varchar(100) DEFAULT NULL COMMENT '原厂副厂',
  `Spec6` varchar(100) DEFAULT NULL COMMENT '商品等级',
  `pro_id` int(11) DEFAULT NULL COMMENT '商品产地',
  `ProvCode` varchar(200) DEFAULT NULL COMMENT '厂商代码',
  `ProvName` varchar(200) DEFAULT NULL COMMENT '厂商名称',
  `OldBM` varchar(100) DEFAULT NULL COMMENT '原厂编码',
  `ItemTM` varchar(100) DEFAULT NULL COMMENT '条形码',
  `PackSpec` varchar(100) DEFAULT NULL COMMENT '包装规格',
  `Spec` varchar(100) DEFAULT NULL COMMENT '体积A',
  `GrossWeight` varchar(100) DEFAULT NULL COMMENT '毛重',
  `NetWeight` varchar(100) DEFAULT NULL COMMENT '净重',
  `MZScale` varchar(100) DEFAULT NULL COMMENT '加价率',
  `InterchangeNo` varchar(100) DEFAULT NULL COMMENT '互换码',
  `ZD3` varchar(100) DEFAULT NULL COMMENT '售价按',
  `price` double DEFAULT NULL COMMENT '标准价',
  `member_price` double DEFAULT NULL COMMENT '会员价',
  `vip_price` double DEFAULT NULL COMMENT 'VIP价',
  `protocol_price` double DEFAULT NULL COMMENT '协议价',
  `claim_price` double DEFAULT NULL COMMENT '索赔价',
  `insurance_price` double DEFAULT NULL COMMENT '保险价格',
  `block_up` int(11) DEFAULT '1' COMMENT '0停用/1启用',
  `good_width` double DEFAULT '200' COMMENT '字段宽度',
  `good_show` int(11) DEFAULT '1' COMMENT '0隐藏/1显示',
  `booldel` int(11) DEFAULT NULL COMMENT '真假删除 0假/1真',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`goods_id`),
  KEY `gb_id` (`gb_id`),
  KEY `goods_c_id` (`goods_c_id`),
  KEY `pro_id` (`pro_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`gb_id`) REFERENCES `goods_brand` (`gb_id`),
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`goods_c_id`) REFERENCES `goods_category` (`goods_c_id`),
  CONSTRAINT `goods_ibfk_3` FOREIGN KEY (`pro_id`) REFERENCES `provinces` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

/*Table structure for table `goods_brand` */

DROP TABLE IF EXISTS `goods_brand`;

CREATE TABLE `goods_brand` (
  `gb_id` int(11) NOT NULL COMMENT '品牌id',
  `gb_name` varchar(100) NOT NULL COMMENT '品牌名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`gb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_brand` */

/*Table structure for table `goods_category` */

DROP TABLE IF EXISTS `goods_category`;

CREATE TABLE `goods_category` (
  `goods_c_id` varchar(100) NOT NULL COMMENT '分类编码',
  `goods_name` varchar(100) NOT NULL COMMENT '分类名称',
  `parentid` varchar(100) NOT NULL COMMENT '父级Id',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`goods_c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_category` */

/*Table structure for table `goods_icon` */

DROP TABLE IF EXISTS `goods_icon`;

CREATE TABLE `goods_icon` (
  `ic_id` int(11) NOT NULL AUTO_INCREMENT,
  `ic_name` varchar(200) NOT NULL COMMENT '图片名',
  `goods_id` varchar(100) NOT NULL COMMENT '商品ID',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`ic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_icon` */

/*Table structure for table `group_tb` */

DROP TABLE IF EXISTS `group_tb`;

CREATE TABLE `group_tb` (
  `group_id` varchar(100) NOT NULL COMMENT '组id',
  `group_name` varchar(100) DEFAULT NULL COMMENT '组名称',
  `initial` varchar(100) DEFAULT '“”' COMMENT '首字母',
  `parentid` varchar(100) DEFAULT NULL COMMENT '父级id',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `group_tb` */

/*Table structure for table `import_and_domestic` */

DROP TABLE IF EXISTS `import_and_domestic`;

CREATE TABLE `import_and_domestic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌编码',
  `name` varchar(50) NOT NULL COMMENT '进口国产',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `import_and_domestic` */

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `jobId` varchar(50) NOT NULL COMMENT '岗位编码',
  `jobName` varchar(200) NOT NULL COMMENT '岗位名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `job` */

/*Table structure for table `jy_biao` */

DROP TABLE IF EXISTS `jy_biao`;

CREATE TABLE `jy_biao` (
  `jy_No` varchar(100) NOT NULL COMMENT '维修单号',
  `jy_djlx` varchar(100) NOT NULL COMMENT '单据类型',
  `jy_ywbc` varchar(100) NOT NULL COMMENT '业务类型',
  `jy_sgbc` varchar(100) NOT NULL COMMENT '施工班次',
  `jy_cz_Name` varchar(100) NOT NULL COMMENT '车主姓名',
  `jy_cph` varchar(100) NOT NULL COMMENT '车牌号',
  `jy_cx` varchar(100) NOT NULL COMMENT '车型',
  `jy_cjh` varchar(100) NOT NULL COMMENT '车架号',
  `jy_jcsj` datetime NOT NULL COMMENT '接车时间',
  `jy_yjwj` datetime NOT NULL COMMENT '预计完工',
  `jy_wgyy` varchar(500) NOT NULL COMMENT '误工原因',
  `jy_zyr` varchar(50) NOT NULL COMMENT '责任人',
  `jy_cfje` double NOT NULL COMMENT '处罚金额',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`jy_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jy_biao` */

/*Table structure for table `kh_biao` */

DROP TABLE IF EXISTS `kh_biao`;

CREATE TABLE `kh_biao` (
  `kh_bm` varchar(50) NOT NULL COMMENT '客户编码',
  `kh_mc` varchar(50) NOT NULL COMMENT '客户名称',
  `kh_dz` varchar(500) NOT NULL COMMENT '客户详细地址',
  `kh_lianxiren` varchar(50) NOT NULL COMMENT '联系人',
  `kh_sjh` varchar(11) NOT NULL COMMENT '手机号',
  `kh_sr` datetime NOT NULL COMMENT '客户生日日期',
  `kh_lb` varchar(50) NOT NULL COMMENT '客户类别',
  `kh_hykh` varchar(50) NOT NULL COMMENT '会员卡号',
  `kh_rhrq` datetime NOT NULL COMMENT '入会日期',
  `kh_hydq` datetime NOT NULL COMMENT '会员到期',
  `kh_bz` varchar(500) NOT NULL COMMENT '备注',
  `kh_jdrq` datetime NOT NULL COMMENT '建档日期',
  `kh_fwgw` varchar(50) NOT NULL COMMENT '服务顾问',
  `kh_zqts` int(11) NOT NULL COMMENT '账期(天数)',
  `kh_gz_ed` double NOT NULL COMMENT '挂账额度',
  `kh_ljjf` double NOT NULL COMMENT '累计积分',
  `kh_djje` double NOT NULL COMMENT '定金金额',
  `kh_khs1` varchar(100) NOT NULL COMMENT '客户省',
  `kh_khs2` varchar(100) NOT NULL COMMENT '客户市',
  `kh_khq` varchar(100) NOT NULL COMMENT '客户区',
  `kh_nsrsbh` varchar(100) NOT NULL COMMENT '纳税人识别号',
  `kh_zcdh` varchar(100) NOT NULL COMMENT '注册电话',
  `kh_khyh` varchar(100) NOT NULL COMMENT '开户银行',
  `kh_yhzh` varchar(100) NOT NULL COMMENT '银行账号',
  `kh_zcdz` varchar(500) NOT NULL COMMENT '注册地址',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`kh_bm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `kh_biao` */

/*Table structure for table `linliao_biao` */

DROP TABLE IF EXISTS `linliao_biao`;

CREATE TABLE `linliao_biao` (
  `Ll_id` int(4) NOT NULL COMMENT 'ID',
  `Ll_Time` datetime NOT NULL COMMENT '领料时间',
  `Ll_Name` varchar(100) NOT NULL COMMENT '领料人',
  `Ll_Wl_bm` varchar(100) NOT NULL COMMENT '物料编码',
  `Ll_Wl_Name` varchar(100) NOT NULL COMMENT '物料名称',
  `Ll_Danwei_name` varchar(100) NOT NULL COMMENT '单位名称',
  `Ll_jl` varchar(100) NOT NULL COMMENT '价类',
  `Ll_sl` double NOT NULL COMMENT '数量',
  `Ll_dj` double NOT NULL COMMENT '单价',
  `Ll_e` double NOT NULL COMMENT '金额',
  `Ll_mdyl` varchar(100) NOT NULL COMMENT '免单原因',
  `Ll_hszt` varchar(100) NOT NULL COMMENT '回收状态',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`Ll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `linliao_biao` */

/*Table structure for table `list_of_sales` */

DROP TABLE IF EXISTS `list_of_sales`;

CREATE TABLE `list_of_sales` (
  `sales_order` varchar(255) NOT NULL COMMENT '销售单号',
  `billsType` varchar(50) DEFAULT NULL COMMENT '单据类型',
  `balance` varchar(50) DEFAULT NULL COMMENT '结算方式',
  `billstatus` varchar(50) DEFAULT NULL COMMENT '单据状态',
  `settlement_status` varchar(50) DEFAULT NULL COMMENT '结算状态',
  `settlement_time` varchar(255) DEFAULT NULL COMMENT '结算时间',
  `settlement_user` varchar(50) DEFAULT NULL COMMENT '结算人',
  `settlement_money` int(4) DEFAULT NULL COMMENT '结算金额',
  `service_type` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `username` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `plate_number` varchar(100) DEFAULT NULL COMMENT '车牌号',
  `motorcycle_type` varchar(50) DEFAULT NULL COMMENT '车型',
  `frame` varchar(100) DEFAULT NULL COMMENT '车架号',
  `phone` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `insurer` varchar(100) DEFAULT NULL COMMENT '保险公司',
  `Indemnity_company` varchar(100) DEFAULT NULL COMMENT '赔款公司',
  `license_plate` varchar(100) DEFAULT NULL COMMENT '对方车牌',
  `service_Adviser` varchar(100) DEFAULT NULL COMMENT '服务顾问',
  `completion_time` varchar(255) DEFAULT NULL COMMENT '完工时间',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`sales_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `list_of_sales` */

/*Table structure for table `maintenance` */

DROP TABLE IF EXISTS `maintenance`;

CREATE TABLE `maintenance` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cheNumber` varchar(100) DEFAULT NULL COMMENT '车牌号',
  `jh` varchar(100) DEFAULT NULL COMMENT '保养计划',
  `jhtime` varchar(100) DEFAULT NULL COMMENT '计划日期',
  `jhlc` varchar(100) DEFAULT NULL COMMENT '计划里程',
  `sjtime` varchar(100) DEFAULT NULL COMMENT '实际日期',
  `sjlc` varchar(100) DEFAULT NULL COMMENT '实际里程',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `maintenance` */

/*Table structure for table `major` */

DROP TABLE IF EXISTS `major`;

CREATE TABLE `major` (
  `majorId` int(10) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `majorName` varchar(200) NOT NULL COMMENT '专业名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`majorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `major` */

/*Table structure for table `marry` */

DROP TABLE IF EXISTS `marry`;

CREATE TABLE `marry` (
  `marryId` int(10) NOT NULL AUTO_INCREMENT COMMENT '民族id,主键，自增',
  `marryName` varchar(200) DEFAULT NULL COMMENT '民族名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`marryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `marry` */

/*Table structure for table `mechanicsstar_level` */

DROP TABLE IF EXISTS `mechanicsstar_level`;

CREATE TABLE `mechanicsstar_level` (
  `crade_code` varchar(50) NOT NULL COMMENT '等级编码',
  `crade_name` varchar(50) NOT NULL COMMENT '等级名称',
  `full_commission` int(11) NOT NULL COMMENT '提成权重',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`crade_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mechanicsstar_level` */

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `mId` int(10) NOT NULL COMMENT '会员编号',
  `mName` varchar(200) DEFAULT NULL COMMENT '会员姓名',
  `mPrice` double DEFAULT NULL COMMENT '会员余额',
  `createDate` varchar(200) DEFAULT NULL COMMENT '注册时间',
  `mPwd` varchar(200) DEFAULT NULL COMMENT '会员密码',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member` */

/*Table structure for table `national` */

DROP TABLE IF EXISTS `national`;

CREATE TABLE `national` (
  `nationalId` int(10) NOT NULL AUTO_INCREMENT COMMENT '民族id,主键，自增',
  `nationalName` varchar(200) DEFAULT NULL COMMENT '民族名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`nationalId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `national` */

/*Table structure for table `nativeplace` */

DROP TABLE IF EXISTS `nativeplace`;

CREATE TABLE `nativeplace` (
  `nplaceId` int(10) NOT NULL AUTO_INCREMENT COMMENT '籍贯编号,主键，自增',
  `nplaceName` varchar(200) DEFAULT NULL COMMENT '籍贯名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`nplaceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `nativeplace` */

/*Table structure for table `nature` */

DROP TABLE IF EXISTS `nature`;

CREATE TABLE `nature` (
  `attId` int(10) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `attName` varchar(200) DEFAULT NULL COMMENT '属性名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`attId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `nature` */

/*Table structure for table `payment_method` */

DROP TABLE IF EXISTS `payment_method`;

CREATE TABLE `payment_method` (
  `pm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pmethod` varchar(50) DEFAULT NULL COMMENT '付款方式',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`pm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `payment_method` */

/*Table structure for table `pq` */

DROP TABLE IF EXISTS `pq`;

CREATE TABLE `pq` (
  `PQId` int(10) NOT NULL AUTO_INCREMENT COMMENT '专业资格id,主键自增',
  `PQName` varchar(200) DEFAULT NULL COMMENT '专业资格',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`PQId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pq` */

/*Table structure for table `provinces` */

DROP TABLE IF EXISTS `provinces`;

CREATE TABLE `provinces` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `provinceid` varchar(100) NOT NULL COMMENT '城市编号',
  `province` varchar(100) NOT NULL COMMENT '城市名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `provinces` */

/*Table structure for table `recharge` */

DROP TABLE IF EXISTS `recharge`;

CREATE TABLE `recharge` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `mId` int(10) DEFAULT NULL COMMENT '会员号',
  `rechargeDate` varchar(200) DEFAULT NULL COMMENT '充值时间',
  `eId` varchar(200) DEFAULT NULL COMMENT '操作人',
  `money` double DEFAULT NULL COMMENT '充值金额',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`id`),
  KEY `mId` (`mId`),
  KEY `eId` (`eId`),
  CONSTRAINT `recharge_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`),
  CONSTRAINT `recharge_ibfk_2` FOREIGN KEY (`eId`) REFERENCES `employees` (`eId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recharge` */

/*Table structure for table `rectify` */

DROP TABLE IF EXISTS `rectify`;

CREATE TABLE `rectify` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号,自增，主键',
  `mId` int(10) DEFAULT NULL COMMENT '会员号，外键会员表',
  `eId` varchar(200) DEFAULT NULL COMMENT '操作人,外键员工表',
  `rectifyDate` varchar(200) DEFAULT NULL COMMENT '矫正时间',
  `money` double DEFAULT NULL COMMENT '矫正金额',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`id`),
  KEY `mId` (`mId`),
  KEY `eId` (`eId`),
  CONSTRAINT `rectify_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`),
  CONSTRAINT `rectify_ibfk_2` FOREIGN KEY (`eId`) REFERENCES `employees` (`eId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rectify` */

/*Table structure for table `school` */

DROP TABLE IF EXISTS `school`;

CREATE TABLE `school` (
  `schoolId` int(10) NOT NULL AUTO_INCREMENT COMMENT '毕业学校id,主键，自增',
  `schoolName` varchar(200) DEFAULT NULL COMMENT '学校名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`schoolId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `school` */

/*Table structure for table `serve` */

DROP TABLE IF EXISTS `serve`;

CREATE TABLE `serve` (
  `se_id` varchar(100) NOT NULL COMMENT '项目编码',
  `se_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `i_id` int(11) DEFAULT NULL COMMENT '收入种类',
  `brand_id` varchar(100) DEFAULT NULL COMMENT '项目类别',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `price` double DEFAULT NULL COMMENT '标准价',
  `member_price` double DEFAULT NULL COMMENT '会员价',
  `vip_price` double DEFAULT NULL COMMENT '	VIP价',
  `protocol_price` double DEFAULT NULL COMMENT '协议价',
  `claim_price` double DEFAULT NULL COMMENT '索赔价',
  `insurance_price` double DEFAULT NULL COMMENT '保险价格',
  `booldel` int(11) DEFAULT NULL COMMENT '真假删除 0假/1真',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`se_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `serve_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `group_tb` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `serve` */

/*Table structure for table `sex` */

DROP TABLE IF EXISTS `sex`;

CREATE TABLE `sex` (
  `sexId` int(10) NOT NULL AUTO_INCREMENT COMMENT '性别id,主键，自增',
  `sexName` varchar(200) DEFAULT NULL COMMENT '性别名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`sexId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sex` */

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `storeId` int(10) NOT NULL AUTO_INCREMENT COMMENT '门店编号',
  `storeName` varchar(200) NOT NULL COMMENT '门店名称',
  `pstoreId` int(10) NOT NULL COMMENT '父门店编号',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用了',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `store` */

/*Table structure for table `suppliers_contacts` */

DROP TABLE IF EXISTS `suppliers_contacts`;

CREATE TABLE `suppliers_contacts` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `sc_name` varchar(100) DEFAULT NULL COMMENT '联系人名称',
  `sc_post` varchar(100) DEFAULT NULL COMMENT '联系人职位',
  `sc_phone` varchar(100) DEFAULT NULL COMMENT '联系人手机',
  `sc_telephone` varchar(100) DEFAULT NULL COMMENT '联系人电话',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suppliers_contacts` */

/*Table structure for table `suppliers_icon` */

DROP TABLE IF EXISTS `suppliers_icon`;

CREATE TABLE `suppliers_icon` (
  `ic_id` int(11) NOT NULL AUTO_INCREMENT,
  `ic_name` varchar(200) NOT NULL COMMENT '图片',
  `sid` int(11) NOT NULL COMMENT '供货商表（suppliers_region）',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`ic_id`),
  KEY `sid` (`sid`),
  CONSTRAINT `suppliers_icon_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `suppliers_region` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suppliers_icon` */

/*Table structure for table `suppliers_region` */

DROP TABLE IF EXISTS `suppliers_region`;

CREATE TABLE `suppliers_region` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ProvCode` varchar(100) DEFAULT NULL COMMENT '厂商代码',
  `ProvName` varchar(100) DEFAULT NULL COMMENT '厂商名称',
  `Address` varchar(200) DEFAULT NULL COMMENT '地址',
  `Operation` varchar(200) DEFAULT NULL COMMENT '经营情况',
  `HttpA` varchar(200) DEFAULT NULL COMMENT '经营情况',
  `KHYH` varchar(200) DEFAULT NULL COMMENT '开户行',
  `YHZH` varchar(200) DEFAULT NULL COMMENT '银行账户',
  `pm_id` int(11) DEFAULT '1' COMMENT '支付方式',
  `fg_id` int(11) DEFAULT NULL COMMENT '厂商等级',
  `ZD2` varchar(100) DEFAULT NULL COMMENT '经营品牌',
  `ProvType` varchar(100) DEFAULT NULL COMMENT '厂商类别',
  `sc_id` int(11) DEFAULT NULL COMMENT '供货商联系人',
  `PreDay` int(11) DEFAULT NULL COMMENT '账期（天）',
  `Remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `region_id` varchar(100) DEFAULT NULL COMMENT '所属地区',
  `block_up` int(11) DEFAULT '1' COMMENT '0停用/1启用',
  `suppliers_width` double DEFAULT '200' COMMENT '字段宽度',
  `suppliers_show` int(11) DEFAULT '1' COMMENT '0隐藏/1显示',
  `booldel` int(11) DEFAULT NULL COMMENT '真假删除 0假/1真',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`sid`),
  KEY `pm_id` (`pm_id`),
  KEY `fg_id` (`fg_id`),
  KEY `sc_id` (`sc_id`),
  KEY `region_id` (`region_id`),
  CONSTRAINT `suppliers_region_ibfk_1` FOREIGN KEY (`pm_id`) REFERENCES `payment_method` (`pm_id`),
  CONSTRAINT `suppliers_region_ibfk_2` FOREIGN KEY (`fg_id`) REFERENCES `firm_grade` (`fg_id`),
  CONSTRAINT `suppliers_region_ibfk_3` FOREIGN KEY (`sc_id`) REFERENCES `suppliers_contacts` (`sc_id`),
  CONSTRAINT `suppliers_region_ibfk_4` FOREIGN KEY (`region_id`) REFERENCES `suppliers_region_city` (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suppliers_region` */

/*Table structure for table `suppliers_region_city` */

DROP TABLE IF EXISTS `suppliers_region_city`;

CREATE TABLE `suppliers_region_city` (
  `region_id` varchar(100) NOT NULL COMMENT '分类编号',
  `region_name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  `parentid` varchar(100) DEFAULT NULL COMMENT '父级Id',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suppliers_region_city` */

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT NULL COMMENT '显示顺序',
  `url` varchar(200) DEFAULT NULL COMMENT '请求地址',
  `menu_type` char(1) DEFAULT NULL COMMENT '菜单类型',
  `char1` char(1) DEFAULT NULL COMMENT '菜单状态',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `status` char(1) DEFAULT NULL COMMENT '角色状态',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志（0代表存在 2代表删除）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色表角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单表菜单id',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_menu` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别（0男 1女 2未知）',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

/*Table structure for table `team_form` */

DROP TABLE IF EXISTS `team_form`;

CREATE TABLE `team_form` (
  `team_code` varchar(50) NOT NULL COMMENT '班组编码',
  `team_name` varchar(50) NOT NULL COMMENT '班组名称',
  `team_commission` int(11) NOT NULL COMMENT '班组权重',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`team_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `team_form` */

/*Table structure for table `technical` */

DROP TABLE IF EXISTS `technical`;

CREATE TABLE `technical` (
  `technical_number` varchar(50) NOT NULL COMMENT '技工编号',
  `technical_name` varchar(50) NOT NULL COMMENT '技工姓名',
  `technical_sex` char(2) NOT NULL COMMENT '性别',
  `headman` int(11) NOT NULL COMMENT '是否是组长',
  `team_code` varchar(50) NOT NULL COMMENT '所在班组',
  `phone` varchar(255) NOT NULL COMMENT '手机',
  `account_number` varchar(255) DEFAULT NULL COMMENT '登陆账号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生日期',
  `Microsignal` varchar(255) DEFAULT NULL COMMENT '微信号',
  `id_number` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `address2` varchar(255) DEFAULT NULL COMMENT '户口地址',
  `bank` varchar(255) DEFAULT NULL COMMENT '开户银行',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `crade_code` varchar(50) DEFAULT NULL COMMENT '等级编码',
  `Maintenance_type` varchar(255) DEFAULT NULL COMMENT '维修工种',
  `Maintenance_brand` varchar(255) DEFAULT NULL COMMENT '维修品牌',
  `dimission` int(11) DEFAULT NULL COMMENT '是否离职',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`technical_number`),
  KEY `team-code` (`team_code`),
  KEY `crade-code` (`crade_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `technical` */

/*Table structure for table `type_of_vehicle` */

DROP TABLE IF EXISTS `type_of_vehicle`;

CREATE TABLE `type_of_vehicle` (
  `vtypeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '型号序号',
  `enginetypeid` int(11) DEFAULT NULL COMMENT '发动机品牌',
  `vtypeno` varchar(20) DEFAULT NULL COMMENT '型号编号',
  `vtypename` varchar(20) DEFAULT NULL COMMENT '型号名称',
  `vprice` float DEFAULT NULL COMMENT '参考价格',
  `vdate` date DEFAULT NULL COMMENT '车辆年款',
  `vpower` int(11) DEFAULT NULL COMMENT '功率',
  `fuelmark` varchar(20) DEFAULT NULL COMMENT '燃油标号',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`vtypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type_of_vehicle` */

/*Table structure for table `user_vehicles` */

DROP TABLE IF EXISTS `user_vehicles`;

CREATE TABLE `user_vehicles` (
  `uvehicleid` int(11) DEFAULT NULL COMMENT '车辆编号',
  `vtypeid` int(11) DEFAULT NULL COMMENT '型号序号',
  `vbrandid` int(11) DEFAULT NULL COMMENT '品牌序号',
  `userid` int(11) DEFAULT NULL COMMENT '用户序号',
  `affiliationid` int(11) DEFAULT NULL COMMENT '归属编号',
  `ulicense` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `resdriver` varchar(20) DEFAULT NULL COMMENT '驾驶员',
  `driverphone` varchar(11) DEFAULT NULL COMMENT '驾驶员手机号',
  `umileage` int(11) DEFAULT NULL COMMENT '里程',
  `registereddate` date DEFAULT NULL COMMENT '上牌日期',
  `buydate` date DEFAULT NULL COMMENT '购买日期',
  `khid` int(11) DEFAULT NULL COMMENT '客户id',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  KEY `vtypeid` (`vtypeid`),
  CONSTRAINT `user_vehicles_ibfk_1` FOREIGN KEY (`vtypeid`) REFERENCES `type_of_vehicle` (`vtypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_vehicles` */

/*Table structure for table `vehicle_brand` */

DROP TABLE IF EXISTS `vehicle_brand`;

CREATE TABLE `vehicle_brand` (
  `vbrandid` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌序号',
  `vbrandno` varchar(20) DEFAULT NULL COMMENT '品牌编号',
  `vbrandname` varchar(20) DEFAULT NULL COMMENT '品牌名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`vbrandid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vehicle_brand` */

/*Table structure for table `vehicle_ownership` */

DROP TABLE IF EXISTS `vehicle_ownership`;

CREATE TABLE `vehicle_ownership` (
  `affiliationid` int(11) NOT NULL AUTO_INCREMENT COMMENT '归属编号',
  `affiliationname` varchar(20) DEFAULT NULL COMMENT '归属名称',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`affiliationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vehicle_ownership` */

/*Table structure for table `wei_xiubiao` */

DROP TABLE IF EXISTS `wei_xiubiao`;

CREATE TABLE `wei_xiubiao` (
  `wx_No` varchar(100) NOT NULL COMMENT '维修单号',
  `wx_jcsj` datetime NOT NULL COMMENT '接车时间',
  `wx_ywlx` varchar(100) NOT NULL COMMENT '业务类型',
  `wx_wgsj` datetime NOT NULL COMMENT '完工时间',
  `wx_khmcc` varchar(100) NOT NULL COMMENT '客户名称',
  `wx_chephao` varchar(100) NOT NULL COMMENT '车牌号',
  `wx_sjh` varchar(100) NOT NULL COMMENT '手机号',
  `wx_hykh` varchar(100) NOT NULL COMMENT '会员卡号',
  `wx_jssj` datetime NOT NULL COMMENT '结算时间',
  `wx_xhje` double NOT NULL COMMENT '消费金额',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`wx_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wei_xiubiao` */

/*Table structure for table `wx_danbiao` */

DROP TABLE IF EXISTS `wx_danbiao`;

CREATE TABLE `wx_danbiao` (
  `wx_dan_id` int(4) NOT NULL COMMENT '维修单Id',
  `wx_xmmc` varchar(100) NOT NULL COMMENT '项目名称',
  `wx_sl` double NOT NULL COMMENT '数量',
  `wx_dj` double NOT NULL COMMENT '维修单价',
  `wx_je` double NOT NULL COMMENT '金额',
  `wx_js_jsj` double NOT NULL COMMENT '技师结算价',
  `wx_gzms` varchar(100) NOT NULL COMMENT '故障描述',
  `wx_wzyy` varchar(100) NOT NULL COMMENT '故障原因',
  `wx_wx_bz` varchar(100) NOT NULL COMMENT '维修班组',
  `wx_zyry` varchar(100) NOT NULL COMMENT '作业人员',
  `wx_gdh` varchar(100) NOT NULL COMMENT '工单号',
  `wx_mdyy` varchar(100) NOT NULL COMMENT '面单原因',
  `column1` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column2` varchar(200) DEFAULT NULL COMMENT '备用列',
  `column3` varchar(200) DEFAULT NULL COMMENT '备用列',
  PRIMARY KEY (`wx_dan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_danbiao` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
