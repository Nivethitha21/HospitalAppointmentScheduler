<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css"/>
<meta charset="ISO-8859-1">
<title>Doctor Details</title>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
     
</head>
<body>
<div id="head">Doctor Details Form</div>
<div id="container">
<form:form action="../doc/saveDoctor" modelAttribute="doctor" method="get">
<form:hidden path="Id" value="${doctor.getId()}"/>
<table>
<tr>
<td> First Name: </td><td><form:input path="firstName" /></td>
</tr>
<tr>
<td> Last Name: </td><td><form:input path="lastName"/></td>
</tr>
<tr>
<td> Phone Number: </td><td><form:input path="phneNum" /></td>
</tr>
<tr>
<td> Speciality: </td><td><form:select path="speciality">
<option value="Gynaecology" label="Gynaecology"/>
<option value="Cardiology" label="Cardiology"/>
<option value="Ophthalmology" label="Ophthalmology"/>
<option value="Pediatrics" label=" Pediatrics"/>
<option value="Physical Theraphy" label="Physical Theraphy"/>
<option value="General Theraphy" label="General Theraphy"/>
</form:select>
</td>
</tr>
<tr>
<td>Available Days:</td>
<td><input type="checkbox" name="Da" value="Monday"/>Monday</td>
<td><input type="checkbox" name="Da" value="Tuesday"/>Tuesday</td>
<td><input type="checkbox" name="Da" value="Wednesday"/>Wednesday</td>
<td><input type="checkbox" name="Da" value="Thursday"/>Thursday</td>
<td><input type="checkbox" name="Da" value="Friday"/>Friday</td>
<td><input type="checkbox" name="Da" value="Saturday"/>Saturday</td>
<td><input type="checkbox" name="Da" value="Sunday"/>Sunday</td>
</tr>
<tr>
<td>Max no of Slots per day: </td>
<td><input type="number" name="slo"/></td>
</tr>
</table>
<br><br>
<input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>