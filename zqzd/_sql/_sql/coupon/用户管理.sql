
/**
 * 优惠劵用户管理
 * 
 */
-- ----------------------------
-- Table structure for `coupon_user`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_user`;
CREATE TABLE `coupon_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别：0:女 1男',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(15) DEFAULT '' COMMENT '最后登录 ip',
  `user_level_id` tinyint(3) DEFAULT NULL COMMENT '用户级别',
  `nickname` varchar(300) DEFAULT '' COMMENT '昵称',
  `mobile` varchar(20) DEFAULT '' COMMENT '手机',
  `register_ip` varchar(45) DEFAULT '' COMMENT '注册ip',
  `avatar` varchar(255) DEFAULT '' COMMENT '头像',
  `weixin_openid` varchar(50) DEFAULT '' COMMENT '微信openid',
  `age` tinyint(4) DEFAULT 0 COMMENT '年龄',
  
  `plat_type` tinyint(3) DEFAULT NULL COMMENT '平台标识编码：1: 鼎鑫权益用户DX开头  2:惠友圈用户 HY开头',
  `weixin_code` varchar(100) DEFAULT '' COMMENT '微信号',
  `code_id` int(11) DEFAULT 0 COMMENT '用户编号id',
  `multiple` int(11) DEFAULT 50 COMMENT '推广倍数 分倍数',
  `status` tinyint(1) DEFAULT 0 COMMENT '状态 0，正常 1，禁用 2，删除',
  `zhifubao` varchar(50) DEFAULT '' COMMENT '支付宝账号',
  `credit` decimal(10,2) DEFAULT 0.00 COMMENT '用户信用积分',
  `integral` decimal(10,2) DEFAULT 0.00 COMMENT '积分',
  `is_extend` tinyint(1) DEFAULT 0 COMMENT '状态 0 否  1 是',
  `frozen` decimal(10,2) DEFAULT 0.00 COMMENT '冻结金额',
  `money` decimal(10,2) DEFAULT 0.00 COMMENT '余额',
  `number` tinyint(1) DEFAULT 0 COMMENT '剩余数量',
  `save_money` decimal(10,2) DEFAULT 0.00 COMMENT '节省金额',
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `code_id` (`code_id`),
  KEY `register_time` (`register_time`),
  KEY `last_login_time` (`last_login_time`),
  KEY `user_level_id` (`user_level_id`),
  KEY `mobile` (`mobile`),
  KEY `weixin_openid` (`weixin_openid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;


/**
 *用户编码关系
 * 
 */
-- ----------------------------
-- Table structure for `coupon_user_code_bom`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_user_code_bom`;
CREATE TABLE `coupon_user_code_bom` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `u_code` int(11) NOT NULL  COMMENT '用户编号',
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_id` (`u_id`),
  KEY `u_code` (`u_code`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;








