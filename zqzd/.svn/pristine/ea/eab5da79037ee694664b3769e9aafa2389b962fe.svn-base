
/**
 * 已支付订单 1小时后确认完成
 */
/** 2019-3-11 4:11 **/
DROP PROCEDURE IF EXISTS cp_order_finish_1h;
delimiter ??
CREATE PROCEDURE `cp_order_finish_1h`()
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
update coupon_order set order_status = 4 where add_time > @btime and add_time < @etime and order_status = 1 and TIMESTAMPDIFF(hour, add_time,now()) >= 1;

select 1;

END??
delimiter ; 