-- ----------------------------
-- Table structure for `coupon_collect`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_collect`;
CREATE TABLE `coupon_collect` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户Id',
  `value_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '产品Id',
  `add_time` datetime not null  COMMENT '添加时间',
  `is_attention` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否提醒',
  `type_id` int(2) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `value_id`(`value_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  INDEX `is_attention`(`is_attention`) USING BTREE
  
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;