package com.se;


import static org.junit.Assert.assertEquals;
import com.google.appengine.api.datastore.Entity;
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
}
