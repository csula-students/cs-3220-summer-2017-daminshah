package homework2;

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
 * Servlet implementation class OrderStatusesAdminServlet
 */
@WebServlet(urlPatterns="/admin/orders", loadOnStartup=1)
public class OrderStatusesAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusesAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {

		List<Order> orderitems = new ArrayList<>();
		getServletContext().setAttribute("orderitems", orderitems);

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		List<Addfood> cartentry = (List<Addfood>) getServletContext().getAttribute("cartentry");
		response.setContentType("text/html");
		
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");

				out.println("<h2> Order Statuses </h2>");

		List<Order> orderitems = (List<Order>) getServletContext().getAttribute("orderitems");

		if (orderitems.size() == 0) {
			
			out.println("<h2>No orders.</h2>");

			

		} else {
			out.println("<table border=2>");
			out.println("<thead>" + 
						"<tr>" + 
						"<th>" + "Order ID" + "</th>" + 
						"<th>" + "Food Name" + "</th>" + 
						"<th>"+ "Food Image" + "</th>" + 
						"<th>" + "Customer Name" + "</th>" + 
						"<th>" + "Order Status" + "</th>"+ 
						"<th>" + " Order Date " + "</th>" + 
						"<th>" + "Edit Order" + "</th>" +
						"</tr>" + 
						"<thead>");

			for (Order order : orderitems)

				out.println("<tbody>" + 
							"<tr>" + 
							"<td>" + order.getId() + "</td>" + 
							"<td>" + order.getFood().getName() + "</td>" 
							+ "<td>"+"<img src= "+order.getFood().getImgurl()+" width=70px ></td>" + 
							"<td>" + order.getName() + "</td>" +
							"<td>"+ order.getStatuses().toString() + "</td>" + 
							"<td>" + order.getDate() + "</td>"
							+ "<td><a href='../admin/order/edit?id=" + order.getId() + "'>Edit</a>" + 
							"</td>" + "</tr>"
						+ "</tbody>");

		}

		out.println("</table>");


		out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
