<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%// page import="" %>

<%
	Boolean loggedin = (Boolean) session.getAttribute("loggedin");
	String username = (String) session.getAttribute("username");
	
	if (loggedin != null && loggedin) {
%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Secret | QRMOR</title>

<link rel="stylesheet" type="text/css" href="static/style.css" />
</head>

<body>
	<div id="wrap">
		<div id="header">
			<div id="header-content">
				<h1>You have successfully logged in as <%= username %>!</h1>
				
				<% if (username.equals("fred")) { %>
				<p>You hacked us! Send an email to steven@heidel.ca with the subject "Nope, just Chuck Testa"</p>
				<p>Please include details so we can fix the problem and contact info so I can send you gift card!</p>
				<% } %>
			</div>
		</div>

		<div class="line"></div>
	</div>
</body>
</html>

<%
    } else {
%>
<p>Not logged in</p>
<%
    }
%>
