
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>welcome to todos list page</title>
	</head>
	<body>
		<div>Welcome ${uname}! 
			<hr>
			<p>You are using @SessionAttributes("value for html name attribute")</p>
		</div>
		
		<!-- todos variable should come from controller class using ModelMap -->
		<div>
			Your TODOs are: ${todosData}
		</div>
		
		<table>
			<thead> 
				<tr> 
					<th> Id </th>
					<th> Description </th>
					<th> Target Date </th>
					<th> Is it Done </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todosData}" var="todo">
				 <tr>${todo.username} </tr>
					<tr> 
						<td> ${todo.id} </td>
						<td> ${todo.description} </td>
						<td> ${todo.targetDate}</td>
						<td> ${todo.done}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>