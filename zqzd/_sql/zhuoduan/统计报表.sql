
/** 2019-2-14 11:11每日订单状态统计表 **/
-- ----------------------------
-- Table structure for `zd_ept_order_eday`
-- ----------------------------
DROP TABLE IF EXISTS `zd_ept_order_eday`;
CREATE TABLE `zd_ept_order_eday` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `total` mediumint(8) DEFAULT 0 COMMENT '总下单数',
  `completed` mediumint(8) DEFAULT 0 COMMENT '完成订单数',
  `unfinished` mediumint(8) DEFAULT 0 COMMENT '未完成订单数',
  `failed` mediumint(8) DEFAULT 0 COMMENT '失败订单数',
  `ctime` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `total`(`total`) USING BTREE,
  INDEX `completed`(`completed`) USING BTREE,
  INDEX `unfinished`(`unfinished`) USING BTREE,
  INDEX `failed`(`failed`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zd_ept_order_eday
-- ----------------------------

/** 2019-2-15 2:21 每日客户活跃度统计表 **/
-- ----------------------------
-- Table structure for `zd_ept_user_eday`
-- ----------------------------
DROP TABLE IF EXISTS `zd_ept_user_eday`;
CREATE TABLE `zd_ept_user_eday` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `reg` mediumint(8) DEFAULT 0 COMMENT '注册数',
  `online` mediumint(8) DEFAULT 0 COMMENT '活跃数',
  `ctime` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `reg`(`reg`) USING BTREE,
  INDEX `online`(`online`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zd_ept_user_eday
-- ----------------------------
