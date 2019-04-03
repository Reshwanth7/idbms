<!DOCTYPE html>
<html>
<head>
<title>Add course</title>
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
<h3>Add Course</h3>
<form action="StudentControllerServlet" method="get">
<input type="hidden" name="command" value="ADDCOURSE"/>
<table>


<tbody>

<tr>
<td><label>Title</label></td>
<td><input type="text" name="title"/></td>
</tr>
<tr>
<td><label>Instructor</label></td>
<td><input type="text" name="instructor"/></td>
</tr>
<tr>
<td><label></label></td>
<td><input type="submit" value="save" name="save"/></td>
</tr>


</tbody>

</table>
</form>
<div style="clear: both;"></div>
<p>
<a href="StudentControllerServlet">Back To List</a>
</p>
</div>
</body>


</html>