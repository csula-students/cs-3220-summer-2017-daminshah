package Midterm;
	

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeeList
 */
@WebServlet("/SeeList")
public class SeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Restaurant> entries = (List<Restaurant>) getServletContext().getAttribute(
	            "entries" );
		
		

	        // display it
	        response.setContentType( "text/html" );
	        PrintWriter out = response.getWriter();
	        out.println( "<html><head><title>Random resturants</title></head><body>" );

	        out.println( "<table border='1'>" );
	        out.println( "<tr><th>Name</th><th>URL</th><th>Design</th><th><th>Taste</th><th>Reviewers</th><br /></th></tr>" );
	        for( Restaurant entry : entries )
	        {
	            out.println( "<tr><td>" + entry.getName() + "</td><td>"
	                + entry.getUrl() + "</td><td>");
	                
	                	out.println(entry.getTasteRatings().get(1));
	                
	                out.println( "</td><td>"
	                +entry.getTasteRatings().get(1)+"</td><td>");
	        }
	        out.println( "</table>" );

	        

	        out.println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
