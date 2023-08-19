<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
	<form:form action="../reservation/submitForm"
		modelAttribute="reservation">  
        <spring:message code="label.firstName" text="Name"/>: <form:input path="firstName" />
		<br>
		<br>  
        <spring:message code="label.lName" text="Last Name..."/>: <form:input path="lastName" />
		<br>
		<br>   
        Gender:   
        Male <form:radiobutton path="gender" value="Male" />  
        Female <form:radiobutton path="gender" value="Female" />
		<br>
		<br>
        Meals:  
        BreakFast<form:checkbox path="Food" value="BreakFast" />  
        Lunch<form:checkbox path="Food" value="Lunch" />  
        Dinner<form:checkbox path="Food" value="Dinner" />
		<br>
		<br>  
        Leaving from: <form:select path="cityFrom">
			<form:option value="Ghaziabad" label="Ghaziabad" />
			<form:option value="Modinagar" label="Modinagar" />
			<form:option value="Meerut" label="Meerut" />
			<form:option value="Amristar" label="Amristar" />
		</form:select>
		<br>
		<br>  
        Going to: <form:select path="cityTo">
			<form:option value="Ghaziabad" label="Ghaziabad" />
			<form:option value="Modinagar" label="Modinagar" />
			<form:option value="Meerut" label="Meerut" />
			<form:option value="Amristar" label="Amristar" />
		</form:select>
		<br>
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>