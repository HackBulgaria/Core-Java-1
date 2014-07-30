### Assure you have Maven properly installed
```
mvn -v
Apache Maven 3.0.4
Maven home: /usr/share/maven
Java version: 1.7.0_55, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-7-openjdk-i386/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.5.0-37-generic", arch: "i386", family: "unix"

```
Any OS will do, and any Maven >= 3.0.0 will do.

### Maven in 5 minutes tutorial
Execute maven in 5 minutes from here:
http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html


### Stop the Tomcat instance launched from Eclipse
Shutdown Eclipse's use of tomcat. We will not let Eclipse manage tomcat for us this time.  
Forget Run as -> Server. We won't be using that again.

If you do not have running Tomcat instance from Eclipse, you don't have to do anything.  
Else, just click on the red button in the'Servers' view. 

(If you've just launched Eclipse, you don't have to do anything)

### Check out tomcat's installation directory
-Go to your tomcat installation directory. For me, it was `/home/georgi/Dev/tomcat/`
-Do an `ls` and notify me when you get there. 

- `tomcat/bin` => All the binaries for tomcat. If you need to start or stop tomcat, there are the binaries you need.
- `tomcat/conf` => All the configuration files for tomcat. tomcat-user.xml and others
- `tomcat/webapps` => The most important folder of all. You must delpoy your web applications here. 'Deploying' means copying one .war file to your webapps dir.

One web application = one .war file. It's like a .jar file, but it means 'webarchive' (.war).

-Start your tomcat using `startup.sh` or `startup.bat` in the `<your-tomcat-dir>/bin/` folder.

-Go to http://localhost:8080 . Do you see the cat? You need to see the cat.  
-Now take a look at http://localhost:8080/examples/

-Take a note - if you let eclipse manage your tomcat, you won't see neither a cat nor examples.

-Edit the tomcat-users.xml file in `your-tomcat-dir/conf`. See the commented lines and add *2 roles* one with a `rolеname="manager"` and the other with a `rolеname="manager-gui"`.
-Create a user with username "a" and password "a" with the role of "manager-gui"
-Create a user with username "test" and password "test" with the role of "manager"
-Save tomcat-users.xml

-Open http://localhost:8080/manager . Authenticate with "a"/"a".
-What you are seeing now is something called the "Tomcat Manager". Here you can see what applications do you have deployed, which of them are running, etc. If you have any problems with web applications, that's the place to check first:
-1) Your web application should be DEPLOYED
-2) Your web application should be RUNNING

### In Eclipse
- Create your Dynamic Web project. Name your project 'AsciiService'.
- Create a servlet echoing "Hello World!" to the writer in the `doGet` method
- Convert it to a Maven project. (Right click on project -> Configure -> Convert to Maven). Leave the groupId and artifactId intact, but delete the "-SNAPSHOT" part from the versioning string. 
Enter name and description of your project.
- Notice the immediate creation of a pom.xml file
- Go to pom.xml and click the "pom.xml" tab (it's below the editor window)
- If you ever need to change anything on the namings, it's there.
- Using the UI, (Right click on your project -> Maven -> Add dependency), try and add a dependency. Let's say, add apache's commons-io library. Latest version.
- You may need to enable global repository indexing in order for your dependency search to work. See http://stackoverflow.com/questions/18523044/how-to-force-maven-repository-indexing-in-eclipse.
- See the changes in your pom.xml file (You now have a 'dependencies' tag and subtags...) Next time, just manually copy-paste the 'dependacy' tag from the library vendor in your pom.xml (at the appropriate tag-location, of course)
- Update your project (right click on project -> Maven -> Update project)
- Try using apache-commons-io (for instance, invoke a static method on `IOUtils` class). If your code compiles, than you have sucessfully added a dependency.

### Show time
Now, it's time to delve deep. I want you to bridge maven with your eclipse project.   
Your goal here: every time you make a change on your project, executing `mvn install` should *upload your project to the webapps folder* in `<your-tomcat-dir>\webapps`. 
- 1) You can use the tomcat7 plugin for maven. See http://stackoverflow.com/questions/15824096/how-to-deploy-war-with-maven-to-tomcat (test results with `mvn clean tomcat7:deploy`)
- 2) You can use a simple maven-anttask-plugin. See http://www.itcuties.com/tools/maven-3-deploy-war-package/ (test results with `mvn install`)
- 3) 1) is the harder route, but it's the better route. You'll learn more by doing 1). If it's half an hour until the end of the session, better choose 2)

11) If you've done 1), there is one more step. You can see your war being deployed by doing `mvn clean tomcat:deploy`. But we want this to happen only on `mvn install`. 
Follow http://www.avajava.com/tutorials/lessons/how-do-i-attach-a-plugin-goal-to-a-particular-phase-of-a-maven-lifecycle.html to **invoke a goal on a phase**.

### Extra
If you are ready, just implement the rest of the 'AsciiService' project. You need to receive a file (via POST, like a file-upload), process it and return the ascii representation of the file. Implement it with pictures only. Use [Apache FileUpload] http://commons.apache.org/proper/commons-fileupload/ at the server side and [Apache HTTP Client] http://hc.apache.org/httpclient-3.x/ at the client side
