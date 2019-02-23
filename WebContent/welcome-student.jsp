<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="css/todolist.css">
<title>Todo list</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="css/todolist.css">
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
		response.sendRedirect("login.jsp");

    }
    
    
    %>
  



   <div id="myDIV" class="header">
  <h2>Todo List welcome ${username }</h2>
  <form action="AddTodoServlet" method="get">
  
  
 
  
</div>

   
  <div class="container">
   <c:forEach var ="tempTodo" items="${TODO_LIST }">
		
		
		
				
							
					<ul id="myUL">
			<tr>
			 <li> ${tempTodo.getDescription()}   </li> 
			 
			</tr>	
				
</ul>
		
	</c:forEach>

  </div>   
</form>


<form action="LogoutServlet" >
<div>


	 <input type="submit" value="Logout">




    
</body>
</html>


