### Part1 - Java theoretical(knowledge-based) test

###### What are the differences between a 'wrapper class' and a 'primitive type' in Java? What is autoboxing and autounboxing?

###### How many types of Exceptions do you know? When do we use them?

###### What is the relation between Throwable, Exception, and Error?

###### Explain the semantics of try-catch-finally.

###### Explain the difference between a LinkedList and ArrayList in java.

###### What is the difference between an interface and an abstract class (Java 7)?

###### What is the difference between JDK and JRE?

###### Explain how arguments are 'passed' to methods in java. What happens if the argument is a primitive type? What happens if it is an instance type? Write an example

###### Explain the contract between hashCode() and equals()

###### Explain the access modifiers public, protected, /*default*/, private

###### What does a 'final' class mean? What happens when I declare a variable 'final'? When I declare a field 'final'? 

###### Explain the difference between Thread.start() and Thread.run()

###### Tell me what you know about InterruptedException. 

###### How do I stop a thread in java?

###### Why can I not make 'new T()' in java? (where T is a generic type here)

###### Explain the wait-notify mechanism in Java - preferably with an example.

###### When should we use an Enum?

###### Explain what happens when you instantiate a type, e.g. 'new A()'. Explain the process as thoroughly as you can.

###### Where can I use a 'for-each' loop in java?

###### Write-out some of the methods defined in Object

###### Draw a picture of the 'Collections' hierarchy -as much as you can remember.

### Part2 - Interesting language-agnostic questions

###### Explain what happens when you enter a URL in the address bar of your browser and press 'Enter'. Explain as thoroughly as you can.

###### Give an example of a deadlock using only 'synchronized' statements (or semaphor/mutexes, if you prefer). For just 2 threads.

###### Explain the Iterator pattern. What does it help us achieve? Why is it used? Give as much (relevant) information as you can. (C#/Java/C++ details don't matter).

###### You have a website, but sometimes the server crashes. You want to know the moment it does, and ensure it restarts. What would you do?

###### Explain what a garbage collector system does. Explain the difference between finalizers(Java) and destructors.

######* Give an example where Java/C# code would be faster than code in C++.

######* Give an example where Java/C# code would be particulary painstakingly slower than C/C++

### Part3 - Coding problems - use Java or close-to-Java pseudocode

###### Reverse every word in a sentence. "This is a string" => "sihT si a gnirts" 

###### You are given a list of numbers - {1,2,3,4,5,7,19,23,3,2}.
- 1) Retain only the unique items from the list. 
- 2) Get only the duplicating numbers. 
- 3) Get only the first non-duplicating element  

###### You are given a sorted, but rotated array. For instance, A = {3,4,5,6,7,1,2,3}
Find all the indices of a given number, for instance `yourFunction(3, A) => {0,7} .

###### You are given two (singly) linked lists -A and B. Can you check whether A merges in B? (Whether A and B have a common element). Give the fastest algorithm you can come up with.

### Part 4 - Practical OOP
You have several fields in a web registration form.  
Let's say name, email, secondary email, personalHosting, phone, etc. (Secondary email = email that should be used in case you don't answer your first email.)
You need to validate user input from them.   

Validation rules:   
- For `personalHosting` - it should just have a valid hostname and a TLD(that's a .bg, .com, etc). For instance `abv.bg` is a valid field entry. Notice http:// or https:// is not mandatory.
- For `name` - it should not contain numbers 
- For `phone` - it should contain numbers only.
- For `secondary_email` - it should just *be a valid email => it should have some letters/digits, a `@` sign, and a hostname and a TLD.
- For `email` - it should both *be a valid email* and *it should not be already taken* (imagine you can do a `boolean isAlreadyTaken(String email)` written for you.

Your code is activated like this:
```java
boolean validate(FieldType field)
//FieldType is an enum containing PERSONAL_HOSTING, NAME, PHONE, SECONDARY_EMAIL, EMAIL

```
Give a good OOP solution for the cases described, aiming to avoid code/logic duplication. It should scale well when a new 


 

