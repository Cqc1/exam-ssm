/*
Navicat MySQL Data Transfer

Source Server         : cqc
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : exam-ssm

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-31 17:27:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adId` int(11) NOT NULL,
  `adPwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`adId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '090822');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `ClassId` int(11) NOT NULL AUTO_INCREMENT,
  `ClaName` varchar(50) DEFAULT NULL,
  `ProId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ClassId`),
  KEY `4` (`ProId`),
  CONSTRAINT `4` FOREIGN KEY (`ProId`) REFERENCES `profession` (`ProId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '软件161', '1');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CouId` int(11) NOT NULL AUTO_INCREMENT,
  `CouName` varchar(50) DEFAULT NULL,
  `Credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`CouId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge` (
  `KnpoId` int(11) NOT NULL AUTO_INCREMENT,
  `ClassId` int(11) DEFAULT NULL,
  `ZhJie` varchar(50) DEFAULT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `Flour` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`KnpoId`),
  KEY `11` (`ClassId`),
  CONSTRAINT `11` FOREIGN KEY (`ClassId`) REFERENCES `course` (`CouId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge
-- ----------------------------

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `ProId` int(11) NOT NULL AUTO_INCREMENT,
  `ProName` varchar(50) DEFAULT NULL,
  `YuId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProId`),
  KEY `3` (`YuId`),
  CONSTRAINT `3` FOREIGN KEY (`YuId`) REFERENCES `yuanxi` (`YuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('1', '软件工程', '1');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Term` varchar(50) NOT NULL,
  `CouId` int(11) NOT NULL,
  `StuId` int(11) NOT NULL,
  `ShijuanId` int(11) DEFAULT NULL,
  `Score` int(11) DEFAULT NULL,
  PRIMARY KEY (`Term`,`CouId`,`StuId`),
  KEY `5` (`CouId`),
  KEY `6` (`StuId`),
  KEY `7` (`ShijuanId`),
  CONSTRAINT `5` FOREIGN KEY (`CouId`) REFERENCES `course` (`CouId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `6` FOREIGN KEY (`StuId`) REFERENCES `student` (`StuId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `7` FOREIGN KEY (`ShijuanId`) REFERENCES `shijuan` (`ShijuanId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for shijuan
-- ----------------------------
DROP TABLE IF EXISTS `shijuan`;
CREATE TABLE `shijuan` (
  `ShijuanId` int(11) NOT NULL AUTO_INCREMENT,
  `CouId` int(11) DEFAULT NULL,
  `ExamDay` datetime DEFAULT NULL,
  `ExamTime` varchar(50) DEFAULT NULL,
  `ExamAdr` varchar(255) DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  `TixinId` int(11) NOT NULL,
  `TixinScore` int(11) DEFAULT NULL,
  `ToalScore` int(11) DEFAULT NULL,
  `ZujuUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ShijuanId`,`TixinId`),
  KEY `ShijuanId` (`ShijuanId`),
  KEY `17` (`CouId`),
  KEY `18` (`ClassId`),
  KEY `19` (`TixinId`),
  CONSTRAINT `17` FOREIGN KEY (`CouId`) REFERENCES `course` (`CouId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `18` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `19` FOREIGN KEY (`TixinId`) REFERENCES `tixin` (`TixinId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shijuan
-- ----------------------------

-- ----------------------------
-- Table structure for shiti
-- ----------------------------
DROP TABLE IF EXISTS `shiti`;
CREATE TABLE `shiti` (
  `ShiTiId` int(11) NOT NULL AUTO_INCREMENT,
  `CouId` int(11) DEFAULT NULL,
  `TixinId` int(11) DEFAULT NULL,
  `Degree` varchar(50) DEFAULT NULL,
  `KnpoId` int(11) DEFAULT NULL,
  `QuFen` varchar(50) DEFAULT NULL,
  `ShitiContent` varchar(255) DEFAULT NULL,
  `Tubiao` varchar(255) DEFAULT NULL,
  `Answer` varchar(255) DEFAULT NULL,
  `Cishu` varchar(50) DEFAULT NULL,
  `PreTime` varchar(50) DEFAULT NULL,
  `AveTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ShiTiId`),
  KEY `12` (`CouId`),
  KEY `13` (`TixinId`),
  KEY `14` (`KnpoId`),
  CONSTRAINT `12` FOREIGN KEY (`CouId`) REFERENCES `course` (`CouId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `13` FOREIGN KEY (`TixinId`) REFERENCES `tixin` (`TixinId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `14` FOREIGN KEY (`KnpoId`) REFERENCES `knowledge` (`KnpoId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiti
-- ----------------------------

-- ----------------------------
-- Table structure for shiti_tixin
-- ----------------------------
DROP TABLE IF EXISTS `shiti_tixin`;
CREATE TABLE `shiti_tixin` (
  `ShijuanId` int(11) NOT NULL,
  `ShiTiId` int(11) NOT NULL,
  PRIMARY KEY (`ShijuanId`,`ShiTiId`),
  KEY `16` (`ShiTiId`),
  CONSTRAINT `15` FOREIGN KEY (`ShijuanId`) REFERENCES `shijuan` (`ShijuanId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `16` FOREIGN KEY (`ShiTiId`) REFERENCES `shiti` (`ShiTiId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiti_tixin
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `StuId` int(11) NOT NULL,
  `StuPwd` varchar(50) DEFAULT NULL,
  `StuName` varchar(50) DEFAULT NULL,
  `StuSex` varchar(50) DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  `StuMail` varchar(50) DEFAULT NULL,
  `StuNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`StuId`),
  KEY `2` (`ClassId`),
  CONSTRAINT `2` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1213', 'csq', '男', '1', '1525@qq.com', '12');
INSERT INTO `student` VALUES ('12', '11', '13', '男', '1', '12@qq.com', '123');
INSERT INTO `student` VALUES ('216160514', '133', 'cqc', '女', '1', '12636@qq.com', '122');

-- ----------------------------
-- Table structure for stu_answer
-- ----------------------------
DROP TABLE IF EXISTS `stu_answer`;
CREATE TABLE `stu_answer` (
  `StuId` int(11) NOT NULL,
  `ShijuanId` int(11) NOT NULL,
  `ShiTiId` int(11) NOT NULL,
  `StuAnswer` varchar(255) DEFAULT NULL,
  `Decsrip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`StuId`,`ShijuanId`,`ShiTiId`),
  KEY `21` (`ShijuanId`),
  KEY `22` (`ShiTiId`),
  CONSTRAINT `20` FOREIGN KEY (`StuId`) REFERENCES `student` (`StuId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `21` FOREIGN KEY (`ShijuanId`) REFERENCES `shijuan` (`ShijuanId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `22` FOREIGN KEY (`ShiTiId`) REFERENCES `shiti` (`ShiTiId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_answer
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `TeaId` int(11) NOT NULL,
  `TeaName` varchar(50) DEFAULT NULL,
  `TeaPwd` varchar(50) DEFAULT NULL,
  `TeaSex` varchar(50) DEFAULT NULL,
  `YuId` int(11) DEFAULT NULL,
  `TeaMail` varchar(50) DEFAULT NULL,
  `TeaNum` int(50) DEFAULT NULL,
  PRIMARY KEY (`TeaId`),
  KEY `1` (`YuId`),
  CONSTRAINT `1` FOREIGN KEY (`YuId`) REFERENCES `yuanxi` (`YuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'cqc', '123', '男', '1', '12@qq.com', '123');
INSERT INTO `teacher` VALUES ('3', 'cqc', '123', '男', '1', '12@qq.com', '123');
INSERT INTO `teacher` VALUES ('32', '123', '13', '男', '1', '23@qq.com', '1213');
INSERT INTO `teacher` VALUES ('345', '王', '12', '男', '1', '21@qq.com', '1232');
INSERT INTO `teacher` VALUES ('555', '1213', '1332', '男', '1', '123@qq.com', '2323');
INSERT INTO `teacher` VALUES ('666', 'wf', '123', '男', '3', '345@qq.com', '12');
INSERT INTO `teacher` VALUES ('1324', '区分', '123', '男', '1', '12@qq.com', '12');
INSERT INTO `teacher` VALUES ('2222', '313', '12', '男', '1', '12@qq.com', '12');
INSERT INTO `teacher` VALUES ('7777', '131', '13', '男', '3', '123@qq.com', '123');
INSERT INTO `teacher` VALUES ('216160514', 'zhupengyu', '3142', '女', '3', '23717@qq.com', '132');

-- ----------------------------
-- Table structure for teatask
-- ----------------------------
DROP TABLE IF EXISTS `teatask`;
CREATE TABLE `teatask` (
  `Term` varchar(50) NOT NULL,
  `TeaId` int(11) DEFAULT NULL,
  `CouId` int(11) DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Term`),
  KEY `8` (`TeaId`),
  KEY `9` (`CouId`),
  KEY `10` (`ClassId`),
  CONSTRAINT `10` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `8` FOREIGN KEY (`TeaId`) REFERENCES `teacher` (`TeaId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `9` FOREIGN KEY (`CouId`) REFERENCES `course` (`CouId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teatask
-- ----------------------------

-- ----------------------------
-- Table structure for tixin
-- ----------------------------
DROP TABLE IF EXISTS `tixin`;
CREATE TABLE `tixin` (
  `TixinId` int(11) NOT NULL AUTO_INCREMENT,
  `TixinName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TixinId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tixin
-- ----------------------------

-- ----------------------------
-- Table structure for yuanxi
-- ----------------------------
DROP TABLE IF EXISTS `yuanxi`;
CREATE TABLE `yuanxi` (
  `YuId` int(11) NOT NULL AUTO_INCREMENT,
  `YuNam` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`YuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yuanxi
-- ----------------------------
INSERT INTO `yuanxi` VALUES ('1', '计算机学院');
INSERT INTO `yuanxi` VALUES ('2', '环境工程学院');
INSERT INTO `yuanxi` VALUES ('3', '哇塞');
