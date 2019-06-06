/*
 Navicat Premium Data Transfer

 Source Server         : yangpeng
 Source Server Type    : MySQL
 Source Server Version : 50535
 Source Host           : localhost:3306
 Source Schema         : zuoduan

 Target Server Type    : MySQL
 Target Server Version : 50535
 File Encoding         : 65001

 Date: 03/06/2019 09:23:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_department
-- ----------------------------
DROP TABLE IF EXISTS `zd_department`;
CREATE TABLE `zd_department`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '科室id',
  `department_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '科室名称',
  `hospital_id` int(11) NULL DEFAULT 0 COMMENT '医院id',
  `handler_id` int(11) NULL DEFAULT 0 COMMENT '操作人',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `is_delete` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否删除  0-未删除，1-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `handler_id`(`handler_id`) USING BTREE,
  INDEX `is_delete`(`is_delete`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_department
-- ----------------------------
INSERT INTO `zd_department` VALUES (1, '妇科', 1, 0, '2019-05-30 15:01:36', 0);

SET FOREIGN_KEY_CHECKS = 1;
