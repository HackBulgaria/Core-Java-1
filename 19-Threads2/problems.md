### Synchronize variable access from two threads
Create a Thread `a` and a Thread `b`. 
Inside each of their run methods, just increment a global static variable - named `sharedData` in a for loop. The `for` should loop `1_000_000` times in each thread.   (Each thread should incremend `sharedData` exactly `1_000_000` times.  

Start both threads and wait for them to end.  
See the final value of `sharedData`. Why is this happening?






