
/** 2019-2-27 1:57 客户申请退款、退货、换货申请表 **/
-- ----------------------------
-- Table structure for `nideshop_order_ask`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_order_ask`;
CREATE TABLE `nideshop_order_ask` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` mediumint(8) DEFAULT 0 COMMENT '订单Id',
  `order_sn` varchar(32) DEFAULT '' COMMENT '订单号',
  `order_status` int(3) DEFAULT 0 COMMENT '原始订单状态',
  `typeId` int(2) DEFAULT 0 COMMENT '类型，1：退款申请 2：退货申请 3：换货申请',
  `status` int(2) DEFAULT 1 COMMENT '1：未提交，2：已提交，3：已通过， 4：已拒绝，5 ：已关闭',
  
  `uId` mediumint(8) DEFAULT 0 COMMENT '用户Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '用户昵称',
  `hander_id` mediumint(8) DEFAULT 0 COMMENT '操作人Id',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  
  `utime` datetime DEFAULT NULL COMMENT '修改时间',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `orderId`(`orderId`) USING BTREE,
  INDEX `order_sn`(`order_sn`) USING BTREE,
  INDEX `typeId`(`typeId`) USING BTREE,
  INDEX `order_status`(`order_status`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  
  INDEX `uId`(`uId`) USING BTREE,
  INDEX `hander_id`(`hander_id`) USING BTREE,
  
  INDEX `utime`(`utime`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nideshop_order_ask
-- ----------------------------


/**
 * a:zy
 * e:zgyxszyd@163.com
 *  2019-3-6 1:57 客户申请退款消息**/
-- ----------------------------
-- Table structure for `nideshop_order_ask_msg`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_order_ask_msg`;
CREATE TABLE `nideshop_order_ask_msg` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `askId` mediumint(8) DEFAULT 0 COMMENT '申请id',
  `msg` varchar(500) DEFAULT '' COMMENT '消息管理',
  `uId` mediumint(8) DEFAULT 0 COMMENT '用户Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '用户昵称',
  `hander_id` mediumint(8) DEFAULT 0 COMMENT '回复人Id',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  `msgType` int(2) DEFAULT 1 COMMENT '消息类型:1.消息, 2.备注',
  `status` int(2) DEFAULT 1 COMMENT '0: 删除 1：显示，2：隐藏，',
  `readStatus` int(2) DEFAULT 1 COMMENT '0: 未读，1：已读',
  `msgWay` int(2) DEFAULT 1 COMMENT '0: 用户给操作员，1：操作员给用户',
  
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `askId`(`askId`) USING BTREE,
  INDEX `uId`(`uId`) USING BTREE,
  INDEX `hander_id`(`hander_id`) USING BTREE,
  INDEX `msgType`(`msgType`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `readStatus`(`readStatus`) USING BTREE,
  INDEX `msgWay`(`msgWay`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nideshop_order_ask_msg
-- ----------------------------



/** 
 * a:zy
 * e:zgyxszyd@163.com
 * 2019-3-6 1:57 客户申请退款操作日志**/
-- ----------------------------
-- Table structure for `nideshop_order_ask_log`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_order_ask_log`;
CREATE TABLE `nideshop_order_ask_log` (

  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `msg` varchar(500) DEFAULT '' COMMENT '日志内容',
  `uId` mediumint(8) DEFAULT 0 COMMENT '用户Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '用户昵称',
  `hander_id` mediumint(8) DEFAULT 0 COMMENT '回复人Id',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uId`(`uId`) USING BTREE,
  INDEX `hander_id`(`hander_id`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nideshop_order_ask_log
-- ----------------------------



