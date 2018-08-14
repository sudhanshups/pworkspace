<%@ page language="java" contentType="text/html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>pageForm</title>
</head>
<body>
	<form action="PageServlet" method="get" >
	<table border="1">
		<tr>
			<td>Id</td>
			<td><input name="id" value="${page.id}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>Page Name</td>
			<td><input name="pageName" value="${page.pageName}" /></td>
		</tr>
		<tr>
			<td>Page Query</td>
			<td><input name="pageQuery" value="${page.pageQuery}" /></td>
		</tr>
		<tr>
			<td>Input Column </td>
			<td><input name="inputColumn" id="inputColumn" value="${page.inputColumn}" /></td>
		</tr>
		<tr>
			<td>Output Column </td>
			<td><input name="outputColumn" id="outputColumn" value="${page.outputColumn}" /></td>
		</tr>
		<tr>
		<tr>
			<td>Status </td>
			<td><input name="status" value="${page.status}" /></td>
		</tr>
		<tr>
			<td >
				<input type="submit" name="action" value="Save">
			</td>
			<td >
				<input type="submit" name="action" value="Cancel">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>