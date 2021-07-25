<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctors</title>
</head>
<body>
<div id="container">
<div id="table-area">
<table class="responsive-table table">
<tr>
<th>ID</th>
<th>Name</th>
<th>Phone Number</th>
<th>Speciality</th>
</tr>
<c:forEach var="doc" items="${dc}">			
<tr>
<td> ${doc.Id}</td>
<td> ${doc.firstName}${doc.lastName} </td>
<td> ${doc.phneNum}</td>
<td> ${doc.speciality}</td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>