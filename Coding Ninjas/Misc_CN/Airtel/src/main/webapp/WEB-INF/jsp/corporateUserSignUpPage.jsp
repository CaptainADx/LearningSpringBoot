<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<body> 
		
		<form:form action="saveCorporateUser" method="post" modelAttribute="corporateUser">
			
			Name: 
			<form:input path="name"/>
			<br/>			
			<br/>
			
			Registration Number:
			<form:input path="registrationNumber" />
			<br/>			
			<br/>

			<input type="submit" value="Submit"/>
			
		</form:form>
		
	</body>
</html>