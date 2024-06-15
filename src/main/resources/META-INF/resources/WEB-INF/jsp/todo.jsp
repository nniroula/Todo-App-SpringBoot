
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<!-- css link copied from Maven dependency folder -->
		<!-- css link location is /META-INF/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css -->
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		
		<title>Add todo page</title>
	</head>
	<body>
		<div class="container"> 
			<h1>Enter Todo Details</h1>
			
			<form method="POST">
				Description: <input type="text" name="description" />
				<input type="submit" class="btn btn-success" />
			</form>
		</div>
		
		
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"> </script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"> </script>
	</body>
</html>