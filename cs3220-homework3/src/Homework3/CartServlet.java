package Homework3;

import java.io.IOException;
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
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	//	List<Order> orderitems = (List<Order>) getServletContext().getAttribute("orderitems");
		List<Addfood> cartentry = (List<Addfood>) getServletContext().getAttribute("cartentry");

		
		List<Order> orderitems=new ArrayList<>();
	
		for (Addfood entry : cartentry) {

			
			orderitems.add(new Order(orderitems.size(), entry, request.getParameter("name"), Order.Statuses.IN_QUEUE , new Date()));
			getServletContext().setAttribute("orderitems", orderitems);
			
			System.out.println(request.getParameter("name"));
			System.out.println("CARTSERVLET--------------"+entry.getName());
		}

		cartentry.clear();
		
		
	response.sendRedirect("http://localhost:8080/cs3220-homework3/orderpage.jsp");	
		
	}

}
