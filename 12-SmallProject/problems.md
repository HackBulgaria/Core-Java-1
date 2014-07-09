## Project 1 - Design and implement a TicTacToe game (PairProgramming/Github workflow)
Design (classes and code-flow) for a TicTacToe game. Do not start implementing until you have a very clear picture.

The minimal requirements: 

- Game is played by two people - `User1` and `User2`. They take turns - first enters `User1`, after that `User2`.
- Users input the move via console like this: "0 1" // first row, second column y => 0, x = 1
- When `User1` wins, a "Player 1 wins!" text should be seen on the screen.
- When `User2` wins, a "Player 2 wins!" text should be seen on the screen.
- If the game is a tie, "It's a draw!" text should be seen on the screen.
- Otherwise, the game board should be printed before every move.
- If a user inputs **q**, the game should **exit immediately**.
- We are very likely to add other features to the game, and more complex user input is likely to follow.  

###### Some hints and tips:  

- Core game logic should **not** be in the **main** method!
- Distinguish game/board **visualization** from **game logic**.
- User keyboard input and error handling logic **must** be separated from **game logic**. Design your game so that a Swing (window-based) visualization can be easily added later on **with as few in-class modifications as possible**
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
If a user enters **u**, it means **undo** - the game must revert its previous state - the board just as it was before player 1 has made his bad choice. 
Also, it is his turn again : )  
If a user enters "r", it means 'redo' - the user now wants to undo his undo - resulting in a 'redo' operation - again, change of turns is happening.  
If a user makes an **undo operation**, and does a new move, the **redo** operations become unavailable.  
Design an 'Undo-Redo' solution. You may or may not use the classical [Memento](http://en.wikipedia.org/wiki/Memento_pattern) solution to this problem.	  
If you are into it, you can use the [Command pattern](http://gamedevelopment.tutsplus.com/tutorials/let-your-players-undo-their-in-game-mistakes-with-the-command-pattern--gamedev-1391) for this undo redo, but I personally don't recommend this approach for this task.
 

###### Additional: User inputs
If a user presses **n**, the board is cleared and the game starts all over. **Starting a new game can be undone.**  
If a user presses **s**, his game gets saved (see below).   
If a user presses **l**, his game gets loaded (see below). **Loading can be undone**   


###### Additional: Implement a simple save-load mechanism
When the user decides he wants to quit, don't lose his game forever. Save it to a location with a format of your choosing. You can use binary format + [serialization](http://www.tutorialspoint.com/java/java_serialization.htm). It is up to you.   
When launching the game, if **the user has a save, restore it**.  

###### Additional: The most simple AI in the world
Now, it's all cool playing with two players. How about playing against the CPU?   
Read a command-line argument `multiplay`. By default `multiplay` should be false.  
Example:  
```
java -jar yourJar.jar //launches your game with you playing against the CPU.
java -jar yourJar.jar multiplay //launches your game with 2 players
```

The 'AI' here is just as complex and smart as Brazil's gameplan against Germany.  
However, make sure your 'AI' approach is extensible - meaning that you could very very easy replace the AI if you wanted. Don't hardcode anything. See [Strategy pattern](http://java.dzone.com/articles/design-patterns-strategy)
###### AI round one: Random moves
Make the stupidest AI on the planet earth. Force your bot to choose a random location. Be wary when choosing locations, you should only use free positions.   

###### AI round two: Random moves + finishing strategy.
Your AI should check if there is a move that he can make that will make him an instant winner. If not, move at random.  


## Project 2 - a 2048 implementation (PairProgramming/GithubWorkflow)
Have you played 2048? The tradition is simple: nobody explains you the rules, you figure them out yourself. See http://gabrielecirulli.github.io/2048/  
Design (classes and code flow)  for a 2048 game. Don't start implementing until you have a very clear picture of the classes you are going to use.  

Minimal requirements: 
- Game is played by one player.
- He/she/it inputs its move via the **console**. 
- When the player wins, a "You've won!" message gets displayed.
- When the player loses, a "You've lost :(" message gets displayed.
- The game board gets printed before every move.
- A chance of a random '4' spawning instead of a '2' is 10%.
- If a user enters **q**, the game must **exit imediately**   
- Design your game in a way that GUI visualization can be easily added later.


###### Hints/tips:  
- Core game logic must not be in your **main** class/method!
- User input getting must be **decoupled** from core game logic!
- Game **visualization** should be **decoupled** from core game logic.
- Use good naming conventions, make your code presentable.
- Matrices are usually easier to visualize by both developer and users when using an y-first approach.
```
1 2 3 
4 5 6

input: 1 2 //row 1, col 2 => 6
```
- Core game logic here might be a bit more difficult, but we have only 1 player.


###### Additional: Undo-Redo
You've made a wrong choice in 2048 and you want to rip all of your hair. Don't! There is a simple solution - just press **u**, and the game will undo! If you want to repeat your move, press **r** - your undone move will be redone.   
However, if you **undo** a move and then make a new move, there is no **redo** for you. (What happens when you go gone back in the past and kill your grandfather?)

###### Additional: User inputs
If a user presses **n**, the board is cleared and the game starts all over. **Starting a new game can be undone.**  
If a user presses **s**, his game gets saved (see below).   
If a user presses **l**, his game gets loaded (see below). **Loading can be undone**   

###### Additional: Do not require 'enter' for taking input.
Did you know you could read the console without having to wait for a 'return'(Enter)? You could use `Jline` to do that. See [Terminal](http://jline.sourceforge.net/apidocs/jline/Terminal.html), and most notably the `setupTerminal` and `read` methods.

###### Additional: Implement a simple save-load mechanism
When the user decides he wants to quit, don't lose his game forever. Save it to a location with a format of your choosing. You can use binary format + [serialization](http://www.tutorialspoint.com/java/java_serialization.htm). It is up to you.   
When launching the game, if **the user has a save, restore it**.  


