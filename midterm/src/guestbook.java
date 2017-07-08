

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
 * Servlet implementation class guestbook
 */
@WebServlet(loadOnStartup=1, urlPatterns="/guestbook")
public class guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestbook() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	List<GuestBookEntry> entries=new ArrayList<>();
    	entries.add(new GuestBookEntry("Eric", "Hello",entries.size()));
    	entries.add(new GuestBookEntry("John", "Hi there!!",entries.size()));

    	
    	
    	getServletContext().setAttribute("entries", entries);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Hello Guestbook</h1>");
		out.println("<table border=1>");
		
		for(GuestBookEntry entry:entries)
		{
			out.println(
					"<tr>"+
							"<td>"+entry.getName() +" says: </td>" +
							"<td>"+entry.getComment()+"</td>"+
							"<td> <a href='EditServlet?id="+entry.getId()+"'>Edit </a> </td>"+
							"<td> <a href='DeleteServlet?id="+entry.getId()+"'>Delete </a> </td>"+
							
					"</tr>"
						
					
					
					);
		}
		
		out.println("</table>");
		
		out.println("<a href='CreateGuestBookServlet'> Add Comment </a>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
