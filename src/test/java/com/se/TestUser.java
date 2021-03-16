package com.se;


import static org.junit.Assert.assertEquals;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUser {

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
  public void TestAdd() {
	  user u=new user();
	  Entity r=u.add("George", 21, "Chennai",121);
	  assertEquals(r.getProperty("Name"),"George");
  }
  
  @Test
  public void TestSearch()
  {
	  main m=new main();
	  String actual=m.user().toString();
	  String Expected="SELECT * FROM user";
	  assertEquals(actual, Expected);
  }
  
  @Test
  public void TestAscSort()
  {
	  main m=new main();
	  
	  String p=m.sort("alph1").toString();
	  String expected="SELECT * FROM user ORDER BY Name";
	  assertEquals(p,expected);
	  
	  
  }
  
  @Test
  public void TestDescSort()
  {
	  main m=new main();
	  
	  String p=m.sort("alph2").toString();
	  String expected="SELECT * FROM user ORDER BY Name DESC";
	  assertEquals(p,expected);
	  
  }
  @Test
  public void TestUpdate()
  {
	  Edit edit=new Edit();
	  Entity e=edit.update("101", "George", 10, "chennai");
	  Entity en=edit.update("101", "George Joseph", 10, "chennai");
	  assertEquals("George Joseph",en.getProperty("Name"));
  }
  

}
