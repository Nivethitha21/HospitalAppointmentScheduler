<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Appointment</title>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
</head>
<body>
<form:form action="../appointment/processUpdate" method="get" modelAttribute="appointment">
<form:hidden path="appId"/>
<input type="hidden" name="appId" value="${appointment.appId }"/>
<table>
<tr>
<td>speciality</td><td><form:select path="speciality">
<option value="Gynaecology" label="Gynaecology" ${appointment.speciality == 'Gynaecology' ? 'selected="selected"':'' }/>
<option value="Cardiology" label="Cardiology" ${appointment.speciality == 'Cardiology' ? 'selected="selected"':'' }/>
<option value="Ophthalmology" label="Ophthalmology" ${appointment.speciality == 'Ophthalmology' ? 'selected="selected"':'' }/>
<option value="Pediatrics" label=" Pediatrics" ${appointment.speciality == 'Pediatrics' ? 'selected="selected"':'' }/>
<option value="Physical Theraphy" label="Physical Theraphy" ${appointment.speciality == 'Physical Theraphy' ? 'selected="selected"':'' }/>
<option value="General Theraphy" label="General Theraphy" ${appointment.speciality == 'General Theraphy' ? 'selected="selected"':'' }/>
</td>
</form:select>
</tr>
<tr>
<td>Severity</td>
<td>
<form:select path="severity">
<option value=1 label="1" ${appointment.severity == '1' ? 'selected = "selected"':'' }/>
<option value=2 label="2"  ${appointment.severity == '2' ? 'selected= "selected"':'' }/>
<option value=3 label="3"  ${appointment.severity == '3' ? 'selected= "selected"':'' }/>
<option value=4 label="4"  ${appointment.severity == '4' ? 'selected= "selected"':'' }/>
<option value=5 label="5"  ${appointment.severity == '5' ? 'selected= "selected"':'' }/>
</form:select></td>
</tr>
</table>
<input type="submit" name="book" value="Change Slot">
</form:form>
</body>
</html>