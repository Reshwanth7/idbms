<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*,com.resh.jdbc.*"%>
<!DOCTYPE html>
<html>

<head>
<title>Student Tracker App</title>

<link type="text/css" rel="stylesheet" href="css/style.css">

</head>


<body>

<div id="wrapper">

<div id = "header">
<h2>UMKC</h2>
</div>

</div>

<div id="container">
<div id ="content">
<form action="StudentControllerServlet" method="GET">
<input type="hidden" name="command" value="REGISTER"/>
<input type="submit" value="Register Student"
class="add-student-button"/>
<input type="hidden" name="courseId" value="${theCourse}"/>
</form>
<table border="1">
<tr>

<th>FirstName</th>
<th>LastName</th>
<th>email</th>
<th>Action</th>
</tr>
<c:forEach var="tempStudent" items="${Student_List}">

	<c:url var="templink" value="StudentControllerServlet">
	<c:param name="command" value="DETAILS"/>
	<c:param name="studentId" value="${tempStudent.id }"/>
	<c:param name="courseId" value="${theCourse }"/>
	</c:url>
	<c:url var="deletelink" value="StudentControllerServlet">
	<c:param name="command" value="DELETESTUDENTCOURSE"/>
		<c:param name="studentId" value="${tempStudent.id }"/>
	</c:url>
	<tr>
	    <td> ${ tempStudent.firstName}</td>
		<td> ${ tempStudent.lastName} </td>
		<td> ${ tempStudent.email}</td>
		<td>
		<a href="${templink}">Select</a>
		 |
		 <a href="${deletelink}" onclick="if(!(confirm('Are you sure you want to delete this student from this course?'))) return false">Delete</a>
		 </td>
	</tr>
</c:forEach>
	
</table>

</div>

</div>
<hr>
<c:url var="coursetemplink" value="StudentControllerServlet">
	<c:param name="command" value="LISTCOURSES"/>
	</c:url>
	<a href="${coursetemplink}">Course List</a>
</body>



</html>