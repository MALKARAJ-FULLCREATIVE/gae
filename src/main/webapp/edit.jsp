<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DETAILS</title>
<style>	
    body{
	 background-color:#E4F1FF;
	}
	.cont{
		text-align:center;
		padding:20px;
		margin:5px;
		background-color:#C6DFFB;
		box-shadow:0 0 2px 2px #B6D8FC;
		margin-right:600px;
		margin-left:600px;
		margin-top:200px;
	}
	input{
		padding:5px;
		margin:10px;
		margin-left:5px;
		border:solid #C6DFFB 2px;
				
	}
	a{
      text-decoration:none;
      padding:5px;
      box-shadow:0 0 2px 2px #C6DFFB;
    }

</style>
</head>
<body>
	<div class="cont">
	<h2>Edit User</h2>
	 <form action="/edit?id=<%=request.getParameter("id") %>" method="POST">
	     <input type="text" name="name" placeholder="Name"><br>
	     <input type="text" name="age" placeholder="Age"><br>
	     <input type="text" name="place" placeholder="Place"><br>
	     <input type="submit" value="submit">
	     <br><br>
	     <a href="/main">All Users</a>
	 </form>
	 </div>
</body>
</html>