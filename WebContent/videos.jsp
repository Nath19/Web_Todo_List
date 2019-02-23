<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
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


<iframe width="560" height="315" src="https://www.youtube.com/embed/2jKpMS2e6UE" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe></body>
</html>