/**
 * a:ghost
 *纠纷处理表
 */
-- ----------------------------
-- Table structure for `coupon_issue_handle`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_issue_handle`;
CREATE TABLE `coupon_issue_handle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `uname` varchar(40) DEFAULT '' COMMENT '用户名',
  `order_sn` varchar(50) DEFAULT '' COMMENT '订单号',
  `status` tinyint(2) DEFAULT 0 COMMENT '状态   0，待处理  1，已处理',
  `reason` varchar(200) DEFAULT '' COMMENT '申请原因',
  `msg` varchar(200) DEFAULT '' COMMENT '处理意见',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `issue_type` tinyint(1) DEFAULT 1 COMMENT '状态   1，卖家问题  2，买家问题',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_sn`(`order_sn`) USING BTREE,
  INDEX `status`(`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/**
 * a:ghost
 * 纠纷处理日志记录
 */
-- ----------------------------
-- Table structure for `coupon_issue_handle_log`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_issue_handle_log`;
CREATE TABLE `coupon_issue_handle_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ih_id` int(11) NOT NULL COMMENT '纠纷Id',
  `uid` varchar(40) DEFAULT '' COMMENT '用户Id',
  `uname` varchar(40) DEFAULT '' COMMENT '用户名',
  `order_sn` varchar(50) DEFAULT '' COMMENT '订单号',
  `status` tinyint(2) DEFAULT 0 COMMENT '状态   0，待处理  1，已处理',
  `msg` varchar(200) DEFAULT '' COMMENT '处理意见',
  `title` varchar(100) DEFAULT '' COMMENT '标题',
  `content` varchar(200) DEFAULT '' COMMENT '内容',
  `reason` varchar(200) DEFAULT '' COMMENT '申请原因',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `handler_id` int(11) DEFAULT 0 COMMENT '操作人Id',
  `handler_name` varchar(50) DEFAULT '' COMMENT '操作人名',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ih_id`(`ih_id`) USING BTREE,
  INDEX `order_sn`(`order_sn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;