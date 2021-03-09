package com.se;


import java.io.IOException;
import java.util.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.Filter;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

	  Entity employee = new Entity("Employee","asalieri");
	  employee.setProperty("firstName", "Antonio");
	  employee.setProperty("lastName", "Salieri");
	 

	  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	  
	  Filter fp=new FilterPredicate("firstName",FilterOperator.EQUAL,"Antonio");
	  Query qp=new Query("employee");
	  PreparedQuery preq=datastore.prepare(qp);
	  
	  
	  List<Entity> res_lst=new ArrayList<Entity>();
	  
	  
	  System.out.println(preq.asList(FetchOptions.Builder.withDefaults()));
	  
	  
	  
	  datastore.put(employee);
	  
	  
  }
}