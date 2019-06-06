/**
 * 短信
 */
DROP TABLE IF EXISTS `coupon_sms_log`;
CREATE TABLE `coupon_sms_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT 0 COMMENT '用户id',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `log_date` bigint(20) DEFAULT NULL COMMENT '发送时间',
  `sms_code` varchar(12) DEFAULT NULL COMMENT '短信码',
  `type` tinyint(2) DEFAULT 0 COMMENT '类型',
  `send_status` bigint(20) DEFAULT NULL COMMENT '发送状态',
  `is_used` tinyint(1) DEFAULT 0 COMMENT '是否使用 0:未使用 1:已经使用',
  `sms_text` varchar(255) DEFAULT NULL COMMENT '1成功 0失败',
  PRIMARY KEY (`id`),
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `phone`(`phone`) USING BTREE,
  INDEX `log_date`(`log_date`) USING BTREE,
  INDEX `is_used`(`is_used`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `send_status`(`send_status`) USING BTREE
  
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
