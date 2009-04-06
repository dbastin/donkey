setLocal EnableDelayedExpansion

set SCRIPT_DIR=%~dp0
set PAYLOAD_CLASSNAME=%1
set CONFIG_DIR=%SCRIPT_DIR%\config
set JAVA_CMD=%JAVA_HOME%\bin\java

rmdir C:\temp\donkey
mkdir C:\temp\donkey
cp %CONFIG_DIR%\log4j\log4j.properties C:\temp\donkey
cp donkey.jar c:\temp\donkey
FOR /F "usebackq" %%i IN (`dir /b /s .\lib\*.jar`) DO cp %%i C:\temp\donkey

set CLASSPATH="C:\TEMP\donkey\*"
echo %CLASSPATH%
set JVM_OPTIONS=-Xmx256m
REM set JVM_DEBUG_OPTIONS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5010"
set EXEC="%JAVA_CMD%" %JVM_OPTIONS% -Dlog4j.configuration=file:C:\TEMP\donkey\log4j.properties -classpath %CLASSPATH% org.burroloco.donkey.trebuchet.Main %PAYLOAD_CLASSNAME%

echo %EXEC%
%EXEC%
