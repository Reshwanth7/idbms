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

<th>Title</th>
<th>Instructor</th>
<th>Action</th>
</tr>
<c:forEach var="tempCourse" items="${Course_List}">

	
	<c:url var="selectlink" value="StudentControllerServlet">
	<c:param name="command" value="REGISTERCOURSE"/>
	<c:param name="courseId" value="${tempCourse.id }"/>
		<c:param name="studentId" value="${studentId}"/>
	
	</c:url>
	<tr>
	    <td> ${ tempCourse.title}</td>
		<td> ${ tempCourse.instructor} </td>
		<td>
		 <a href="${selectlink}">Select</a>
		 
		 
		 </td>
	</tr>
</c:forEach>
	
</table>

</div>

</div>
<hr>
<c:url var="studenttemplink" value="StudentControllerServlet">
	<c:param name="command" value="LIST"/>
	</c:url>
<a href="${studenttemplink}">Students List</a>
</body>



</html>