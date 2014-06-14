Both tasks should go into a project named Exam1. 
Later on you will be asked to give a link to your solution (to the Exam1 project). All tasks but the last one should have good test cases with them.	

### Make a method 'sort', which sorts a copy of a List
`Collections.sort` is really cool, but it sorts collections in place.
Write a **utility** method `sort`, that sorts a **copy of the given** `List`, and returns it. Use `Integer` as type for your `List`.

### Make a method 'reverse', which reverses a copy of a List.
Write a **utility** method `reverse`, that takes a `List`, **reverses** a copy of it and returns the reversed copy. Use `Integer` as type for your `List` argument.

### Check if the given List<Integer> is monotonous
Make a **utility** method, that returns **boolean** whenever the `List` given is monotonic.
```java
YourClass.yourMethod(Arrays.asList(1,2,3,4,5,6)); //true
YourClass.yourMethod(Arrays.asList(6,5,4,3,2,1,1,1); //true
YourClass.yourMethod(Arrays.asList(1,2,1,4,5,4)); //false
```
**Bonus** Maximum 1 line of code allowed. :)

### Make a logger class 

Disclaimer: To **log** somethings means simply to write it to the console. 

A *logger* class is a class that people use when they want something written on the console. Of course, one can always use `System.out.println()`, but it is a churn, and logger classes tend to offer good methods for writing a little more complicated stuff to the console (see examples below). 

A logger class also has something called `LEVEL`, which is usually an integer. 
`LEVEL` represents the **importance** of the message logged. For instance, `logger.log(3, "something)` means that the priority for message **"something"** is **3**.

And when a `LEVEL` is **set to the logger**, the logger **ignores logging calls for higher levels**.
For instance:
```java
Logger logger = new Logger(3); //set LEVEL to 3
//I can also call 'new Logger()', in which case use a default LEVEL of 3

logger.log(2, "Somewhat important message"); //gets logged as "2 => Somewhat important message"
logger.log(3, "Less important message"); // also gets logged!
logger.log(5, "Not important"); //this is less important than LEVEL, so it will **not be logged**.
logger.log("Meh"); //overload without a LEVEL parameter, use 3 as default.

....
looger.setLevel(2);
logger.log("My message"); //does not get printed!
``` 

`LEVEL` is always expected to be > 0. Your class should not encourage/tolerate behavior like:
`logger.log(INTEGER.MIN_VALUE, "THIS is most important message in the world!!!")`. This is not a correct call and calling your method like this is a programmer mistake. **Make sure you do not accept such usage.**


**It is important to note that LEVEL must be settable at runtime, after the logger object has been created.**  



Also, it is quite important on how the log message look like. In order for your log messages to be more informative, include the *current date and time* of the logging.
Make a class `DateLogger`, which logs messages, but prepends
Example

```java 
Logger logger = new DateLogger(); //I am not obliged to set a log level, by default your class should print everything in this case
logger.log("My message"); //this is an overload without a LEVEL parameter. In this situation, assume the LEVEL given to you is 3.
//|22:14:01 14.06.2014| 3 => My message
```

To summarize:
- Create a `Logger` class. Make a constructor accepting log `LEVEL`. Make a default constructor with a default log level of 3.
- Implement a `log(int level, String message)` and `log(String message)`
- Do not log messages if the level given is higher than the currently set in the logger.
- Protect users of this class from invalid usage
- Create a sublcass `DateLogger`. Override it's methods so that date and time is added to every logged message (see examples above).
- It's okay (just for now, and just for this task!), not to use TDD. This is because I have not shown you mocking, and we have not talked about PrintStreams, PrintWriters, etc. in Java.


 


