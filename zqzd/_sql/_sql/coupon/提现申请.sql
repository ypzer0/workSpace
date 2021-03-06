/**
 * a:ghost
 * 提现申请表
 */
-- ----------------------------
-- Table structure for `coupon_cash_drawal`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_cash_drawal`;
CREATE TABLE `coupon_cash_drawal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `uname` varchar(40) DEFAULT '' COMMENT '用户名',
  `cash` decimal(10,2) DEFAULT 0 COMMENT '提现金额',
  `c_type` tinyint(2) DEFAULT 1 COMMENT '提现类型,1:微信提现 2 支付宝提现',
  `status` tinyint(2) DEFAULT 0 COMMENT '状态   0，申请中  1，已通过  2，已拒绝',
  `msg` varchar(200) DEFAULT '' COMMENT '处理意见',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `uname`(`uname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;


/**
 * a:ghost
 */
-- ----------------------------
-- Table structure for `coupon_cash_drawal_log`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_cash_drawal_log`;
CREATE TABLE `coupon_cash_drawal_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL COMMENT '提现id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `uname` varchar(40) DEFAULT '' COMMENT '用户名',
  `cash` Decimal(10,2) DEFAULT 0 COMMENT '提现金额',
  `c_type` tinyint(2) DEFAULT 0 COMMENT '提现类型,1:提现申请',
  `status` tinyint(2) DEFAULT 0 COMMENT '状态   0，申请中  1，已通过  2，已拒绝',
  `msg` varchar(200) DEFAULT '' COMMENT '处理意见',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `title` varchar(100) DEFAULT '' COMMENT '标题',
  `content` varchar(200) DEFAULT '' COMMENT '内容',
  `handler_id` int(11) DEFAULT 0 COMMENT '操作人Id',
  `handler_name` varchar(50) DEFAULT '' COMMENT '操作人名',
  
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
