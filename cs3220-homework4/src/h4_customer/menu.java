package h4_customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h4_admin.FoodItem;
import h4_admin.FoodItemDAO;

/**
 * Servlet implementation class menu
 */
@WebServlet("/h4_customer/menu")
public class menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		FoodItemDAO dao = new FoodItemDAO();
		//OrderDAO dao_cart = new OrderDAO();
		CartDAO cartDAO=new CartDAO();
		
		
		if (request.getParameter("Add") != null) {
			int id = Integer.parseInt(request.getParameter("Add"));
			System.out.println(id);
			FoodItem additems = dao.get(id).get();
			cartDAO.add(new FoodItem(additems.getId(), additems.getName(), additems.getDescription(),additems.getUrl(),additems.getPrice()));
		}

		request.setAttribute("list", dao.list());
		request.setAttribute("cartlist", cartDAO.list());

		request.getRequestDispatcher("/WEB-INF/customer/menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
