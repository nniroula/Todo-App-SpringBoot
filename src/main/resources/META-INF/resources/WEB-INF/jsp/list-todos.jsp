
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<!-- css link copied from Maven dependency folder -->
		<!-- css link location is /META-INF/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css -->
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		
		<title>todos list page</title>
	</head>
	<body>
		<div class="container">
			<div>Welcome ${uname}!
				<!--  <p>You are using @SessionAttributes("value for html name attribute")</p> -->
			</div>
			<br>
			
			<!-- todos variable should come from controller class using ModelMap -->
			<!--  <div> Your TODOs are: ${todosData} </div> -->
			<table class="table">
				<thead> 
					<tr> 
						<th> Id </th>
						<th> Description </th>
						<th> Target Date </th>
						<th> Is it Done </th>
						<!-- empty th corresponds to delete and update buttons -->
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todosData}" var="todo">
						<tr> 
							<td> ${todo.id} </td>
							<td> ${todo.description} </td>
							<td> ${todo.targetDate}</td>
							<td> ${todo.done}</td>
							<!--  delete button and todo item link to delete it-->
							<%-- <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE ${todo.id} </a> </td> --%>
							<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE </a> </td>
							
							<!--  update todo button-->
							<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE </a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add todo</a>
			
			<!--  js links copied from Maven Dependency folder
			links are: 	/META-INF/resources/webjars/bootstrap/5.1.3/js/bootstrap.min.js
						/META-INF/resources/webjars/jquery/3.6.0/jquery.min.js
			-->
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"> </script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"> </script>
			 
		</div>
	</body>
</html>