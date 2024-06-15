<!DOCTYPE html>

<html>
	<head>
		<title>Login jsp page</title>
	</head>
	<body>
		<div class="container">
			<h3>Welcome to login page!</h3>
			
			<!-- Error Message for Unsuccessful login  -->
			<pre>${error}</pre>
			
			<form method="post">
				<label for="usernameLabel"> <b>User name:</b> </label>
				<input id="usernameLabel" type="text" name="uname" placeholder="enter username">
				<br>
				<label for="passwordLabel"> <b>Password:</b> </label>
				<input id="passwordLabel" type="password" name="pass" placeholder="enter password">
				
				<input type="submit">
			</form>
			
		</div>
		
	</body>
</html>