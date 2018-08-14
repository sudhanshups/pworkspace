<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<jsp:useBean id="per" class="demo.Person" scope="session" />
<jsp:setProperty name="per" property="*" />

<html>

<head>
<title>set demo</title>
</head>
<body>
<h2>
I know yr name .. 
	<a href="getDemo.jsp">test</a>
</h2>

</body>
</html>