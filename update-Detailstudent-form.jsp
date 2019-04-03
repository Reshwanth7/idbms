<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Update student</title>
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
<h3>Update Student Detail</h3>
<form action="StudentControllerServlet" method="get">
<input type="hidden" name="command" value="UPDATEDETAIL"/>
<input type="hidden" name="courseId" value="${Details.course_id }"/>
<input type="hidden" name="studentId" value="${Details.student_id }"/>
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
<tr>
<tr>
<td><label></label></td>
<td><input type="submit" value="save" name="save"/></td>
</tr>


</tbody>

</table>
</form>
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