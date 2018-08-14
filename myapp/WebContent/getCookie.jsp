<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>get Cookie</title>
</head>

<%
	String value=null;
	Cookie cookies[]=request.getCookies();
	if(cookies!=null &&cookies.length >0){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("mycookie")){
				value=cookies[i].getValue();
				break;
			}
		}
	}
	if(value==null){
	  session.setAttribute("myurl","getCookie.jsp");
%>  <jsp:forward page="name.jsp"/>
<%
	}
%>
<body>
<h1>

	your name  <%=value %>
</h1>

</body>
</html>