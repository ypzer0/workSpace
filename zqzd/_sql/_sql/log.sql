
/**
 * a:zy
 * e:zgyxszyd@163.com
 *  2019-3-6 1:57 系统操作日志**/
-- ----------------------------
-- Table structure for `sys_oper_log`
-- 系统操作日志
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flag` mediumint(3) NOT NULL COMMENT '标志id',
  `hid` mediumint(8) NULL COMMENT '操作人',
  `name` varchar(50) DEFAULT NULL COMMENT '操作名称',
  `title` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `flag`(`flag`) USING BTREE,
  INDEX `hid`(`hid`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `title`(`title`) USING BTREE,
  INDEX `create_date`(`create_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=894 DEFAULT CHARSET=utf8 COMMENT='系统操作日志';
-- ----------------------------
-- Table structure for `sys_oper_log`
-- ----------------------------