package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework2.Order.Statuses;

/**
 * Servlet implementation class EditOrderStatuses
 */
@WebServlet("/admin/order/edit")
public class EditOrderStatuses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderStatuses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orderitems = (List<Order>) getServletContext().getAttribute("orderitems");
		Order leEntry = null;

		for (Order order : orderitems) {
			if (order.getId() == id) {
				leEntry = order;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		out.println("<form method=\"post\">");
		out.println("<select id =\"status\" name = \"status\">");
		out.println("<option value =\"IN_QUEUE\" selected>" + leEntry.statuses.IN_QUEUE + "</option>");
		out.println("<option value =\"IN_PROGRESS\">" + leEntry.statuses.IN_PROGRESS+ "</option>");
		out.println("<option value =\"COMPLETED\">" + leEntry.statuses.COMPLETED + "</option>");
		out.println("</select>");
		out.println("<button>Edit</button>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orderitems = (List<Order>) getServletContext().getAttribute("orderitems");
		Order leEntry = null;
		int index = -1;
		for (int i = 0; i < orderitems.size(); i++) {
			if (orderitems.get(i).getId() == id) {
				leEntry = orderitems.get(i);
				index = i;
			}
			
		}
		
		String status = request.getParameter("status");
		Statuses status2 = Statuses.valueOf(status);

		System.out.println(status);

		orderitems.set(index, new Order(leEntry.getId(), leEntry.getFood(), leEntry.getName(), status2,leEntry.getDate()));
		getServletContext().setAttribute("orderitems", orderitems);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		out.println("Successfully Updated");

		out.println("<a href='http://localhost:8080/cs3220-homework2/admin/orders'>Go back to Orders</a>");

	}

}
