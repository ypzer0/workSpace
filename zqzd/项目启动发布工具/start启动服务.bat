@echo off
color 2e
CLS
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆                                                    ★☆
ECHO ★☆                                                    ★☆
ECHO ★☆                看到这个就成功了一半                ★☆
ECHO ★☆                                                    ★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
ECHO ------------------------------------------------------------

cd ..
start /d "D:\Program Files\Redis" redis-server.exe
start /d "E:\web_server\web_server" web_server.exe
rem start /d "D:\tomcat\apache-tomcat-8.5.35\apache-tomcat-8.5.35\bin" startup.bat
rem start /d "%cd%\platform-vue" npm run dev

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