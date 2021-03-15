package com.se;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public PreparedQuery user()
    {
	  	Query q = new Query("user");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastore.prepare(q);	
		return p;
    }
    
    
    public PreparedQuery sort(String sort)
    {
    	if(sort.equals("alph1"))
    	{
    		
     	  Query q1 = new Query("user").addSort("Name", SortDirection.ASCENDING);
    	  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		  PreparedQuery p = datastore.prepare(q1);
    	  return p;
    	}
    	else
    	{
       	  Query q1 = new Query("user").addSort("Name", SortDirection.DESCENDING);
      	  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
  		  PreparedQuery p = datastore.prepare(q1);
      	  return p;
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  main m=new main();
		  String name=request.getParameter("name");
		  String sort=request.getParameter("sort");
		  

		  if(sort!=null){
				  
				  PreparedQuery p=m.sort(sort);	
				  request.setAttribute("p",p);
	
							/*Entity result =pq.asSingleEntity();
							for (Entity result : p.asIterable()) 
							{
							
							}*/
			  
		  }
		  else
		  {
			  PreparedQuery p=m.user();	
			  System.out.println(p);
      		  request.setAttribute("p",p);

			/*Entity result =pq.asSingleEntity();
			for (Entity result : p.asIterable()) 
			{
			
			}*/
	  	 } 
	    PrintWriter p=new PrintWriter(System.out);
	    p.write("gj");
		request.getRequestDispatcher("main.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
