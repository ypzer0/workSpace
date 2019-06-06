-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- Server version:               10.1.37-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for coupon
CREATE DATABASE IF NOT EXISTS `coupon` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `coupon`;

-- Dumping structure for table coupon.nideshop_ad
CREATE TABLE IF NOT EXISTS `nideshop_ad` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `ad_position_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `media_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `name` varchar(60) DEFAULT '',
  `link` varchar(255) DEFAULT '',
  `image_url` text,
  `content` varchar(255) DEFAULT '',
  `end_time` datetime DEFAULT NULL,
  `enabled` tinyint(3) unsigned DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `position_id` (`ad_position_id`),
  KEY `enabled` (`enabled`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_address
CREATE TABLE IF NOT EXISTS `nideshop_address` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned DEFAULT '0' COMMENT '会员ID',
  `user_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '收货人姓名',
  `tel_number` varchar(60) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '手机',
  `postal_Code` varchar(50) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '邮编',
  `national_Code` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '收货地址国家码',
  `province_Name` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '省',
  `city_Name` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '市',
  `county_Name` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '区',
  `detail_Info` varchar(120) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '详细收货地址信息',
  `is_default` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_ad_position
CREATE TABLE IF NOT EXISTS `nideshop_ad_position` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL DEFAULT '''',
  `width` smallint(5) unsigned NOT NULL DEFAULT '0',
  `height` smallint(5) unsigned NOT NULL DEFAULT '0',
  `desc` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_attribute
CREATE TABLE IF NOT EXISTS `nideshop_attribute` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attribute_category_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '商品类型',
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '属性名称',
  `input_type` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '当添加商品时,该属性的添加类别; 0为手功输入;1为选择输入;2为多行文本输入',
  `value` text NOT NULL COMMENT '即选择输入,则attr_name对应的值的取值就是该这字段值 ',
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `cat_id` (`attribute_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_attribute_category
CREATE TABLE IF NOT EXISTS `nideshop_attribute_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(60) NOT NULL DEFAULT '',
  `enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '1开启; 0关闭;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1036001 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_brand
CREATE TABLE IF NOT EXISTS `nideshop_brand` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌名称',
  `list_pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '图片',
  `simple_desc` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '图片',
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '50' COMMENT '排序',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '显示',
  `floor_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `app_list_pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT 'app显示图片',
  `is_new` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '新品牌',
  `new_pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '图片',
  `new_sort_order` tinyint(2) unsigned NOT NULL DEFAULT '10' COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `is_show` (`is_show`)
) ENGINE=InnoDB AUTO_INCREMENT=1046001 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_cart
CREATE TABLE IF NOT EXISTS `nideshop_cart` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '会员Id',
  `session_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'sessionId',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '商品Id',
  `goods_sn` varchar(60) NOT NULL DEFAULT '' COMMENT '商品序列号',
  `product_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '产品Id',
  `goods_name` varchar(120) NOT NULL DEFAULT '' COMMENT '产品名称',
  `market_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '市场价',
  `retail_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '零售价格',
  `number` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '数量',
  `goods_specifition_name_value` text COMMENT '规格属性组成的字符串，用来显示用',
  `goods_specifition_ids` varchar(60) DEFAULT '' COMMENT 'product表对应的goods_specifition_ids',
  `checked` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `list_pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '商品图片',
  PRIMARY KEY (`id`),
  KEY `session_id` (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_category
CREATE TABLE IF NOT EXISTS `nideshop_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(90) NOT NULL DEFAULT '',
  `keywords` varchar(255) DEFAULT '',
  `front_desc` varchar(255) DEFAULT '',
  `parent_id` int(11) unsigned DEFAULT '0',
  `sort_order` tinyint(1) unsigned DEFAULT '50',
  `show_index` tinyint(1) DEFAULT '0',
  `is_show` tinyint(1) unsigned DEFAULT '1',
  `banner_url` varchar(255) DEFAULT '',
  `icon_url` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `wap_banner_url` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  `front_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1036001 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_channel
CREATE TABLE IF NOT EXISTS `nideshop_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `url` varchar(255) NOT NULL DEFAULT '',
  `icon_url` varchar(255) NOT NULL DEFAULT '',
  `sort_order` int(4) unsigned NOT NULL DEFAULT '10',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_collect
CREATE TABLE IF NOT EXISTS `nideshop_collect` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '用户Id',
  `value_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '产品Id',
  `add_time` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',
  `is_attention` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否提醒',
  `type_id` int(2) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `goods_id` (`value_id`),
  KEY `is_attention` (`is_attention`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_comment
CREATE TABLE IF NOT EXISTS `nideshop_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_id` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '类型',
  `value_id` int(11) DEFAULT '0',
  `content` varchar(6550) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '储存为base64编码',
  `add_time` bigint(12) unsigned DEFAULT '0' COMMENT '记录时间',
  `status` tinyint(3) unsigned DEFAULT '0' COMMENT '状态',
  `user_id` int(11) DEFAULT '0' COMMENT '会员Id',
  PRIMARY KEY (`id`),
  KEY `id_value` (`value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_comment_picture
CREATE TABLE IF NOT EXISTS `nideshop_comment_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `comment_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '评价Id',
  `pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '评价图片',
  `sort_order` tinyint(1) unsigned NOT NULL DEFAULT '5' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_coupon
CREATE TABLE IF NOT EXISTS `nideshop_coupon` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT '',
  `type_money` decimal(10,2) DEFAULT '0.00',
  `send_type` tinyint(3) unsigned DEFAULT '0',
  `min_amount` decimal(10,2) unsigned DEFAULT '0.00',
  `max_amount` decimal(10,2) unsigned DEFAULT '0.00',
  `send_start_date` datetime DEFAULT NULL,
  `send_end_date` datetime DEFAULT NULL,
  `use_start_date` datetime DEFAULT NULL,
  `use_end_date` datetime DEFAULT NULL,
  `min_goods_amount` decimal(10,2) unsigned DEFAULT '0.00',
  `min_transmit_num` int(4) DEFAULT NULL COMMENT '转发次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_coupon_goods
CREATE TABLE IF NOT EXISTS `nideshop_coupon_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coupon_id` int(11) NOT NULL COMMENT '优惠券Id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='优惠券关联商品';

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_ept_order_eday
CREATE TABLE IF NOT EXISTS `nideshop_ept_order_eday` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `total` mediumint(8) DEFAULT '0' COMMENT '总下单数',
  `completed` mediumint(8) DEFAULT '0' COMMENT '完成订单数',
  `unfinished` mediumint(8) DEFAULT '0' COMMENT '未完成订单数',
  `failed` mediumint(8) DEFAULT '0' COMMENT '失败订单数',
  `ctime` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `total` (`total`) USING BTREE,
  KEY `completed` (`completed`) USING BTREE,
  KEY `unfinished` (`unfinished`) USING BTREE,
  KEY `failed` (`failed`) USING BTREE,
  KEY `ctime` (`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_ept_user_eday
CREATE TABLE IF NOT EXISTS `nideshop_ept_user_eday` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `reg` mediumint(8) DEFAULT '0' COMMENT '注册数',
  `online` mediumint(8) DEFAULT '0' COMMENT '活跃数',
  `ctime` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `reg` (`reg`) USING BTREE,
  KEY `online` (`online`) USING BTREE,
  KEY `ctime` (`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_feedback
CREATE TABLE IF NOT EXISTS `nideshop_feedback` (
  `msg_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '会员Id',
  `user_name` varchar(60) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '会员会员名称',
  `mobile` varchar(60) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '手机',
  `feed_Type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '反馈类型',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT '详细内容',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '状态',
  `add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '反馈时间',
  PRIMARY KEY (`msg_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_footprint
CREATE TABLE IF NOT EXISTS `nideshop_footprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '会员Id',
  `goods_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `add_time` int(11) NOT NULL DEFAULT '0' COMMENT '记录时间',
  `referrer` int(11) DEFAULT NULL COMMENT '转发人',
  PRIMARY KEY (`id`),
  KEY `index_nideshop_footprint_user_id_goods_id` (`user_id`,`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=654 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_goods
CREATE TABLE IF NOT EXISTS `nideshop_goods` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(11) unsigned DEFAULT '0',
  `goods_sn` varchar(60) DEFAULT '',
  `name` varchar(120) NOT NULL DEFAULT '',
  `brand_id` int(11) unsigned DEFAULT '0',
  `goods_number` mediumint(8) unsigned DEFAULT '0',
  `keywords` varchar(255) DEFAULT '',
  `goods_brief` varchar(255) DEFAULT '',
  `goods_desc` text,
  `is_on_sale` tinyint(1) unsigned DEFAULT '1',
  `add_time` datetime DEFAULT NULL,
  `sort_order` smallint(4) unsigned DEFAULT '100',
  `is_delete` tinyint(1) unsigned DEFAULT '0',
  `attribute_category` int(11) unsigned DEFAULT '0',
  `counter_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '专柜价格',
  `extra_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '附加价格',
  `is_new` tinyint(1) unsigned DEFAULT '0',
  `goods_unit` varchar(45) DEFAULT NULL COMMENT '商品单位',
  `primary_pic_url` varchar(255) DEFAULT NULL COMMENT '商品主图',
  `list_pic_url` varchar(255) DEFAULT NULL COMMENT '商品列表图',
  `retail_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '零售价格',
  `sell_volume` int(11) unsigned DEFAULT '0' COMMENT '销售量',
  `primary_product_id` int(11) unsigned DEFAULT '0' COMMENT '主sku　product_id',
  `unit_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '单位价格，单价',
  `promotion_desc` varchar(255) DEFAULT NULL,
  `promotion_tag` varchar(45) DEFAULT NULL,
  `app_exclusive_price` decimal(10,2) unsigned DEFAULT NULL COMMENT 'APP专享价',
  `is_app_exclusive` tinyint(1) unsigned DEFAULT NULL COMMENT '是否是APP专属',
  `is_limited` tinyint(1) unsigned DEFAULT NULL,
  `is_hot` tinyint(1) unsigned DEFAULT '0',
  `market_price` decimal(10,2) DEFAULT '0.00',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_dept_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_sn` (`goods_sn`),
  KEY `cat_id` (`category_id`),
  KEY `brand_id` (`brand_id`),
  KEY `goods_number` (`goods_number`),
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=1181003 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_goods_attribute
CREATE TABLE IF NOT EXISTS `nideshop_goods_attribute` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '商品Id',
  `attribute_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '属性Id',
  `value` text NOT NULL COMMENT '属性值',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  KEY `attr_id` (`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=872 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_goods_gallery
CREATE TABLE IF NOT EXISTS `nideshop_goods_gallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(11) DEFAULT '0' COMMENT '商品id',
  `img_url` longblob COMMENT '图片',
  `img_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '描述',
  `sort_order` int(11) DEFAULT '5' COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=691 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_goods_issue
CREATE TABLE IF NOT EXISTS `nideshop_goods_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_goods_specification
CREATE TABLE IF NOT EXISTS `nideshop_goods_specification` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) unsigned NOT NULL DEFAULT '0',
  `specification_id` int(11) unsigned NOT NULL DEFAULT '0',
  `value` varchar(50) DEFAULT '',
  `pic_url` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  KEY `specification_id` (`specification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='商品对应规格表值表';

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_help_issue
CREATE TABLE IF NOT EXISTS `nideshop_help_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL COMMENT '问题分类',
  `question` varchar(500) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_help_type
CREATE TABLE IF NOT EXISTS `nideshop_help_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL COMMENT '问题分类',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_keywords
CREATE TABLE IF NOT EXISTS `nideshop_keywords` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `keyword` varchar(90) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '关键字',
  `is_hot` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '热销',
  `is_default` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '默认',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '显示',
  `sort_order` int(11) NOT NULL DEFAULT '100' COMMENT '排序',
  `scheme_url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '关键词的跳转链接',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='热闹关键词表';

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_order
CREATE TABLE IF NOT EXISTS `nideshop_order` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(32) DEFAULT '',
  `user_id` mediumint(8) unsigned DEFAULT '0',
  `order_status` int(3) unsigned DEFAULT '0',
  `shipping_status` tinyint(1) unsigned DEFAULT '0',
  `pay_status` tinyint(1) unsigned DEFAULT '0',
  `consignee` varchar(60) DEFAULT '',
  `country` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT '',
  `mobile` varchar(60) DEFAULT '',
  `postscript` varchar(255) DEFAULT '',
  `shipping_id` tinyint(3) DEFAULT '0',
  `shipping_name` varchar(120) DEFAULT '',
  `pay_id` varchar(64) DEFAULT '0',
  `pay_name` varchar(120) DEFAULT '',
  `shipping_fee` decimal(10,2) DEFAULT '0.00',
  `actual_price` decimal(10,2) DEFAULT '0.00' COMMENT '实际需要支付的金额',
  `integral` int(10) unsigned DEFAULT '0',
  `integral_money` decimal(10,2) DEFAULT '0.00',
  `order_price` decimal(10,2) DEFAULT '0.00' COMMENT '订单总价',
  `goods_price` decimal(10,2) DEFAULT '0.00' COMMENT '商品总价',
  `add_time` datetime DEFAULT NULL,
  `confirm_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `freight_price` int(10) unsigned DEFAULT '0' COMMENT '配送费用',
  `coupon_id` mediumint(8) unsigned DEFAULT '0' COMMENT '使用的优惠券id',
  `parent_id` mediumint(8) unsigned DEFAULT '0',
  `coupon_price` decimal(10,2) DEFAULT NULL,
  `callback_status` enum('true','false') DEFAULT 'true',
  `shipping_no` varchar(32) DEFAULT NULL,
  `full_cut_price` decimal(10,2) DEFAULT NULL,
  `order_type` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_sn` (`order_sn`),
  KEY `user_id` (`user_id`),
  KEY `order_status` (`order_status`),
  KEY `shipping_status` (`shipping_status`),
  KEY `pay_status` (`pay_status`),
  KEY `shipping_id` (`shipping_id`),
  KEY `pay_id` (`pay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_order_ask
CREATE TABLE IF NOT EXISTS `nideshop_order_ask` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` mediumint(8) DEFAULT '0' COMMENT '订单Id',
  `order_sn` varchar(32) DEFAULT '' COMMENT '订单号',
  `order_status` int(3) DEFAULT '0' COMMENT '原始订单状态',
  `typeId` int(2) DEFAULT '0' COMMENT '类型，1：退款申请 2：退货申请 3：换货申请',
  `status` int(2) DEFAULT '1' COMMENT '1：未提交，2：已提交，3：已通过， 4：已拒绝，5 ：已关闭',
  `uId` mediumint(8) DEFAULT '0' COMMENT '用户Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '用户昵称',
  `hander_id` mediumint(8) DEFAULT '0' COMMENT '操作人Id',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  `utime` datetime DEFAULT NULL COMMENT '修改时间',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `orderId` (`orderId`) USING BTREE,
  KEY `order_sn` (`order_sn`) USING BTREE,
  KEY `typeId` (`typeId`) USING BTREE,
  KEY `order_status` (`order_status`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `uId` (`uId`) USING BTREE,
  KEY `hander_id` (`hander_id`) USING BTREE,
  KEY `utime` (`utime`) USING BTREE,
  KEY `ctime` (`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_order_ask_log
CREATE TABLE IF NOT EXISTS `nideshop_order_ask_log` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `msg` varchar(500) DEFAULT '' COMMENT '日志内容',
  `uId` mediumint(8) DEFAULT '0' COMMENT '用户Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '用户昵称',
  `hander_id` mediumint(8) DEFAULT '0' COMMENT '回复人Id',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `uId` (`uId`) USING BTREE,
  KEY `hander_id` (`hander_id`) USING BTREE,
  KEY `ctime` (`ctime`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_order_ask_msg
CREATE TABLE IF NOT EXISTS `nideshop_order_ask_msg` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `askId` mediumint(8) DEFAULT '0' COMMENT '申请id',
  `msg` varchar(500) DEFAULT '' COMMENT '消息管理',
  `uId` mediumint(8) DEFAULT '0' COMMENT '用户Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '用户昵称',
  `hander_id` mediumint(8) DEFAULT '0' COMMENT '回复人Id',
  `hander_name` varchar(50) DEFAULT '' COMMENT '操作人',
  `msgType` int(2) DEFAULT '1' COMMENT '消息类型:1.消息, 2.备注',
  `status` int(2) DEFAULT '1' COMMENT '0: 删除 1：显示，2：隐藏，',
  `readStatus` int(2) DEFAULT '1' COMMENT '0: 未读，1：已读',
  `msgWay` int(2) DEFAULT '1' COMMENT '0: 用户给操作员，1：操作员给用户',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `askId` (`askId`) USING BTREE,
  KEY `uId` (`uId`) USING BTREE,
  KEY `hander_id` (`hander_id`) USING BTREE,
  KEY `msgType` (`msgType`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `readStatus` (`readStatus`) USING BTREE,
  KEY `msgWay` (`msgWay`) USING BTREE,
  KEY `ctime` (`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_order_goods
CREATE TABLE IF NOT EXISTS `nideshop_order_goods` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '订单Id',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '商品id',
  `goods_name` varchar(120) NOT NULL DEFAULT '' COMMENT '商品名称',
  `goods_sn` varchar(60) NOT NULL DEFAULT '' COMMENT '商品序列号',
  `product_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '产品Id',
  `number` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '商品数量',
  `market_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '市场价',
  `retail_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '零售价格',
  `goods_specifition_name_value` text COMMENT '商品规格详情',
  `is_real` tinyint(1) unsigned DEFAULT '0' COMMENT '虚拟商品',
  `goods_specifition_ids` varchar(255) DEFAULT '' COMMENT '商品规格Ids',
  `list_pic_url` varchar(255) DEFAULT '' COMMENT '图片链接',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=287 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_pay_log
CREATE TABLE IF NOT EXISTS `nideshop_pay_log` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `ip` varchar(25) DEFAULT '' COMMENT '请求ip',
  `u_id` mediumint(8) DEFAULT '0' COMMENT '申请人Id',
  `u_name` varchar(50) DEFAULT '' COMMENT '申请人昵称',
  `o_id` mediumint(8) DEFAULT '0' COMMENT '订单Id',
  `order_no` varchar(50) DEFAULT '' COMMENT '订单编号',
  `money` decimal(10,2) DEFAULT '0.00' COMMENT '金额',
  `tra_type` tinyint(2) DEFAULT '0' COMMENT '类型:1：用户申请 2: 平台返回',
  `pay_type` tinyint(2) DEFAULT '0' COMMENT '类型:1：微信支付 2: 支付宝',
  `status` tinyint(2) DEFAULT '0' COMMENT '类型:1：成功 2:失败 3:异常',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `ip` (`ip`) USING BTREE,
  KEY `u_id` (`u_id`) USING BTREE,
  KEY `o_id` (`o_id`) USING BTREE,
  KEY `order_no` (`order_no`) USING BTREE,
  KEY `tra_type` (`tra_type`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `pay_type` (`pay_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_product
DROP TABLE IF EXISTS `nideshop_product`;
CREATE TABLE `nideshop_product` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` mediumint(8) unsigned DEFAULT '0' COMMENT '商品Id',
  `goods_specification_ids` varchar(50) DEFAULT '' COMMENT '商品规格ids',
  `goods_sn` varchar(60) DEFAULT '' COMMENT '商品序列号',
  `goods_number` mediumint(8) unsigned DEFAULT '0' COMMENT '商品编码',
  `retail_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '零售价格',
  `market_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '价格',
  
  `c_time` datetime DEFAULT NULL COMMENT '创建时间',
  `u_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  KEY `goods_sn` (`goods_sn`),
  KEY `retail_price` (`retail_price`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_related_goods
CREATE TABLE IF NOT EXISTS `nideshop_related_goods` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '商品Id',
  `related_goods_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_search_history
CREATE TABLE IF NOT EXISTS `nideshop_search_history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `keyword` char(50) NOT NULL COMMENT '关键字',
  `from` varchar(45) DEFAULT '' COMMENT '搜索来源，如PC、小程序、APP等',
  `add_time` int(11) NOT NULL DEFAULT '0' COMMENT '搜索时间',
  `user_id` varchar(45) DEFAULT NULL COMMENT '会员Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_shipping
CREATE TABLE IF NOT EXISTS `nideshop_shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `status` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '状态 0正常 1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_sms_log
CREATE TABLE IF NOT EXISTS `nideshop_sms_log` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `log_date` bigint(20) DEFAULT NULL,
  `sms_code` varchar(12) DEFAULT NULL,
  `send_status` bigint(20) DEFAULT NULL,
  `sms_text` varchar(255) DEFAULT NULL COMMENT '1成功 0失败',
  `type` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_sms_temp
CREATE TABLE IF NOT EXISTS `nideshop_sms_temp` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '' COMMENT '模板名称',
  `code` varchar(32) DEFAULT '' COMMENT '模版CODE',
  `content` varchar(500) DEFAULT '' COMMENT '模版内容',
  `status` int(2) DEFAULT '1' COMMENT '0:删除 1：禁用，2：启用',
  `utime` datetime DEFAULT NULL COMMENT '修改时间',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `name` (`name`) USING BTREE,
  KEY `code` (`code`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `utime` (`utime`) USING BTREE,
  KEY `ctime` (`ctime`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_specification
CREATE TABLE IF NOT EXISTS `nideshop_specification` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '规范名称',
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='规格表';

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_topic
CREATE TABLE IF NOT EXISTS `nideshop_topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL DEFAULT '''''' COMMENT '活动主题',
  `content` text COMMENT '活动内容',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '化名',
  `item_pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '活动条例图片',
  `subtitle` varchar(255) NOT NULL DEFAULT '''' COMMENT '子标题',
  `topic_category_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '活动类别',
  `price_info` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '活动价格',
  `read_count` varchar(255) NOT NULL DEFAULT '0',
  `scene_pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '场景图片链接',
  `topic_template_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '活动模板Id',
  `topic_tag_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '活动标签Id',
  KEY `topic_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=315 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_topic_category
CREATE TABLE IF NOT EXISTS `nideshop_topic_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '活动类别主题',
  `pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '活动类别图片链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_user
CREATE TABLE IF NOT EXISTS `nideshop_user` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL DEFAULT '',
  `password` varchar(32) DEFAULT '',
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT '',
  `user_level_id` tinyint(3) DEFAULT NULL,
  `nickname` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL,
  `mobile` varchar(20) DEFAULT '',
  `register_ip` varchar(45) DEFAULT '',
  `avatar` varchar(255) DEFAULT '',
  `weixin_openid` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_user_coupon
CREATE TABLE IF NOT EXISTS `nideshop_user_coupon` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `coupon_id` tinyint(3) unsigned DEFAULT '0',
  `coupon_number` varchar(20) DEFAULT '',
  `user_id` int(11) unsigned DEFAULT '0',
  `used_time` datetime DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `order_id` mediumint(8) unsigned DEFAULT '0',
  `source_key` varchar(64) DEFAULT NULL COMMENT '来源key',
  `referrer` int(32) DEFAULT NULL COMMENT '发券人',
  `coupon_status` tinyint(3) unsigned DEFAULT '1' COMMENT '状态 1. 可用 2. 已用 3. 过期',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.nideshop_user_level
CREATE TABLE IF NOT EXISTS `nideshop_user_level` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_blob_triggers
CREATE TABLE IF NOT EXISTS `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_calendars
CREATE TABLE IF NOT EXISTS `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_cron_triggers
CREATE TABLE IF NOT EXISTS `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_fired_triggers
CREATE TABLE IF NOT EXISTS `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_job_details
CREATE TABLE IF NOT EXISTS `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_locks
CREATE TABLE IF NOT EXISTS `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_paused_trigger_grps
CREATE TABLE IF NOT EXISTS `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_scheduler_state
CREATE TABLE IF NOT EXISTS `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_simple_triggers
CREATE TABLE IF NOT EXISTS `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_simprop_triggers
CREATE TABLE IF NOT EXISTS `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.qrtz_triggers
CREATE TABLE IF NOT EXISTS `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.schedule_job
CREATE TABLE IF NOT EXISTS `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- Data exporting was unselected.
-- Dumping structure for table coupon.schedule_job_log
CREATE TABLE IF NOT EXISTS `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_config
CREATE TABLE IF NOT EXISTS `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_dept
CREATE TABLE IF NOT EXISTS `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_log
CREATE TABLE IF NOT EXISTS `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1042 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_macro
CREATE TABLE IF NOT EXISTS `sys_macro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(255) DEFAULT NULL COMMENT '父级id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `value` varchar(2000) DEFAULT NULL COMMENT '值',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态，0：隐藏   1：显示',
  `type` tinyint(20) DEFAULT NULL COMMENT '类型,0:目录，1:参数配置',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk COMMENT='通用字典表';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_menu
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=439 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_oper_log
CREATE TABLE IF NOT EXISTS `sys_oper_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flag` mediumint(3) NOT NULL COMMENT '标志id',
  `hid` mediumint(8) DEFAULT NULL COMMENT '操作人',
  `name` varchar(50) DEFAULT NULL COMMENT '操作名称',
  `title` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `flag` (`flag`) USING BTREE,
  KEY `hid` (`hid`) USING BTREE,
  KEY `name` (`name`) USING BTREE,
  KEY `title` (`title`) USING BTREE,
  KEY `create_date` (`create_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=894 DEFAULT CHARSET=utf8 COMMENT='系统操作日志';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_oss
CREATE TABLE IF NOT EXISTS `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_region
CREATE TABLE IF NOT EXISTS `sys_region` (
  `id` mediumint(32) NOT NULL AUTO_INCREMENT,
  `parent_id` mediumint(32) NOT NULL DEFAULT '0',
  `name` varchar(120) NOT NULL DEFAULT '',
  `type` tinyint(1) NOT NULL DEFAULT '2',
  `agency_id` int(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `agency_id` (`agency_id`) USING BTREE,
  KEY `parent_id` (`parent_id`) USING BTREE,
  KEY `region_type` (`type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46182 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_role
CREATE TABLE IF NOT EXISTS `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_role_dept
CREATE TABLE IF NOT EXISTS `sys_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色与部门对应关系';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_role_menu
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1470 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_sms_log
CREATE TABLE IF NOT EXISTS `sys_sms_log` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '操作人',
  `content` text COLLATE utf8_unicode_ci COMMENT '必填参数。发送内容（1-500 个汉字）UTF-8编码',
  `mobile` text COLLATE utf8_unicode_ci COMMENT '必填参数。手机号码。多个以英文逗号隔开',
  `stime` datetime DEFAULT NULL COMMENT '可选参数。发送时间，填写时已填写的时间发送，不填时为当前时间发送',
  `sign` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '必填参数。用户签名',
  `type` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '必填参数。固定值 pt',
  `extno` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '可选参数。扩展码，用户定义扩展码，只能为数字',
  `send_status` int(11) DEFAULT NULL COMMENT '1成功 0失败',
  `send_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发送编号',
  `invalid_num` int(11) DEFAULT NULL COMMENT '无效号码数',
  `success_num` int(11) DEFAULT NULL COMMENT '成功提交数',
  `black_num` int(11) DEFAULT NULL COMMENT '黑名单数',
  `return_msg` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '返回消息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_user
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- Data exporting was unselected.
-- Dumping structure for table coupon.sys_user_role
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- Data exporting was unselected.
-- Dumping structure for table coupon.tb_token
CREATE TABLE IF NOT EXISTS `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- Data exporting was unselected.
-- Dumping structure for table coupon.wallet_info
CREATE TABLE IF NOT EXISTS `wallet_info` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `uid` mediumint(8) DEFAULT NULL COMMENT '客户Id',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `wtype1` mediumint(8) DEFAULT '0' COMMENT '类型:1.支出 2.收入 ',
  `wtype2` mediumint(8) DEFAULT '0' COMMENT '类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 ',
  `order_sn` varchar(32) DEFAULT NULL COMMENT '订单号',
  `coupon_id` mediumint(8) DEFAULT NULL COMMENT '优惠劵Id',
  `transaction_id` varchar(32) DEFAULT NULL COMMENT '微信订单号',
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '商户订单号',
  `activity_id` varchar(32) DEFAULT NULL COMMENT '活动id',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `money` (`money`) USING BTREE,
  KEY `wtype1` (`wtype1`) USING BTREE,
  KEY `wtype2` (`wtype2`) USING BTREE,
  KEY `order_sn` (`order_sn`) USING BTREE,
  KEY `coupon_id` (`coupon_id`) USING BTREE,
  KEY `transaction_id` (`transaction_id`) USING BTREE,
  KEY `out_trade_no` (`out_trade_no`) USING BTREE,
  KEY `activity_id` (`activity_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table coupon.wallet_info_log
CREATE TABLE IF NOT EXISTS `wallet_info_log` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `wid` mediumint(8) DEFAULT NULL COMMENT '流水Id',
  `uid` mediumint(8) DEFAULT NULL COMMENT '操作人id',
  `wtype1` mediumint(8) DEFAULT '0' COMMENT '类型:1.支出 2.收入 ',
  `wtype2` mediumint(8) DEFAULT '0' COMMENT '类型:3.微信支付  4.退款 5.优惠劵抵扣 6.活动折扣 7.配送费 ',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `wid` (`wid`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `money` (`money`) USING BTREE,
  KEY `wtype1` (`wtype1`) USING BTREE,
  KEY `wtype2` (`wtype2`) USING BTREE,
  KEY `ctime` (`ctime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
