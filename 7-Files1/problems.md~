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

[.properties files](http://en.wikipedia.org/wiki/.properties) are commonly used in java as a resources and configuration. They just represent a key=value pairs, where each pair is a new line. The `#` sign denotes a comment.

Make a **utility** method `Map<String, String> parseProperties` that reads a .properties file and returns its content as a Map<String,String>.

The `#`-sign, when seen as a **first character in a line**,  denotes that **the line is a comment and should not be parsed**. 

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
All of the above entries (`a1` to `a7`) are valid key-value pairs. 
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



### Fix these subtitles
Have you ever wanted to watch a movie, and all the cyrillic characters be like ������? 

Have you received an emails like "Greetings, dear �������"?

These things happen because of different encoding and decoding schemes used.   

As we all know, even text files and strings are retained as binary in memory. 
So if we have the string 'Dumbledore', we need to store an array of bytes to represent it. 

The way we choose what bytes represent 'Dumbledore' in memory is called an **encoding scheme**. (a.k.a. encoding)
"windows-1251" is a type of encoding scheme.
"ISO-8859-1" is another type of encoding scheme.

The way we choose to convert it from a byte array to a char array is called a **decoding scheme**.

**Unicode** is an industry standard of encodings. There is no good reason against an Unicode encoding scheme.
UTF-8 is a good encoding scheme from the Unicode standard. (There are others, which differ slightly.)

So, here you are given a text file with a Windows-1251 encoding. Your task is to convert it to UTF-8. You can test this in your browser, just open the text file and choose to view it with UTF-8 encoding. (You might have to rename it to .html though)

The subtitle you need to fix are here: http://subsunacs.net/get.php?id=41854
It is okay not to use TDD for this one. 

In summary:
- Create a utility method `fixEncoding(Path path)`
- Backup the subtitles file so you don't have to download it again if you fail to write it.
- The text in the file given is encoded using a **windows-1251** scheme. 
- Conver it to UTF-8.


