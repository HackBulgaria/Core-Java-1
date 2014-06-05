All of these should go in a project named 'Collections1'
###Check if an expression of brackets is correct###
Such expression is a string like "()()())))((())(" - it has multiple brackets, your job is to check whether the expression is correct.
Such expression is correct if:
- it starts with a '('
- it ends with a ')'
- the number of opening brackets equals exactly the number of closing brackets

TDD, of course.
 
###Reverse a collection###
Declare a method, expecting a Collection of generalized type <? extends Object>, and reverse it in your method.

The argument you accept in your method should be like `Collection<? extends Object> argument`. Ask me about the question mark when you get here if I forget to explain the difference with Collection<Object>.


###Implement an on/off collection###
Implement a Collection, in which, if you add an element twice, it gets removed from your collection.
How would you handle null objects? :)

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
```
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

```

*Part 2*
Now let's gamify this a little bit.
Let us say that you (a fairly decent class `Person`) have an 'energy level' - which some of the tasks take, and some of the tasks actually give back.
For instance, sleeping will give energy, but studying algebra... well, it will take energy. 
You have to not only worry about time now, but about your energy as well.

Example usages:
```
Person me = new Person(100, 11); //100 energy, 11 hours free
ToDoList list = new AdvancedToDoList(me);
list.addTask(new Study



```
