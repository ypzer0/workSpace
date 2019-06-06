@echo off
color 2e
CLS
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆                                                    ★☆
ECHO ★☆                                                    ★☆
ECHO ★☆                开始Package                         ★☆
ECHO ★☆                                                    ★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ------------------------------------------------------------

cd ..

set YYYYmmdd=%date:~0,4%%date:~5,2%%date:~8,2%
set hhmiss=%time:~0,2%-%time:~3,2%-%time:~6,2%
set rootPath=%~dp0
set nowPath=%rootPath%%YYYYmmdd%-%hhmiss%\
set endH5=%cd%\mobile\dist\
set endH5Name=zuoduan-h5-%YYYYmmdd%-%hhmiss%
set endSys=%cd%\platform-framework\target\
set endSysName=zuoduan-%YYYYmmdd%-%hhmiss%.war

if exist %nowPath% (
   echo "已经存在文件夹"
) else (
   md "%nowPath%"
)


set haozip="D:\Program Files\2345Soft\HaoZip\"
%haozip%HaoZipC a -tzip "%nowPath%%endH5Name%.zip" %endH5%*
copy %endSys%zuoduan.war "%nowPath%%endSysName%"


ECHO ------------------------------------------------------------
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆                                                    ★☆
ECHO ★☆                                                    ★☆
ECHO ★☆                小伙子真的是练武奇才                ★☆
ECHO ★☆                                                    ★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆

pause