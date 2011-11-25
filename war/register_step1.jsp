<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Register | QRMOR</title>

<link rel="stylesheet" type="text/css" href="static/style.css" />
</head>

<body>
	<div id="wrap">
		<div id="header">
			<div id="header-content">
				<h1>Register Step 1</h1>

				<form id="form" name="form" action="/register" method="post">
					<div>
						<label for="username">Username:</label> <input type="text"
							name="username" id="username" />
					</div>
					<div>
						<label for="password">Password:</label> <input type="password"
							name="password" id="password" />
					</div>
					<div>
						<label for="password">Password Again:</label> <input
							type="password" name="password2" id="password2" />
					</div>
					<div>
						<label for="androidPhone">Phone Number:<span class="small">Example: 15551234567 SaskTel only</span></label> <input type="text"
							name="phone" id="phone" />
					</div>

					<div>
						<input type="submit" value="Register" />
					</div>
				</form>
			</div>
		</div>

		<div class="line"></div>
	</div>
</body>
</html>