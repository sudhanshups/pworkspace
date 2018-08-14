<%@page import="org.omg.IOP.ExceptionDetailMessage"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; 
 	charset=UTF-8" 
     pageEncoding="UTF-8" 
     isErrorPage="true" 
     %>





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>b.jsp</title>
</head>

		Error occurred in handling yr request 
		<br>
		type : <%= exception.getClass().getName() %>
		<br>
		Reason : <%= exception.getMessage() %>
		<br>
		Content inside b.jsp
		<br>	 
</body>
</html>