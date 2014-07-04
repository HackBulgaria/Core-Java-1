#### First, download all the files in testData/links.md

#### Parse this XML
Now, as you have the latest-stub-articles xml from Wikipedia, it's time to test the two XML parsers in java to see which is faster, and why.  

###### Parse it with the DomParser.
Use the [DOMParser](http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/) to parse the xml file and get a `Document` instance.  
Do not go through all the nodelists and nodes, just obtain the `Document` instance from the `parse` method.  
Notice the ammount of time needed for the `DocumentBuilder` to parse your file. 


###### Parse it with the SAXPasrer
Use the [SAXParser](http://www.mkyong.com/java/how-to-read-xml-file-in-java-sax-parser/) to parse the xml file. Extend 	`DefaultHandler`, and see the time needed.


###### Hints: 
In order to **measure** the time needed for an operation to complete in java, check out the `System.currentTimeMillis()` : )



###### Count the number of different 
As the file format above is something like:
```
  <page>
    <title>Translations:Wikimedia Foundation elections/FDC Ombudsperson elections/2013/13/en</title>
    <ns>1198</ns>
    <id>2239772</id>
    <revision>
      <id>5552639</id>
      <parentid>5394284</parentid>
      <timestamp>2013-06-09T12:36:44Z</timestamp>
      <contributor>
        <username>FuzzyBot</username>
        <id>1058846</id>
      </contributor>
      <comment>Importing a new version from external source</comment>
      <text id="5538008" bytes="520" />
      <sha1>lwdr5q15u1n9bsxgipym50earq8tpd8</sha1>
      <model>wikitext</model>
      <format>text/x-wiki</format>
    </revision>
  </page>
```

I'd like you to print the username of the **wikipedia contributor, that has contributed the most!**
Choose between the two major parsers and use one of them. Use and combine the `startElement`, `endElement`, and `characters` methods in your extension of `DefaultHandler` (if you are using `SAXParser`, or use XPath or XQuery + `Document` if you prefer and like the DOMParser more (for some reason).  

Friendly advice: **If you haven't use the DOM Parser in Java, don't use it here. You won't like it. It is slow, as it builds up the whole tree. You don't need that. Also, XPath and XQuery are not as easy as they seem.**



#### Serializing, deserializing and Bindings with JAXB/Jettison
Create a class `CoreJavaCourse` with fields
```
List<Student> enrolledStudents
int courseId
String courseName
```
A `Student` class has the following:
```
int studentId
String name
```


Now: 
0) in a main method: Create an instance of the `CoreJavaCourse` class.  
1) Create a JAXBContext of this class and the class Student.  
2) Obtain a Marshaller from the `JAXBContext` instance.  
3) Marshal the `CoreJavaCourse` instance.  
4) Verify that you have correct xml output to the console.   

4.5) Create an Unmarshaller from the `JAXBContext` instance.   
5) Unmarshal the file to an instance.  
6) Override the `toString()` method and print it to the console, verifying that you have unmarshalled the xml file properly.  

7) Now, let's switch the whole procedure to JSON! We will reuse are @XML bindings, but we will just produce JSON  
8) First, download and link the [jettison library](http://repo1.maven.org/maven2/org/codehaus/jettison/jettison/1.3.3/jettison-1.3.3.jar)
9) Create a `MappedNamespaceConvention` instance.  
10) Create an instance of  `MappedXMLStreamWriter` instance using the `MappedNamespaceConvention`  instance you just created.  
11) On your `Marshaller` instance, call the `marshal` method, but giving it the `MappedXMLStreamWriter` instance you just created. This instance will apply the conversion from XML to JSON, so be sure you pass your `MappedXMLStreamWriter` argument!  
12) Now, you can go and check the file you've just marshalled to (or the console, if you've marshalled to the console). You see the output is JSON.  
13) Repeat the procedure, but for unmarshalling, this time using a `MappedXMLStreamReader` instance. See if you can work your way **without** looking at the resources.  

If somewhere along the process you get lost, check out the `materials.md` file provided. Be wary - the contents there are basically everything you need and you will **learn nothing if you just head there and copy-paste some code. Don't do that. Try to understand the whole process, what is happening and why.**



