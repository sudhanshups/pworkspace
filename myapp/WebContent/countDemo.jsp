<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% Object obj=session.getAttribute("count");
	Integer intObj=(Integer)obj;
	if(intObj==null)
		intObj=new Integer(0);
	int visits=intObj.intValue();
	visits++;
	int seconds = session.getMaxInactiveInterval();
	session.setAttribute("count", new Integer(visits));

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>count Demo</title>
</head>
<body>
	<h1>
	Visits : <%=session.getAttribute("count") %>
	<br>
	<a href="countDemo.jsp">visit Again</a>
	</h1>
	<%= seconds %>

</body>
</html>