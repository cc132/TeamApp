/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : teamapp

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-12-21 17:43:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '张三丰', '123456');
