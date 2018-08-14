<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>
		<%
			 String myArray[]={"C","c++","java","brain","scala","ht"};
		
		%>
		<table border="10" >
		<%  
				for(int i=0;i<myArray.length;i++)
				{
		%>		<tr bgcolor='<%= i%2 ==0 ? "pink": "green" %>' >
		
		       <td> <%= i+1%> </td>
		       <td> <%=myArray[i] %> </td>
		   		</tr>
		<%
		
				}
		%>
		</table>
	    </h1>
</body>
</html>