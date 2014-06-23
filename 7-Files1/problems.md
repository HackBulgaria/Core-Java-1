### Prepare utility methods for reading and writing to files

Create a class `FileUtils`. Forbid it's instantiating (make the default constructor private).
Create and implement a **utility** method `String readFrom(File file)`.
`readFrom` should read **all the contents** from the file to a String, using the default (OS-default) charset. Do not worry about performance.

As this method is an **API**, you should NOT catch the exceptions in the method's body, remember?

- Add an overload `String readFrom(Path path)`. Make sure one of them calls the other, **do not let code duplication in those methods**.

For this task, do not worry about performance or different encoding.


Do the same for a 'write' method.
Make sure you have utility methods that read from and write to files, and people can use them in 1-liners.

### Implement a 'Properties' file parser.

[.properties files](http://en.wikipedia.org/wiki/.properties) are commonly used in java as a resources and configuration.

Make a **utility** method `Map<String, String> parseProperties` that reads a .properties file and returns its content as a Map<String,String>.

The `#`-sign, when seen as a **first character in a line**,  denotes that **the line is a comment and should not be parsed**. 
Be careful when parsing lines. 
```
# this=comment
a1=b1 
a2 =b2
a3    =    b3
   a4 = b4
a5=b6=b7=b8
a6=b9 #comment 
a7==b10
```
All of the above entries are all valid. 
The value for `a5` is `b6=b7=b8`
The value for `a6` is `b9 #comment`
The value for `a7` is `=b10`

Hints and suggestions:
- Make a helper method, that does all the parsing logic (generates the Map from List<String>).
- Do **not** split the lines on your own like `fileContents.split("\n")`. This is not a cross-platform solution. 
- First test your helper method, which creates the Map from a given List<String>. 
- After assuring yourself your helper method works great, test the `parseProperties` method.
- Create (write) your .properties file (for testing) programmatically, in `setUp`. Do not depend on external resources for testing if you can avoid it!
- Do not polute the filesystem because you are writing tests. Clean up (delete the file in `tearDown`) after your each test run. Your file is relevant ONLY for the tests, and it should not outlive them. 


### Implement the wc command

Create a **utility** method `WordCountResult wordCount(Path path)` with an overload `WordCountResult wordCount(File file)`.
As you've probably guessed, the `WordCountResult` is a custom class, having these methods
```
int getLineCount(); //returns number of lines
int getWordCount(); //returns number Of words in File
int getCharacterCount(); //returns number of characters in the file.
```

Follow the testing approach described in the previous task.

