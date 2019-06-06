/**
 * 冻结金额
 * 作者：zy
 */
-- ----------------------------
-- Table structure for `coupon_user_frozen_info`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_user_frozen_info`;
CREATE TABLE `coupon_user_frozen_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `f_money` decimal(10, 2) DEFAULT 0 COMMENT '冻结金额',
  `src_type` tinyint(2) DEFAULT 0 COMMENT '冻结金额来源 0:佣金，1：卖劵收入',
  `status` tinyint(2) default 0 COMMENT '状态0:冻结，1：解冻',
  `h_id` int(11) NOT NULL COMMENT '操作人id',
  `h_name` varchar(50) default '' COMMENT '操作人',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `u_time` datetime DEFAULT NULL COMMENT '修改时间',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `h_id`(`h_id`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE,
  INDEX `src_type`(`src_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/**
 * 冻结金额明细
 * 作者：zy
 */
-- ----------------------------
-- Table structure for `coupon_user_frozen_info_log`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_user_frozen_info_log`;
CREATE TABLE `coupon_user_frozen_info_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `f_money` decimal(10, 2) DEFAULT 0 COMMENT '冻结金额',
  `src_type` tinyint(2) DEFAULT 0 COMMENT '冻结金额来源 0:佣金，1：卖劵收入',
  `status` tinyint(2) default 0 COMMENT '状态0:冻结，1：解冻',
  `h_id` int(11) NOT NULL COMMENT '操作人id',
  `h_name` varchar(50) default '' COMMENT '操作人',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `h_id`(`h_id`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE,
  INDEX `src_type`(`src_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;








