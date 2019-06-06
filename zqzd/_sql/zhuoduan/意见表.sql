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

 Date: 03/06/2019 09:23:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_opinion
-- ----------------------------
DROP TABLE IF EXISTS `zd_opinion`;
CREATE TABLE `zd_opinion`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '用户ID',
  `opinion` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '意见',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `is_delete` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否删除  0-未删除，1-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `is_delete`(`is_delete`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_opinion
-- ----------------------------
INSERT INTO `zd_opinion` VALUES (1, 1, '去世', '2019-05-30 13:09:54', 0);

SET FOREIGN_KEY_CHECKS = 1;
