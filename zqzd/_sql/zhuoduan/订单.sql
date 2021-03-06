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

 Date: 03/06/2019 09:23:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_order
-- ----------------------------
DROP TABLE IF EXISTS `zd_order`;
CREATE TABLE `zd_order`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) NULL DEFAULT NULL COMMENT '医生id',
  `goods_id` int(11) NULL DEFAULT 0 COMMENT '商品id',
  `department_id` int(11) NOT NULL COMMENT '科室id',
  `hospital_id` int(11) NULL DEFAULT NULL COMMENT '医院id',
  `order_status` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '订单状态  0：未支付  1：支付成功  2：支付失败',
  `pay_status` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '购买成功0:未支付 1:支付成功',
  `user_id` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '用户ID',
  `order_number` mediumint(8) UNSIGNED NULL DEFAULT 0 COMMENT '下单数量',
  `order_sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '订单编号',
  `confirm_time` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `order_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '订单价格',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_sn`(`order_sn`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `order_status`(`order_status`) USING BTREE,
  INDEX `pay_status`(`pay_status`) USING BTREE,
  INDEX `confirm_time`(`confirm_time`) USING BTREE,
  INDEX `pay_time`(`pay_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_order
-- ----------------------------
INSERT INTO `zd_order` VALUES (1, NULL, 2, 0, NULL, 2, 2, 1, 45, '1', '2019-05-30 17:41:30', '2019-05-01 08:00:00', 998.00);

SET FOREIGN_KEY_CHECKS = 1;
