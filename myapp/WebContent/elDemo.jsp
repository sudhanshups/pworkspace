<%@ page language="java" contentType="text/html" 
isELIgnored="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="/WEB-INF/tlds/SimpleTagLibrary.tld" prefix="demo" %>

<c:set var="str" value="c,c++,java" scope="page" />

<%
	pageContext.setAttribute("x", 5);
	request.setAttribute("x", 7);
%>


<c:set var="x" value="2" scope="page" />
<c:set var="y" value="1" scope="request" />
<c:out value="${x}"></c:out>
<!--<c:remove var="x"  scope="page"/> -->



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL DEmo</title>
</head>
<body>
<h1>
		${'hello from EL' }
		<br>
		1 sum=${ x+4 }
		<br>
		2 sum=${ x }
		<br>
		3 sum=${ x+0 }
		<br>
		4 sum=${ requestScope.x+4 }
		<br>
		5 sum=${ requestScope["x"]+4 }
		<br>
		6 sum=${ requestScope["x"]}${pageScope.x }
		<br>
		7 sum=${ x+y }
		<br>
		7 sum  =${demo:concat(x,y) }
		<br>
		${x}
	<br>
	<c:forEach items="${fn:split(str,',')}" var="i">
	${i } <br>	
	
	</c:forEach>
	<br>
	joining back ${fn:join(fn:split(str,','),':')}

</h1>
</body>
</html>


