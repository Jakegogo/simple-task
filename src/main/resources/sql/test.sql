/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-01-29 15:07:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `entity`
-- ----------------------------
DROP TABLE IF EXISTS `entity`;
CREATE TABLE `entity` (
  `id` varchar(255) NOT NULL,
  `group_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of entity
-- ----------------------------

-- ----------------------------
-- Table structure for `system_user`
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` char(128) NOT NULL DEFAULT '' COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(128) NOT NULL COMMENT '用户名',
  `user_password` varchar(128) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of system_user
-- ----------------------------
