@echo off
REM power by zy
REM zgyxszyd@163.com

REM 声明采用UTF-8编码
chcp 65001

color 2e
CLS

ECHO -- 融合sql
ECHO ------------------------------------------------------------

REM copy coupon\*.sql all.sql.txt
REM copy coupon\存储过程\*.sql all.sql.txt

REM for /R %f in (*.sql) do type "%f" >> all.sql.txt
REM for /R %f in (coupon\存储过程\*.sql) do type "%f" >> all.sql.txt

set dest=.\all.sql.txt
set src=.\coupon\
echo -- >%dest%
echo SET FOREIGN_KEY_CHECKS=0; >%dest%

for /r "%src%" %%i in (*.sql) do (

rem 添加分割线
echo -- ------------------------------------- >> %dest%

rem 输出文件路径
rem echo -- %%i >> %dest%
rem 输出文件内容
type "%%i" >> %dest%

)


ECHO ------------------------------------------------------------
ECHO 完成



pause