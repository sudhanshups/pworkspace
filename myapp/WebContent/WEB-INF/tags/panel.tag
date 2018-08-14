<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"  %>
<%@attribute name="color"	required="false"  %>
<%@attribute name="bgcolor" required="false"  %>

<table border="1" bgcolor="${color}">
	<tr> 
	<td> <b> ${title}</b> </td>
	</tr>
	<tr>
	<td bgcolor="${bgcolor}">
	<jsp:doBody/>
	</td>
	</tr>
</table>