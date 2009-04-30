setLocal EnableDelayedExpansion

set SCRIPT_DIR=%CD%
set SPECIFICATION_CLASSNAME=%1
set CONFIG_DIR=%SCRIPT_DIR%\config
set JAVA_CMD=%JAVA_HOME%\bin\java

REM Copy all jars to one location to keep CLASSPATH small
rmdir C:\temp\donkey
mkdir C:\temp\donkey
copy donkey.jar c:\temp\donkey
FOR /F "usebackq tokens=*" %%i IN (`dir /b /s .\lib\*.jar`) DO copy "%%i" C:\temp\donkey

REM Requires Java 1.6
set CLASSPATH=%CLASSPATH%;C:\TEMP\donkey\*
echo %CLASSPATH%
set JVM_OPTIONS=-Xmx256m
REM set JVM_DEBUG_OPTIONS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5010"
set EXEC="%JAVA_CMD%" %JVM_OPTIONS% -Dlog4j.configuration=file:"%CONFIG_DIR%\log4j\log4j.properties" -classpath %CLASSPATH% org.burroloco.donkey.trebuchet.Main %SPECIFICATION_CLASSNAME%

echo %EXEC%
%EXEC%
