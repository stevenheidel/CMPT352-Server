<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Register | CMPT 352 Project</title>
  </head>

  <body>
  	<h1>Register | CMPT 352 Project</h1>
  	
  	<form action="/register" method="post">
	  <div>
	    <label for="username">Username:</label>
	    <input type="text" name="username" id="username" />
	  </div>
	  <div>
	    <label for="password">Password:</label>
	    <input type="password" name="password" id="password" />
	  </div>
	  
	  <div>
	    <label for="androidUUID">Android UUID:</label>
	    <input type="text" name="androidUUID" id="androidUUID" />
	  </div>
	  <div>
	    <label for="androidIMEI">Android IMEI:</label>
	    <input type="text" name="androidIMEI" id="androidIMEI" />
	  </div>
	  <div>
	    <label for="androidPhone">Phone Number:</label>
	    <input type="text" name="androidPN" id="androidPN" />
	  </div>
	  
	  <div><input type="submit" value="Register" /></div>
	</form>
  </body>
</html>