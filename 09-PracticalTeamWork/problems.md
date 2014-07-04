### Make an ASCII ART image viewer

![example](http://i.imgur.com/ko5kj6vl.jpg)

You are on the console. Again. You've reinstalled your linux `n` times, but your video driveres can't seem to work properly.   
You've installed the proprietary ones, but then gnome 3 does not seem to like them and crashes with SEGFAULT... somewhere, because of reasons.

A friend of yours has just send you some cool picture link, and you've downloaded it using **wget** or **curl**...but you can't open them.

You'd really, really like to see what the laugh is all about. Something about a horse biting a player? Wtf...

Create yourself your very own ASCII viewer - an application that opens image files and turns them into an ASCII art (prints the ASCII art on the console).
The algorithm for creating ASCII art from images is very simple
```
for each pixel in image
    if intensity(pixel) > 240 put ' ' on console
    if intensity(pixel) between 200 and 240 put '.' on console
    if intensity(pixel) between 160 and 200 put '*' on console
    if intensity(pixel) between 120 and ....
    if intensity(pixel) between 40 and 80 put '#' on console
```
where **intensity** is the average of the red, green and blue components of the pixel's color.
The idea here is that the **closer the color is to black (black is of intesity 0), the darker character you should type on console**.



Your application should take the first argument `args[0]` and interpret it as a file path to the image you want to represent in ASCII art.   

Afterwards, you should read the image to a **BufferedImage** using the `ImageIO.read` method. 
Once that you have a reference to a **BufferedImage**, you should check out the `getRGB(x, y)` method. Using this method, you can get the color of a pixel.

You will see that `getRGB` actually returns an integer. Turn it into a `Color` using `new Color(int rgba, boolean hasAlpha)` method. Ignore alpha for now (use `false` as a second argument)

Now that you have a `Color`, you can get the red, green, and blue components using the `color.getRed()`, `color.getGreen()`, etc. methods.    
**Intensity** is simply `(red + green + blue)/3`.

Test this problem with small images. No more than 300x200 in resolution. Once you've made the above algorithm work, come back here.

##### Additional (not mandatory)
Now, we want to load bigger images.
The problem here is that most consoles do not have 1920 character columns.
A standart monospace console is something like 160 characters. Check how much characters your console supports using `echo $COLUMNS`. Mine supports for instance 204 per line.  

Once you know how much characters they are in a console, you need to **scale down** the output image. (Don't print a character for every pixel, print a character for every block of pixels).

For instance:
You are given an 800x600 image. You know you can show a maximum of 204 pixels (this number will be different for you), so you calculate that you should scale it down **4** times, and give me a 200x150 image. So your block length is 4. 

The algorithm now is almost the same:
```
for y from 0 to numberOfBlocksWidth(image)
    for y from 0 to numberOfBlocksHeight(image)
        avgIntensity = getAvgIntensityForBock(x,y, blockLength);
        if avgIntensity > 240 put ' ' on cosnole
        if avgIntensity > 200 put '*" on console  
        ... and so on
```

For every block of size `blockLength x blockLength`, you output one pixel. That's the idea.
P.S. You don't need to keep the blocks in fields.
P.S.2 Do **not** upscale. Only downscale, if necessary.

The first team that implements the additional scaling part gets a free beer for every member. 

##### GIF Support

Now imagine that you are on the console and you'd like to check the hilarrious gif about Luiz Suarez your mate just send you. Not having a graphical environment should not be a stopper!

How do we play gifs in the console? Simple. We **draw a frame**, we **wait a little bit**, then we **clear** the console and **draw the next frame**.

Use the [JLine library](http://stackoverflow.com/questions/2979383/java-clear-the-console) to clear the console. See `ConsoleReader#clearScreen()`

Use [Kevin Weiner's Gif Decoder class](http://www.java2s.com/Code/Java/2D-Graphics-GUI/DecodesaGIFfileintooneormoreframes.htm) to help you decode the gif frames. Make sure you **leave the copyright/author information intact when using the class!**

Use the `GifDecoder` 's `read`, `getFrameCount` `getFrame(int)` methods in order to play the gif.

In summary:
Modify your application, so that if the **file given in args[0] is a gif file**:
- args[1] will be the gif playing speed (delay between frames drawing). Assume 50 milliseconds if not given.   
- read all the frames from the gif.  
- Show the ascii art for the first frame (print it in the console)  
- Wait a little bit (50 milliseconds **if not given from args[1]** - utilise the `Thread.sleep()` method)
- Clear the console using Jline's `ConsoleReader#clearScreen`.
- Draw the ascii art for the next frame (in the console)

Do this until you are out of frames to draw.
Make an ASCII representation of every frame.


##### Video Support

Come on, let's support video, shall we?

Use the `jcodec` java library for video frame fetching. Focus on the class `FrameGrab` and look around its methods to see how you can use it to gain a frame from a video.
Use and support **.mp4** for videos - we'd like to avoid any decoding issues.

1 video plays (averagely) around 25 frames per second. Once more, implement the following flow:
- args[1] will be the speed (delay between frames) given. Experiment and set a nice default value if the user does not provide a args[1]. It will be different for every laptop, as it is based on decoding speed.
- read the next frame using `FrameGrab`
- print the ascii ART on the console.
- Wait a little bit using `Thread.sleep()`
- Clear the console using Jline's `ConsoleReader#clearScreen`.
- Draw the ascii art for the next frame.
 
Do this until you are out of frames to draw.
Make an ASCII representation of every video frame.

```
BufferedImage frame = null;
while ((image = frameGrab.getFrame())!=null){
    ...
}
```

You can get an instance of `FrameGrab` using the below sinppet:
```
FileInputStream fileInputStream = new FileInputStream(file);
FileChannelWrapper wrapper = new FileChannelWrapper(fileInputStream.getChannel());
FrameGrab frameGrab = new FrameGrab(wrapper);
```

### Details, hints
For both gif and video, you will need to clear the console. Use the `JLine` library - http://jline.sourceforge.net/, and `ConsoleReader#clearScreen` method.

You have to clear the screen before drawing the next frame. 
Your video/gif player should do something like the following
```
while hasFramesToPlay
    String asciiArt = getAsciiRepresentation(frame);
    print(asciiArt);
    Thread.sleep(50); //sleep a little bit
    clearConsole();
```
>>>>>>> 0c7676878dca720a7065eed41348a6db16c8e0a1

### Implement MS paint in java
Create an MS-Paint fullscreen equivallent in java. Implementing only a small subset of the features, of course.
![example](http://i.imgur.com/OrQkzff.png)

##### Project setup
- Create a new java project named 'Paint'
- Create 5 packages:
```
com.hackbulgaria.corejava.paint
com.hackbulgaria.corejava.paint.controller
com.hackbulgaria.corejava.paint.sprites
com.hackbulgaria.corejava.paint.view
com.hackbulgaria.corejava.paint.tools
```
- Craete a class `Main`, residing in `com.hackbulgaria.corejava.paint` (the main package). 
- Now create a class `PaintWindow`, extending `JFrame`.It should reside in `com.hackbulgaria.corejava.paint.view`
- Create a class `PaintController` in `com.hackbulgaria.corejava.paint.controller`
- Create an abstract class `Sprite` in `com.hackbulgaria.corejava.paint.sprites`. It should have these `protected` fields:
```java
int x;
int y; //position
int size; //in pixels
Color color; //By default this should be Color.RED;
```
- - Create getters and setters for all of them. **Please** use the IDE to achieve that.
- - Declare a constructor in Sprite, which accepts all of the 4 arguments described above. **Please** use the IDE to achieve that.
- - Sprite should also have a `public abstract void draw(Graphics graphics)` method. //java.awt.Graphics
- - Create a `DotSprite` class that extends the Sprite class. Override the `draw` method with the following:

```java
	@Override
	public void draw(Graphics graphics) {
		if (color != null) {
			graphics.setColor(color); //set Color to use for FUTURE draw and fill calls
		}
		graphics.fillOval(x, y, size, size);
	}
```
- - Create a constructor in `DotSprite` with the following declaration:

```java
	public DotSprite(int x, int y, Color c) {
		super(x, y, 5, c); //We decide how big a DotSprite will be if we are not given an argument.
	}
```

- - You have a good and complete `Sprite` and `DotSprite` classes? Great!
- Now go to your `PaintWindow` class 
- - Add a private List<Sprite> member like this: `private final List<Sprite> sprites = new ArrayList<>();`
- - Override the paint method like this:
```java
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK); //set color
		g.fillRect(0, 0, getWidth(), getHeight()); //fill the whole window with black

		for (Sprite sprite : sprites) {
			sprite.draw(g);
		}
	}
``` 
- Create an enum `Tool` in your `com.hackbulgaria.corejava.paint.tools` package. The Enum should have two entries (for now): `DOT, SPRAY;`
- Go to your `PaintController` class. Add a `private final PaintWindow window;` member. Add a `	private Tool currentTool;` member.
- - Override the default constructor like that:
```java
	public PaintController() {
		this.window = new PaintWindow();
		window.setTitle("Paint!");
		currentTool = Tool.DOT;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setVisible(true);
                window.setSize(800,600);
         }
``` 
- Go to your main class and your main method. Just create a new instance of `PaintController` like that: `new PaintController()`.
- Run your application. You should see a window  with a 'Paint!' title and black frame.

So far so good? (Whew), okay.
Now, the fun starts here.

###### Get fullscreen mode for your application.
We want to make our paint in fullscreen. See http://docs.oracle.com/javase/tutorial/extra/fullscreen/exclusivemode.html  to check how can you get a full screen exclusive mode.
You've made paint full screen? Excellent.

###### Set a mouse listener (Create an inner class extending MouseAdapter)
Your inner class should reside in the 'PaintController' top-level class.
Override the `mousePressed` method and print 'Mouse click!' at the console to know you've got there.

Once you have this class, in the `PaintController` constructor, using `window.addMouseListener(anInstanceOfYourMouseListenerClass);`
Run your application. Do you see your message when you click on the mouse? Splendid.

###### Draw a point on mouse click.
In your `mousePressed` method, **create a new dot sprite with the x and y of the event received in the method**.
Once you have it, you have to add it the List<Sprite> in your `PaintWindow` class (your `window` field). Create an appropriate `addSprite` method in the `PaintWindow` class in order to able to add the Sprite you created to the list of sprites that are to be drawn.  
Call `window.repaint()` right after you add the Sprite.  

###### Draw a line between two points
Create a `LineSprite` class.
Add your mouse listener insance as a motion listener to the window. 
See `http://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseListener.html` methods. Override the appropriate `MouseListener` methods in order to detect a 'Click, Move, Release' motion and draw a line from mouse 'Click' location to mouse 'Release' location.

###### Clear the screen on right mouse button click
In your `mousePressed` method, check `e.getButton()` and if the event received is for a **right mouse button click**, clear the screen.
Any idea how can you do that? **No graphics/framebuffer/low-level hacking is allowed.**

###### Create a 'spray' tool 
Remember the old 'Spray' tool in MSPaint? Make one like it.
Extend the Sprite class:
 - Draw a point at x, y 
 - If we have a point at x,y, its neighbours are the points {x+1, y+1} {x-1, y-1} {x+1, y-1} {x-1, y+1} {x, y+1} {x, y-1} and so on... let's call them **level-1** neighbours.
 - Choose an n, which will be our **spray-radius**. For every neighbour of {x,y}, from level-1, to level-n neighbour, use `java.util.Random` to decide whether or not you should draw a point there.
 - Make the probability for the point depend on the distance from the center. The farther it is from the center, the less chance it should have of being drawn.

###### Change active tools on a mousewheel
Add a `MouseWheelListener` to the window, so when a mouse wheel event occurs, the `currentTool` gets changed. Implement mouse-wheel switch between drawing a dot and drawing with the spray tool. 

###### Implement a 'undo' functionality on right mouse click.
When I click accidentally the right mouse button, baaam, my drawing is gone.
This sucks. Make it to just undo the last modification.
