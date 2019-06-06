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

 Date: 03/06/2019 09:23:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_hospital
-- ----------------------------
DROP TABLE IF EXISTS `zd_hospital`;
CREATE TABLE `zd_hospital`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '医院id',
  `hospital_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '医院名称',
  `handler_id` int(11) NULL DEFAULT 0 COMMENT '操作人',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `is_delete` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否删除  0-未删除，1-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `handler_id`(`handler_id`) USING BTREE,
  INDEX `is_delete`(`is_delete`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_hospital
-- ----------------------------
INSERT INTO `zd_hospital` VALUES (1, '和平医院', 0, '2019-05-30 15:02:05', 0);
INSERT INTO `zd_hospital` VALUES (2, '战争医院', NULL, '2019-06-01 13:12:56', NULL);
INSERT INTO `zd_hospital` VALUES (3, '卓断', NULL, '2019-06-01 14:56:13', NULL);

SET FOREIGN_KEY_CHECKS = 1;
