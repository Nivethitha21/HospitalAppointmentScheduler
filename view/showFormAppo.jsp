<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page import = "pack.entity.Patient"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css"/>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
</head>
<body>

<form:form method="get" action="../appointment/processPatFormA" modelAttribute="patient">
<div id="container">
<form:hidden path="hospId" value="${patient.hospId }"/>
<h3 style="red"><b>Hospital Id:</b> ${patient.hospId }</h3>
<h3 style="red"><b>Name:</b> ${patient.firstName} ${patient.lastName }</h3>
<h3 style="red"><b>Age:</b>${patient.age}</h3>
 Speciality: <select name="speciality">
<option value="Gynaecology" label="Gynaecology"/>
<option value="Cardiology" label="Cardiology"/>
<option value="Ophthalmology" label="Ophthalmology"/>
<option value="Pediatrics" label=" Pediatrics"/>
<option value="Physical Theraphy" label="Physical Theraphy"/>
<option value="General Theraphy" label="General Theraphy"/>
</select>

<br><br>
Severity: <select name="severity">
<option value=1 label="1"/>
<option value=2 label="2"/>
<option value=3 label="3"/>
<option value=4 label="4"/>
<option value=5 label="5"/>
</select>
<input type="submit" name="book" value="book Slot"/><br>
<input type="submit" name="submit" value="Submit"/>
</div>
</form:form>

</body>
</html>