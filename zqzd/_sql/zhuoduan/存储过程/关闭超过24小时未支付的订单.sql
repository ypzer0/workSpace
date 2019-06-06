/** 2019-3-11 4:11 关闭超过24小时未支付的订单**/
DROP PROCEDURE IF EXISTS zd_order_close_24h;
delimiter ??
CREATE PROCEDURE `zd_order_close_24h`()
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
update zd_order set order_status = 2 where confirm_time > @btime and confirm_time < @etime and order_status = 0 and TIMESTAMPDIFF(day, confirm_time,now()) >= 1;

select 1;

END??
delimiter ; 