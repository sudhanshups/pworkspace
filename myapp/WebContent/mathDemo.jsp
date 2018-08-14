<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/SimpleTagLibrary.tld" prefix="demo" %>


<c:set var="cities" value="Bengaluru,Chennai,Hyderabad,Kolkata,New Delhi" />



<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="pink">
		<form  name="myform" method="post"   >
  		   Select your City 
  		   <select name="city" onchange="document.myform.submit()" > 
  		   <c:forEach  items="${cities}" var="str" >  
  		   	<option value="${str}" ${str==param.city ?"Selected City= 'selected'" :"" }>${str}</option>
  		   </c:forEach> 
  	 </select>
  	   	 <br>
  	 You selected ${param.city}.
  	 <br>  	 <br>
  	 </form> 
		

		<form  method="post"   >
  		   Num 1 <input type="text" name="num1" value="${param.num1}"> <br>
  		   Num 2 <input type="text" name="num2" value="${param.num2}" > <br>
  		   <input type="submit" name="operator" value="+" > <br>
  		   <input type="submit" name="operator" value="-" > <br>
   		   <input type="submit" name="operator" value="*" > <br>
   		   <input type="submit" name="operator" value="/" > <br>  		 
  	 
  	 </form> 
  	<c:if test="${not empty param.operator }">
  		${param.num1}
  		${param.operator}
  		${param.num2}=${demo:perform(param.num1,param.num2,param.operator)} ;
  	
  	</c:if>
	


</body>
</html>