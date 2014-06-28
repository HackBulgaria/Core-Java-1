### Send an email about the 'Suarez' accident

Have you seen the Suarez-Chiellini biting accident from the World Cup in Brazil? It was both hilarious and weird-ish at the same time.   
In the dawn of the internet, when skype, snapchat and stuff like that did not exist, people were sending a lot of emails to each other with funny stuff.   

Send an email to someone about the suarez biting accident. Attach a gif of the biting accident, available [here](http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif)

Integrate and use the apache commons-email library from http://commons.apache.org/proper/commons-email/userguide.html

Note: The commons-email library depends on the javax.mail library, which you should download from somewhere.

### JToaster

Ivan stays a lot on his computer. His mother is afraid he will spoils his vision.
As you know very well, you should take a break of at least 5 minutes (actually, it should be 15, but this *might* be outdated).

Help Ivan maintain his eagle-like vision. Write a program that waits 45 minutes, and the shows a notification saying 'Get a little rest, will you?' (or a message of your choosing :D) 

Use the incredibly-complex JToaster library. Download it from http://jtoaster.sourceforge.net/
Use the methods `showToaster`, `setToasterWidth`, `setToasterHeight`, `setToasterIcon`, `setToasterColor`, `setBackgroundImage`, `setStep`, etc. to customize and make the coolest toaster you can imagine. Also, set a nice background, something like

![This dog] (http://www.mnn.com/sites/default/files/editorial/Corgeek.jpg)

  
Also, check out the `Thread.sleep` method.


### Make a QuickCodeInspector desktop application

Ever needed to really, really quickly inpsect some code?
Here is a one cool syntax highlighter for java https://code.google.com/p/java-syntax-highlighter/  

1) Create a program, that receives a file path as a command-line argument (args[0] in `main(String[] args)`)  
2) For the File given, launch a syntax highlighter windows as the example in the link above.  

Come back when you are done with 1) and 2).   

Does it work so far? Marvelous.   
3) *Not mandatory*. Now, for the fun, export your program as a *runnable* jar. (See Eclipse->Export). Register your program as one that can handle .java files in your OS (the way to do this will vary among OS and distributions)  
For ubuntu see http://askubuntu.com/questions/289337/how-can-i-change-file-association-globally.  

For windows, create a **.bat** file, containing somthing like:
```
"C:\Program Files\Java\jre7\bin\javaw.exe" -jar "C:\Users\Adriana\Desktop\QuickCodeInspector.jar" %1 %
```
1) C:\Program Files... -> Is the path to your javaw.exe location  
2)-jar C:\Users.....  -> is the path to your QuickCodeInspector.jar  
3) Just append %1 % at the end of the .bat script.
After that, try opening .java files with your application, by using **open with** and pointing to your .bat file. 

Go and check your cool java program that opens .java files for you. (Remove the entry later!).  

4) Set a title on the window that matches the name of the file being viewed!  
5) How cool would it be if we could navigate through all the files of the current directory with the arrows of the keyboard?   
In order to do that, make the jframe **focusable**, add a **KeyEventListener**, and when the user presses the arrow-next on the keyboard (see [key-code table](http://www.foreui.com/articles/Key_Code_Table.htm)), `dispose()` the frame and create a new one with a syntax highlighter configured for the next file.   
6) Make this work recursively for all the files in the folder.  

