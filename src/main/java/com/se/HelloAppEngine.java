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
import com.google.appengine.repackaged.com.google.common.collect.ImmutableList;
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


  
  public DatastoreService funDatastore()
  {
	  
	  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	  Entity a = new Entity("Person", "a");
	    a.setProperty("firstName", "Alph");
	    a.setProperty("lastName", "Alpha");
	    a.setProperty("height", 60);
	    Entity b = new Entity("Person", "b");
	    b.setProperty("firstName", "Bee");
	    b.setProperty("lastName", "Bravo");
	    b.setProperty("height", 70);
	    Entity c = new Entity("Person", "c");
	    c.setProperty("firstName", "Charles");
	    c.setProperty("lastName", "Charlie");
	    c.setProperty("height", 100);
	    
	    datastore.put(ImmutableList.<Entity>of(a, b, c));
		return datastore;
  }
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  
	  
	 DatastoreService datastore= funDatastore();
	    long minHeight=60;
	    
	    Filter heightMinFilter =
	            new FilterPredicate("firstName", FilterOperator.EQUAL, "Charles");

	    
	    Query q = new Query("Person").setFilter(heightMinFilter);

	    // Use PreparedQuery interface to retrieve results
	    PreparedQuery pq = datastore.prepare(q);

	    for (Entity result : pq.asIterable()) {
	      String firstName = (String) result.getProperty("firstName");
	      String lastName = (String) result.getProperty("lastName");
	      Long height = (Long) result.getProperty("height");

	      response.getWriter().print(firstName + " " + lastName + ", " + height + " inches tall");
	    }

  }
}