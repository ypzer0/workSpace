
/** 2019-2-15 2:21 客户资金明细 **/
-- ----------------------------
-- Table structure for `wallet_info`
-- ----------------------------
DROP TABLE IF EXISTS `wallet_info`;
CREATE TABLE `wallet_info` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `uid` mediumint(8) DEFAULT NULL COMMENT '客户Id',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `wtype1` mediumint(8) DEFAULT 0 COMMENT '类型:1.支出 2.收入 ',
  `wtype2` mediumint(8) DEFAULT 0 COMMENT '类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 ',
  `order_sn` varchar(32) DEFAULT NULL COMMENT '订单号',
  `coupon_id` mediumint(8) DEFAULT NULL COMMENT '优惠劵Id',
  `transaction_id` varchar(32) DEFAULT NULL COMMENT '微信订单号',
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '商户订单号',
  `activity_id` varchar(32) DEFAULT NULL COMMENT '活动id',
  
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `money`(`money`) USING BTREE,
  INDEX `wtype1`(`wtype1`) USING BTREE,
  INDEX `wtype2`(`wtype2`) USING BTREE,
  INDEX `order_sn`(`order_sn`) USING BTREE,
  INDEX `coupon_id`(`coupon_id`) USING BTREE,
  INDEX `transaction_id`(`transaction_id`) USING BTREE,
  INDEX `out_trade_no`(`out_trade_no`) USING BTREE,
  INDEX `activity_id`(`activity_id`) USING BTREE
  
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wallet_info
-- ----------------------------


-- ----------------------------
-- Table structure for `wallet_info_log`
-- 客户资金流水日志
-- ----------------------------
DROP TABLE IF EXISTS `wallet_info_log`;
CREATE TABLE `wallet_info_log` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `wid` mediumint(8) DEFAULT NULL COMMENT '流水Id',
  `uid` mediumint(8) DEFAULT NULL COMMENT '操作人id',
  `wtype1` mediumint(8) DEFAULT 0 COMMENT '类型:1.支出 2.收入 ',
  `wtype2` mediumint(8) DEFAULT 0 COMMENT '类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 ',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
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
-- Records of wallet_info_log
-- ----------------------------


