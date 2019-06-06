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

 Date: 03/06/2019 09:24:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_report
-- ----------------------------
DROP TABLE IF EXISTS `zd_report`;
CREATE TABLE `zd_report`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `report_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '报表名称',
  `upload_status` tinyint(1) NULL DEFAULT NULL COMMENT '上传状态 0:没有, 1:有',
  `check_status` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否检查过  0 :没有,  1: 有',
  `report_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告文件路径(加密)',
  `add_time` datetime NOT NULL COMMENT '报告时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `report_name`(`report_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zd_report
-- ----------------------------
INSERT INTO `zd_report` VALUES (2, 2, '222', 1, 1, 'www.baidu.com', '2019-05-31 16:07:24');
INSERT INTO `zd_report` VALUES (3, 88, '报告', 0, 0, 'www.baidu.com', '2019-05-31 17:14:06');
INSERT INTO `zd_report` VALUES (7, 9, '测试和尚', 1, 0, 'https://wsimg.qzhkj.cn/h5/goods/20190531/174012895564b5.xlsx', '2019-05-31 17:40:14');
INSERT INTO `zd_report` VALUES (8, 8, '测试----', 1, 0, 'https://wsimg.qzhkj.cn/h5/goods/20190531/174154176a6c15.xlsx', '2019-05-31 17:41:55');
INSERT INTO `zd_report` VALUES (9, 7, '测试小风', 1, 0, 'https://wsimg.qzhkj.cn/h5/goods/20190531/174229746671b4.txt', '2019-05-31 17:42:30');
INSERT INTO `zd_report` VALUES (10, 8, '测试包++++', 1, 1, 'https://wsimg.qzhkj.cn/h5/goods/20190531/1749187259b9ce.xlsx', '2019-05-31 17:49:19');
INSERT INTO `zd_report` VALUES (11, 7, '测试积极未积极急急急1', 1, 1, 'https://wsimg.qzhkj.cn/h5/goods/20190531/174954584db01f.xlsx', '2019-05-31 17:49:55');
INSERT INTO `zd_report` VALUES (12, 9, '检查检查2', 1, 1, 'https://wsimg.qzhkj.cn/h5/goods/20190531/175201831fbde.xlsx', '2019-05-31 17:52:02');
INSERT INTO `zd_report` VALUES (13, 1, '测试是生死事实', 1, 1, 'https://wsimg.qzhkj.cn/h5/goods/20190531/180425694d6c6.xlsx', '2019-05-31 18:04:26');
INSERT INTO `zd_report` VALUES (14, 7, '小风1111', 0, 0, NULL, '2019-05-31 18:13:46');
INSERT INTO `zd_report` VALUES (15, 9, '和尚', 1, 0, 'https://wsimg.qzhkj.cn/h5/goods/20190531/18142375238589.txt', '2019-05-31 18:14:24');
INSERT INTO `zd_report` VALUES (16, 10, '测试上传', 1, 1, 'https://wsimg.qzhkj.cn/h5/goods/20190531/18354885e36e7.txt', '2019-05-31 18:36:00');
INSERT INTO `zd_report` VALUES (17, 11, '为用户添加报告', 1, 0, 'https://wsimg.qzhkj.cn/h5/goods/20190531/1918088293d406.xlsx', '2019-05-31 19:18:09');
INSERT INTO `zd_report` VALUES (18, 7, '域名测试', 1, 1, 'https://wsimg.qzhkj.cn/h5/goods/20190531/1942244088f724.xlsx', '2019-05-31 19:42:26');
INSERT INTO `zd_report` VALUES (19, 15, '医生报告', 1, 0, 'https://wsimg.qzhkj.cn/h5/goods/20190601/14574990912f58.jpg', '2019-06-01 14:58:03');

SET FOREIGN_KEY_CHECKS = 1;
