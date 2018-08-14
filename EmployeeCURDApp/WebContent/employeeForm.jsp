<%@ page language="java" contentType="text/html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>employeeForm</title>
</head>
<body>
	<form action="EmployeeServlet" method="post">
	<table border="1">
		<tr>
			<td>Emp Id</td>
			<td><input name="empId" value="${employee.empId}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>Emp Name</td>
			<td><input name="empName" value="${employee.empName}" /></td>
		</tr>
		<tr>
			<td>Emp Salary</td>
			<td><input name="empSalary" value="${employee.empSalary}" /></td>
		</tr>
		<tr>
			<td>Date Of Join</td>
			<td><input name="dateOfJoin" value="${employee.dateOfJoin}" />(yyyy-MM-dd)</td>
		</tr>
		<tr>
			<td>Status</td>
			<td><input type="checkbox" name="active" value="${employee.active}"
								 ${employee.active ? 'checked = checked' : ''}"/>Active</td>
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