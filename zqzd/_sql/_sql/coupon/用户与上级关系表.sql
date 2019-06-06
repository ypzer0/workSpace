/**
 * 
 * 用户与上级关系表
 * 
 */
DROP TABLE IF EXISTS `fx_user`;
CREATE TABLE `fx_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `u_id` int(11) unsigned DEFAULT '0' COMMENT '用户ID',
  `puid` int(11) unsigned DEFAULT '0' COMMENT '上级用户ID',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `from_type` tinyint(2) DEFAULT 0 COMMENT '来至哪里',
  
  PRIMARY KEY (`id`),
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `puid`(`puid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/**
 * 
 * 用户与上级关系日志表
 * 
 * 
 */
DROP TABLE IF EXISTS `fx_user_log`;
CREATE TABLE `fx_user_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `f_id` int(11) unsigned DEFAULT '0' COMMENT '分销ID',
  `u_id` int(11) unsigned DEFAULT '0' COMMENT '用户ID',
  `puid` int(11) unsigned DEFAULT '0' COMMENT '上级用户ID',
  `content` varchar(100)  DEFAULT '' COMMENT '描述',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  
  PRIMARY KEY (`id`),
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `puid`(`puid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;