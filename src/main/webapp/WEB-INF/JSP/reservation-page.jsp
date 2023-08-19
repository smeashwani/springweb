<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<body>
<form:form action="submitForm" modelAttribute="reservation">  
        First name: 
        <form:input path="firstName" />         
        <br><br>  
        Last name: 
        <form:input path="lastName" />  
        <br><br>  
        <input type="submit" value="Submit" />      
    </form:form>
</body>
</html>