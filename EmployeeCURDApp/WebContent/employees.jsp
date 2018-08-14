<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Employees</title>
</head>
<body>
	<div style="border: 1px solid black">
		Employee Management
	</div>

	<br>
	
	<form action="EmployeeServlet">
		<input type="submit" name="action" value="Add" />
	</form>
	
	<br>

	<table border="1">
		<tr>
			<th>Emp Id</th>
			<th>Emp Name</th>
			<th>Emp Salary</th>
			<th>Date Of Join</th>
			<th>Is Active</th>
			<th>&nbsp;</th>
		</tr>

	<c:forEach var="employee" items="${employees}">
		<tr>
			<td>${employee.empId}</td>
			<td>${employee.empName}</td>
			<td>${employee.empSalary}</td>
			<td>${employee.dateOfJoin}</td>
			<td>${employee.active}</td>
			<td><a href="EmployeeServlet?action=Edit&empId=${employee.empId}">Edit</a>
					<a href="EmployeeServlet?action=Delete&empId=${employee.empId}"
						onclick="return confirm('Are you sure ?');">Delete</a>
			</td>
		</tr>			
	</c:forEach>
	</table>

</body>
</html>