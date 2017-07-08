package Midterm;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomRestaurantServlet
 */
@WebServlet(urlPatterns="/RandomRestaurantServlet", loadOnStartup=1)
public class RandomRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        int id;
		String name;
		String url;
		List<Integer> designRatings = new ArrayList<Integer>();		
		List<Integer> tasteRatings = new ArrayList<Integer>();		
		
		//List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		List<Restaurant> entries = new ArrayList<Restaurant>();
		for(int i=0;i<22;i++)
		{
			id = i;
			name = "Student"+i+"'s resturant";
			url= "http://cs3.calstatela.edu:8080/cs3220xstu"+i;
			designRatings.add(0);
			tasteRatings.add(0);
			entries.add(new Restaurant(id,name,url,designRatings,tasteRatings));
			
		}
		getServletContext().setAttribute( "entries", entries );
        
    }
    
    public Restaurant getRandomRestaurant(List<Restaurant> list) {
    	return list.get(new Random().nextInt(list.size()));
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//PrintWriter out=response.getWriter();
		
		List<Restaurant> entries = (List<Restaurant>) getServletContext().getAttribute(
	            "entries" );
		List<Restaurant> random = new ArrayList<>() ;
		for(int i=0;i<1;i++){
			random.add(getRandomRestaurant(entries));
		}
		

	        // display it
	        response.setContentType( "text/html" );
	        PrintWriter out = response.getWriter();
	        out.println( "<html><head><title>Random resturants</title></head><body>" );
	        
	        out.println("<h2>You should go to  </h2>");

	        out.println( "<table border='1'>" );
	        out.println( "<tr><th>Name</th><th>URL</th><th>Design</th><th><th>Taste</th><th>Reviewers</th><br /></th></tr>" );
	        for( Restaurant entry : random )
	        {
	            out.println( "<tr><td>" + entry.getName() + "</td><td>"
	                + entry.getUrl() + "</td><td>");
	                
	                	out.println(entry.getTasteRatings().get(1));
	                
	                out.println( "</td><td>"
	                +entry.getTasteRatings().get(1)+"</td><td>");
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
