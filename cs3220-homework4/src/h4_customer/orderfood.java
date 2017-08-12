package h4_customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h4_admin.FoodItem;

/**
 * Servlet implementation class orderfood
 */
@WebServlet("/h4_order")
public class orderfood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderfood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CartDAO cartDAO=new CartDAO();
		OrderDAO orderDAO=new OrderDAO();
		
		if (request.getParameter("Delete") != null) {
			int id = Integer.parseInt(request.getParameter("Delete"));
			cartDAO.delete(id);
		}
		
		request.setAttribute("cartlist", cartDAO.list());
		request.setAttribute("orderlist", orderDAO.list());
		request.getRequestDispatcher("/WEB-INF/customer/order.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		CartDAO cartDAO = new CartDAO();
		OrderDAO orderDAO = new OrderDAO();

		for (FoodItem hw4item : cartDAO.list()) {

			
			String name = request.getParameter("customer_name");
			orderDAO.add(new Order(hw4item.getId(), hw4item.getName(), hw4item.getPrice(), name, "IN_QUEUE"));

		}

	
		request.setAttribute("orderlist", orderDAO.list());
		response.sendRedirect(request.getContextPath() + "/h4_status");

	}

}
