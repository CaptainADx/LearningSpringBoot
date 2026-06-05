<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<body>
	
		<h2>Car Registration Form</h2>

		<form:form action="done" method="post" modelAttribute="car">
		
		    Registration Number :
		    <form:input path="registerationNumber"/>
		    <br><br>
		
		    Car Name :
		    <form:input path="carName"/>
		    <br><br>
		
		    Covered In Warranty :
		    <form:input path="carDetails"/>
		    <br><br>
		
		    Remarks :
		    <form:input path="carWork"/>
		    <br><br>
		
		    <input type="submit" value="Register"/>
		
		</form:form>

	</body>
</html>