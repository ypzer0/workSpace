/** 2019-3-11 4:11 关闭超过24小时未支付的订单**/
DROP PROCEDURE IF EXISTS order_close_24h;
delimiter ??
CREATE PROCEDURE `order_close_24h`()
BEGIN

DECLARE btime VARCHAR(10);
DECLARE etime VARCHAR(10);

/**
筛选前7天的订单(性能方面)
*/
set @etime = DATE_FORMAT(now(),'%Y-%m-%d');
set @etime = date_add(@etime, interval 1 day);
set @btime = date_add(@etime, interval -7 day);

-- SELECT TIMESTAMPDIFF(day, '2008-12-29',now())
update nideshop_order set order_status = 103 where add_time > @btime and add_time < @etime and order_status = 0 and TIMESTAMPDIFF(day, add_time,now()) >= 1;

select 1;

END??
delimiter ; 



/** 2019-3-11 4:11 关闭超过7已确认收货，退款、退货的订单**/
DROP PROCEDURE IF EXISTS order_close_7d;
delimiter ??
CREATE PROCEDURE `order_close_7d`()
BEGIN

DECLARE btime VARCHAR(10);
DECLARE etime VARCHAR(10);

/**
筛选前10天的订单(性能方面)
*/
set @etime = DATE_FORMAT(now(),'%Y-%m-%d');
set @etime = date_add(@etime, interval 1 day);
set @btime = date_add(@etime, interval -10 day);

-- SELECT TIMESTAMPDIFF(day, '2008-12-29',now())
update nideshop_order set order_status = 103 where add_time > @btime and add_time < @etime and order_status in (301, 401, 402) and TIMESTAMPDIFF(day, add_time,now()) >= 7;

select 1;

END??
delimiter ; 