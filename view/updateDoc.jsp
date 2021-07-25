<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ page import = "pack.entity.Appointment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update doctor</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styleHome.css"/>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
       type = "image/x-icon">
</head>
<body>
<form:form action="../doc/showDoc" ModelAttribute="docList" method="get">
<div id="container">
<div id="table-area">
<table class="responsive-table table">
<tr>
<th> DOC ID</th>
<th>Name</th>
<th>Phone Number</th>
<th>Speciality</th>
<th>Action</th>
</tr>
<c:forEach var="doc" items="${docList}">
<c:url var="updateLink" value="/doc/showDoc">
<c:param name="id" value="${doc.id}" /></c:url>	
<c:url var="deleteLink" value="/doc/showDelDoc">
<c:param name="id" value="${doc.id}" /></c:url>	
<tr>
<td> ${doc.id}</td>
<td> ${doc.firstName} ${doc.lastName}</td>
<td> ${doc.phneNum}</td>
<td> ${doc.speciality}</td>
<td><a href="${updateLink}">Update</a> |
 <a href="${deleteLink}"onclick="if (!(confirm('Are you sure you want to Cancel this Appointment?'))) return false">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>

</form:form>
</body>
</html>