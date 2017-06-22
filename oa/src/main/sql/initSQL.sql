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

Date: 2017-06-22 17:44:06
*/


-- ----------------------------
-- Table structure for O_SCHOOLDISTRICT
-- ----------------------------
DROP TABLE "HOTMARZZ"."O_SCHOOLDISTRICT";
CREATE TABLE "HOTMARZZ"."O_SCHOOLDISTRICT" (
"SCHOOLID" NUMBER NOT NULL ,
"SCHOOLNAME" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."SCHOOLID" IS '校区id';
COMMENT ON COLUMN "HOTMARZZ"."O_SCHOOLDISTRICT"."SCHOOLNAME" IS '校区名称';

-- ----------------------------
-- Records of O_SCHOOLDISTRICT
-- ----------------------------
INSERT INTO "HOTMARZZ"."O_SCHOOLDISTRICT" VALUES ('1', '南京校区');

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

