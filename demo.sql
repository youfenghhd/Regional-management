/*
Navicat MariaDB Data Transfer

Source Server         : localhost
Source Server Version : 100903
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MariaDB
Target Server Version : 100903
File Encoding         : 65001

Date: 2023-04-27 09:37:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Citys
-- ----------------------------
DROP TABLE IF EXISTS `Citys`;
CREATE TABLE `Citys` (
  `cid` int(19) NOT NULL AUTO_INCREMENT,
  `cityname` varchar(255) NOT NULL DEFAULT '',
  `addr` varchar(255) DEFAULT NULL,
  `rid` int(19) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of Citys
-- ----------------------------
INSERT INTO `Citys` VALUES ('1', '深圳', '深圳市福田区北环大道通业大厦南塔五层501', '1');
INSERT INTO `Citys` VALUES ('2', '深圳', '深圳市福田区北环大道通业大厦南塔六层602', '1');
INSERT INTO `Citys` VALUES ('3', '深圳', '深圳市福田区北环大道通业大厦南塔七层703', '1');
INSERT INTO `Citys` VALUES ('4', '广州', '广州市越秀区东湖路123号', '1');
INSERT INTO `Citys` VALUES ('5', '上海', '上海市浦东新区锦绣路1001号', '2');
INSERT INTO `Citys` VALUES ('6', '杭州', '杭州市上城区万松岭路81号', '2');
INSERT INTO `Citys` VALUES ('7', '杭州', null, null);
INSERT INTO `Citys` VALUES ('8', '泉州', null, null);

-- ----------------------------
-- Table structure for Region
-- ----------------------------
DROP TABLE IF EXISTS `Region`;
CREATE TABLE `Region` (
  `rid` int(19) NOT NULL AUTO_INCREMENT,
  `regionName` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of Region
-- ----------------------------
INSERT INTO `Region` VALUES ('1', '华南区域', '2023-04-26 13:02:22', '2023-04-26 13:02:26');
INSERT INTO `Region` VALUES ('2', '华东区域', '2023-04-26 13:02:22', '2023-04-26 13:02:26');
