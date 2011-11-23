<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.PreparedQuery" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>CMPT 352 Project</title>
  </head>

  <body>
    <h1>Index | CMPT 352 Project</h1>
	
    <p><a href="/login_step1.jsp">Login</a></p>
    <p><a href="/register.jsp">Register</a></p>
    
    <h2>User List</h2>
    
    <ul>
    <%
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	Query query = new Query("User");
    	PreparedQuery pq = datastore.prepare(query);
    	
    	for (Entity user : pq.asIterable()) {
    		%>
    		<li><%= user.getProperty("username") %></li>
    		<%
    	}
   	%>
   	</ul>
  </body>
</html>
