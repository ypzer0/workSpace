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

 Date: 03/06/2019 09:24:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 278 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '会员管理', NULL, NULL, 0, 'fa fa-user-circle-o', -6, 0);
INSERT INTO `sys_menu` VALUES (17, 0, '商品管理', NULL, NULL, 0, 'fa fa-user-circle-o', -5, 0);
INSERT INTO `sys_menu` VALUES (41, 0, '订单管理', NULL, NULL, 0, 'fa fa-sitemap', -3, 0);
INSERT INTO `sys_menu` VALUES (64, 0, '系统管理', NULL, NULL, 0, 'fa fa-cog', -1, 0);
INSERT INTO `sys_menu` VALUES (65, 64, '近期下单情况', NULL, 'couponeptordereday:list', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (66, 64, '近期客户活跃情况', NULL, 'couponeptusereday:list', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (67, 64, '管理员列表', 'sys/user.html', NULL, 1, 'fa fa-user', 1, 0);
INSERT INTO `sys_menu` VALUES (68, 67, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (69, 67, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (70, 67, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (71, 67, '删除', NULL, 'sys:user:delete', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (72, 64, '角色管理', 'sys/role.html', NULL, 1, 'fa fa-user-secret', 1, 0);
INSERT INTO `sys_menu` VALUES (73, 72, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (74, 72, '新增', NULL, 'sys:role:save,sys:menu:perms', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (75, 72, '修改', NULL, 'sys:role:update,sys:menu:perms', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (76, 72, '删除', NULL, 'sys:role:delete', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (83, 64, '短信配置', 'sys/smslog.html', NULL, 1, 'fa fa-envelope-open', 1, 0);
INSERT INTO `sys_menu` VALUES (84, 83, '查看', NULL, 'sys:smslog:list,sys:smslog:info', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (85, 64, '操作日志', 'sys/sysoperlog.html', NULL, 1, 'fa fa-envelope-open', 1, 0);
INSERT INTO `sys_menu` VALUES (86, 85, '查看', NULL, 'sysoperlog:list,sysoperlog:info', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (87, 64, '文件服务器配置', 'sys/oss.html', 'sys:oss:all', 1, 'fa fa-file-image-o', 6, 0);
INSERT INTO `sys_menu` VALUES (88, 64, '定时任务', 'sys/schedule.html', NULL, 1, 'fa fa-tasks', 5, 0);
INSERT INTO `sys_menu` VALUES (89, 88, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (90, 88, '新增', NULL, 'sys:schedule:save', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (91, 88, '修改', NULL, 'sys:schedule:update', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (92, 88, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (93, 88, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (94, 88, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (95, 88, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (96, 88, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (97, 64, '系统字典', 'sys/macro.html', NULL, 1, 'fa fa-book', 6, 0);
INSERT INTO `sys_menu` VALUES (98, 97, '查看', NULL, 'sys:macro:list,sys:macro:info', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (99, 97, '新增', NULL, 'sys:macro:save', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (100, 97, '修改', NULL, 'sys:macro:update', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (101, 97, '删除', NULL, 'sys:macro:delete', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (102, 64, '卓断配置', 'coupon/coupon/couponconfig.html', '', 1, 'fa fa-sun-o', 7, 0);
INSERT INTO `sys_menu` VALUES (103, 102, '加载数据', NULL, 'coupon:config:load', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (104, 102, '保存', NULL, 'coupon:config:update', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (105, 1, '代码生成器', 'sys/generator.html', 'sys:generator:list,sys:generator:code', 1, 'fa fa-rocket', 10, 0);
INSERT INTO `sys_menu` VALUES (106, 1, '菜单管理', 'sys/menu.html', '', 1, 'fa fa-folder-open', 4, 0);
INSERT INTO `sys_menu` VALUES (226, 41, '订单列表', 'zhuoduan/zdorder.html', 'Zdorder:list,Zdorder:info', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (227, 999, '新增', NULL, 'Zdorder:save', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (228, 999, '修改', NULL, 'Zdorder:update', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (229, 999, '删除', NULL, 'Zdorder:delete', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (231, 235, '留言查看', 'zhuoduan/Zdquestion.html', 'Zdquestion:list,Zdquestion:info', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (232, 999, '新增', NULL, 'Zdquestion:save', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (233, 999, '修改', NULL, 'Zdquestion:update', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (234, 999, '删除', NULL, 'Zdquestion:delete', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (235, 0, '留言管理', NULL, NULL, 0, 'fa fa-user-circle-o', -2, 0);
INSERT INTO `sys_menu` VALUES (236, 0, '检查报告', '', NULL, 0, 'fa fa-file-code-o', -3, 0);
INSERT INTO `sys_menu` VALUES (237, 236, '查看', 'zhuoduan/Zdreport.html', 'Zdreport:list,Zdreport:info', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (238, 236, '新增', NULL, 'Zdreport:save', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (239, 236, '修改', NULL, 'Zdreport:update', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (240, 236, '删除', NULL, 'Zdreport:delete', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (242, 64, '投诉建议', 'zhuoduan/Zdopinion.html', 'Zdopinion:list,Zdopinion:info', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (243, 64, '新增', NULL, 'Zdopinion:save', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (244, 64, '修改', NULL, 'Zdopinion:update', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (245, 64, '删除', NULL, 'Zdopinion:delete', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (247, 17, '商品列表', 'zhuoduan/Zdgoodsinfo.html', 'Zdgoodsinfo:list,Zdgoodsinfo:info,Zdcategory:list', 1, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (248, 17, '新增', NULL, 'Zdgoodsinfo:save', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (249, 17, '修改', NULL, 'Zdgoodsinfo:update', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (250, 17, '删除', NULL, 'Zdgoodsinfo:delete', 2, NULL, 0, 0);
INSERT INTO `sys_menu` VALUES (252, 17, '商品种类', 'zhuoduan/Zdcategory.html', 'Zdcategory:list,Zdcategory:info', 1, NULL, -1, 0);
INSERT INTO `sys_menu` VALUES (253, 252, '新增', NULL, 'Zdcategory:save', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (254, 252, '修改', NULL, 'Zdcategory:update', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (255, 252, '删除', NULL, 'Zdcategory:delete', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (258, 267, '新增', NULL, 'Zddoctor:save', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (259, 267, '修改', NULL, 'Zddoctor:update', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (260, 267, '删除', NULL, 'Zddoctor:delete', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (262, 1, '用户信息', 'zhuoduan/Zduser.html', 'Zduser:list,Zduser:info', 1, 'fa fa-user-circle-o', -3, 0);
INSERT INTO `sys_menu` VALUES (263, 1, '新增', NULL, 'Zduser:save', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (264, 1, '修改', NULL, 'Zduser:update', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (265, 1, '删除', NULL, 'Zduser:delete', 2, NULL, 6, 0);
INSERT INTO `sys_menu` VALUES (267, 17, '医院管理', 'zhuoduan/Zddoctor.html', 'Zddoctor:list,Zddoctor:info', 1, NULL, 3, 0);

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `status`) VALUES (65, '近期下单情况', NULL, 'Zdeptordereday:list', 2, NULL, 0, 0);
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `status`) VALUES (66, '近期客户活跃情况', NULL, 'Zdeptusereday:list', 2, NULL, 0, 0);

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `status`) VALUES (247, '上架', NULL, 'Zdgoodsinfo:upperShelf', 2, NULL, 0, 0);
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `status`) VALUES (247, '下架', NULL, 'Zdgoodsinfo:soldOut', 2, NULL, 0, 0);

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `status`) VALUES(64, '删除', NULL, 'Zdsysoperlog:delete', 2, NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
