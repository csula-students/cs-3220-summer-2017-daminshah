package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(urlPatterns="/shopping-cart",loadOnStartup=1)
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
		List<Addfood> Homework2cartentry = new ArrayList<>();
		getServletContext().setAttribute("Homework2cartentry", Homework2cartentry);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<Addfood> Homework2foodentry = (List<Addfood>) getServletContext().getAttribute("Homework2foodentry");

		response.setContentType("text/html");
		
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<head>");
		out.println("<title> Shopping Cart </title>");
		out.println("</head>");

		out.println("<body>");

	
		


		out.println("<h2> Shopping Cart </h2>");

		List<Addfood> Homework2cartentry = (List<Addfood>) getServletContext().getAttribute("Homework2cartentry");

			out.println("<table border=2>");
			out.println("<thead>" + "<tr>"  + "<th>" + "Name" + "</th>" + "<th>"
					+ " Description" + "</th>" + "<th>" + "Image" + "</th>" + "<th>" + "Price" + "</th>"
					+ "<th>" + " Remove" + "</th>" + "</tr>" + "<thead>");

			for (Addfood entries : Homework2cartentry) {

				out.println("<tbody>" + "<tr>"  + "<td>" + entries.getName() + "</td>"
						+ "<td>" + entries.getDescription() + "</td>" + "<td><img src=" + "\"" + entries.getImgurl() + "\""
						+ " width=\"200\" height=\"100\"></td>" + "<td> $" + entries.getPrice() + "</td>"
						+ "<td><a href='shopping-cart/delete?id=" + entries.getId() + "'>Remove</a>" + "</td>" + "</tr>"
						+ "</tbody>");
				out.println("<hr>");
			}

			out.println("</table>");

			out.println("<h3> Enter your Name </h3>");

			out.println("<form method=\"post\">");
			out.println("<label>Your Name:</label><br>");
			out.println("<input name='name' type='text'/></br><br>");
			out.println("<button>Confirm order</button>");
			out.println("</form>");

		

		
		out.println("</body>");
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		ORDER FUNCTIONALITY REMAINING
		
		List<Order> Homework2orderitems = (List<Order>) getServletContext().getAttribute("Homework2orderitems");
		List<Addfood> Homework2cartentry = (List<Addfood>) getServletContext().getAttribute("Homework2cartentry");

		
	
		for (Addfood entry : Homework2cartentry) {

			
			Homework2orderitems.add(new Order(Homework2orderitems.size(), entry, request.getParameter("name"), Order.Statuses.IN_QUEUE , new Date()));
			getServletContext().setAttribute("orderitems", Homework2orderitems);
			
			System.out.println(entry.getName());
		}

		Homework2cartentry.clear();
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
			
		out.println("<title> Shopping Cart </title>");
		out.println("<h2>Thank you for your order !</h2>");
		out.println("<a href='http://localhost:8080/cs3220-homework2/orders'> Go to Orders Page </a>");
		
		
		
	}
	}


