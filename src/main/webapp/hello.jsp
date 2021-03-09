<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DETAILS</title>
<style>
	.cont{
		text-align:center;
		padding:20px;
		margin:5px;
	}
	input{
		padding:5px;
		margin:10px;
		
	}

</style>
</head>
<body>
	<div class="cont">
	 <form action="/user" method="POST">
	     Name:<input type="text" name="name"><br>
	     Age:<input type="text" name="age"><br>
	     Place:<input type="text" name="place"><br>
	     <input type="submit" value="submit">
	 </form>
	 </div>
</body>
</html>