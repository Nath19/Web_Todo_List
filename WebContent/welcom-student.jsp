<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="css/todolist.css">

<title>Insert title here</title>
</head>
<body>

	<%
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
	
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
	%>

	<h1>Welcome ${username} in your TodoList</h1>
	<a href="videos.jsp">Video here </a>
	
	<form action="LogoutServlet"> 

<div id="myDIV" class="header">
  <h2>My To Do List</h2>
  <input type="text" id="myInput" placeholder="Title...">
</div>

	<input type="submit" value="Logout">
	
	
	
	</form>
	
	
	
	
</body>
</html>