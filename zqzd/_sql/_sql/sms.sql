/** 2019-3-1 5:13 短信模板管理 zy zgyxszyd@163.com **/
-- ----------------------------
-- Table structure for `nideshop_sms_temp`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_sms_temp`;
CREATE TABLE `nideshop_sms_temp` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '' COMMENT '模板名称',
  `code` varchar(32) DEFAULT '' COMMENT '模版CODE',
  `content` varchar(500) DEFAULT '' COMMENT '模版内容',
  `status` int(2) DEFAULT 1 COMMENT '0:删除 1：禁用，2：启用',
  `utime` datetime DEFAULT NULL COMMENT '修改时间',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `code`(`code`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `utime`(`utime`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nideshop_sms_temp
-- ----------------------------