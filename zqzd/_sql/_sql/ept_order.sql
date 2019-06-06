
/*
 * 近期下单情况统计储存过程，2019-2-15
 * zy
 * 参数 btime VARCHAR(10)
 * 
 * */
DROP PROCEDURE IF EXISTS rpt_add_order;
delimiter ??
CREATE PROCEDURE `rpt_add_order`(IN btime VARCHAR(10))
BEGIN
DECLARE fail INT DEFAULT 0;
DECLARE finish INT DEFAULT 0;
DECLARE total INT DEFAULT 0;
DECLARE unfinish INT DEFAULT 0;
DECLARE eptoid INT DEFAULT 0;
DECLARE etime VARCHAR(10) DEFAULT '';

SET @etime = date_add(btime, interval 1 day);

-- setting
SET @fail = (SELECT COUNT(*) FROM nideshop_order WHERE order_status IN (101, 102) AND add_time >= btime AND add_time < @etime);
SET @finish = (SELECT COUNT(*) FROM nideshop_order WHERE order_status IN (300, 301, 402) AND add_time >= btime AND add_time < @etime);
SET @total = (SELECT COUNT(*) FROM nideshop_order WHERE add_time >= btime AND add_time < @etime);
SET @unfinish = @total-@fail-@finish;

-- get id
SET @eptoid = (SELECT id FROM nideshop_ept_order_eday WHERE ctime = btime);

-- update
IF ISNULL(@eptoid) THEN
INSERT INTO nideshop_ept_order_eday (total, completed, unfinished, failed, ctime) VALUES(@total, @finish, @unfinish, @fail, btime);
ELSE
UPDATE nideshop_ept_order_eday SET total=@total,completed=@finish, unfinished=@unfinish, failed=@fail WHERE id = @eptoid;
END IF;

SELECT 1;
-- SELECT @fail, @unfinish, @finish, @total;
-- SELECT btime, @etime;

END??
delimiter ; 

