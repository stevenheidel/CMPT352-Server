<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Login Step 1 | QRMOR</title>

<link rel="stylesheet" type="text/css" href="static/style.css" />
</head>

<body>
	<div id="wrap">
		<div id="header">
			<div id="header-content">
				<h1>Login Step 1</h1>

				<form id="form" name="form" action="/login" method="post">
					<div>
						<label for="username">Username:</label> <input type="text"
							name="username" id="username" />
					</div>
					<div>
						<label for="password">Password:</label> <input type="password"
							name="password" id="password" />
					</div>

					<div>
						<input type="submit" value="Login" />
					</div>
				</form>
			</div>
		</div>

		<div class="line"></div>
	</div>
</body>
</html>