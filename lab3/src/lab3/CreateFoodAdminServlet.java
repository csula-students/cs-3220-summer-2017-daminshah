package lab3;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateFoodAdminServlet
 */
@WebServlet("/CreateFoodAdminServlet")
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
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		
//		out.print("<html><head><style='text/css'>{"
//				
//			+"	input[type=text], select {  width: 100%;"
//			 +"    padding: 12px 20px;"
//				 +"   margin: 8px 0;"
//				  +"  display: inline-block;"
//				   +" border: 1px solid #ccc;"
//				   +" border-radius: 4px;"
//				    +"box-sizing: border-box; }"
//				
//				
//				
//				
//				+ "}</style></head>");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		
		
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h2>Create Food</h2>");
		out.println("<form method=\"post\">");
		out.println("Food name: <input name='foodname' type='text'/></br>");
		out.println("Food Description: <input name='description' type='textarea'/></br>");
		out.println("Image URL : <input name='imgurl' type='url'/></br>");
		out.println("Price: <input name='price' type='text'/></br>");
		out.println("<button>Add</button>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		List<FoodItems> items=(List<FoodItems>) getServletContext().getAttribute("items");
		//List<FoodItems> items=new ArrayList<>();
		items.add(new FoodItems(items.size(), request.getParameter("foodname"), request.getParameter("description"), request.getParameter("imgurl"),
				Integer.parseInt(request.getParameter("price"))));
		
		getServletContext().setAttribute("items", items);
		
		PrintWriter out = response.getWriter();
		out.println("<a href='FoodItemListAdminServlet'> Check FoodItems List</a>");
		
		
		
	}

}
