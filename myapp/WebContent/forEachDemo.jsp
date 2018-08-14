<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="person" class="demo.Person" scope="page">  </jsp:useBean>
<jsp:useBean id="students" class="java.util.HashMap" scope="page"> </jsp:useBean>

<% 	pageContext.setAttribute("myarray", new String[]{"c","c++","java"}); %>

<c:set var="myarray"  value="c,c++,java" />
<c:set property="firstName" target="${ person}" value="John" />
<c:set property="lastName" target="${ person}" value="keni" />

<c:set target="${students}" property="103" value="sco"></c:set>
<c:set target="${students}" property="101" value="sam"></c:set>
<c:set target="${students}" property="102" value="sbn"></c:set>
<c:set target="${students}" property="104" value="sdp"></c:set>
<c:set target="${students}" property="105" value="seq"></c:set>



<html>
<head>
<title>for each demo</title>
</head>
<body>
		<h2>		
				<c:forEach items="${students}" var="student">
				${student.key} : ${student.value} 
				<br>
				</c:forEach>
		</h2>
			Name -${person.firstName }${person.lastName }
		<h1>	
				<table border="1">
				<c:forEach items="${myarray}" var="str" varStatus="status">
				<tr bgcolor="${status.count % 2 ==0 ?'pink' :'yellow'}" >
				 <td> ${status.count} </td> 
				 <td> ${str} </td>
				
				</c:forEach>
				</table>
		
				<br>
				<c:forEach var="i" begin="1"  end="10" step="2">
				${i } - I lk <br>
				</c:forEach>
			
		</h1>




</body>
</html>