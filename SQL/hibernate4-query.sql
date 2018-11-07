/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : hibernate3

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2013-09-23 17:02:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `provice` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `MANAGER_ID` bigint(20) DEFAULT NULL,
  `sn` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA9601F7262086B81` (`MANAGER_ID`),
  CONSTRAINT `FKA9601F7262086B81` FOREIGN KEY (`MANAGER_ID`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '市场部', '四川', '成都', '八宝街', '1', '002');
INSERT INTO `department` VALUES ('2', '技术部', '四川', '成都', '宁夏街', '5', '001');
INSERT INTO `department` VALUES ('3', '市场二部', '广东', '广州', '恩宁路', '9', '004');
INSERT INTO `department` VALUES ('4', '技术二部', '广东', '广州', '恩宁路', '13', '003');
INSERT INTO `department` VALUES ('5', '市场三部', '四川', '成都', '西大街', null, '005');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `DEPT_ID` bigint(20) DEFAULT NULL,
  `salay` decimal(8,2) DEFAULT NULL,
  `hireDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4AFD4ACE3DA4510D` (`DEPT_ID`),
  CONSTRAINT `FK4AFD4ACE3DA4510D` FOREIGN KEY (`DEPT_ID`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'Tom', '1', '4500.00', '2010-09-04');
INSERT INTO `employee` VALUES ('2', 'Aaron', '1', '4000.00', '2012-03-06');
INSERT INTO `employee` VALUES ('3', 'Abel', '1', '4200.00', '2012-06-08');
INSERT INTO `employee` VALUES ('4', 'Abraham', '1', '6000.00', '2009-11-18');
INSERT INTO `employee` VALUES ('5', 'Ben', '2', '2600.00', '2013-03-20');
INSERT INTO `employee` VALUES ('6', 'Benjamin', '2', '8000.00', '2008-07-09');
INSERT INTO `employee` VALUES ('7', 'Bert', null, '5100.00', '2012-11-15');
INSERT INTO `employee` VALUES ('8', 'Benson', '2', '3800.00', '2013-03-20');
INSERT INTO `employee` VALUES ('9', 'Cameron', '3', '5200.00', '2012-08-25');
INSERT INTO `employee` VALUES ('10', 'Carl', '3', '5500.00', '2012-07-15');
INSERT INTO `employee` VALUES ('11', 'Carlos', '3', '5000.00', '2012-09-05');
INSERT INTO `employee` VALUES ('12', 'Christian', '3', '5600.00', '2012-11-16');
INSERT INTO `employee` VALUES ('13', 'Daniel', '4', '5800.00', '2012-10-19');
INSERT INTO `employee` VALUES ('14', 'Denny', '4', '5900.00', '2012-02-25');
INSERT INTO `employee` VALUES ('15', 'Darwin', '4', '7000.00', '2012-03-21');
INSERT INTO `employee` VALUES ('16', 'Dennis', '4', '5200.00', '2012-05-18');
INSERT INTO `employee` VALUES ('17', 'Derek', '4', '5600.00', '2012-07-25');

-- ----------------------------
-- Table structure for `phone`
-- ----------------------------
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `types` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `EMPLOYEE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4984D4E3CBA8E0` (`EMPLOYEE_ID`),
  CONSTRAINT `FK4984D4E3CBA8E0` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phone
-- ----------------------------
INSERT INTO `phone` VALUES ('1', 'CELL', '000001', '1');
INSERT INTO `phone` VALUES ('2', 'WORK', '000002', '1');
INSERT INTO `phone` VALUES ('3', 'CELL', '000003', '2');
INSERT INTO `phone` VALUES ('4', 'CELL', '000004', '3');
INSERT INTO `phone` VALUES ('5', 'CELL', '000005', '4');
INSERT INTO `phone` VALUES ('6', 'CELL', '000006', '5');
INSERT INTO `phone` VALUES ('7', 'CELL', '000007', '6');
INSERT INTO `phone` VALUES ('8', 'WORK', '000008', '7');
INSERT INTO `phone` VALUES ('9', 'WORK', '000009', '8');
INSERT INTO `phone` VALUES ('10', 'CELL', '000010', '9');
INSERT INTO `phone` VALUES ('11', 'CELL', '000011', '10');
INSERT INTO `phone` VALUES ('12', 'CELL', '000012', '11');
INSERT INTO `phone` VALUES ('13', 'WORK', '000013', '12');
INSERT INTO `phone` VALUES ('14', 'CELL', '000014', '12');
INSERT INTO `phone` VALUES ('15', 'WORK', '000015', '13');
INSERT INTO `phone` VALUES ('16', 'WORK', '000016', '14');
INSERT INTO `phone` VALUES ('17', 'CELL', '000017', '15');
INSERT INTO `phone` VALUES ('18', 'WORK', '000018', '15');
INSERT INTO `phone` VALUES ('19', 'CELL', '000019', '16');
INSERT INTO `phone` VALUES ('20', 'CELL', '000020', '17');
INSERT INTO `phone` VALUES ('21', 'WORK', '000021', '17');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `MANAGER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50C8E2F962086B81` (`MANAGER_ID`),
  CONSTRAINT `FK50C8E2F962086B81` FOREIGN KEY (`MANAGER_ID`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '装饰ERP', '5');
INSERT INTO `project` VALUES ('2', '服装ERP', '5');
INSERT INTO `project` VALUES ('3', '工业制造ERP', '5');
INSERT INTO `project` VALUES ('4', '通用CRM', '13');
INSERT INTO `project` VALUES ('5', '蓝源OA', '14');
INSERT INTO `project` VALUES ('6', '蓝源SAAS平台', '13');
INSERT INTO `project` VALUES ('7', '蓝源EDP', '13');

-- ----------------------------
-- Table structure for `project_employee`
-- ----------------------------
DROP TABLE IF EXISTS `project_employee`;
CREATE TABLE `project_employee` (
  `EMPLOYEE_ID` bigint(20) NOT NULL,
  `PROJECT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`PROJECT_ID`,`EMPLOYEE_ID`),
  KEY `FK9931F934DF91BC74` (`PROJECT_ID`),
  KEY `FK9931F9343CBA8E0` (`EMPLOYEE_ID`),
  CONSTRAINT `FK9931F9343CBA8E0` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK9931F934DF91BC74` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_employee
-- ----------------------------
INSERT INTO `project_employee` VALUES ('5', '1');
INSERT INTO `project_employee` VALUES ('6', '1');
INSERT INTO `project_employee` VALUES ('8', '1');
INSERT INTO `project_employee` VALUES ('5', '2');
INSERT INTO `project_employee` VALUES ('6', '2');
INSERT INTO `project_employee` VALUES ('8', '2');
INSERT INTO `project_employee` VALUES ('13', '3');
INSERT INTO `project_employee` VALUES ('14', '3');
INSERT INTO `project_employee` VALUES ('13', '4');
INSERT INTO `project_employee` VALUES ('15', '4');
INSERT INTO `project_employee` VALUES ('16', '4');
INSERT INTO `project_employee` VALUES ('17', '4');
INSERT INTO `project_employee` VALUES ('13', '5');
INSERT INTO `project_employee` VALUES ('14', '5');
