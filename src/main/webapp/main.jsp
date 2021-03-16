<%@page import="com.google.appengine.api.datastore.Key"%>
<%@page import="com.google.appengine.api.datastore.Query.FilterOperator"%>
<%@page import="com.google.appengine.api.datastore.Query.SortDirection"%>
<%@page import="com.google.appengine.api.datastore.DatastoreServiceFactory"%>
<%@page import="com.google.appengine.api.datastore.DatastoreService"%>
<%@page import="com.google.appengine.api.datastore.PreparedQuery"%>
<%@page import="com.google.appengine.api.datastore.Query"%>
<%@page import="com.google.appengine.api.datastore.Entity"%>
<%@page import="com.google.appengine.api.datastore.Entities"%>

<%@page import="com.google.appengine.api.datastore.Query.FilterPredicate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data</title>
<style>
	body{
	 background-color:#F7FBFF;
	}
    form{
    	margin:15px;
		
    }
    input{
    	padding:5px;

    	margin-right:10px;
    	
    }
    a{
      text-decoration:none;
      padding:5px;
      box-shadow:0 0 2px 2px #C6DFFB;
    }
    .opr a{
      
	    text-decoration: none;
	    padding: 4px;
	    color: black;
	    margin-right: 6px;
	    box-shadow: 0 0 2px 2px #adcff5;

    }
	.contents{
	margin:15px;
	padding:10px;
      box-shadow:0 0 2px 2px #C6DFFB;
	background-color:#C6DFFB;
	}
	.info{
		padding:10px;
	}
	.heading{
	margin:15px;
	background-color:#C6DFFB;
	padding:1px;
	text-align:center;
	}
	
</style>
</head>
<body>

	<div class="container">

		<div class="info">
		    <div class="heading">
		       <h2>Database</h2>
			</div>
			<form action="/search"  method="GET">
				<input type="text" placeholder="search" name="name">
				<input type="submit" value="SUBMIT">
				<a href="/main?sort=alph1">ASCENDING</a>
			    <a href="/main?sort=alph2">DESCENDING</a>	
				<a href="/add">Add user</a>								
			</form>
			  <%
    			  PreparedQuery p=(PreparedQuery)request.getAttribute("p");
			  	  System.out.println(p);
			  	  String sort=(String)request.getParameter("sort");
				  String name=(String)request.getAttribute("name");
				  System.out.println(sort);
				  Long age=(Long)request.getAttribute("age");
				  String place=(String)request.getAttribute("place");
				  if(name!=null)
				  {
				  
			  %>
			    <div class="contents">
				     <h3>Name :<%= name %></h3>
				     <h3>Age :<%=age %></h3>
				     <h3>Place :<%= place%></h3>

				 </div> 
				<%
		     	  }
				  else{
				       for (Entity result : p.asIterable()) 
								{    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

									 %>
									 <div class="contents">				  
									  <h3>Name :<%=(String)result.getProperty("Name") %></h3>
									  <h3>Age :<%=(Long)result.getProperty("Age") %></h3>
									  <h3>Place :<%=(String)result.getProperty("Place") %></h3>
							          <div class="opr">
								     	<a href="/edit?id=<%= result.getKey().getId() %>">Edit</a>
								     	<a href="/delete?id=<%= result.getKey().getId() %>">Delete</a>
								     </div>
									 </div>

														
								<%
								}
				   }%>
		</div>
	</div>

</body>
</html>