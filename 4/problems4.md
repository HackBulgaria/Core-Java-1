All of these should go in a project named 'Collections1'
###Check if an expression of brackets is correct###
Such expression is a string like `"()()())))((())("` - it has multiple brackets, your job is to check whether the expression is correct.
Such expression is correct if:
- it starts with a `'('`
- it ends with a `')'`
- the number of opening brackets equals exactly the number of closing brackets
- at no point in the string the number of closing brackets is higher than the number of opening brackets. E.g. `())(()` is not a valid one, because at index 2 there is a second closing bracket with only one opening bracket.

TDD, of course.

*Hint (and also spoiler)*
Is there a way you can use a *stack* in here?

###Reverse a generic collection###
Declare a method, expecting a Collection and reverse it in your method. Return the same collection given, do not return a new collection!.
Either use:
`static <T> void  reverse (Collection<T> collection)`
or make it a concrete type:
`static void reverse(Collection<Integer> collection)`

*Do not try to use* Collections.reverse. It works only for a List, and not for collections : )


###Implement an on/off collection###
Implement a Collection, in which, if you add an element twice, the element gets removed from your collection.

*Hint and edge case spoiler:* How would you handle null objects? :)
*Fun fact:*: As logical idea behind a collection is an abstraction of a... well, bunch of elements, allowing null actually makes no sense.
Note that the java implementations are broken on several places, allowing nulls to creep into the collections, making all kinds of havoc later on. Don't blindly follow the java implementations, do better.


###Make a bounded queue###
A bounded queue is queue with a 'limit' of maximum elements.
Your `BoundedQueue` class of course should implement the `Queue` interface.
Example usage of your `BoundedQueue` class:
```
BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(3);
boundedQueue.offer(1);
boundedQueue.offer(2);
boundedQueue.offer(3);
boundedQueue.offer(4);
boundedQueue.offer(5);
System.out.println(boundedQueue.toString()); //3,4,5
```

###Rotate the elements of a collection###
Make a void *utility* method that rotates the contents of a collection.

You are given a collection containing `[one, two, three, four, five, six, seven]`
"Rotating" it once means the collection becoming `[seven, one, two, three, four, five, six]`

```java
void rotate(Collection<Integer> collection, int rotateStep )
```

`rotateStep` can be negative - meaning you are rotating to the left, and not to the right.


###Given a list contaning some duplicate values, find the first unique element###
Make a *utility* method, which returns the first unique element in a given argument of type `Collection<Integer>`.
Example:

```java
Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,4,3,1);
System.out.println(yourMethod(ints)) //2;
```


###Given several sets, find the duplicating elements###
Write a *utility* method, that takes several sets, and returns a set that contains the duplicating elements of all the other sets.

```
A = {1,2,3,4,5}
B = {4,5,6}
C = {5,6,7,8}
```

`yourMethd(A,B,C) => D{5}`

###Given a list of Students, sort them by grade###
Lets say you have a `List<Student>`, where a Student is a class, containing two fields: `name` and `grade`.

Sort them by their grades first. Their grades actually are integers => 2,3,4,5,6. If two students happen to have the same grades, sort those two by their names.

###Give me the median, quick!###
Make an interface `Statistics`, which has these operations:

```
-getMean();
-getMedian();
-getMode();
-getRange();
```

If you don't know what Mean,Median, Mode and Range are, see http://www.purplemath.com/modules/meanmode.htm

Make an implementation of this interface, with an additional operation `add(int number)` (Work with integers only).
I would also like to able to look through all the integers I've given you, with a `for(Integer i : isntanceOfYourClass) {... }`.

So, as a client of your code, I will be adding some integers(just like in a list), and would want you to give me the mean, median, mode and range.

*Bonus/Challenge*
Every method from `Statistics` interface should complete in O(1) time.
This is a little bit on the algorithm side, and you might need some interesting data structures : )
Come back to this when you are done with all the tasks.


*Hints*
Solve this one *iteratively* with TDD.


###Implement a class ToDoList###
Imagine you have a world of stuff to do.
Homeworks, courseworks, exams, even preparing for HackBulgaria!
Unfortunately you do not have much time - you need to eat, you need to sleep, you need to have a good time.

Now, you need to sort your priorities right! Make a class `ToDoList`, which supports the following operations:
`void add(Task t)`
`void markFinished(Task t)`
`void markCancelled(Task t)`
`Task getTop()`
`boolean canFinish()`
`int getRemainigTime()` //calculates the time remaining after you've done all of your tasks.

... where `Task` is a class which represents something you have to do. What data/methods should it have? What is common for all the tasks you need to get done?
A `Task` should at the very least have a priority and a time required in order to finish.
You should take an integer in your constructor - the ammount of hours available for each task.

Example usage of your class:

```java
ToDoList todo = new ToDoList(11); //11 hours remaining!
todo.addTask(new StudyForAlgebraTask(10)); //maximum priority!
todo.addTask(new LearnGeometryTask()); //default priority, smaller than 10
todo.addTask(new GoOutTask(1.5f));  //default priority, smaller than 10
todo.addTask(new SleepTask()); //straight 8 hours, of course!

if (todo.canFinish()){
    System.out.println("Woohoo!");
} else {
    System.out.println("I am ...screwed :(");
}

System.out.println(todo.top()) //StudyForAlgebraTask
System.out.println(todo.getTimeNeeded()) //sum of the time needed for every task added in todo list
```

*Hints*
See Comparable and Comparator classes in Java. Check out the PriorityQueue class.
http://javarevisited.blogspot.com/2011/06/comparator-and-comparable-in-java.html

###Make a utility method that converts a hashMap into a very human-readable string###
Make a *utility* method that takes a `HashMap<? extends Object, ? extends Object>`
and *returns a String*, representing the HashMap.

I want you to make a utility method that does this, *do not* to override `toString()` in hashMap.

Example:

```java
String result = YourUtilsClass.yourFirstUtilMethod(map);
System.out.println(result) // { key1:value1, key2:value2, key3:value3 }
```

###Count occurences of words in text###
Make a *utility* method that takes a `String text`  and returns a map, which on every word in `text` maps the number of times this word has been used.

See Example:

```java
Map<String, Integer> result = YourUtilsClass.yourSecondUtilMethod("Ninjas are all over the place! We are all going to die!");
System.out.println(YourUtilsClass.yourFirstUtilMethod(result));
```

Outputs:

```
// { Ninjas: 1, are: 2, all: 2, over: 1, the: 1, place:1, We:1, going:1, to:1, die!:1}
```

Retain the ordering of the elements!

###Cryptoanalysis fun###
