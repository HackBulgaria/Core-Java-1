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
   "11:07 08-07-2014" - updated
   "11:08 08-07-2014" - updated
   "11:08 08-07-2014" - updated
   "11:09 08-07-2014" - finished
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


#### Design and implement a TicTacToe game (Pair Programming)
Design (classes and code-flow) for a TicTacToe game. Do not start implementing until you have a very clear picture.

Read the requirements below: 

- Game is played by two people - User1 and User2. They take turns - first enters user A, after that - user B.
- Users input its move via console like this: "0 1" // first row, second column
- If a user enters "q", the game should exit immediately.
- We are very likely to add other features to the game, and more complex user input is likely to follow.
Some hints and tips:  
- Core game logic should **not** be in the **main** method!
- Distinguish game/board **visualization** from **game logic**.
- User keyboard input and error handling logic **must** be separated from **game logic**. Design your game so that a Swing (window-based) visualization can be easily added later on **with as few in-class modifications as possible**
- Design the game in order to support **different visualizations**. Imagine we would like to add a GUI visualization later. 
- Implement the game only on the console. Use 'X' for player 1, and 'O' for player 2. (Or use swing for GUI, if you feel up to it). 
- Use good naming conventions, make your code presentable.
- Matrices are usually easier to visualize by both developer and users when using an y-first approach.
```
1 2 3 
4 5 6

input: 1 2 //row 1, col 2 => 6
```


###### Additional: Implement a simple undo-redo.
Now imagine User1 has made a bad choice. He now wants to undo his choice and User2 is OK with that. 
If a user enters "u", it means 'undo' - the game must revert its previous state - the board just as it was before player 1 has made his bad choice. 
Also, it is also his turn again : )
If a user enters "r", it means 'redo' - the user now wants to undo his undo - resulting in a 'redo' operation.
Design an 'Undo-Redo' solution. You may or may not use the classical [Memento](http://en.wikipedia.org/wiki/Memento_pattern) solution to this problem.	
If you are into it, you can use the [Command pattern](http://gamedevelopment.tutsplus.com/tutorials/let-your-players-undo-their-in-game-mistakes-with-the-command-pattern--gamedev-1391) for this undo redo, but I personally don't recommend that for this task.
 

##### Additional: A new game
If a user presses 'n', a new game instance is launched.


##### Additional: Implement a simple save-load mechanism
When the user decides he wants to quit, don't lose his game forever. Save it to a location with a format of your choosing. You can use binary format + [serialization](http://www.tutorialspoint.com/java/java_serialization.htm)   
When launching the game, if the user has a save, restore it.



