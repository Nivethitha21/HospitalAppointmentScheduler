<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Entry Form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css"/>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
</head>
<body>
<form:form action="../patient/processPatForm" method="get" modelAttribute="patient">
<div id="container">
<table>
<tr>
<td>First Name: </td>
<td><form:input path="firstName"/></td>
</tr>
<tr>
<td>Last Name: </td>
<td><form:input path="lastName"/></td>
</tr>
<tr>
<td>Age: </td>
<td><input type="number" name="age"/></td>
</tr>
<tr>
<td>Phone Number: </td>
<td><form:input path="phneNum"/></td>
</tr>
</table>

<br><br>
<input type="submit" value="Submit"/>
</div>
</form:form>
</body>
</html>