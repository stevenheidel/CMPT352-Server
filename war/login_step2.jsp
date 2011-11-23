<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Login Step 2 | CMPT 352 Project</title>
</head>

<body>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script>
     $(document).ready(function() {
    	 setInterval("checklogin()",1000);
     });
     
     function checklogin() {
	     $.ajax({
	 		type: "GET",
		        url: "/api/checklogin",
		        dataType: "text",
		        
		        async: true,
		        cache: false,
		        timeout: 10000,
		        
		        success: function(result) {
		        	$('#result').html(result + new Date());
		        }
	 	 });
     }
    </script>

	<h1>Login Step 2 | CMPT 352 Project</h1>

	<img width='300' height='300' src='/qrcode' />
	
	<p id="result"></p>
</body>
</html>