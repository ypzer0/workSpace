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

 Date: 03/06/2019 09:23:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_category
-- ----------------------------
DROP TABLE IF EXISTS `zd_category`;
CREATE TABLE `zd_category`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '种类名称',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '关键字',
  `parent_id` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '上级id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `keywords`(`keywords`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_category
-- ----------------------------
INSERT INTO `zd_category` VALUES (1, '基因检测',  '妇科', 0);
INSERT INTO `zd_category` VALUES (35, '精神检测', '神经', 1);
INSERT INTO `zd_category` VALUES (36, '基因治疗', '放弃治疗', 1);
INSERT INTO `zd_category` VALUES (37, '妇科治疗',  '测试测试', 0);
INSERT INTO `zd_category` VALUES (38, '头发治疗',  '测试', 0);
INSERT INTO `zd_category` VALUES (39, '放射治疗',  '测试', 0);
INSERT INTO `zd_category` VALUES (40, '放弃治疗',  '测试', 0);
INSERT INTO `zd_category` VALUES (41, '投胎疗法',  '测试', 0);
INSERT INTO `zd_category` VALUES (42, '颈椎治疗',  '测试', 0);
INSERT INTO `zd_category` VALUES (43, '眼睛治疗',  '测试', 0);
INSERT INTO `zd_category` VALUES (44, '腰椎治疗',  '测试', 0);

SET FOREIGN_KEY_CHECKS = 1;
