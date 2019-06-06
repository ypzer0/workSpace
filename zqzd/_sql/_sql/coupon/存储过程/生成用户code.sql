
-- 生成用户编码存储过程

DROP PROCEDURE IF EXISTS `coupon_user_code_gen`;
delimiter ??
CREATE PROCEDURE coupon_user_code_gen()
BEGIN


DECLARE Debug INT DEFAULT 0;

DECLARE RandomID1 INT;
DECLARE RandomID2 INT;
DECLARE Upper INT;
DECLARE Lower INT;
DECLARE Start INT;

DECLARE d datetime;
DECLARE	ct INT;
DECLARE BeginGameID INT;
DECLARE EndGameID INT;


set @ct = 0;
SET @BeginGameID=1;
SET @EndGameID	= 200000;

Truncate table coupon_user_code_bom;


set @d=now();

WHILE @BeginGameID <= @EndGameID DO
	INSERT coupon_user_code_bom (u_id, u_code) VALUES(@BeginGameID, @BeginGameID);
	SET @BeginGameID = @BeginGameID + 1;
END WHILE;

-- ID生产 End
-- -----------------------------------------------------------------------

select timestampdiff(second,@d,now()), @ct;


-- 1至10万

set @Lower=1;

set @Upper=100000;
set @Start=0;

set @d=now();
 while @Start< @Upper-@Lower DO
 	set @RandomID1 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0);
 	set @RandomID2 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0);
	
 		if (select count(*) from coupon_user_code_bom where u_code=@RandomID1 OR u_code=@RandomID2)=2 then-- 账号是否存在
 			update coupon_user_code_bom set u_code=0 where u_code =@RandomID1;  -- 把第一个设置为0，防止冲突
 			update coupon_user_code_bom set u_code=@RandomID1 where u_code =@RandomID2;-- 第二个修改为第一个的
 			update coupon_user_code_bom set u_code=@RandomID2 where u_code =0;-- 第二个修改为第一个的
 			set @Start=@Start+1;
 		end if;
		
 end while;
 
select timestampdiff(second,@d,now()), @ct;


-- 10至20万

set @Lower=100000;

set @Upper=200000;
set @Start=0;

set @d=now();
 while @Start< @Upper-@Lower DO
 	set @RandomID1 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0);
 	set @RandomID2 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0);
	
 		if (select count(*) from coupon_user_code_bom where u_code=@RandomID1 OR u_code=@RandomID2)=2 then-- 账号是否存在
 			update coupon_user_code_bom set u_code=0 where u_code =@RandomID1;  -- 把第一个设置为0，防止冲突
 			update coupon_user_code_bom set u_code=@RandomID1 where u_code =@RandomID2;-- 第二个修改为第一个的
 			update coupon_user_code_bom set u_code=@RandomID2 where u_code =0;-- 第二个修改为第一个的
 			set @Start=@Start+1;
 		end if;
		
 end while;
 
select timestampdiff(second,@d,now()), @ct;


END??
delimiter ;