/** 
 * a:zy
 * e:zgyxszyd@163.com
 * 2019-3-30 1:57 支付日志 **/
-- ----------------------------
-- Table structure for `nideshop_pay_log`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_pay_log`;
CREATE TABLE `nideshop_pay_log` (

  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `ip` varchar(25) DEFAULT '' COMMENT '请求ip',
  `u_id` mediumint(8) DEFAULT 0 COMMENT '申请人Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '申请人昵称',
  `o_id` mediumint(8) DEFAULT 0 COMMENT '订单Id',
  `order_no` varchar(50) DEFAULT '' COMMENT '订单编号',
  `money` decimal(10,2) DEFAULT 0 COMMENT '金额',
  `tra_type` tinyint(2) DEFAULT 0 COMMENT '类型:1：用户申请 2: 平台返回',
  `pay_type` tinyint(2) DEFAULT 0 COMMENT '类型:1：微信支付 2: 支付宝',
  `status` tinyint(2) DEFAULT 0 COMMENT '类型:1：成功 2:失败 3:异常',
  `ctime` datetime COMMENT '创建时间',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ip`(`ip`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `o_id`(`o_id`) USING BTREE,
  INDEX `order_no`(`order_no`) USING BTREE,
  INDEX `tra_type`(`tra_type`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `pay_type`(`pay_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nideshop_pay_log
-- ----------------------------