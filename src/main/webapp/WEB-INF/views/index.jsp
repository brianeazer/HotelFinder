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
	<h1>Find a Hotel</h1>
	<form action = "/results">
	<select name="city">
		<c:forEach var="city" items="${cities }">
	 		<option value="${city }">${city }</option>
	 	</c:forEach>
		</select>
	<p>Set your max cost here<input name="maxPrice" type="number"></input></p>
  	<button>Submit</button>
  </form>
</body>
</html>

