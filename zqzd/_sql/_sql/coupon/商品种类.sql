
/**
 * 商品种类
 * a:zy
 * e:zgyxszyd@163.com
 *  2019-4-20 1:57 商品种类**/
-- ----------------------------
-- Table structure for `coupon_category`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_category`;
CREATE TABLE `coupon_category` (

  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,

  `name` varchar(90) NOT NULL DEFAULT '' COMMENT '种类名称',
  `keywords` varchar(255) DEFAULT '' COMMENT '关键字',
  `front_desc` varchar(255) DEFAULT '' COMMENT '描述',
  `parent_id` int(11) unsigned DEFAULT '0' COMMENT '上级id',
  `sort_order` tinyint(1) unsigned DEFAULT '50' COMMENT '排序号',
  `is_show` tinyint(1) unsigned DEFAULT '1' COMMENT '是否展示 1：展示 0：隐藏',
  
  `market_price` decimal(10, 2) DEFAULT 0 COMMENT '市场价',
  `sale_price` decimal(10, 2) DEFAULT 0 COMMENT '鼎鑫销售价格',
  `sale_price_hy` decimal(10, 2) DEFAULT 0 COMMENT '惠友销售价格',
  `buy_price` decimal(10, 2) DEFAULT 0 COMMENT '收购价格',
  `pro_price` decimal(10, 2) DEFAULT 0 COMMENT '推广价格',
  `src` varchar(2000) DEFAULT '' COMMENT '来源描述',
  `goods_desc` varchar(2000) DEFAULT '' COMMENT '商品描述',
  `reminder` varchar(2000) DEFAULT '' COMMENT '温馨提示',
  `service` varchar(2000) DEFAULT '' COMMENT '服务协议',
  `user_msg` varchar(2000) DEFAULT '' COMMENT '使用需知',
  `max_count` int(11) DEFAULT 0 COMMENT '最大库存',
  `sale_times` varchar(20) DEFAULT '' COMMENT '0:正常出售 1：周末出售',
  `pic_url` varchar(200) DEFAULT '' COMMENT '商品缩略图',
  `pic_big_url` varchar(200) DEFAULT '' COMMENT '商品大图url',
  `handler_id` int(11) DEFAULT 0 COMMENT '操作人',
  `add_time` datetime not null COMMENT '添加时间',
  `status` tinyint(1) unsigned DEFAULT 0 COMMENT '状态 0：正常 1：删除',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  INDEX `is_show`(`is_show`) USING BTREE,
  INDEX `handler_id`(`handler_id`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon_category
-- ----------------------------

INSERT INTO `coupon_category`(`name`, `keywords`, `front_desc`, `parent_id`, `sort_order`, `is_show`, `market_price`, `sale_price`, `buy_price`, `pro_price`, `src`, `goods_desc`, `reminder`, `service`, `user_msg`, `max_count`, `sale_times`, `pic_url`, `pic_big_url`, `handler_id`, `add_time`, `status`) VALUES ('推荐', '推荐', '推荐', 0, 0.00, 0, 0.00, 0.00, 0.00, 0.00, '', '', '', '', '', 0, '0', '', '', 0, '2019-04-25 14:15:14', 0);
INSERT INTO `coupon_category`(`name`, `keywords`, `front_desc`, `parent_id`, `sort_order`, `is_show`, `market_price`, `sale_price`, `buy_price`, `pro_price`, `src`, `goods_desc`, `reminder`, `service`, `user_msg`, `max_count`, `sale_times`, `pic_url`, `pic_big_url`, `handler_id`, `add_time`, `status`) VALUES ('视频', '视频', '视频', 0, 0.00, 0, 0.00, 0.00, 0.00, 0.00, '', '', '', '', '', 0, '0', '', '', 0, '2019-04-25 14:15:14', 0);
INSERT INTO `coupon_category`(`name`, `keywords`, `front_desc`, `parent_id`, `sort_order`, `is_show`, `market_price`, `sale_price`, `buy_price`, `pro_price`, `src`, `goods_desc`, `reminder`, `service`, `user_msg`, `max_count`, `sale_times`, `pic_url`, `pic_big_url`, `handler_id`, `add_time`, `status`) VALUES ('饮品', '饮品', '饮品', 0, 0.00, 0, 0.00, 0.00, 0.00, 0.00, '', '', '', '', '', 0, '0', '', '', 0, '2019-04-25 14:15:14', 0);
INSERT INTO `coupon_category`(`name`, `keywords`, `front_desc`, `parent_id`, `sort_order`, `is_show`, `market_price`, `sale_price`, `buy_price`, `pro_price`, `src`, `goods_desc`, `reminder`, `service`, `user_msg`, `max_count`, `sale_times`, `pic_url`, `pic_big_url`, `handler_id`, `add_time`, `status`) VALUES ('出行', '出行', '出行', 0, 0.00, 0, 0.00, 0.00, 0.00, 0.00, '', '', '', '', '', 0, '0', '', '', 0, '2019-04-25 14:15:14', 0);
INSERT INTO `coupon_category`(`name`, `keywords`, `front_desc`, `parent_id`, `sort_order`, `is_show`, `market_price`, `sale_price`, `buy_price`, `pro_price`, `src`, `goods_desc`, `reminder`, `service`, `user_msg`, `max_count`, `sale_times`, `pic_url`, `pic_big_url`, `handler_id`, `add_time`, `status`) VALUES ('美食', '美食', '美食', 0, 0.00, 0, 0.00, 0.00, 0.00, 0.00, '', '', '', '', '', 0, '0', '', '', 0, '2019-04-25 14:15:14', 0);


