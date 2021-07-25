<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page import = "pack.entity.Appointment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointments</title>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png" type = "image/x-icon">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styleHome.css"/>
</head>
<body>
<c:url var="homeLink" value="/hosp/home"></c:url>
<div id="head">
<a href="${homeLink }"/><img style="max-width:100%;height:90px;float:left;" src="<c:url value="/resources/images/healthh.png"/>"/></a><h5>APPOINMENTS</h5></div>
<form:form action="../appointment/formSub" modelAttribute="appointment" method="get">
<input type="submit" value="AutoSchedule" name="autoSchedule" onclick="window.location.href='../appointment/autoschedule';return false" id="left" class="addd-button"/>
<input type="submit" value="Mark Selected as completed" name="mark" id="right" class="addd-button"/>
<div id="container">
<div id="table-area">
<table class="responsive-table table">
<tr>
<th></th>
<th>Appointment ID</th>
<th> Patient ID</th>
<th>Doctor ID</th>
<th>Speciality</th>
<th>Severity</th>
<th>Appointment Day</th>
<th>Action</th>
</tr>
<c:forEach var="app" items="${appointment}">
<c:url var="updateLink" value="/appointment/showFormForUpdate">
<c:param name="appId" value="${app.appId}" /></c:url>	
<c:url var="deleteLink" value="/appointment/deleteAppointment">
<c:param name="appId" value="${app.appId}" /></c:url>				
<tr>
<td><input type="checkbox" name="completed" value="${app.appId}" /></td>
<td> ${app.appId}</td>
<td> ${app.patId}</td>
<td> ${app.docId}</td>
<td> ${app.speciality}</td>
<td> ${app.severity}</td>
<td> ${app.appDay}</td>
<td><a href="${updateLink}">Update</a> |
 <a href="${deleteLink}"onclick="if (!(confirm('Are you sure you want to Cancel this Appointment?'))) return false">Cancel</a></td>

</tr>
</c:forEach>
</table>
</div>
</div>
</form:form>

</body>
</html>