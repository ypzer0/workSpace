
/** 2019-2-15 2:21 客户资金明细 **/
-- ----------------------------
-- Table structure for `coupon_wallet_info`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_wallet_info`;
CREATE TABLE `coupon_wallet_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '客户Id',
  `money` decimal(10,2) DEFAULT NULL COMMENT '变动金额',
  `pre_money` decimal(10,2) DEFAULT NULL COMMENT '原始金额',
  `end_money` decimal(10,2) DEFAULT NULL COMMENT '当前金额',
  `wtype1` int(11) DEFAULT 0 COMMENT '类型:1.支出 2.收入 ',
  `wtype2` int(11) DEFAULT 0 COMMENT '类型:3.微信 4.支付宝 5:佣金 6:提成:',
  `order_sn` varchar(32) DEFAULT NULL COMMENT '订单号',
  `transaction_id` varchar(32) DEFAULT NULL COMMENT '微信订单号',
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '商户订单号',
  `f_money` decimal(10,2) DEFAULT 0 COMMENT '冻结金额',
  `f_status` tinyint(2) DEFAULT 0 COMMENT '冻结状态0:正常 1:冻结中',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `money`(`money`) USING BTREE,
  INDEX `wtype1`(`wtype1`) USING BTREE,
  INDEX `wtype2`(`wtype2`) USING BTREE,
  INDEX `order_sn`(`order_sn`) USING BTREE,
  INDEX `f_status`(`f_status`) USING BTREE,
  INDEX `transaction_id`(`transaction_id`) USING BTREE,
  INDEX `out_trade_no`(`out_trade_no`) USING BTREE
  
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wallet_info
-- ----------------------------


-- ----------------------------
-- Table structure for `coupon_wallet_info_log`
-- 客户资金流水日志
-- ----------------------------
DROP TABLE IF EXISTS `coupon_wallet_info_log`;
CREATE TABLE `coupon_wallet_info_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `wid` int(11) DEFAULT NULL COMMENT '流水Id',
  `uid` int(11) DEFAULT NULL COMMENT '操作人id',
  `wtype1` tinyint(2) DEFAULT 0 COMMENT '类型:1.支出 2.收入 ',
  `wtype2` tinyint(2) DEFAULT 0 COMMENT '类型:3.微信 4.支付宝 5:佣金 6:提成:',
  `money` decimal(10,2) DEFAULT NULL COMMENT '变动金额',
  `pre_money` decimal(10,2) DEFAULT NULL COMMENT '原始金额',
  `end_money` decimal(10,2) DEFAULT NULL COMMENT '当前金额',
  `f_money` decimal(10,2) DEFAULT 0 COMMENT '冻结金额',
  `f_status` tinyint(2) DEFAULT 0 COMMENT '冻结状态0:正常 1:冻结中',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `wid`(`wid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `money`(`money`) USING BTREE,
  INDEX `wtype1`(`wtype1`) USING BTREE,
  INDEX `wtype2`(`wtype2`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon_wallet_info_log
-- ----------------------------


