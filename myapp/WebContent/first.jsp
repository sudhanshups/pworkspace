<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html
    impor; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first jsp page</title>
</head>
<body>

	<h1> welcome to jsp world </h1>
		<br><br>
		REQUEST METHOD:
		<%out.println(request.getMethod()); %>	
		
		<br><br>
         <%=new Date() %>

</body>
</html>