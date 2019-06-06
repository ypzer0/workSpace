/*
 * 近期用户活跃情况储存过程，2019-2-15
 * zy
 * 参数 btime VARCHAR(10)
 * 
 * */
DROP PROCEDURE IF EXISTS rpt_zd_customer;
delimiter ??
CREATE PROCEDURE `rpt_zd_customer`(IN btime VARCHAR(10))
BEGIN
DECLARE reg INT DEFAULT 0;
DECLARE online INT DEFAULT 0;
DECLARE eptcid INT DEFAULT 0;
DECLARE etime VARCHAR(10) DEFAULT '';

SET @etime = date_add(btime, interval 1 day);

-- setting
SET @reg = (SELECT COUNT(*) FROM zd_user WHERE register_time >= btime AND register_time < @etime);
SET @online = (SELECT COUNT(*) AS finish FROM zd_user WHERE last_login_time >= btime AND last_login_time < @etime);

-- get id
SET @eptcid = (SELECT id FROM zd_ept_user_eday WHERE ctime = btime);

-- update
IF ISNULL(@eptcid) THEN
INSERT INTO zd_ept_user_eday (reg, online, ctime) VALUES(@reg, @online, btime);
ELSE
UPDATE zd_ept_user_eday SET reg=@reg,online=@online WHERE id = @eptcid;
END IF;

SELECT 1;

END??
delimiter ; 