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

 Date: 03/06/2019 09:23:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `zd_goods_info`;
CREATE TABLE `zd_goods_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NULL DEFAULT 0 COMMENT '种类id',
  `goods_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `goods_sn` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品编号',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '是否上架: 0 未上架 1:上架',
  `price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品价格5',
  `goods_number` mediumint(8) UNSIGNED NULL DEFAULT 0 COMMENT '商品数量',
  `small_img_path` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图路径',
  `big_img_path` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情图路径',
  `goods_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品详情',
  `add_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  INDEX `goods_name`(`goods_name`) USING BTREE,
  INDEX `goods_sn`(`goods_sn`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `price`(`price`) USING BTREE,
  INDEX `goods_number`(`goods_number`) USING BTREE,
  INDEX `small_img_path`(`small_img_path`(255)) USING BTREE,
  INDEX `big_img_path`(`big_img_path`(255)) USING BTREE
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_goods_info
-- ----------------------------
INSERT INTO `zd_goods_info` VALUES (3, 0, NULL, '商品测试', '999', 1, 111111.00, 8889, 'https://wsimg.qzhkj.cn/h5/goods/20190531/185742379c0a12.png', 'https://wsimg.qzhkj.cn/h5/goods/20190531/18574629932efc.jpg', NULL);
INSERT INTO `zd_goods_info` VALUES (4, 0, NULL, '关精神病院', '11119999', 1, 998.00, 998, 'https://wsimg.qzhkj.cn/h5/goods/20190601/105633118d3b70.jpg', 'https://wsimg.qzhkj.cn/h5/goods/20190601/10563788520ac5.jpg', NULL);

SET FOREIGN_KEY_CHECKS = 1;
