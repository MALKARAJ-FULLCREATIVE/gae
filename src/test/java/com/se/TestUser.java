package com.se;


import static org.junit.Assert.assertEquals;
import com.google.appengine.api.datastore.Entity;
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
	  Entity r=u.add("George", 21, "Chennai");
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
  

  

}