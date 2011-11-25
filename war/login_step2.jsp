<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%
	String username = (String) session.getAttribute("username");
	
	if (username != null) {
%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Login Step 2 | QRMOR</title>

<link rel="stylesheet" type="text/css" href="static/style.css" />
</head>

<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			setInterval("checklogin()", 1000);
		});

		function checklogin() {
			$.ajax({
				type : "GET",
				url : "/api/checklogin",
				dataType : "text",

				async : true,
				cache : false,
				timeout : 10000,

				success : function(result) {
					if (result == "true\n")
						window.location = "/secret.jsp";
				}
			});
		}
	</script>

	<div id="wrap">
		<div id="header">
			<div id="header-content">
				<h1>Login Step 2</h1>
				
				<img width='300' height='300' src='/qrcode' />
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