<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>setCookie</title>
</head>

<%
	String t1value =request.getParameter("t1");
	if(t1value==null|| t1value.trim().length()==0)
	{
		%>
		<jsp:forward page="name.jsp"/>
		<%
		
	}
	Cookie ck= new Cookie("mycookie",t1value);
	ck.setMaxAge(1*24*60*60);
	response.addCookie(ck);
	Object obj=session.getAttribute("myurl");
	if(obj!=null){
		session.removeAttribute("myurl");
		response.sendRedirect(obj.toString());
	}
	
%>
 
<html>
<body>
 <h1>
 I know name <a href='getCookie.jsp'>test </a>
 
 
 </h1>



</body>
</html>