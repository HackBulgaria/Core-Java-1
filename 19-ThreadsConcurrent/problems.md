### A demonstration of a race condition
Create a project 'Threads'.

Create a static variable `counter`.
Create two threads - A and B.
In their `run()` methods just increment the shared variable 2_000_000 times.

Start the two threads, join them, and print out `counter`. What happens? Why?
Print out the time needed.

##### Introduce critical blocks
Now wrap the incrementing in a synchronized block in each thread. (They should be **synchronized on the same monitor**).
First, wrap the whole `for` statements in a synchronized blocks.

See the result is now correct, and observe the minor performance penalty.

Now, move the synochronized block `inside` the `for` statements.
Notice the increased performance penalty.


##### Replace the synchronized blocks with a call to a synchronized method increment()

##### Replace the synchronized stuff with an AtomicInteger. Notice the performance penalty!

##### Replace the Atomic Integer with wait/notify + mutex variable mechanism
The scenario we want is the following:
- Thread A obtains the mutex (`wait()`s until the mutex is available) 
- Works (increments the integer) 
- Then calls `notify` on the monitor 
- Which fires the Thread B, which does the same 


### Implement a simple blocking queue.
A blocking queue is just like a regular queue, with the difference that if someone calls `poll()` and the queue is empty, the call is blocked until somebody adds an element to the queue. After an element is added, the caller (the one who called `poll()`) gets unblocked and the `poll()` call returns.
