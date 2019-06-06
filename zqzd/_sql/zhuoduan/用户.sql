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

 Date: 03/06/2019 09:24:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zd_user
-- ----------------------------
DROP TABLE IF EXISTS `zd_user`;
CREATE TABLE `zd_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `nickname` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别：0:女 1男',
  `register_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登录 ip',
  `user_level_id` tinyint(3) NULL DEFAULT NULL COMMENT '用户级别',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机',
  `register_ip` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '注册ip',
  `age` int(4) NULL DEFAULT 0 COMMENT '年龄',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 0，禁用 1，正常 2，删除',
  `remarks` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weixin_openid` varchar(50) DEFAULT '' COMMENT '微信openid',
  `weixin_code` varchar(100) DEFAULT '' COMMENT '微信号',
  `avatar` varchar(255) DEFAULT '' COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  INDEX `register_time`(`register_time`) USING BTREE,
  INDEX `last_login_time`(`last_login_time`) USING BTREE,
  INDEX `user_level_id`(`user_level_id`) USING BTREE,
  INDEX `mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records  of zd_user
-- ----------------------------
INSERT INTO `zd_user`(`id`, `username`, `nickname`, `password`, `gender`, `register_time`, `last_login_time`, `last_login_ip`, `user_level_id`, `mobile`, `register_ip`, `age`, `status`, `remarks`, `weixin_openid`, `weixin_code`, `avatar`) VALUES (1, 'admin', '管理者', '111', 0, '2019-05-23 15:40:36', '2019-05-23 15:40:36', '123478', 0, '18323457891', '11126549', 18, 1, NULL, NULL, NULL, NULL);
INSERT INTO `zd_user`(`id`, `username`, `nickname`, `password`, `gender`, `register_time`, `last_login_time`, `last_login_ip`, `user_level_id`, `mobile`, `register_ip`, `age`, `status`, `remarks`, `weixin_openid`, `weixin_code`, `avatar`) VALUES (2, '西门吹雪', '洗吹', '9999', 1, '2019-05-31 15:45:57', '2019-05-31 15:46:00', '999', 1, '18323104626', '456165156', 26, 1, '', NULL, NULL, NULL);
INSERT INTO `zd_user`(`id`, `username`, `nickname`, `password`, `gender`, `register_time`, `last_login_time`, `last_login_ip`, `user_level_id`, `mobile`, `register_ip`, `age`, `status`, `remarks`, `weixin_openid`, `weixin_code`, `avatar`) VALUES (7, '陆小凤', '消费', '9999', 0, '2019-05-29 15:48:01', '2019-05-31 15:48:05', '1111', 1, '1111111', '111111', 0, 0, NULL, NULL, NULL, NULL);
INSERT INTO `zd_user`(`id`, `username`, `nickname`, `password`, `gender`, `register_time`, `last_login_time`, `last_login_ip`, `user_level_id`, `mobile`, `register_ip`, `age`, `status`, `remarks`, `weixin_openid`, `weixin_code`, `avatar`) VALUES (8, '叶孤城', '野古', '999', 0, '2019-05-31 15:47:23', '2019-05-31 15:47:29', '1111', 1, '11111111', '111111', 0, 1, NULL, NULL, NULL, NULL);
INSERT INTO `zd_user`(`id`, `username`, `nickname`, `password`, `gender`, `register_time`, `last_login_time`, `last_login_ip`, `user_level_id`, `mobile`, `register_ip`, `age`, `status`, `remarks`, `weixin_openid`, `weixin_code`, `avatar`) VALUES (9, '老实和尚', '和尚', '2222', 1, '2019-05-31 15:48:46', '2019-05-31 15:48:49', '11111', 1, '11111111', '111111', 0, 0, NULL, NULL, NULL, NULL);
INSERT INTO `zd_user`(`id`, `username`, `nickname`, `password`, `gender`, `register_time`, `last_login_time`, `last_login_ip`, `user_level_id`, `mobile`, `register_ip`, `age`, `status`, `remarks`, `weixin_openid`, `weixin_code`, `avatar`) VALUES (10, 'bbb', 'bbb', 'bbb', 1, '2019-05-31 19:37:36', '2019-05-31 19:37:40', 'bbb', 1, '96446516', 'bbb', 0, 0, NULL, NULL, NULL, NULL);
INSERT INTO `zd_user`(`id`, `username`, `nickname`, `password`, `gender`, `register_time`, `last_login_time`, `last_login_ip`, `user_level_id`, `mobile`, `register_ip`, `age`, `status`, `remarks`, `weixin_openid`, `weixin_code`, `avatar`) VALUES (11, 'aaa', 'aaa', 'aaa', 0, '2019-05-31 19:38:17', '2019-05-31 19:38:19', 'aaa', 1, '456531534', 'aaa', 0, 0, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
