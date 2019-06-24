@echo off
SET JAVA_HOME=C:\app\Java\jdk-9.0.1
SET PATH=%JAVA_HOME%\bin;%PATH%
SET ECLIPSE_HOME=C:\Developing\Eclipse\Oxygen_2\eclipse
@start %ECLIPSE_HOME%\eclipse.exe -data C:\Users\Stephan user\Desktop\FH\Semester_6\SAT\Code\Pattern\CompositPattern -vm %JAVA_HOME%\bin\javaw -vmargs -Dfile.encoding=UTF-8 -Xms128m -Xmx3072m -XX:MaxHeapSize=768m -XX:MaxPermSize=512m
