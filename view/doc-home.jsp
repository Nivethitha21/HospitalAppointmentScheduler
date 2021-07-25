<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctors</title>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styleHome.css"/>
</head>
<body>
<c:url var="homeLink" value="/hosp/home"></c:url>
<div>
<a href="${homeLink }"/><img style="max-width:100%;height:90px;float:left;" src="<c:url value="/resources/images/healthh.png"/>"/></div>
<div>
<input type="button" value="Add Doctor" 
onclick="window.location.href='../doc/showFormForAdd';return false" class="add-button"/>
<!-- <input type="button" value="Search Doctor" 
onclick="window.location.href='../doc/showFormForSearch';return false" class="add-button"/> -->
<input type="button" value="Show Doctor" 
onclick="window.location.href='../doc/updateDoc';return false" class="add-button"/>
</div>
</body>
</html>