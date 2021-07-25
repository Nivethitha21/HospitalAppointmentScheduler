<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import = "pack.entity.docAvail" %>
<%@ page import = "pack.entity.Doctor"%>
<%@ page import = "pack.entity.Appointment"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@page import = "java.util.Calendar" %>
<%@ page import = "java.time.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.time.format.DateTimeFormatter" %>
<% 
Appointment a = (Appointment) request.getAttribute("app");
	Dictionary<String,Integer> dayPair = new Hashtable<String,Integer>();
	dayPair.put("Sunday",0);
	dayPair.put("Monday",1);
	dayPair.put("Tuesday",2);
	dayPair.put("Wednesday",3);
	dayPair.put("Thursday",4);
	dayPair.put("Friday",5);
	dayPair.put("Saturday",6); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule Appointment</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css"/>
<link rel = "icon" href = "${pageContext.request.contextPath}/resources/images/icon.png"
        type = "image/x-icon">
</head>
<body>
<div id="container">
<form:form action="../appointment/submitSlot" method="get" modelAttribute="app">
<h4>Select Convenient Slot</h4>

<input type="hidden" name="appointment" value="<%= a.getAppId() %>"/>

<%List<Doctor> param = (List)request.getAttribute("li");
for(int i = 0;i < param.size();i++){
	Doctor temp = param.get(i);
	List<docAvail> tem = temp.getAvail();
	for(int j = 0;j<tem.size();j++)
	{
		docAvail t = tem.get(j);
		if(t.getSlot()<=0)
			continue;%>
	<input type="radio" name="appoId" value="<%=t.getId() %>" >
	<% 
	LocalDate noww = LocalDate.now();
	DayOfWeek dayof = noww.getDayOfWeek();
	int day = dayof.getValue();
	int dif = dayPair.get(t.getDays())-day;
	if(dif<0)
		dif = 6 - (0-dif);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    LocalDate date2 =  LocalDate.now().plusDays(dif+1);
    formatter.format(date2);
	out.print(temp.getFirstName()+" "+temp.getLastName()+", "+date2+" "+t.getDays()+" "+t.getSlot()+" slots."); %>
	<br><br>
	<%}
}
%>
<input type="submit" value="submit"/>

</form:form>
</div>
</body>
</html>