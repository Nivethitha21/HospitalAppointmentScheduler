<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ page import = "pack.entity.Appointment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PatientRecord</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styleHome.css"/>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
       type = "image/x-icon">
</head>
<body>
<form:form action="../patient/showPat" ModelAttribute="patList" method="get">
<div id="container">
<div id="table-area">
<table class="responsive-table table">
<tr>
<th> Pat ID</th>
<th>first Name</th>
<th>Last Name</th>
<th>Age</th>
<th>Phone</th>
</tr>
<c:forEach var="doc" items="${patList}">
<c:param name="hospId" value="${pat.hospId}" />
<tr>
<td> ${pat.hospId}</td>
<td> ${pat.firstName} ${pat.lastName}</td>
<td> ${pat.phneNum}</td>
<td> ${pat.Age}</td>
</tr>
</c:forEach>
</table>
</div>
</div>

</form:form>
</body>
</html>