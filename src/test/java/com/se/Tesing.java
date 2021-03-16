package com.se;


import static org.junit.Assert.assertEquals;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class Tesing {
	
	private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

		  @Before
		  public void setUp() {
		    helper.setUp();
		  }

		  @After
		  public void tearDown() {
		    helper.tearDown();
		  }
		  
		  @Test
		  public void testName() {
		    Entity  e=user.funDataStore("malkaraj", 21, "chennai");
		    
		    assertEquals(e.getProperty("Name"),"malkaraj");
		   			
			
		    
		  }
		  @Test
		  public void testSortByAsc()
		  {
			  
			 PreparedQuery pq= Sorting.SortMethod(SortDirection.ASCENDING);
		       	  assertEquals(pq.toString(),"SELECT * FROM user ORDER BY Name");
		       	  
		  }
		  
		 }
		  
