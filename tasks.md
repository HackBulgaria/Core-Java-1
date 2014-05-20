##1##
Count words: Make a word histogramme, reading input from file
result: {"Dimitar": 55}
Input from wikipedia

##2##
Check if this list/array is increasing! 


##4##
Contains a digit?

##5##
Design a method, which does the following:
Replaces occurences of a string(A) in another string(B) only on the positions *specified by the caller*

##6##
Design and implement a utility method, that takes a text and returns a set of unique words in it, retaining their ordering in the text

##7##
Design and implement a collection, called 'UniqueList'.
A switch list is a collection that can have an item only once, and *adding the item a second time removes the item*.
Choose an appropriate parent for the class!

##8##
Reduce file path
/home/radorado/code/hackbulgaria/.././../../week0
Use String.replace method, 
Regular expressions.
Your code must not exceed 3 statements.

##9##
Design a hierarchy, describing a file path
/home/radorado/code/hackbulgaria/week0
You have a root element, a parent-child relationship, one element has a lot of children. 
Implement a .parse(String location) which returns a root element of the hierarchy
interface FilePathElement
-String getName()
-String getAbsolutePath()
-int getLevel()

##10##
Sort a list  of fractions
You will be given a list<Pair<Int,Int>> fractions, which you will need to sort.
Make a class, representing a *Fraction*
Implement Comparable OR Implement a comparator

##11##
Make a class representing a Sudoku table.

    Each row contains the numbers from 1 do 9 without repeating a number
    Each column contains the numbers from 1 to 9, without repeating a number
    All 3x3 subgrids contains the numbers from 1 to 9, without repeating a number

class Sudoku
     -isSolved()
     -getNumber(int x, int y)
     -getRow(int y);
     -getCol(int x);
     -getRows();
     -getCols();
     -getSubsquare(int insideX, int insideY);
     -getSubsquare(int index);
     -getSubsquares();

     Row or Col or subsquare: Contains 1 to 9, without repeating a number 

##12##
Using the previous Sudoku structure, solve a sudoku with some holes!
-getListOfAllEmptyPixels
-getRowFor(int x, int y);
-getColFor(int x, int y);
-getSubsquareFor(int x, int y);

##13##
Find duplicating files in a folder tree.
You are given an initial path via main(String[] args).
Find duplicating files:
A Level 1 duplicating files group are two or more files that

##14##
Don't do this!

We need to be tracking some money transactions.
Because we are extremely smart, we will use a file to back it up.
Because we are even more smart, we won't even synchronize the access to the file.

##15##

Implement an interface, TransactionLog
    <strike>-onTransactionStarted(int ammount, Authority authority);</strike>
    -onTransactionStarted(TransactionInfo info);
    -onTransactionFinished(TransactionInfo info);
    operations:
    -getStatus()- are the new logs persisted?

TransactionInfo:
     -int userId;
     -int fromAccountId;
     -int toAccountId;
     -float ammount;
##16##
Design and implement a 'query' API to the 'TransactionLog' task,
which supports the following options:
-sorting by what
-filter by userId, minAmmount
-filter by accountId 

##17##
Think in terms of objects!
Make a class 'Ball'
-size,
-position

Implement the 'BeachBall game, using these mechanics'

##18##
//Implement the 2048

##19##
Design a class to store date and time.
-setSeconds
-setMinutes
-setHour
-set(int, int, int);
-__construct();
Where should you throw an exception?
-toString(): returns "HH:MM:SS".

    hour: between 00 to 23.
    minute: between 00 to 59.
    Second: between 00 to 59.

##20##

Using the given Canvas interface/Canvas factory,
design and implement a simple drawing library
Using the forms from ##X##
-----------------------------
A    B 
   C    D
-----------------------------
A, B, C, D are MOVABLE!
Hints: A class, representing a scene
Register shapes;
for shape s : shapes{
   s.draw(canvas); 
}
-redraw



##X##
Interface or abstract class?
interface Shape implements Drawable
     -getArea()
     -getBounds()
     -getPosition()
     -contains(Point p)
     -contains(Shape s)
     -draw(Canvas c)

class Circle extends Shape

class Rectangle extends Shape

class Square extends Rectangle

class Line extends Shape

class Pollygon extends Shape

class Triangle extends Shape

##21##
Greta has a beauty saloon. Greta has promised a lot of discounts to her friends. But she kind of forgets which friends is from where, and wants you to design her a simple java OOP system to help her track her customers.

Basically, at the end of her service for a customer, Greta wants to be able to easily calculate  easily the total cost she should want, and the total discount she squandered away by easy promises!

Services might vary from a simple foot massage, to nail polishing, to a complex set of services.

BeautyShop
-visit(Service service, Customer c){
    
}

Service => Composite 
-getTotalCost
-getCustomer
-getTotalDiscount

Customer
-name
-CustomerType type
-


test driven, of course!
