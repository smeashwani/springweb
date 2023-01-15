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
</body>
</html>