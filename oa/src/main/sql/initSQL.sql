create sequence o_seq;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;
select o_seq.nextval from dual;

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-22 17:43:40
*/


-- ----------------------------
-- Table structure for O_EMP
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_EMP";
CREATE TABLE "HOTMARZZ"."O_EMP" (
"EMPID" NUMBER NOT NULL ,
"EMPNAME" VARCHAR2(50 BYTE) NOT NULL ,
"USERNAME" VARCHAR2(50 BYTE) NOT NULL ,
"USERPWD" VARCHAR2(255 BYTE) NOT NULL ,
"PHONE" VARCHAR2(50 BYTE) NOT NULL ,
"HIREDATE" DATE NOT NULL ,
"SCHOOLID" NUMBER NULL ,
"DEPTID" NUMBER NULL ,
"ROLEID" NUMBER NULL ,
"STATIONID" NUMBER NULL ,
"ASSOWECHAT" NUMBER NULL ,
"CREATEUSER" VARCHAR2(50 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEUSER" VARCHAR2(50 BYTE) NULL ,
"UPDATEDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."EMPID" IS '员工id';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."EMPNAME" IS '员工姓名';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."USERNAME" IS '用户名';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."USERPWD" IS '用户密码';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."PHONE" IS '手机号';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."HIREDATE" IS '入职时间';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."SCHOOLID" IS '所属校区';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."DEPTID" IS '所属部门';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."ROLEID" IS '所属角色';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."STATIONID" IS '所属岗位';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."ASSOWECHAT" IS '是否关联微信';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."CREATEUSER" IS '创建人';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."UPDATEUSER" IS '更新人';
COMMENT ON COLUMN "HOTMARZZ"."O_EMP"."UPDATEDATE" IS '更新时间';

-- ----------------------------
-- Records of O_EMP
-- ----------------------------
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('10', '张三2', 'dfhm001', 'E10ADC3949BA59ABBE56E057F20F883E', '1596661234', TO_DATE('2017-06-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '1', '1', '1', '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('13', '赵六', 'zl001', '123456', '13997877432', TO_DATE('2017-06-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('14', '马云', 'mayun001', '123456', '13997111665', TO_DATE('2017-06-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('15', '刘伯温', 'liubowen001', '123456', '12345678901', TO_DATE('2017-06-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('16', '刘伯温', 'liubowen001', '123456', '12345678901', TO_DATE('2017-06-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('12', '王五', 'ww001', '123456', '13997877665', TO_DATE('2017-06-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('17', '刘伯温', 'liubowen001', '123456', '12345678901', TO_DATE('2017-06-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('18', '卡斯特罗', 'kasi001', '123456', '09876543211', TO_DATE('2017-06-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('20', '郭德纲', 'gdg', '123456', '16859403213', TO_DATE('2017-06-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('19', '郭德纲', 'gdg', '123456', '16859403213', TO_DATE('2017-06-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, '1', null, null, null, null);
INSERT INTO "HOTMARZZ"."O_EMP" VALUES ('9', '张三', 'dfhm001', 'E10ADC3949BA59ABBE56E057F20F883E', '1596661234', TO_DATE('2017-06-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '1', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Indexes structure for table O_EMP
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_EMP
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_EMP" ADD CHECK ("EMPID" IS NOT NULL);
ALTER TABLE "HOTMARZZ"."O_EMP" ADD CHECK ("EMPNAME" IS NOT NULL);
ALTER TABLE "HOTMARZZ"."O_EMP" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "HOTMARZZ"."O_EMP" ADD CHECK ("USERPWD" IS NOT NULL);
ALTER TABLE "HOTMARZZ"."O_EMP" ADD CHECK ("PHONE" IS NOT NULL);
ALTER TABLE "HOTMARZZ"."O_EMP" ADD CHECK ("HIREDATE" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_EMP
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_EMP" ADD PRIMARY KEY ("EMPID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-22 17:43:18
*/


-- ----------------------------
-- Table structure for O_DEPT
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_DEPT";
CREATE TABLE "HOTMARZZ"."O_DEPT" (
"DEPTID" NUMBER NOT NULL ,
"DEPTNAME" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_DEPT"."DEPTID" IS '部门id';
COMMENT ON COLUMN "HOTMARZZ"."O_DEPT"."DEPTNAME" IS '部门名称';

-- ----------------------------
-- Records of O_DEPT
-- ----------------------------
INSERT INTO "HOTMARZZ"."O_DEPT" VALUES ('1', '教学部');
INSERT INTO "HOTMARZZ"."O_DEPT" VALUES ('2', '咨询部');
INSERT INTO "HOTMARZZ"."O_DEPT" VALUES ('3', '就业部');

-- ----------------------------
-- Indexes structure for table O_DEPT
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_DEPT
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_DEPT" ADD CHECK ("DEPTID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_DEPT
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_DEPT" ADD PRIMARY KEY ("DEPTID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-22 17:43:51
*/


-- ----------------------------
-- Table structure for O_ROLE
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_ROLE";
CREATE TABLE "HOTMARZZ"."O_ROLE" (
"ROLEID" NUMBER NOT NULL ,
"ROLENAME" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_ROLE"."ROLEID" IS '角色id';
COMMENT ON COLUMN "HOTMARZZ"."O_ROLE"."ROLENAME" IS '角色名称';

-- ----------------------------
-- Records of O_ROLE
-- ----------------------------
INSERT INTO "HOTMARZZ"."O_ROLE" VALUES ('1', '系统管理员');
INSERT INTO "HOTMARZZ"."O_ROLE" VALUES ('2', '总经理');

-- ----------------------------
-- Indexes structure for table O_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_ROLE
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_ROLE" ADD CHECK ("ROLEID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_ROLE
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_ROLE" ADD PRIMARY KEY ("ROLEID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-28 00:06:30
*/


-- ----------------------------
-- Table structure for O_SCHOOLDISTRICT
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_SCHOOLDISTRICT";
CREATE TABLE "HOTMARZZ"."O_SCHOOLDISTRICT" (
"SCHOOLID" NUMBER NOT NULL ,
"SCHOOLNAME" VARCHAR2(50 BYTE) NULL ,
"PROVINCE" VARCHAR2(255 BYTE) NULL ,
"TEACHERQUANTITY" NUMBER NULL ,
"CURRENTCLASSQUANTITY" NUMBER NULL ,
"CURRENTSTUQUANTITY" NUMBER NULL ,
"TOTALSTUQUANTITY" NUMBER NULL ,
"CREATEUSER" VARCHAR2(50 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEUSER" VARCHAR2(50 BYTE) NULL ,
"UPDATEDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."SCHOOLID" IS '校区id';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."SCHOOLNAME" IS '校区名称';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."PROVINCE" IS '所属省份';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."TEACHERQUANTITY" IS '教师数量';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."CURRENTCLASSQUANTITY" IS '当前开班数';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."CURRENTSTUQUANTITY" IS '当前学员数';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."TOTALSTUQUANTITY" IS '学生总数';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."CREATEUSER" IS '创建人';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."UPDATEUSER" IS '修改人';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."UPDATEDATE" IS '修改时间';

-- ----------------------------
-- Records of O_SCHOOLDISTRICT
-- ----------------------------
INSERT INTO "HOTMARZZ"."O_SCHOOLDISTRICT" VALUES ('1', '南京校区', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Indexes structure for table O_SCHOOLDISTRICT
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_SCHOOLDISTRICT
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_SCHOOLDISTRICT" ADD CHECK ("SCHOOLID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_SCHOOLDISTRICT
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_SCHOOLDISTRICT" ADD PRIMARY KEY ("SCHOOLID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-22 17:44:14
*/


-- ----------------------------
-- Table structure for O_STATION
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_STATION";
CREATE TABLE "HOTMARZZ"."O_STATION" (
"STATIONID" NUMBER NOT NULL ,
"STATIONNAME" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_STATION"."STATIONID" IS '岗位id';
COMMENT ON COLUMN "HOTMARZZ"."O_STATION"."STATIONNAME" IS '岗位名称';

-- ----------------------------
-- Records of O_STATION
-- ----------------------------
INSERT INTO "HOTMARZZ"."O_STATION" VALUES ('1', '咨询师');
INSERT INTO "HOTMARZZ"."O_STATION" VALUES ('2', '讲师');
INSERT INTO "HOTMARZZ"."O_STATION" VALUES ('3', '助教');
INSERT INTO "HOTMARZZ"."O_STATION" VALUES ('4', '就业推荐');

-- ----------------------------
-- Indexes structure for table O_STATION
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_STATION
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_STATION" ADD CHECK ("STATIONID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_STATION
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_STATION" ADD PRIMARY KEY ("STATIONID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-28 00:05:52
*/


-- ----------------------------
-- Table structure for O_CASH
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_CASH";
CREATE TABLE "HOTMARZZ"."O_CASH" (
"PAYID" NUMBER NOT NULL ,
"PAYTYPE" VARCHAR2(50 BYTE) NULL ,
"TUITION" NUMBER NULL ,
"TOTALPERIOD" NUMBER NULL ,
"PAIDPERIOD" NUMBER NULL ,
"PAIDAMOUNT" NUMBER NULL ,
"ARREARAMOUNT" NUMBER NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL ,
"CREATEUSER" VARCHAR2(50 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEUSER" VARCHAR2(50 BYTE) NULL ,
"UPDATEDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."PAYID" IS '现金ID';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."PAYTYPE" IS '缴费类型';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."TUITION" IS '学费';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."TOTALPERIOD" IS '总期数';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."PAIDPERIOD" IS '已缴期数';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."PAIDAMOUNT" IS '已缴金额';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."ARREARAMOUNT" IS '欠款金额';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."REMARKS" IS '备注';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."CREATEUSER" IS '创建人';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."UPDATEUSER" IS '修改人';
COMMENT ON COLUMN "HOTMARZZ"."O_CASH"."UPDATEDATE" IS '修改人';

-- ----------------------------
-- Records of O_CASH
-- ----------------------------

-- ----------------------------
-- Indexes structure for table O_CASH
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_CASH
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_CASH" ADD CHECK ("PAYID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_CASH
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_CASH" ADD PRIMARY KEY ("PAYID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-28 00:06:06
*/


-- ----------------------------
-- Table structure for O_CLASS
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_CLASS";
CREATE TABLE "HOTMARZZ"."O_CLASS" (
"CLASSID" NUMBER NOT NULL ,
"CLASSNAME" VARCHAR2(255 BYTE) NULL ,
"PREDIRECTION" VARCHAR2(255 BYTE) NULL ,
"CLASTATUS" VARCHAR2(255 BYTE) NULL ,
"OPENTIME" DATE NULL ,
"ENDTIME" DATE NULL ,
"LECTOR" VARCHAR2(50 BYTE) NULL ,
"TUTOR" VARCHAR2(50 BYTE) NULL ,
"ORIGINALSTUS" NUMBER NULL ,
"CURRENTSTUS" NUMBER NULL ,
"CREATEUSER" VARCHAR2(50 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEUSER" VARCHAR2(50 BYTE) NULL ,
"UPDATEDATE" DATE NULL ,
"SCHOOLID" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."CLASSID" IS '班级ID';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."CLASSNAME" IS '班级名称';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."PREDIRECTION" IS '专业方向';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."CLASTATUS" IS '班级状态';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."OPENTIME" IS '开班时间';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."ENDTIME" IS '结束时间';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."LECTOR" IS '讲师姓名';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."TUTOR" IS '助教姓名';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."ORIGINALSTUS" IS '之前班级学生人数';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."CURRENTSTUS" IS '现有班级学生人数';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."CREATEUSER" IS '创建人';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."UPDATEUSER" IS '修改人';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."UPDATEDATE" IS '修改时间';
COMMENT ON COLUMN "HOTMARZZ"."O_CLASS"."SCHOOLID" IS '所属校区ID';

-- ----------------------------
-- Records of O_CLASS
-- ----------------------------

-- ----------------------------
-- Indexes structure for table O_CLASS
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_CLASS
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_CLASS" ADD CHECK ("CLASSID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_CLASS
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_CLASS" ADD PRIMARY KEY ("CLASSID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-28 00:32:02
*/


-- ----------------------------
-- Table structure for O_LOAN
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_LOAN";
CREATE TABLE "HOTMARZZ"."O_LOAN" (
"PAYID" NUMBER NOT NULL ,
"CARDNUM" VARCHAR2(255 BYTE) NULL ,
"PAYTYPE" VARCHAR2(50 BYTE) NULL ,
"DEPOSITBANK" VARCHAR2(255 BYTE) NULL ,
"LOANSTATUS" VARCHAR2(50 BYTE) NULL ,
"LOANUNIT" VARCHAR2(255 BYTE) NULL ,
"LOANPLAN" VARCHAR2(50 BYTE) NULL ,
"LOANTIME" DATE NULL ,
"LOANAMOUNT" NUMBER NULL ,
"REPAYMENTTIME" DATE NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL ,
"CREATEUSER" VARCHAR2(50 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEUSER" VARCHAR2(50 BYTE) NULL ,
"UPDATEDATE" DATE NULL ,
"TUITION" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."PAYID" IS '贷款ID';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."CARDNUM" IS '贷款卡号';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."PAYTYPE" IS '缴费类型';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."DEPOSITBANK" IS '开户行';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."LOANSTATUS" IS '贷款状态';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."LOANUNIT" IS '贷款单位';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."LOANPLAN" IS '贷款方案';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."LOANTIME" IS '放款时间';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."LOANAMOUNT" IS '放款金额';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."REPAYMENTTIME" IS '还款时间';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."REMARKS" IS '备注';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."CREATEUSER" IS '创建人';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."UPDATEUSER" IS '修改人';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."UPDATEDATE" IS '修改时间';
COMMENT ON COLUMN "HOTMARZZ"."O_LOAN"."TUITION" IS '学费';

-- ----------------------------
-- Records of O_LOAN
-- ----------------------------

-- ----------------------------
-- Indexes structure for table O_LOAN
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_LOAN
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_LOAN" ADD CHECK ("PAYID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_LOAN
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_LOAN" ADD PRIMARY KEY ("PAYID");


/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-28 00:06:22
*/


-- ----------------------------
-- Table structure for O_PAY
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_PAY";
CREATE TABLE "HOTMARZZ"."O_PAY" (
"PAYID" NUMBER NOT NULL ,
"PAYTYPE" NUMBER NULL ,
"CREATEUSER" VARCHAR2(50 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEUSER" VARCHAR2(50 BYTE) NULL ,
"UPDATEDATE" DATE NULL ,
"TUITION" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_PAY"."PAYID" IS '付款ID';
COMMENT ON COLUMN "HOTMARZZ"."O_PAY"."PAYTYPE" IS '付款类型';
COMMENT ON COLUMN "HOTMARZZ"."O_PAY"."CREATEUSER" IS '创建人';
COMMENT ON COLUMN "HOTMARZZ"."O_PAY"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "HOTMARZZ"."O_PAY"."UPDATEUSER" IS '修改人';
COMMENT ON COLUMN "HOTMARZZ"."O_PAY"."UPDATEDATE" IS '修改时间';
COMMENT ON COLUMN "HOTMARZZ"."O_PAY"."TUITION" IS '学费';

-- ----------------------------
-- Records of O_PAY
-- ----------------------------

-- ----------------------------
-- Indexes structure for table O_PAY
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_PAY
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_PAY" ADD CHECK ("PAYID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_PAY
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_PAY" ADD PRIMARY KEY ("PAYID");

/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : hotMarzz_OA
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : HOTMARZZ

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-06-28 00:06:38
*/


-- ----------------------------
-- Table structure for O_STU
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_STU";
CREATE TABLE "HOTMARZZ"."O_STU" (
"STUID" NUMBER NOT NULL ,
"PHONE" VARCHAR2(50 BYTE) NOT NULL ,
"STUNAME" VARCHAR2(50 BYTE) NOT NULL ,
"IDNUMBER" VARCHAR2(100 BYTE) NULL ,
"SEX" NUMBER(1) NULL ,
"ENTRANCETIME" DATE NULL ,
"FIRSTCLASSID" NUMBER NULL ,
"CURRENTCLASSID" NUMBER NULL ,
"STUSTATUS" VARCHAR2(50 BYTE) NULL ,
"GRADUATION" DATE NULL ,
"GRASCHOOL" VARCHAR2(100 BYTE) NULL ,
"EDUCATION" VARCHAR2(50 BYTE) NULL ,
"PROFESSION" VARCHAR2(100 BYTE) NULL ,
"WSKLEVEL" VARCHAR2(50 BYTE) NULL ,
"COMPUTERSKILL" VARCHAR2(50 BYTE) NULL ,
"QQ" VARCHAR2(100 BYTE) NULL ,
"EMAIL" VARCHAR2(255 BYTE) NULL ,
"CONTACTPERSON" VARCHAR2(255 BYTE) NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL ,
"LOCKED" NUMBER(1) NULL ,
"LOCKUSER" VARCHAR2(100 BYTE) NULL ,
"CREATEUSER" VARCHAR2(50 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEUSER" VARCHAR2(50 BYTE) NULL ,
"UPDATEDATE" DATE NULL ,
"PAYID" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."STUID" IS '学生ID';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."PHONE" IS '联系电话';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."STUNAME" IS '学生姓名';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."IDNUMBER" IS '学生身份证号';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."SEX" IS '性别，0代表男，1代表1';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."ENTRANCETIME" IS '入校时间';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."FIRSTCLASSID" IS '首次分班ID';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."CURRENTCLASSID" IS '当前班级ID';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."STUSTATUS" IS '学生状态';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."GRADUATION" IS '毕业时间';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."GRASCHOOL" IS '毕业院校';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."EDUCATION" IS '学历';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."PROFESSION" IS '专业';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."WSKLEVEL" IS '外语水平';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."COMPUTERSKILL" IS '计算机技能';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."QQ" IS 'QQ号';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."EMAIL" IS '邮箱';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."CONTACTPERSON" IS '紧急联系人信息';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."REMARKS" IS '备注';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."LOCKED" IS '是否锁定，0代表锁定，1代表未锁定';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."LOCKUSER" IS '锁定人姓名';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."CREATEUSER" IS '创建人';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."UPDATEUSER" IS '修改人';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."UPDATEDATE" IS '修改时间';
COMMENT ON COLUMN "HOTMARZZ"."O_STU"."PAYID" IS '付款信息ID';

-- ----------------------------
-- Records of O_STU
-- ----------------------------

-- ----------------------------
-- Indexes structure for table O_STU
-- ----------------------------

-- ----------------------------
-- Checks structure for table O_STU
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_STU" ADD CHECK ("STUID" IS NOT NULL);
ALTER TABLE "HOTMARZZ"."O_STU" ADD CHECK ("PHONE" IS NOT NULL);
ALTER TABLE "HOTMARZZ"."O_STU" ADD CHECK ("STUNAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table O_STU
-- ----------------------------
ALTER TABLE "HOTMARZZ"."O_STU" ADD PRIMARY KEY ("STUID");

