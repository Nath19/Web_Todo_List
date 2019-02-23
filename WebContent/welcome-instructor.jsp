<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="css/todolist.css">
    <style>
body {
    background-color: #C0C0C0;
}
</style>
<title>Todo list</title>
</head>
<body>
 <%
    
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expire",0);
    
 	
    
    if(session.getAttribute("username")==null)
    {
		response.sendRedirect("LoginServlet");

    }
    
    
    %>
  


	   <div id="myDIV" class="header">
  <h2>Welcome ${username } in your Todo List</h2>
  <form action="AddTodoServlet" method="get">
  <!-- <input type="text" id="myInput" placeholder="Title..."> -->
  <input type="submit" name ="boutton" value="AddTodo"/>
  
  
 
  
</div>

   
  <div class="container">
   <c:forEach var ="tempTodo" items="${TODO_LIST }">
		<c:url var="EditLink" value= "EditTodoServlet">
		<c:param name="TodoId" value="${tempTodo.getId()}"/> 
		</c:url>	
		
		<c:url var="DeleteLink" value= "DeleteTodoServlet"> 
		<c:param name="TodoId" value="${tempTodo.id}"/> 
		</c:url> 	
				
							
					<ul id="myUL">
			<tr>
			 <li> ${tempTodo.getDescription()}  <a href="${EditLink }">  Edit</a> | <a href="${DeleteLink }"> Delete </a> </li> 
			 
			</tr>	
				
</ul>
		
	</c:forEach>

  </div>   
</form>


<form action="LogoutServlet" >
<div>
<input type="submit" value="Logout">



</div>
</form>
    
</body>
</html>


