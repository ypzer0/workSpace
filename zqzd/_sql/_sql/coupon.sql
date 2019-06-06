
/**
 * a:zy
 * e:zgyxszyd@163.com
 *  2019-3-15 1:57 优惠劵**/
-- ----------------------------
-- Table structure for `nideshop_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_coupon`;
CREATE TABLE `nideshop_coupon` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT '' COMMENT '优惠券名称',
  `type_money` decimal(10,2) DEFAULT '0.00' COMMENT '金额',
  `send_type` tinyint(3) unsigned DEFAULT '0' COMMENT '发放方式',
  `min_amount` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '最小金额',
  `max_amount` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '最大金额',
  `send_start_date` datetime DEFAULT NULL COMMENT '发放开始时间',
  `send_end_date` datetime DEFAULT NULL COMMENT '发放结束时间',
  `min_goods_amount` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '最小商品金额',
  `min_transmit_num` int(4) DEFAULT NULL COMMENT '转发次数',
  
  `count` int(11) DEFAULT NULL COMMENT '发送数量',
  `dis_type` smallint(2) DEFAULT NULL COMMENT '优惠形式 1：指定现金  2.折扣',
  `dis_type_val` decimal(10,2) DEFAULT NULL COMMENT '优惠值',
  `use_type` smallint(2) DEFAULT NULL COMMENT '使用门槛 0：不限制 1：满xxx可得',
  `use_type_val` decimal(10,2) DEFAULT NULL COMMENT '使用门槛值:',
  
  `level_id` mediumint(8) DEFAULT NULL COMMENT '会员等级：0：不限制 ',
  `limit_sheet` int(11) DEFAULT NULL COMMENT '限制领取张数：0：不限制',
  `use_start_date` datetime DEFAULT NULL COMMENT '生效时间',
  `use_end_date` datetime DEFAULT NULL COMMENT '过期时间',
  `use_goods` smallint(2) DEFAULT 0 COMMENT '使用商品：0：全店商品  1：指定商品',
  `used_count` int(11) DEFAULT 0 COMMENT '已使用',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `utime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT '优惠劵';


/**
 * a:zy
 * e:zgyxszyd@163.com
 *  2019-3-15 1:57 优惠劵操作日志**/
-- ----------------------------
-- Table structure for `nideshop_coupon_handle_log`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_coupon_handle_log`;
CREATE TABLE `nideshop_coupon_handle_log` (

  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `cid` mediumint(8) NOT NULL COMMENT '优惠劵id',
  `title` varchar(50) DEFAULT '' COMMENT '标题',
  `msg` varchar(500) DEFAULT '' COMMENT '日志内容',
  `hander_id` mediumint(8) DEFAULT 0 COMMENT '操作人',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  `ctime` datetime DEFAULT NULL COMMENT '记录时间',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hander_id`(`hander_id`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nideshop_coupon_handle_log
-- ----------------------------


/**
 * a:zy
 * e:zgyxszyd@163.com
 *  2019-3-15 1:57 优惠劵使用流水日志**/
-- ----------------------------
-- Table structure for `nideshop_coupon_log`
-- ----------------------------
DROP TABLE IF EXISTS `nideshop_coupon_log`;
CREATE TABLE `nideshop_coupon_log` (

  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `cid` mediumint(8) NOT NULL COMMENT '优惠劵id',
  `send_type` tinyint(3) unsigned DEFAULT '0' COMMENT '发放方式',
  `reson` varchar(50) DEFAULT '' COMMENT '变化原因',
  `change_type` tinyint(3) DEFAULT NULL COMMENT '类型 1:增加  2:减少',
  `change` int(4) DEFAULT NULL COMMENT '数量',
  `uid` mediumint(8) NOT NULL DEFAULT 0 COMMENT '客户',
  `uname` varchar(50) DEFAULT '' COMMENT '客户昵称',
  `hander_id` mediumint(8) DEFAULT 0 COMMENT '操作人',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  `ctime` datetime DEFAULT NULL COMMENT '记录时间',
  
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `hander_id`(`hander_id`) USING BTREE,
  INDEX `ctime`(`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nideshop_coupon_log
-- ----------------------------



