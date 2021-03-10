package com.se;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

/**
 * Servlet implementation class ControllerSearch
 */

@WebServlet("/ControllerSearch")
public class ControllerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter in do get method");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	String name=request.getParameter("name");
         
	Filter filter=
            new FilterPredicate("Name", FilterOperator.EQUAL, name);
	

    
	
    Query q = new Query("user").setFilter(filter);
    
      
    PreparedQuery pq = datastore.prepare(q);
    
    System.out.println(pq);
    boolean valueExist=false;
    for (Entity result : pq.asIterable()) {
            
    
 String resultName=(String) result.getProperty("Name");

                   valueExist=true;

                response.getWriter().print("Name:"+resultName+"   Age:"+result.getProperty("Age"));
 
    }
    
    if(valueExist==false)
    	response.getWriter().print("no result found");

		
	
  
	
	
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
