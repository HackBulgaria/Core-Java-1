### Servlet/HelloWorld
- Create an Http Servlet. Override the `doGet` method, and write 'HelloWorld!' to the response's outputStream.
- Run your application on Eclipse ('Run as Server').
- See your own message at 'localhost:8080/YourAppName/YourServletName'
- Make your servlet respond at 'localhost:8080/YourAppName/' (Edit the @WebServlet annotation path to '/')
- See that your servlet now responds at 'localhost:8080/YourAppName/'
- Now undo your change (restore the @WebServlet annotation path).
- Right click on your project -> Java EE tools -> Generate Deployment descriptor stub. 
- - You will now have a 'web.xml' file. It is called a deployment descriptor.
- - Edit the deployment descriptor, and add a first welcome-file tag pointing to 'YourServletName'. We want to register the servlet as a welcome page for your server :)
- Check the 'html source code' returned by your servlet. You will see no HTML tags. Why?
- Write an HTML response to your client. For instance `<h1>Now that's a big title!</h1>`

Congratulations. You've just witnessed what ASP/JSP/PHP is all about. We are not going to do any of that ~~sh**~~ stuff.

