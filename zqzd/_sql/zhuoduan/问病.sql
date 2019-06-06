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

 Date: 05/06/2019 15:54:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_question
-- ----------------------------
DROP TABLE IF EXISTS `zd_question`;
CREATE TABLE `zd_question`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NULL DEFAULT 0 COMMENT '用户id',
  `answer_status` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '回复状态  0：未回复  1：已回复 ',
  `consultation` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '基本问题',
  `check_status` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT ' 0：接受过治疗  1：未接受过治疗 ',
  `check_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '检查或治疗的基本情况',
  `help_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '想获得怎样的帮助',
  `answer_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '回复信息',
  `add_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `back_time` datetime NULL DEFAULT NULL COMMENT '问题提交时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `answer_status`(`answer_status`) USING BTREE,
  INDEX `consultation`(`consultation`(255)) USING BTREE,
  INDEX `check_status`(`check_status`) USING BTREE,
  INDEX `check_info`(`check_info`(255)) USING BTREE,
  INDEX `help_info`(`help_info`(255)) USING BTREE,
  INDEX `answer_info`(`answer_info`(255)) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE,
  INDEX `back_time`(`back_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
