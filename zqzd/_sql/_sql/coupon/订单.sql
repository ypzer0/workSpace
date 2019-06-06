
/**
 * 
 * 
 */
-- ----------------------------
-- Table structure for `coupon_order`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_order`;
CREATE TABLE `coupon_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(32) DEFAULT '' COMMENT '订单号',
  `bus_order_sn` varchar(50) DEFAULT '' COMMENT '商户订单号',
  `user_id` int(11) unsigned DEFAULT '0' COMMENT '用户ID',
  `order_status` tinyint(1) unsigned DEFAULT '0' COMMENT '订单状态  0：未支付  1：支付成功  2：支付失败',
  `pay_status` tinyint(1) unsigned DEFAULT '0' COMMENT '购买成功0:未支付 1:支付成功',
  `pay_type` tinyint(1) DEFAULT 0 COMMENT '0:微信支付 1：支付宝',
  `order_price` decimal(10,2) DEFAULT '0.00' COMMENT '订单总价',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `confirm_time` datetime DEFAULT NULL COMMENT '下单时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `order_type` tinyint(1) DEFAULT 0 COMMENT '订单类型 0:正常订单 1：纠纷订单',
  `g_id` int(11) DEFAULT 0 COMMENT '商品二级分类id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_sn` (`order_sn`),
  KEY `bus_order_sn` (`bus_order_sn`),
  KEY `user_id` (`user_id`),
  KEY `order_status` (`order_status`),
  KEY `pay_status` (`pay_status`),
  KEY `g_id` (`g_id`),
  KEY `pay_type` (`pay_type`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/**
 * 
 * 
 */
-- ----------------------------
-- Table structure for `coupon_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_order_detail`;
CREATE TABLE `coupon_order_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT 0 COMMENT '订单id',
  `order_sn` varchar(32) DEFAULT '' COMMENT '订单号',
  `goods_id` int(11) DEFAULT 0 COMMENT '商品id',
  `goods_sn` varchar(60) DEFAULT '' COMMENT '商品编号',
  `buy_count` int(11) DEFAULT 0 COMMENT '购买数量',
  `buy_price` decimal(10,2) DEFAULT 0.00 COMMENT '购买金额',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `order_sn` (`order_sn`),
  KEY `goods_id` (`goods_id`),
  KEY `goods_sn` (`goods_sn`),
  KEY `add_time` (`add_time`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

