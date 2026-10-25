@echo off
title Menjalankan Kasir Kedai Pos Kopi
echo [1/2] Melakukan kompilasi kode Java...
if not exist "target\classes" mkdir "target\classes"
javac -encoding UTF-8 -d target/classes src/main/java/com/kasir/*.java src/main/java/com/kasir/model/*.java src/main/java/com/kasir/service/*.java src/main/java/com/kasir/view/*.java

if %errorlevel% neq 0 (
    echo [ERROR] Kompilasi gagal! Pastikan JDK terpasang dengan benar.
    pause
    exit /b %errorlevel%
)

echo [2/2] Membuka Kasir Kedai Pos Kopi...
start javaw -cp target/classes com.kasir.Main
exit
