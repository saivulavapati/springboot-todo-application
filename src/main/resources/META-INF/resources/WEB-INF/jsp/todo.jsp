	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	Todo
	<form:form method="post" modelAttribute="todo">
		<form:input type="text" path="userName" hidden="true"/><br/>
		Description: <form:input type="text" path="description"/><br/>
		<form:errors path="description" />
		Target Date : <form:input type="text" path="targetDate"/>
		<form:errors path="targetDate" />
		<button type="submit">submit</button>
	</form:form>
	
	<%@ include file="common/footer.jspf" %>
	
	<script type="text/javascript">
		$('#targetDate').datepicker({
		    format: 'yyyy-mm-dd'
		});
	</script>