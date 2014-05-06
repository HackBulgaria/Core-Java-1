##Start here!##

Welcome :) 

Here are a few things you  should probably get done before the start of the core java course:

**1)** Install JDK 7

*Windows:* use Oracle's JDK from http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
or 

*Linux:* use your distribution's jdk-7 package:
(Check http://openjdk.java.net/install/)

*Mac OS X:* Use the native updater to update Java to a release > 7u25.
7u25 is disabled by Apple because of severe security issues.

**2)** Make sure java binaries are registered in PATH
and that they are **the same version**

```
java -version

java version "1.7.0_51"
OpenJDK Runtime Environment (IcedTea 2.4.4) (7u51-2.4.4-0ubuntu0.12.04.2)
OpenJDK Server VM (build 24.45-b08, mixed mode)
```
```
javac -version

javac 1.7.0_51
```

**3)** Install Eclipse Kepler from Eclipse site:
https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/keplersr2-with-java8-patches
Do not use your Linux distribution's Eclipse distribution. It would most likely be outdated.

**4)** Read the Google style-guide for Java source code:
http://google-styleguide.googlecode.com/svn/trunk/javaguide.html

We will be using very similiar style guide, but with the following modifications:
- 4 spaces for identation instead of 2.
- 120 lines for line-wrapping instead of 80.

