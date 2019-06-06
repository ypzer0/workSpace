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

-- Dumping structure for procedure coupon.order_close_24h
DELIMITER //
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

END//
DELIMITER ;

-- Dumping structure for procedure coupon.order_close_7d
DELIMITER //
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

END//
DELIMITER ;

-- Dumping structure for procedure coupon.rpt_add_order
DELIMITER //
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

END//
DELIMITER ;

-- Dumping structure for procedure coupon.rpt_customer
DELIMITER //
CREATE PROCEDURE `rpt_customer`(IN btime VARCHAR(10))
BEGIN
DECLARE reg INT DEFAULT 0;
DECLARE online INT DEFAULT 0;
DECLARE eptcid INT DEFAULT 0;
DECLARE etime VARCHAR(10) DEFAULT '';

SET @etime = date_add(btime, interval 1 day);

-- setting
SET @reg = (SELECT COUNT(*) FROM nideshop_user WHERE register_time >= btime AND register_time < @etime);
SET @online = (SELECT COUNT(*) AS finish FROM nideshop_user WHERE last_login_time >= btime AND last_login_time < @etime);

-- get id
SET @eptcid = (SELECT id FROM nideshop_ept_user_eday WHERE ctime = btime);

-- update
IF ISNULL(@eptcid) THEN
INSERT INTO nideshop_ept_user_eday (reg, online, ctime) VALUES(@reg, @online, btime);
ELSE
UPDATE nideshop_ept_user_eday SET reg=@reg,online=@online WHERE id = @eptcid;
END IF;

SELECT 1;

END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
