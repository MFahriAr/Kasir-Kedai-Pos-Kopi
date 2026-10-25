@echo off
title Uji Logika OOP Kasir (Console)
echo Melakukan kompilasi dan pengujian konsep OOP...
if not exist "target\classes" mkdir "target\classes"
javac -encoding UTF-8 -d target/classes src/main/java/com/kasir/*.java src/main/java/com/kasir/model/*.java src/main/java/com/kasir/service/*.java src/main/java/com/kasir/view/*.java
java -cp target/classes com.kasir.TestKasirOOP
pause
