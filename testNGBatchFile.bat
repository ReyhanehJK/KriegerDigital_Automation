set projectLocation=C:\Users\r.karimi\eclipse-workspace2\KriegerDigital_AutomationBDD
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause