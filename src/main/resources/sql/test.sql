/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-02-02 14:33:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `system_group`
-- ----------------------------
DROP TABLE IF EXISTS `system_group`;
CREATE TABLE `system_group` (
  `group_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '组ID',
  `group_name` varchar(128) NOT NULL COMMENT '组名称',
  `group_parent` bigint(11) DEFAULT NULL COMMENT '上级组ID',
  `group_desc` varchar(128) DEFAULT NULL COMMENT '组描述',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_group
-- ----------------------------

-- ----------------------------
-- Table structure for `system_menu`
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `menu_id` bigint(11) NOT NULL,
  `permission_id` bigint(11) DEFAULT NULL,
  `menu_name` varchar(64) NOT NULL,
  `menu_url` varchar(256) DEFAULT NULL,
  `menu_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `system_permission`
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission` (
  `permission_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` varchar(128) NOT NULL COMMENT '权限名称',
  `permission_url` varchar(256) NOT NULL COMMENT '权限地址',
  `permission_rest` varchar(20) DEFAULT NULL COMMENT 'rest风格权限值',
  `permission_desc` varchar(128) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES ('1', 'testcontroller', '/testcontroller:read', null, null);

-- ----------------------------
-- Table structure for `system_role`
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `role_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(128) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(128) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1', '超级管理员', null);

-- ----------------------------
-- Table structure for `system_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `system_role_permission`;
CREATE TABLE `system_role_permission` (
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(11) NOT NULL COMMENT '权限ID',
  `role_permission_desc` varchar(128) DEFAULT NULL COMMENT '角色权限描述',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role_permission
-- ----------------------------
INSERT INTO `system_role_permission` VALUES ('1', '1', null);

-- ----------------------------
-- Table structure for `system_user`
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` char(128) NOT NULL DEFAULT '' COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(128) NOT NULL COMMENT '用户名',
  `user_password` varchar(128) NOT NULL COMMENT '密码',
  `user_locked` tinyint(1) NOT NULL DEFAULT '0',
  `user_create_date` bigint(20) DEFAULT NULL COMMENT '用户创建时间',
  `user_creator` varchar(64) DEFAULT NULL COMMENT '用户创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1111111111111111111', '1', 'jake', '123', '0', null, null);

-- ----------------------------
-- Table structure for `system_user_group`
-- ----------------------------
DROP TABLE IF EXISTS `system_user_group`;
CREATE TABLE `system_user_group` (
  `group_id` bigint(11) NOT NULL COMMENT '组ID',
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `user_group_creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `user_group_desc` varchar(128) DEFAULT NULL COMMENT '用户组描述',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`group_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for `system_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `user_role_creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `user_role_desc` varchar(128) DEFAULT NULL COMMENT '用户角色描述',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间戳',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES ('1', '1', null, null, null);
