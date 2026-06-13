<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	    <title>Normal Plans</title>
	</head>
	<body>
		<h1>Select Normal Plans</h1>
		
		<form:form action="saveNormalPlan" modelAttribute="normalPlan" method="post">
			<form:radiobutton path="data" value="1GB/day"/>
		    1GB/day

		    <br>

		    <form:radiobutton path="data" value="2GB/day"/>
		    2GB/day

		    <br><br>

		    <input type="submit" value="Submit">
		</form:form>
	</body>	
</html>