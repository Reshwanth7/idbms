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


<table border="1">
<tr>

<th>FirstName</th>
<th>LastName</th>
<th>email</th>
<th>Action</th>
</tr>
<c:forEach var="tempStudent" items="${Student_List}">

	<c:url var="selectlink" value="StudentControllerServlet">
	<c:param name="command" value="REGISTERSTUDENT"/>
	<c:param name="studentId" value="${tempStudent.id }"/>
		<c:param name="courseId" value="${courseId }"/>
	
	</c:url>
	<tr>
	    <td> ${ tempStudent.firstName}</td>
		<td> ${ tempStudent.lastName} </td>
		<td> ${ tempStudent.email}</td>
		<td>
		 <a href="${selectlink}">Select</a>
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