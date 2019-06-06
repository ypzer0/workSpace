
/*
 * 近期下单情况统计储存过程，2019-2-15
 * zy
 * 参数 btime VARCHAR(10)
 * 
 * */
DROP PROCEDURE IF EXISTS rpt_zd_add_order;
delimiter ??
CREATE PROCEDURE `rpt_zd_add_order`(IN btime VARCHAR(10))
BEGIN
DECLARE fail INT DEFAULT 0;
DECLARE finish INT DEFAULT 0;
DECLARE total INT DEFAULT 0;
DECLARE unfinish INT DEFAULT 0;
DECLARE eptoid INT DEFAULT 0;
DECLARE etime VARCHAR(10) DEFAULT '';

SET @etime = date_add(btime, interval 1 day);

-- setting
SET @fail = (SELECT COUNT(*) FROM zd_order WHERE order_status IN (2) AND confirm_time >= btime AND confirm_time < @etime);
SET @finish = (SELECT COUNT(*) FROM zd_order WHERE order_status IN (1) AND confirm_time >= btime AND confirm_time < @etime);
SET @total = (SELECT COUNT(*) FROM zd_order WHERE confirm_time >= btime AND confirm_time < @etime);
SET @unfinish = @total-@fail-@finish;

-- get id
SET @eptoid = (SELECT id FROM zd_ept_order_eday WHERE ctime = btime);

-- update
IF ISNULL(@eptoid) THEN
INSERT INTO zd_ept_order_eday (total, completed, unfinished, failed, ctime) VALUES(@total, @finish, @unfinish, @fail, btime);
ELSE
UPDATE zd_ept_order_eday SET total=@total,completed=@finish, unfinished=@unfinish, failed=@fail WHERE id = @eptoid;
END IF;

SELECT 1;
-- SELECT @fail, @unfinish, @finish, @total;
-- SELECT btime, @etime;

END??
delimiter ; 