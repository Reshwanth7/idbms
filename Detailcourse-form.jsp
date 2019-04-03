<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.resh.jdbc.*"%>

<!DOCTYPE html>
<html>
<head>
<title>student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">

</head>
<body>
<div id="wrapper">
<div id="header">
<h2>UMKC</h2>
</div>
</div>

<div id="container">
<h3>Student Detail</h3>


<table>


<tbody>



<tr>
<td><label>Marks:</label></td>
<td><input type="text" name="marks" value="${Details.marks }"/></td>
</tr>
<tr>
<td><label>Attendance:</label></td>
<td><input type="text" name="attendance" value="${Details.attendance }"/></td>
</tr>




</tbody>

</table>
<div style="clear: both;"></div>
<p>
<c:url var="studenttemplink" value="StudentControllerServlet">
	<c:param name="command" value="LIST"/>
	</c:url>
<a href="${studenttemplink}">Back to List</a>
</p>
</div>
</body>


</html>