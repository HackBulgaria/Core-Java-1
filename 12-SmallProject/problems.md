## Project 1 - Design and implement a TicTacToe game (Pair Programming/Github workflow)
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
If a user enters "u", it means 'undo' - the game must revert its previous state - the board just as it was before player 1 has made his bad choice. 
Also, it is also his turn again : )
If a user enters "r", it means 'redo' - the user now wants to undo his undo - resulting in a 'redo' operation.
If a user makes an **undo operation**, and the writes does a new move, the **redo** operations become unavailable.
Design an 'Undo-Redo' solution. You may or may not use the classical [Memento](http://en.wikipedia.org/wiki/Memento_pattern) solution to this problem.	
If you are into it, you can use the [Command pattern](http://gamedevelopment.tutsplus.com/tutorials/let-your-players-undo-their-in-game-mistakes-with-the-command-pattern--gamedev-1391) for this undo redo, but I personally don't recommend that for this task.
 

###### Additional: User inputs
If a user presses **n**, the board is cleared and the game starts all over. **Starting a new game can be undone.**
If a user presses **s**, his game gets saved (see below). 
If a user presses **l**, his game gets loaded (see below). **Loading can be undone** 


###### Additional: Implement a simple save-load mechanism
When the user decides he wants to quit, don't lose his game forever. Save it to a location with a format of your choosing. You can use binary format + [serialization](http://www.tutorialspoint.com/java/java_serialization.htm)   
When launching the game, if the user has a save, restore it.

###### Additional: The most simple AI in the world
Now, it's all cool playing with two players. How about playing against the CPU? 
Read a command-line argument `multiplay`. By default `multiplay` should be false.
Example:
```
java -jar yourJar.jar //launches your game with you playing against the CPU.
java -jar yourJar.jar multiplay //launches your game with 2 players


The 'AI' here is just as complex and smart as Brazil's gameplan against Germany.
###### AI round one: Random moves
Make the stupidest AI on the planet earth. Force your bot to choose a random location. Be wary when choosing locations, you should only use free positions. 

###### AI round two: Random moves + finishing strategy.
Your AI should check if there is a move that he can make that will make him an instant winner. If not, move at random.
