### Declare an annotation type 'ClassInfo'
It should contain information about:
- author of the class
- revision of the class (by default it should be 1)
- should the class be 'checked' (by default it should be) //this 'checked' thing is a bogus one, I just made it up so you can use a boolean default 
- an array of 'related' classes (Class<?>[])

- Annotatate a class with this annotation. Fill in the 'required' information
- In a main method, instantiate the annotated class. Using the `getClass().getAnnotations()`, print out all the annotations declared for your annotated class.
- Now fetch your own annotation using `yourInstance.getClass().getAnnotation(YourAnnotationName.class);`
- Print out all the filled information 


###1. Create a Box class

A Box class can hold an instance. 

```java
Box<Integer> box = new Box<>();
box.set(3);
System.out.println(box.get()); //=>3


Box<String> box = new Box<>("this example belongs to Oracle");
System.out.println(box.get()) //"this example belongs to  Oracle"
```

Demonstrate the usage of the class you wrote in a main method, setting an `Integer`, a `String`, and a `List<String>` list to the box.

###2. Create a Pair<F,S> class
**F** stands for first, **S** stands for second.

```java
Pair<Integer,String> pair = new Pair<>();
pair.setFirst(3);
pair.setSecond("string");

System.out.println(pair.toString()); //=> <3, "string"> (Implement the to string method as well) 
System.out.println(pair.first()); //=> 3 (first() here returns an *Integer*, not an *Object*!)
System.out.println(pair.second()); //=> "string"

Pair<Integer, String> pair = new Pair<>(3, "string");
System.out.println(pair.toString()); //=> <3, "string"> 
```

Demonstrate the usage of your Pair class in a similiar manner.

###3. Write a static newInstance method
Declare a method that receives a Class<T> clazz, and returns a new instance of T. See http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#newInstance--


###4. Write a 'Favourites' class
Write a class `Favourites`, with which I can do the following:
```java
Favourites favourites = new Favourites();
favourites.add(String.class, "myString");
favourites.add(Integer.class, 3);

System.out.println(favourites.get(Integer.class)) => //3
```
No compile time warnings : )  
Hints: See `cast` method on `Class` class. There is more than 1 solution to this task.


Demonstrate the usage of your class.  

Can you make the `Favourites` class iterable? No casts/ compiler warnings allowed : )

###5. Write an 'Arrays.asList' - like method.
```java
List<Integer> ints = asList(1,2,3,4,5);
List<String> strings = asList("1","2","3","4","5");

//also, give an explanation to what is happening in the lines below :)
List<?> whatIsThis = asList(null,null,null);
List<Object> hahaaah = asList(null,null,null);
List<Integer> didNotExpectThisWTF = asList(null,null,null);
List<Number> nowWhat = YourClass.<Number> asList(null,null,null);
```


###6. Write a class NaturalNumber that works with Integer, Short or Long
```java
NaturalNumber<Long> n1 = new NaturalNumber<>(12341541L);
NaturalNumber<Integer> n2 = new NaturalNumber<>(123);
NaturalNumber<Short> n3 = new NaturalNumber<>((short) 122);

System.out.println(n1.isEven()); //false;
System.out.println(n2.isEven()); //false;
System.out.println(n3.isEven()); //true;

NaturalNumber<String> n4 = new NaturalNumber<>("1231516"); //compile-time error!
```
Use a combination of wildcards(?), and the `Number` class to make the above functionality work. Check out `Number`'s methods : )

###7. Implement a `greaterThan` method that returns all the items in a collection 'arg1', that are greater than 'arg2'.
Your method should receive two parameters - a Collection of some type. 
Hint: Your type parameter should extend Comparable<T>

```java 
Collection<Integer> all = Arrays.asList(1,2,3,4,5,6,7);
Collection<Integer> filtered = yourMethod(fitered, 5); //6, 7
```
Demonstrate the usage of your program.



