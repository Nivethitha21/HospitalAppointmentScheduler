<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetId</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css"/>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
</head>
<body>
<div id="container">
<form:form action="../patient/showPat" method="get">
Patient ID: <input type=number name="patId"/><br><br>
<input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>