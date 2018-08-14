<%@ page language="java" contentType="text/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	var statusColumnCount = 1;
	function addNewQuery() {
		document.getElementById('pageQuery').value = getQuery();
		return true;
	};
	function addNewStatusColumn() {
		var statusTableDOM = document.getElementById("#" + "statusRow-"
				+ statusColumnCount);
		statusColumnCount++;
		statusTableDOM
				.append("<tr> <td> Column </td> <td>:</td> <td><input type='text' id='statusColumn-'+ statusColumnCount name='statusColumn-' + statusColumnCount> </td>"
						+ "<td> Value </td> <td>:</td> <td><input type='text' id='statusValue-'+ statusColumnCount name='statusValue-' + statusColumnCount> </td> "
						+ "</tr>"
						+ "<tr id = 'statusRow-' + statusColumnCount> </tr>");
	};
	function getQuery() {
		var searchQuery = '';
		searchQuery = "SELECT " + document.getElementById("outputColumn").value
				+ " FROM " + document.getElementById("tableName").value
				+ " WHERE ";

		var whereConditionColumns = document.getElementById("inputColumn").value
				.split(',');
		var whereCondition = '';
		for ( var i in whereConditionColumns) {
			whereCondition += whereConditionColumns[i]
					+ "= <" + whereConditionColumns[i] +"> AND ";
		}
		whereCondition = whereCondition.substring(0, whereCondition
				.lastIndexOf("AND"));
		searchQuery += whereCondition;

		var additionalCondition = '';
		if (document.getElementById("statusValue-").value != '') {
			var value = parseInt(document.getElementById("statusValue-").value) ? parseInt(document
					.getElementById("statusValue-").value)
					: "'" + document.getElementById("statusValue-").value + "'";
			additionalCondition = document.getElementById("statusColumn-").value
					+ " = " + value;
		}
		if (additionalCondition != '')
			searchQuery += " AND " + additionalCondition;
		//document.getElementById("pageQuery").value = searchQuery;
		return searchQuery;
	}
</script>
<head>
<title>Eagle Eye New Query Form</title>
</head>
<body>
	<form id="form1" action="PageServlet" method="get" onsubmit="addNewQuery();">
		<div align="middle" style="font-size: 200%">Admin</div>
		<table align="center">
			<tr>
				<td>Id</td>
				<td>:</td>
				<td><input name="id" value="${page.id}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Query Name</td>
				<td>:</td>
				<td><input type="text" name="pageName" value="${page.pageName}">
				</td>
			</tr>
			<tr>
				<td>DB Server name</td>
				<td>:</td>
				<td><input type="text" id="dbServerName" name="dbServerName"
					value='DBGEARDEVNYC'></td>
			</tr>
			<tr>
				<td>Table name</td>
				<td>:</td>
				<td><input type="text" id="tableName" name="tableName"
					value='database.schema.table_name'></td>
			</tr>
			<tr>
				<td>Input Columns</td>
				<td>:</td>
				<td><input type="text" id="inputColumn" name="inputColumn"
					value="${page.inputColumn}"></td>
			</tr>
			<tr>
				<td>Output Columns</td>
				<td>:</td>
				<td><input type="text" id="outputColumn" name="outputColumn"
					value="${page.outputColumn}"></td>
			</tr>
			<tr>
				<td>Additional Condition</td>
				<td>:</td>
				<td>
					<table id="status">
						<tr>
							<td>Field</td>
							<td>:</td>
							<td><input type="text" id="statusColumn-"
								+ statusColumnCount name="statusColumn-" + statusColumnCount></td>
							<td>Value</td>
							<td>:</td>
							<td><input type="text" id="statusValue-" + statusColumnCount
								name="statusValue-" + statusColumnCount></td>
						</tr>
						<tr id="statusRow-" + statusColumnCount>
						</tr>
					</table>
				</td>
				<td style="display: none">
					<button id="addNewStatusColumn" onClick="addNewStatusColumn()">
						+</button>
				</td>
				<td style="display: none">
					<button id="removeAStatusColumn" onClick="removeAStatusColumn()">
					</button>
				</td>
			</tr>
			<tr>
				<td>Is Active</td>
				<td>:</td>
				<td><input type="text" id="status" name="status"
					value="${page.status}"></td>
			</tr>
		</table>
		<div align="center">
			<input type="submit" name="action" value="Save"> </input>
			<input type="submit" name="action" value="Cancel"> </input>
		</div>
		<br>
		<button type="button"
			onclick="document.getElementById('pageQuery').value = getQuery()">Click
			to see Query Formed</button>
		<textarea name="pageQuery" id="pageQuery" value="${page.pageQuery}"
			cols="40" rows="5"></textarea>
	</form>
</body>
</html>