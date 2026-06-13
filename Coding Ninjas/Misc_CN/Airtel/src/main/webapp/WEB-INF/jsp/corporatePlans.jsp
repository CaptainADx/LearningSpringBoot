<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<html>
<body>

<h2>Select Corporate Plan</h2>

<form:form action="saveCorporatePlan"
           modelAttribute="corporatePlan"
           method="post">

    <form:radiobutton path="data" value="100GB"/>
    100GB

    <br>

    <form:radiobutton path="data" value="200GB"/>
    200GB

    <br><br>

    <input type="submit" value="Submit">

</form:form>

</body>
</html>