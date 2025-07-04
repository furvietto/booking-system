@echo off
echo =======================================
echo    Compilazione Maven dei servizi...
echo =======================================

echo.
echo --> Booking Service
cd booking-service
call mvn clean package -DskipTests
cd..

echo.
echo --> Eureka Server
cd eureka-server
call mvn clean package -DskipTests
cd..

echo.
echo --> Gateway Server
cd gateway-service
call mvn clean package -DskipTests
cd..

echo =======================================
echo     Build Maven completato con successo!
echo =======================================
pause