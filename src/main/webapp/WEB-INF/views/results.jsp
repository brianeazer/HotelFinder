<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is the results page for ${city }. <c:if test="${not empty price}"> You are willing to pay $${price }</c:if>
<c:forEach var="hotel" items="${hotels }">
<p> ${hotel.name } costs $${hotel.pricePerNight} per night</p>
</c:forEach>
<a href="/">Go back</a>
</body>
</html>