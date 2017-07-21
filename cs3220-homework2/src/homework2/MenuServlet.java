package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		List<Addfood> entry = (List<Addfood>) getServletContext().getAttribute("entry");
		
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
	
		
		out.println("<table border='2'>");
		out.println("<tr>"
				+ "<th> Name</th>"
				+ "<th>Price</th>"
				+ "<th>Description</th>"
				+ "<th>Image</th>"
				+ "<th>Add to Cart</th>"
				+ "</tr>");
			for (Addfood entries : entry) {
			out.println("<tr>"  
					+"<td>" + entries.getName() + "  </td>" 
					+ "<td>"+ entries.getPrice() + " </td>" 
					+ "<td>"+ entries.getDescription() + " </td>" 
					+ "<td>" +"<img src= "+entries.getImgurl()+" width=70px > </td>" 
					+"<td><a href='http://localhost:8080/cs3220-homework2/menu/add?id="+entries.getId()+"'>Add To cart</a></td>"
					
		+"</tr>"

			);
		}
		out.println("</table>");
		
		
		out.println("</br>");
		out.println("</br>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
