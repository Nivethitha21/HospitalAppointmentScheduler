<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
</head>
<body>
<h1> Enter Known details to Search</h1>
<form action="../doc/searchDoctor" method="get">
<table>
<tr>
<td><input type="number" name="id" value=-1 placeholder="Enter DOCTOR ID"/></td></tr>
<td><input type="text" name="firstName" value ="" placeholder="Enter first name"/></td></tr>
<tr><td><input type="text" name="lastName" value ="" placeholder="Enter Last name"/></td></tr>
<tr><td><input type="text" name="phneNum" value ="" placeholder="Phone Number"/></td></tr>
<tr><td> Speciality: </td>

<td><select name="speciality">
<option value="" label="    "/>
<option value="Gynaecology" label="Gynaecology"/>
<option value="Cardiology" label="Cardiology"/>
<option value="Ophthalmology" label="Ophthalmology"/>
<option value="Pediatrics" label=" Pediatrics"/>
<option value="Physical Theraphy" label="Physical Theraphy"/>
<option value="General Theraphy" label="General Theraphy"/>
</select>
</td>
</tr>
<tr>
<td> Available Days: </td>
<td><input type="checkbox" name="Da" value="Monday"/>Monday</td>
<td><input type="checkbox" name="Da" value="Tuesday"/>Tuesday</td>
<td><input type="checkbox" name="Da" value="Wednesday"/>Wednesday</td>
<td><input type="checkbox" name="Da" value="Thursday"/>Thursday</td>
<td><input type="checkbox" name="Da" value="Friday"/>Friday</td>
<td><input type="checkbox" name="Da" value="Saturday"/>Saturday</td>
<td><input type="checkbox" name="Da" value="Sunday"/>Sunday</td>
</tr>
</table>
<br><br>
<input type="submit" value="Search"/>
</form>
</body>
</html>