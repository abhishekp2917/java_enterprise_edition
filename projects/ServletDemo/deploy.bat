@echo off

:: REM Configuration Variables
set TOMCAT_HOME=C:\Users\Abhishek.Pandey1\apache-tomcat-10.1.24
set CATALINA_HOME=%TOMCAT_HOME%
set WAR_FILE_NAME=ServletDemo_1.0.0.war
set WAR_FILE=C:\java_enterprise_edition\projects\ServletDemo\target\%WAR_FILE_NAME%
set TARGET_DIR=%TOMCAT_HOME%\webapps


:: deploying WAR
echo Deploying %WAR_FILE% to %TARGET_DIR%...

:: Stopping tomcat
echo Tomcat is running, stopping Tomcat...
call %TOMCAT_HOME%\bin\shutdown.bat

:: REM Wait for Tomcat to stop completely
timeout /t 10 > nul

:: REM Remove old deployment
echo Removing old deployment %TARGET_DIR%\%WAR_FILE_NAME%...
rmdir /s /q %TARGET_DIR%\%WAR_FILE_NAME%
del /f /q "%TARGET_DIR%\%WAR_FILE_NAME%" 2>nul

:: REM Check if removal was successful before continuing
if exist "%TARGET_DIR%\%WAR_FILE_NAME%" (
    echo Failed to remove old deployment.
    timeout /t 5 > nul
    exit /b 1
)

:: REM Copy new WAR file
echo Copying new WAR file...
xcopy /e /i "%WAR_FILE%" "%TARGET_DIR%"

:: REM Start Tomcat
echo Starting Tomcat...
call %TOMCAT_HOME%\bin\startup.bat

echo Deployment completed!
exit /b 0

