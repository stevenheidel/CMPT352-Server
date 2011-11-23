<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Login Step 1 | CMPT 352 Project</title>
  </head>

  <body>
    <h1>Login Step 1 | CMPT 352 Project</h1>
    
    <form action="/login" method="post">
	  <div>
	    <label for="username">Username:</label>
	    <input type="text" name="username" id="username" />
	  </div>
	  <div>
	    <label for="password">Password:</label>
	    <input type="password" name="password" id="password" />
	  </div>
	  
	  <div><input type="submit" value="Login" /></div>
	</form>
  </body>
</html>