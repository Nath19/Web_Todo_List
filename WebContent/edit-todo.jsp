<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">
<style>
body {
    background-color: #C0C0C0;
}

h1{
	 text-align: center;
	   font-family:Arial, Helvetica, sans-serif;
	    font-size: 42px;
	
}
</style>
<title>Add a Student</title>
</head>
<body>
<div id="wrapper">

</div>
<div id="container">
<h1> Edit a Todo</h1>
 <div id="myDIV" class="header">
  <h2>Welcome ${username } in your Edit Page</h2>
<form action="EditTodoServlet" method = "post">
<table>

<tbody>
	<tr>
		<td><label>Description </label> </td>
		<td><input type="text" name = "description" value="${Todo.description }"/></td>

	</tr>

	<tr>
		<td><label></label> </td>
		<td><input type="submit" value = "Save"/></td>
	</tr>
</tbody>

</table>
</form>

<div style="clear:both;"></div>
<a href="WelcomeInstructorServlet">Back to List</a>
</div>
</body>
</html>