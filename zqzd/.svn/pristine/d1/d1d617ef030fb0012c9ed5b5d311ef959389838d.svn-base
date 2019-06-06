
/**
 * 
 * 用户信用明细表
 * 
 */
DROP TABLE IF EXISTS `coupon_user_credit_info`;
CREATE TABLE `coupon_user_credit_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `c_type` tinyint(2) DEFAULT 0 COMMENT '信用明细类型, 1:增加  2:减少',
  `u_id` int(11) unsigned DEFAULT '0' COMMENT '用户ID',
  `credit` int(11) unsigned DEFAULT '0' COMMENT '变动积分',
  `pre_credit` int(11) unsigned DEFAULT '0' COMMENT '变动前',
  `end_credit` int(11) unsigned DEFAULT '0' COMMENT '变动后',
  `reson` varchar(20)  DEFAULT '' COMMENT '变动原因',
  `handler_id` int(11) unsigned DEFAULT '0' COMMENT '操作人',
  `add_time` datetime DEFAULT NULL COMMENT '操作时间',
  
  PRIMARY KEY (`id`),
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `handler_id`(`handler_id`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


/**
 * 
 * 用户积分明细表
 * 
 */
DROP TABLE IF EXISTS `coupon_user_integral_info`;
CREATE TABLE `coupon_user_integral_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `i_type` tinyint(2) DEFAULT 0 COMMENT '信用明细类型, 1:增加  2:减少',
  `u_id` int(11) unsigned DEFAULT '0' COMMENT '用户ID',
  `integral` int(11) unsigned DEFAULT '0' COMMENT '变动积分',
  `pre_integral` int(11) unsigned DEFAULT '0' COMMENT '变动前',
  `end_integral` int(11) unsigned DEFAULT '0' COMMENT '变动后',
  `reson` varchar(20)  DEFAULT '' COMMENT '变动原因',
  `handler_id` int(11) unsigned DEFAULT '0' COMMENT '操作人',
  `add_time` datetime DEFAULT NULL COMMENT '操作时间',
  
  PRIMARY KEY (`id`),
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `handler_id`(`handler_id`) USING BTREE,
  INDEX `add_time`(`add_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
