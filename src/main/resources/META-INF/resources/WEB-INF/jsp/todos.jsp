<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<h1 class="h5">Todos</h1>
<div class="container">
	<h1>Hello ${userName}</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Completed</th>
				<th></th>
				<th></th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${todosList}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.completed}</td>  
					<td><a href="deleteTodo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					<td><a href="updateTodo?id=${todo.id}" class="btn btn-success">update</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="addTodo"><button class="btn btn-primary">Add Todo</button></a>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>