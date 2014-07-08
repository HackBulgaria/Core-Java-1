You will work in teams - minimum of 2 people per team.  
Here we will be focusing on architecture rather than implementation.  
Do not use TDD unless specified in the task.  

##### Warm-up 
Mary has a furniture business. She has a website, which sells furniture.
Mary only sells a handful of furniture - chairs and tables using only two materials - iron and wood.

Unfortunately, Mary is not very good at OOP programming.
Each furniture has a `getDescription()` method - the description of the furniture (for her website!) 
The base `Furniture` class looks like this
```java
public abstract class Furniture{
     protected int price;
     public Furniture(int price){
        this.price = price;
     } 

     public abstract String getDescription();
     ...
}
```

And now the derived classes look like this
```java
public class IronChair extends Furniture{
     //constructor, calling super, nothing fancy here  
     ...
     @Override
    public String getDescription(){
      return "A chair made of iron";
    }
}
```

```java
public class WoodenTable extends Furniture {
     //constructor, nothing fancy here  

     @Override
     public String getDescirption(){ 
        return "A table made of wood";
     }
}
```
There are 2 more similiar classes - WoodenChair and IronTable.

Now, Mary is proud that her business is expanding. She will be selling sofas! Also, she has made a contract with another supplier, so now she can sell sofas, tables and chairs, made of concrete.   

How many new classes must Marry create? If by the next week she signs a deal with a supplier getting her furniture made of ice, and she starts selling beds, how many classes will she have to create? Make a big O estimation of the (un)scalability of Mary's furniture hierarchy.  

Refactor Mary's hierarchy, avoiding the forseen explosion of `Furniture` subclasses. Pseudo-code is enough.


##### Warm-up 2  - Design and implement a time tracker class (Pair Programming)
A 'TimeTracker' is a class that tracks the time needed for an operation.  
Design a class supporting time tracking for several operations. See example usage below:  

Example usage 1:
```java
TimeTracker timeTracker = new TimeTracker();
timeTracker.start("fileCopyOperation");
FileUtils.copy(path1, path2);
timeTracker.finish("fileCopyOperation");

System.out.println(timeTracker.getReport("fileCopyOperation"));
// => "Operation fileCopyOperation took 314 ms. 
//    "11:05 08-07-2014 started" 
//    "11:06 08-07-2014 finished"

```


Example usage 2:
```java
final TimeTracker timeTracker = new TimeTracker();
timeTracker.start("asyncFileCopy");
FileUtils.copyAsync(directory1, directory2, new CopyCallback(){ //copying ALL the files in directory1 to directory2

  public void onFileCopied(File whichFile){ //called when one file is copied! 
     timeTracker.update("asyncFileCopy");

  }

  public void onAllFilesCopied(){
    timeTracker.finish("asyncFileCopy"); 
    System.out.println(timeTracker.getReport("asyncFileCopy"));
  }
}
); //copying multiple files here!

timeTracker.start("moveOpearion");
FileUitls.mv(path1,path2);
timeTracker.finish("moveOperation");
System.out.println(timeTracker.getReport("moveOperation"));
// "Operation moveOperation took 112 ms"
   "11:07 08-07-2014" - started
   "11:07 08-07-2014" - finished
```

**Note: calling getReport(String) if operation has not finished is a VALID operation**


#### Design and implement a 'search' method, giving the user some settings (Pair Programming)
 
Design and implement a class (or a utility method) to carry out a prioritized search. Your method will be searching for a `String` in a `List<String>`. Lets call them `needle` and `haystack`.
It should return a `List<String>` - the matches, in prioritiezed order. 

Your method should support something called **prioritized search**. 
Here are some predefined prioritization criteria you will need to implement and make availabe to your class's clients:

- If a line in `haystack` is an exact match with needle, this is the top result.
- If a line in `haystack` **begins** with `needle`, it is a second-top match.
- If a line in `haystack` **contains** a `needle` **as a word**, and not a word **infix**, it is a third-rated match.
- - For example, if a line in `haystack` = "Baba Pena mrazi Sergei Stanishev" && `needle` = "mrazi" => third-rated match.
- - if `needle` = "mraz" => not a third-rated match.
- If a line in `haystyack` **contains** needle, it is the last-based match.

The **priorities** given above are just for the example. The user of your class should be able to use any your predefined criteria, as well as **his own criteria**, and **define the priorities himself**.


#### Design a TicTacToe game (Pair Programming)
Design (classes and code-flow) for a TicTacToe game.
Some hints:  
- How will the user enter his input (assume console)?
- How will he quit the game? How will this be separated from the core game logic?
- Where will you keep the state of the game?
Write a pseudocode for the main method and core components of the TicTacToe game. Implementation is not mandatory.

#### Design a 'CarRental' service
Cars can be Audi, BMW, Opel, WolkSWAGen, etc. They can also be Sedans or SUVs. Sedan's have an optional 'sports package' **extra**, adding extra horse power. SUV's have an optional **extra** - 1 more passenger seat. 
Every car has its own license plate, number of seats and horse power.  
Every car can be queried for its brand, license plate, number of passenger seats, and horse power.  

Pseudocode is OK.

### Design an Ice Cream class ofr an IceCreamMachine
Ice cream is a great thing. Everybody loves ice cream. Some people love it with sprinkles, other people with added cream, a third kind likes it with a topping, a fourth kind of people like it with a topping and some sprinkles... you see where this is going. (Don't make classes like `VanillaSprinklesChocolateToppingNoCreamIceCream`, please)
An ice cream machine can add  some (or) all of the 4 kinds of extras on an Ice Cream.

Let's say you have a class `IceCream`
```java 
public class IceCream{
   public String toString() {
     return "Plain old IceCream";
   }
}
```

```java
 IceCream iceCream = IceCreamMachine.newRandomFlavouredIceCreme(); //just for the test!
 System.out.println(iceCream.toString());
 //Cherry Ice cream with added sprinkles with added vanilla topping with added sour cream

```

IceCream flavours, kinds of toppings, and extras as a whole are expected to grow in numbers. How can you make your IceCream class handle additional extras and still implement `toString()` correctly?


#### Design an abstract and flexible search  (OK for github workflow)
Remember the searching thing? You want to search for a needle in a haystack. Needle will be a `String`. Haystack will be a little more complicated. But you want to reuse the logic in your search method.  
You want to search in directories, files (search in file contents), collections, and even in google. Also, the user should be able to give multiple  haystacks, each with different priority : )  
Here both the search criteria and the haystacks can be prioritized.   
Also search results are a bit more complicated. The user of your search should be able to tell which result came from which haystack.  

Example: when on your android phone you search for something in the 'google' widget, it gives you a multitude of results of different kinds. If you play with the search widget, you will see that what they do is similiar to what we want to do here.

Implement the task, (with a haystack or two or three) and create a demonstration of it.
 
 

 


