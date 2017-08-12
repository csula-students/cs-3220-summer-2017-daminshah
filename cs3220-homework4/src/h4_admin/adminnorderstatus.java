package h4_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h4_customer.Order;
import h4_customer.OrderDAO;

/**
 * Servlet implementation class adminnorderstatus
 */
@WebServlet("/h4_admin/h4_status")
public class adminnorderstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminnorderstatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		OrderDAO orderDAO = new OrderDAO();

		request.setAttribute("orderlist", orderDAO.list());
		request.getRequestDispatcher("/WEB-INF/admin/order-status.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		OrderDAO orderDAO = new OrderDAO();
		int id = Integer.parseInt(request.getParameter("change"));

		Order editorder = orderDAO.get(id).get();
		String updatestatus = request.getParameter("status");

		Order order = new Order(id, editorder.getName(), editorder.getFoodprice(),editorder.getCustomername(), updatestatus);
		editorder.setStatus(updatestatus);

		orderDAO.update(order);
		request.setAttribute("orderlist", orderDAO.list());
		request.getRequestDispatcher("/WEB-INF/admin/order-status.jsp").forward(request, response);
	}

}
