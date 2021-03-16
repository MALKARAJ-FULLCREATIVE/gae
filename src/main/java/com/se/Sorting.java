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
import com.google.appengine.api.datastore.Query.SortDirection;
//import com.google.appengine.api.search.SortExpression.SortDirection;

/**
 * Servlet implementation class Sorting
 */
@WebServlet("/Sorting")
public class Sorting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sorting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	
    
    
    public static PreparedQuery SortMethod(SortDirection str )
    {
    	
    	
    	
        Query q=new Query("user").addSort("Name",str);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery pq=datastore.prepare(q);
        
        return pq;
        
        
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	
		System.out.println("enter in do get method");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq;
		if(request.getParameter("sort").equals("asc"))
	       pq=SortMethod(SortDirection.ASCENDING);
		else
			pq=SortMethod(SortDirection.DESCENDING);
		
	      
	      boolean valueExist=false;
	      
	      for (Entity result : pq.asIterable()) {
	            
	    	    
	    	  String resultName=(String) result.getProperty("Name");

	    	                    valueExist=true;

	    	                 response.getWriter().print("Name:"+resultName+"   Age:"+result.getProperty("Age"));
	    	                 response.getWriter().print("</br>");
	    	  
	    	     }
	       

	
	
	      
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
