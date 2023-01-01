<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>Your reservation is confirmed successfully. Please, re-check the details.</p>
First Name : ${reservation.firstName}
<br>
Last Name : ${reservation.lastName}
<br>
Gender: ${reservation.gender}
<c:forEach var="meal" items="${reservation.food}">
	<li>${meal}</li>
</c:forEach>
</br> Leaving From : ${reservation.cityFrom}
<br> Going To : ${reservation.cityTo}