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
 * Servlet implementation class CreateFoodAdminServlet
 */
@WebServlet( "/admin/foods/create")
public class CreateFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFoodAdminServlet() {
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

		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h1>Create Food</h1>");
		out.println("<form method=\"post\">");
		
		out.println("Food Name:<input name='foodname' type='text'/><br> ");
		out.println("<hr>");
		out.println("Food Description: <input name='description' type='textarea'/></br>");	
		out.println("<hr>");
		out.println("Image URL:<input name='imgurl' type='text'/><br> ");
		out.println("<hr>");
		out.println("Price:<input name='price' type='text'/><br> ");
		out.println("<hr>");
		out.println("<button> Add Food</button>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		List<Addfood> Homework2entry=(List<Addfood>) getServletContext().getAttribute("Homework2entry");
		//List<FoodItems> items=new ArrayList<>();
		Homework2entry.add(new Addfood(Homework2entry.size(), request.getParameter("foodname"), request.getParameter("description"), request.getParameter("imgurl"),
				Integer.parseInt(request.getParameter("price"))));
				
				getServletContext().setAttribute("Homework2entry", Homework2entry);
		
		PrintWriter out = response.getWriter();
		out.println("<a href='http://localhost:8080/cs3220-homework2/admin/foods'> Check FoodItems List</a>");
		//response.sendRedirect("FoodMenuServlet");

	}

}
