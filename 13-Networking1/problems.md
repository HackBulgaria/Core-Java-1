### Print your own IP address! 

Print your own IP address in HackBulgaria's wireless network, using the classes `NetworkInterface`, and `InetAddress`.
See http://docs.oracle.com/javase/tutorial/networking/nifs/listing.html for help.

Your netowоrk interface is the one that **is up** and **is not a loopback interface** and **is not a virtual interface**.
If you have more than 1 network interface with those criteria, use the one your internet connection comes from. For example, if you have `wlan0` and `eth0` both connected, but the HackBulgaria network is set at the `wlan0`, pick the `wlan0` device using `getName()` method  

### Find all available hosts in your network
Using the `InetAddress#isReachable()` method find the IP's of every reachable host in your network.



### Create/Implement a simple socket-based RBI backdoor-protocol. (Team work)
`RBI` stands for Remote Bash Invocation - the ability to invoke bash commands from a client to a server. (something like ssh, but simplified) Don't look for RBI on google, I just made it up.  

Craete an **RBI-Protocol**, **RBI-Server** and **RBI-Client** applications.

An **RBI-Server** does the following:
- Accepts an incoming socket connection 
- Retrieves a **command** string from the incoming connections socket's input stream.
- Executes the command using `Runtime.getRuntime().exec` methods
- Logs to the command line the command being executed and the start time of execution.
- Retrieves the output of the command executed.
- Logs to the command line that the command executed has finished and logs the time of execution.
- Writes it back to the incoming connection socket's output stream. 
- The server **supports only one client at a time**
- The server **does not break when the user gets an invalid command**.

An **RBI-Client** does the following:
- Receive a 'server' IP as a command line parameter from `args[0]`;
- Connect to the server ip given.
- Echo a 'Connection successfull' message to the user.
- Accept a user command **from the command line**. 
- Let's say the user enters 'ls /tmp'.
- You need to write the user command to the output stream of your connected socket.
 
The **RBI-Protocol** project **holds** the following:
- A class for all constants related to the protocol. For example, the port the server starts in.
- The 'EOM' (End-of-message) String - you can use something like `<[?!EOM!?]>`
- Holds the logic for **reading an RBI message from a socket** - has a utility method that **receives** a connected socket and returns 1 message from it. If there is no message, return null or block (choice is yours).
- Holds the logic for **writing an RBI message to a socket** - has a utility **void** method that **receives** a connected socket and a message => and writes the message to the socket's output stream.

Hints and tips:
- Both **RBI-Server** and **RBI-Client** projects should **depend on** the **RBI-Protocol** class in their build path (e.g. so they can see the protocol-related constants)
- After every message writing, **append your 'EOM' string**. (Preferably as a new line)
- When you read a message from a socket, **read until you see an 'EOM' line**
- Use `PrintWriter` for writing and be very careful to **flush** all your messages.
- Watch out for blocks: You should know that `read` operations from socket's input stream will **block** if there is nothing in the stream. But if you implement the 'EOM' concept properly, you should have no problem at all. 
- Watch out for firewall-related problems. Temporarily disable your: 
- - Windows firewall, if you have one.
- - MAC OS X firewall, if you have one.
- - `sudo iptables -F` if you are on Linux. (Don't worry, they will be restored on next boot!)
 

##### You are done? Excellent
Can you make the client-server application you've just build in order to **stream the ascii ART representation** of a picture located on your partner's laptop? Use the ASCII art jar you built in the previous sessions.  

What happens when you try to do the same, but with a .gif file instead?

##### Send and receive files
Just adding to our fantasy protocol:
- In **RBI-Client** if the user writes **rbi-send <path-to-file>** the client writes: `<[?!FILENAME?!]>name-of-the-file\n`, gets the file and writes it to the outputstream, after that adding a **newline**. After that, the client adds `<[!?EOM?!]>` on a newline.
- In **RBI-Server** if the server sees a `<[?!FILENAME?!]>` command, it parses it until it sees **end-of-line** symbol, gets all the bytes until it sees a newline. Saves it to a file in `/home/<username>/.RBI/files/file-name` 


##### Implement a simple 'login' procedure as a part of the RBI protocol
Just adding this to our fantasy protocol:
- Every connection starts with the client writing the following:
```
username:MyUserName\n
hash:MyHash
```
- The server parses both the username and the password and decides whether or not to allow the connection:
- For instance, you can check whether the username and hash are contained in a file called `/home/<username>/.RBI/.allowedUsers`. It can be xml, json, .properties, or just plain text. I recommend .properties format + usage of [Apache Commons Configuration](http://commons.apache.org/proper/commons-configuration/userguide/howto_filebased.html#File-based_Configurations), but you can use plain text and parsings if you want to.
- If the server decides **not to** accept the connection, the server writes **Unathorized.\n401** and **closes** the socket.
- If the server decides to accept the connection, the server writes **OK.\n200**.

