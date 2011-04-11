setLocal EnableDelayedExpansion

set SCRIPT_DIR=%CD%
set SPECIFICATION_CLASSNAME=%1
set CONFIG_DIR=%SCRIPT_DIR%\config
set JAVA_CMD=%JAVA_HOME%\bin\java

REM Copy all jars to one location to keep CLASSPATH small
rmdir /S /Q C:\temp\donkey_%SPECIFICATION_CLASSNAME%
mkdir C:\temp\donkey_%SPECIFICATION_CLASSNAME%
copy donkey.jar c:\temp\donkey_%SPECIFICATION_CLASSNAME%
FOR /F "usebackq tokens=*" %%i IN (`dir /b /s .\lib\*.jar`) DO copy "%%i" C:\temp\donkey_%SPECIFICATION_CLASSNAME%

REM Requires Java 1.6
set CLASSPATH=%CLASSPATH%;C:\temp\donkey_%SPECIFICATION_CLASSNAME%\*
echo %CLASSPATH%
set JVM_OPTIONS=-Xmx512m
REM set JVM_DEBUG_OPTIONS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5010"
set EXEC="%JAVA_CMD%" %JVM_OPTIONS% -Dlog4j.configuration=file:"%CONFIG_DIR%\log4j\log4j.properties" -classpath %CLASSPATH% org.burroloco.donkey.trebuchet.Main %SPECIFICATION_CLASSNAME%

echo %EXEC%
%EXEC%

REM Cleanup
rmdir /S /Q C:\temp\donkey_%SPECIFICATION_CLASSNAME%
