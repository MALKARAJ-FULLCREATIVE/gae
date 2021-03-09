package com.se;


import java.io.IOException;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

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

	  Entity employee = new Entity("Employee", "asalieri");
	  employee.setProperty("firstName", "Antonio");
	  employee.setProperty("lastName", "Salieri");
	 

	  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	  datastore.put(employee);
	  
	  
  }
}