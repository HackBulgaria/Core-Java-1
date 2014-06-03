###OOP fun!###

###1###
Make a class Car. 
Make several(at least 4) subtypes of Car, representing the different brands of cars - Audi, BMW, Wolkswagen (of course!), etc. 

Implement the toString method, to match the type of the class. For example, an object of type Audi should return "Audi@1f52ac3";

###2###

Make a class `Time` to hold information about the current time and *the current date* .

Make an *easy-to-use* constructor (from client perspective), that would represent the time and date the client wants to hold in your class.

Implement the toString() method, returning the time and date in format : "hh:mm:ss dd.MM.YY". 

Check out String.format method

*Bonus*
Make a factory method `now()` for your class, returning the Time at the present moment :)

See http://en.wikipedia.org/wiki/Factory_method_pattern

###3###

Make a class `Pair`, representing a pair of *Objects* (later we will revisit this with Generics)

Create getter and setter methods for the first and second member of the pair.
http://stackoverflow.com/questions/2036970/how-do-getters-and-setters-work

Implement the toString method, giving a meaningful representation of the class.
Implement the equals method => two pairs are equal if both their members are equal.

###4###

Create and implement a class `StackImpl`, representing a... well, stack. 

Think about all the required (public) operations needed, so that one can use a stack class. You know, stuff like actually pushing an element, popping an element, length, clear, isEmpty, stuff like that. Think about the return types of those operations (see task 5, you may get a hint about one). Extract them all to an *interface*  `Stack`, which your class should implement. 

###5###

Create an implementation of `Stack`, which has the added invariant:
-It does not allow an element to be duplicated. If there is an element 'a' in the stack, and some smart guy pushes 'a' again, his operation should fail, and the smart guy should have a way to know this.


###6###

Implement a (doubly-linked) list (using ints only). Just as before, extract all of its required public operations in an interface. Some of those operations are add, *remove*, size, get(int elementIndex), getHead (getFirst), getTail(getLast), etc. 
Think good and hard about your implementation, and whether you will need another class for a List Node.

###7###
Implement your own `Stack` with your own `LinkedList` class : )

*Bonus* implement a unique stack just as before, but using `LinkedList` and an *anonymous implementation*. 
See http://www.programmerinterview.com/index.php/java-questions/java-anonymous-class-example/

###8###
Make a mutable class 'Matrix' represeting a NxM (integer) matrix. Think good about your constructors, your data. Your goal is to make this class as convenient as possible for the person using it.

Your class `Matrix` should have another cool thing about it => it would allow operations with every pixel.

To do this, make an interface `MatrixOperation`, containing a method 'int withPixel(int x, int y, int[][] matrix)'.
*Think - why are we getting x, y, and the matrix instead of just passing the pixel value?*

Implement the toString(), converting the whole matrix into a String in a way that it would be visible on the console.

`Matrix` should have a method `operate(MatrixOperation op)`, which should call the `withPixel` method for every x and y in the matrix.

Now that you have this, implement:
-a naive binarization filter, using a simple threshold, let's say 127.
-a naive gaussian blur filter, which just averages the color of this pixel by using the colors of its neighbour pixels!

*Bonuses* - Use a *local class* to fetch information about the matrix using the MatrixOperation interface.

Make an implementation of MatrixOperation, that you can use to:
- get average of pixels
- get most used color in the matrix
- get an image histogram of the matrix 

See http://docstore.mik.ua/orelly/java-ent/jnut/ch03_11.htm