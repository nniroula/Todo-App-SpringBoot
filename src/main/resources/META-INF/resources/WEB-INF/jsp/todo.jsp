
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			
			<%-- <form method="POST">
				Description: <input type="text" name="description" required="required"/>
				<input type="submit" class="btn btn-success" />
			</form> --%>
			
			<form:form method="POST" modelAttribute="todoinjsp">
				Description: <form:input type="text" path="description" />
				
				<!-- Display errors using form tag library  -->
							<form:errors path="description" cssClass="text-warning" />
				
				<!-- submit button -->
				<input type="submit" class="btn btn-success" />
				
				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="done" />
			</form:form>
		</div>
		
		
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"> </script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"> </script>
	</body>
</html>