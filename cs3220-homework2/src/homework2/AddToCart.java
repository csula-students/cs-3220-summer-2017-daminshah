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
 * Servlet implementation class AddToCart
 */
@WebServlet("/menu/add")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Addfood> entry = (List<Addfood>) getServletContext().getAttribute("entry");

		Addfood leentry = null;

		for (Addfood foodentries : entry) {
			if (foodentries.getId() == id) {
				
				leentry = foodentries;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<Addfood> cartentry = (List<Addfood>) getServletContext().getAttribute("cartentry");

		cartentry.add(new Addfood(id, leentry.getName(), leentry.getDescription(), leentry.getImgurl(),
			leentry.getPrice()));
		System.out.println(leentry.getName());


		getServletContext().setAttribute("cartentry", cartentry);
		
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


		out.println("<title>Shopping Cart </title>");
		out.println("<h2>You put " + leentry.getName() + " in your cart.</h2>");
		out.println("<a href='http://localhost:8080/cs3220-homework2/menu'>Go to the main menu</a>");
		out.println("<a href='http://localhost:8080/cs3220-homework2/shopping-cart'>Check Out </a>");
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
