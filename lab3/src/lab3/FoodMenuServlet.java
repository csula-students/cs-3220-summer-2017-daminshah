package lab3;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodMenuServlet
 */
@WebServlet("/FoodMenuServlet")
public class FoodMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodMenuServlet() {
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
		List<FoodItems> items = (List<FoodItems>) getServletContext().getAttribute("items");
		// tell browser this is html document
		response.setContentType("text/html");

//		out.println("<head>");
//		out.println("<style>body { " + "}</style>");
//		out.println("</head>");

		out.println("<h1> Damin's Cafe </h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h2> Menu:</h2>");
		out.println("<table border=1px>");
		out.println("<thead>" + "<tr>" + "<th>Image</th>" + "<th>Name</th?>" + "<th>Description</th>" + "<th>Price</th>"
				+ "<th>Add</th>" + "</tr>" + "</thead>");
		for (FoodItems item : items) {
			out.println("<tr>" 
						+ "<td>" + "<img src= "+item.getImgurl()+" width=70px > </td>" 
						+ "<td>" + item.getName()
					+ "</td>" + "<td>" + item.getDescription() + "</td>" 
						+ "<td>" + item.getPrice() + "</td>"
					+ "<td><a href='#" + item.getId() + "'>Add</a> " + "</td>" + "</tr>");
		}
		out.println("</table>");
//		out.println("<a href='creat" + "'>Creat Food</a> ");
//		out.println("<a href='list" + "'>Inventory</a> ");

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
