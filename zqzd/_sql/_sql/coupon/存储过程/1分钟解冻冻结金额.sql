/** 2019-3-11 4:11 1分钟解冻冻结金额**/
DROP PROCEDURE IF EXISTS cp_order_thaw_money_6h;
delimiter ??
CREATE PROCEDURE `cp_order_thaw_money_6h`()
BEGIN

DECLARE btime VARCHAR(10);
DECLARE etime VARCHAR(10);

/**
筛选前7天的冻结金额(性能方面)
*/
set @etime = DATE_FORMAT(now(),'%Y-%m-%d');
set @etime = date_add(@etime, interval 1 day);
set @btime = date_add(@etime, interval -7 day);


/**
 * 查询冻结金额
 */

/**
 *插入资金明细 
 */

INSERT INTO `coupon_wallet_info`
(`uid`, `money`, `pre_money`, `end_money`, `wtype1`,
`wtype2`, `order_sn`, `transaction_id`, `out_trade_no`, `f_money`, `f_status`, `remark`, `ctime`)
select 
-- (20, 0.00, 888.00, 888.00, 2, 5, 'O20190509133028998', NULL, NULL, 0.03, 1, NULL, '2019-05-23 17:47:43');
cf.u_id, cf.f_money, (select ifnull(money, 0.00) from coupon_user where id = cf.u_id), (select ifnull(money, 0.00) + ifnull(cf.f_money, 0.00) from coupon_user where id = cf.u_id), 2,
5, '', '', '', 0.00, 0.00, '佣金解冻', now()
from coupon_user_frozen_info cf
where cf.add_time > @btime and cf.add_time < @etime and cf.`status` = 0 and cf.`src_type` = 0 and TIMESTAMPDIFF(minute, cf.add_time,now()) >= 1;

/**
 * 更新用户余额
 */

update coupon_user set money = ifnull(money, 0.00) + ifnull(cf.f_money, 0.00) from coupon_user_frozen_info cf
where cf.add_time > @btime and cf.add_time < @etime and cf.`status` = 0 and cf.`src_type` = 0 and TIMESTAMPDIFF(minute, cf.add_time,now()) >= 1;

/**
 * 更新冻结金额
 */

update coupon_user_frozen_info set `status` = 1, u_time = now(), h_id = 0, h_name='系统' 
where add_time > @btime 
and add_time < @etime and `status` = 0 and `src_type` = 0 
and TIMESTAMPDIFF(minute, add_time,now()) >= 1;

select 1;

END??
delimiter ; 