## Agenda for week 0 ##
- Java, JRE, JVM, JDK
- JSR, JCP
- JSE, J2EE, J2ME
- Cross-platform, compatibility
- Javac
- classpath

//what IDE does for us
C:\>javac -sourcepath src -classpath classes;lib\Banners.jar ^
            src\farewells\GoodBye.java -d classes
//source and target explanations
C\:>javac -source 1.6 -target 1.6 -bootclasspath C:\jdk1.6.0\lib\rt.jar ^
            -extdirs "" OldCode.java

//bootclasspath option

- javap
- the javadoc tool
- jar format 
- Common VM Arguments