@echo off

:: Define directories
set PROJECT_NAME=ServletDemo
set PROJECT_VERSION=1.0.0
set BUILD_FILE_NAME=%PROJECT_NAME%_%PROJECT_VERSION%
set SRC_DIR=src\main\java
set WEBAPP_DIR=src\main\webapp
set LIB_DIR=lib
set RESOURCE_DIR=src\main\resources
set BUILD_DIR=target
set BUILD_CLASSES_DIR=%BUILD_DIR%\classes
set WAR_DIR=%BUILD_DIR%\%BUILD_FILE_NAME%

:: Clean previous build files and create new classes directory
echo Cleaning previous build...
rmdir /s /q %BUILD_DIR%
echo Building classes directory...
mkdir %BUILD_CLASSES_DIR%

:: Compile source code and place it in build classes directory
echo Compiling source code...
for /r %SRC_DIR% %%f in (*.java) do javac -d %BUILD_CLASSES_DIR% -cp "%LIB_DIR%\*" %%f

:: Creating WAR directory and Copy web resources (JSP, HTML, CSS, JS) to it
echo Creating WAR directory for packaging...
mkdir %WAR_DIR%
echo Copying web resources to WAR directory...
xcopy /e /i %WEBAPP_DIR%\* %WAR_DIR%
xcopy /e /i %BUILD_CLASSES_DIR%\* %WAR_DIR%\WEB-INF\classes
xcopy /e /i %LIB_DIR%\* %WAR_DIR%\WEB-INF\lib
xcopy /e /i %RESOURCE_DIR%\* %WAR_DIR%\WEB-INF\

:: Package into WAR
echo Packaging into WAR...
cd %WAR_DIR%
jar cvf ..\ROOT.war -C . .

:: Output location of the WAR file
echo Build successful. WAR created.
pause
