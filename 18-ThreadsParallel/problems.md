### Paralel minimal point calculations

Create a static method `generatePoints()` which returns a `List<Point>` - `java.awt.Point`   
Implement it, generating a 100 000 points (in java that is written `100_000`) points with random coordinates - ranging from 0 to 10_000.

Now, for each of those points, I'd like you to find it's nearest point. Do this in a method `Map<Point,Point> getNearestPoints(List<Point> generatedPoints)`  

As you can see, it takes a while. By my calculations, it should take like 100-250 seconds to complete (depending on your CPU speed).  

Now introduce some multithreading to speed it up.  
Declare and implement a method `doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap)`.
Move your calculations logic from `getNearestPoints` to `doCalculations`, but work strictly from `indexFrom`, to `indexTo`. 

Now in your `getNearestPoints(List<Point> generatedPoints)` method, start two Threads that call `doCalculations`, in their run methods, one from 0 to half of the elements, the other from half of the elements to the last of them.

Measure speedup between the two implementations (See `System.currentTimeMillis()`).

Introduce a third and forth thread. Does your implementation go faster?

###  Paralel web crawler

You remember your webcrawler project, right?   
There is a bottleneck in it - while you are waiting for an answer from the server, your CPU does nothing.   
Now, if you were to make several requests at once, it would be better.

Try io crawl 9gag.com, for instance, and print every page you've visited. See the speed is not that great.
Now Introduce parallelisation and speed up in your solution. Use an approach similiar to the approach for task #1.

If your web crawler project is not working, use the one in this github folder instead. (It's a Maven project, you will need to fetch all dependencies).
