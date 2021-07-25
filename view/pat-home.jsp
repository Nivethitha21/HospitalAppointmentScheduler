<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/styleHome.css"/>
<meta charset="ISO-8859-1">
<title>Patient Home Page</title>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
        <style>
body
{
background-image:url("${pageContext.request.contextPath}/resources/images/white.jpg");
 background-size: cover;
background-attachment: fixed;
background-repeat: no-repeat;
}
</style>
</head>
<body>
<c:url var="homeLink" value="/hosp/home"></c:url>
<div>
<a href="${homeLink }"/><img style="max-width:100%;height:90px;float:left;" src="<c:url value="/resources/images/healthh.png"/>"/></div>
<input type="button" value="Add new Patient" 
onclick="window.location.href='../patient/showFormForAdd';return false" class="add-button"/>
<!-- <input type="button" value="Search Patient" 
onclick="window.location.href='showFormForAdd';return false" class="add-button"/> -->
<input type="button" value="Show Patient" 
onclick="window.location.href='../patient/showPatient';return false" class="add-button"/>
<input type="button" value="Create Appointment" 
onclick="window.location.href='../patient/showFormForAppC';return false" class="add-button"/>

</body>
</html>