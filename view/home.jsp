<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styleHome.css"/>
<title>Hospital Management</title>
 <link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
</head>
<body>
<c:url var="docLink" value="/hosp/showDoctorHomePage"></c:url>
<c:url var="patLink" value="/hosp/showPatientHomePage"></c:url>
<c:url var="appoLink" value="/hosp/showAppoHomePage"></c:url>
<table id="tb" >
<tr>
<td><a href="${docLink}">Doctor</a></td>
<td><a href="${patLink}">Patient</a> </td>
<td><a href="${appoLink}">Appointment</a> </td>
</tr>
</table>
<img style="max-width:100%;max-height:75%;" src="<c:url value="/resources/images/ABC.png"/>"/>
</body>
</html>