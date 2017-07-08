

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateGuestBookServlet
 */
@WebServlet("/CreateGuestBookServlet")
public class CreateGuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGuestBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<form method=\"post\">");
		out.println("Your Name: <input type='text' name='name'/> </br>");
		out.println("<textarea name='comment'></textarea> </br> ");
		out.println("<button>Add</button>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		entries.add(new GuestBookEntry(request.getParameter("name"), request.getParameter("comment"), entries.size()));
		PrintWriter out=response.getWriter();
		
		out.println("<a href=guestbook> Go back to Guestbook </a>");
		//System.out.println(request.getParameter("name"));
		//System.out.println(request.getParameter("comment"));
	}

}
