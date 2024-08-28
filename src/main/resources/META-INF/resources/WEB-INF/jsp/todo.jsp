<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
			<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >	
		<title>Manage Your Todo
		</title>	
	<body>
	
		<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
				<a class="navbar-brand m-1" href="https://courses.in28minutes.com">MyGithubRepo</a>
				<div class="collapse navbar-collapse">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
					</ul>
				</div>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
				</ul>	
		</nav>
		
		<div class="container">
			<h1>Enter todo details</h1>
			<form:form method="post" modelAttribute="todo">
			<%--  Description: <input type="text" name="description" 
							required="required "/> --%>
				<fieldset class="mb-3">
					<form:label path="description">Description</form:label></>
					<form:input type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-warning"/>
				</fieldset>
				
				<fieldset class="mb-3">
					<form:label path="targetDate">Target Date</form:label></>
					<form:input type="text" path="targetDate" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning"/>
				</fieldset>
							 
				<form:input type="hidden" path="id" />
				
				<form:input type="hidden" path="done" />
			<input type="submit" class="btn btn-success"/>
			
			</form:form>
		</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		
	</body>
	</head>
</html>