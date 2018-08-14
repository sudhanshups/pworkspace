<%@ page language="java" contentType="text/html; charset=UTF-8"
	errorPage="b.jsp"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% String s="Hello"; %>

<%
		int x=10;
		int y=0;
%>




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>a.jsp</title>
</head>
<body>
	<%= x %> /<%=y %>= <%=x/y %>
    <br>
	<h2>
	  This is before forward
	  <br>
	  <!--<jsp:include page="b.jsp"   />-->
	  <br>
	  This is after forward
	</h2>
</body>
</html>