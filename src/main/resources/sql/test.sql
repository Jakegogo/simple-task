/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-01-31 17:38:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `system_permission`
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission` (
  `permission_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` varchar(64) NOT NULL DEFAULT '' COMMENT '权限名称',
  `permission_url` varchar(256) NOT NULL DEFAULT '' COMMENT '权限地址',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `system_user`
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` char(128) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '主键',
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `user_password` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of system_user
-- ----------------------------

-- ----------------------------
-- Table structure for `system_user_permission`
-- ----------------------------
DROP TABLE IF EXISTS `system_user_permission`;
CREATE TABLE `system_user_permission` (
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `permission_id` bigint(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`user_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user_permission
-- ----------------------------
