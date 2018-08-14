<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="per" class="demo.Person" scope="session"></jsp:useBean>
<html>

<head>
<title>Get demo</title>
</head>
<body>
<h2>
			Hello
			<jsp:getProperty name="per" property="firstName"/>
			<jsp:getProperty name="per" property="lastName"/>
</h2>

<h3>
			Using EL Hello
			1 ${sessionScope.per.firstName} ${sessionScope.per.lastName }
			<br>
			2 ${sessionScope.per['firstName']} ${sessionScope.per['lastName'] }
			<br>
			3 ${sessionScope['per'].firstName} ${sessionScope.per.lastName }
			<br>
			4 ${sessionScope['per']['firstName']} ${sessionScope['per']['lastName'] }
			<br>
			5 ${per.firstName} ${per.lastName }
			<br>

</h3>

</body>
</html>