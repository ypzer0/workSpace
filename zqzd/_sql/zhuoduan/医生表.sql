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

 Date: 03/06/2019 09:23:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_doctor
-- ----------------------------
DROP TABLE IF EXISTS `zd_doctor`;
CREATE TABLE `zd_doctor`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '医生id',
  `doctor_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '医生姓名',
  `department_id` int(11) NULL DEFAULT 0 COMMENT '科室id',
  `handler_id` int(11) NULL DEFAULT 0 COMMENT '操作人',
  `add_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `is_delete` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否删除  0-未删除，1-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `handler_id`(`handler_id`) USING BTREE,
  INDEX `is_delete`(`is_delete`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_doctor
-- ----------------------------
INSERT INTO `zd_doctor` VALUES (1, '蓝医生', 1, 1, '2019-05-30 14:58:10', 0);
INSERT INTO `zd_doctor` VALUES (2, '甘道夫', 1, 1, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
