<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<html>
<head>

<title>paramDemo</title>
</head>
<body bgcolor="pink">
	<h1>
			<form method="post" >
			Enter name : <input type="text" name ="myname" value="${param.myname }">
			
			<br>
			<input type="submit"  value="Proceed" >
			
			</form>
	
	param expression - <%= request.getParameter("myname") %>
	<br>
	
	${ empty param.myname ?"":"your name is "  } ${ param.myname}
	
	</h1>



</body>
</html>