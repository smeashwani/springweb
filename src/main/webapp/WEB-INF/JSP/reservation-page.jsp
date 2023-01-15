<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<style>
.error {
	color:red;
}
</style>
<body>
	<form:form action="submitForm"
		modelAttribute="reservation">  
        <spring:message code="label.firstName" text="Name"/>: 
        <form:input path="firstName" />
        <form:errors path="firstName" cssClass="error" />
		<br>
		<br>  
        <spring:message code="label.lName" text="Last Name..."/>: 
        <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
		<br>
		<br> 
		<spring:message code="label.password" text="Password."/>: 
        <form:input path="password" />
        <form:errors path="password" cssClass="error" />
        </br>  
        <spring:message code="label.amount" text="Amount."/>: 
        <form:input path="amount" />
        <form:errors path="amount" cssClass="error" />
        </br> 
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