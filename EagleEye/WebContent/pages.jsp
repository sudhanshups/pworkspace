<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Eagle Eye</title>
</head>
<body>
	<div style="border: 1px solid black">
		Eagle Eye Management
	</div>

	<br>
	
	<form action="PageServlet">
		<input type="submit" name="action" value="Add" />
	</form>
	
	<br>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Query</th>
			<th>Input Column</th>
			<th>Output Column</th>
			<th>Status </th>
			<th>Action</th>
		</tr>

	<c:forEach var="page" items="${pages}">
		<tr>
			<td>${page.id}</td>
			<td>${page.pageName}</td>
			<td> <c:out value="${page.pageQuery}" escapeXml="true"/> </td>
			<td>${page.inputColumn}</td>
			<td>${page.outputColumn}</td>
			<td>${page.status}</td>
			<td><a href="PageServlet?action=Edit&id=${page.id}">Edit</a>
				<a href="PageServlet?action=Delete&id=${page.id}"
				   onclick="return confirm('Are you sure ?');">Delete</a>
			</td>
		</tr>			
	</c:forEach>
	</table>

</body>
</html>