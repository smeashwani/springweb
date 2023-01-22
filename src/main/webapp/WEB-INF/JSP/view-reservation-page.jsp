<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>  
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>
	<table border=1>
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Password</td>
			<td>Amount</td>
		</tr>
		<c:forEach var="item" items="${reservationLst}">
			<tr>
				<td><c:out value="${item.firstName}" /> </td>
				<td><c:out value="${item.lastName}" /> </td>
				<td><c:out value="${item.password}" /> </td>
				<td><c:out value="${item.amount}" /> </td>
			</tr>
		</c:forEach>

	</table>
	
	<br>
	<hr>
	<h3>ReservationLstByFirstName</h3>

	<table border=1>
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Password</td>
		</tr>
		<c:forEach var="item" items="${reservationLstByFirstName}">
			<tr>
				<td><c:out value="${item.firstName}" /> </td>
				<td><c:out value="${item.lastName}" /> </td>
				<td><c:out value="${item.password}" /> </td>
			</tr>
		</c:forEach>

	</table>
		<button onclick="send()">send by ajax</button>
<script type="text/javascript">
    function send() {
        var reservation = {
        	    "firstName": "first1",
        	    "lastName": "last1",
        	    "password": "welcome1",
        	    "amount": 100
        };

        $.ajax({
            url: 'http://localhost:8080/reservation/submitFormByRequestBody',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(reservation),
            success: function (data) {
            	location.reload(true);
            },
            error: function() { 
            	location.reload(true);
            }
        });
    }
</script>
</body>
</html>