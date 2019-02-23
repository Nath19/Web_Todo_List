<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to ESILV</title>
<link type="text/css" rel="stylesheet" href="css/test.css">

<style>
body {
    background-color: #C0C0C0;
}
h1{
	 text-align: center;
	   font-family:Arial, Helvetica, sans-serif;
	    font-size: 52px;
	
}

div.banniere {
 position: absolute;
    left: 10px;
    top: 10px;
   
   
}
</style>
</head>
<body>
<% String message = (String)request.getAttribute("alertMsg");%>
<script type="text/javascript">
 
    var msg = "<%=message%>";
    if(msg!="null")
    	{
    	 alert(msg);
    	}
   
</script>

<form action="LoginServlet" method="post">
	<h1>
	WEB TODO LIST
	</h1>
	<div class="banniere">
<img src="css/esilv2.png"  width=100 height=100 ">
</div>
	
   

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="enter username" name="uname" value="${uname}" required>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder=" enter password" name="pass" required>
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>   
  </div>
</form>
	

</body>
</html>