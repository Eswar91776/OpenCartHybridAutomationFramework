@echo off

:MENU

cls

echo ==========================================
echo     OpenCart Hybrid Automation Framework
echo ==========================================
echo.
echo 1. Run All Tests
echo 2. Run Sanity Tests
echo 3. Run Regression Tests
echo 4. Exit
echo.

set /p choice=Enter your choice: 

if "%choice%"=="1" goto ALL
if "%choice%"=="2" goto SANITY
if "%choice%"=="3" goto REGRESSION
if "%choice%"=="4" goto EXIT

echo.
echo Invalid choice. Please try again.
pause
goto MENU


:ALL

echo.
echo Running All Tests...
echo.

mvn clean test

echo.
echo All Tests Completed.
pause
goto MENU


:SANITY

echo.
echo Running Sanity Tests...
echo.

mvn clean test -Dgroups=sanity

echo.
echo Sanity Tests Completed.
pause
goto MENU


:REGRESSION

echo.
echo Running Regression Tests...
echo.

mvn clean test -Dgroups=regression

echo.
echo Regression Tests Completed.
pause
goto MENU


:EXIT

echo.
echo Exiting Automation Framework...
echo.
pause