package h4_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editfood
 */
@WebServlet("/h4_admin/h4_foods/edit")
public class editfood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editfood() {
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

		int id = Integer.parseInt(request.getParameter("id"));

		FoodItem edititem = dao.get(id).get();

		request.setAttribute("item", edititem);

		request.getRequestDispatcher("/WEB-INF/admin/edit-food.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		FoodItemDAO dao = new FoodItemDAO();

		FoodItem updated = new FoodItem(Integer.parseInt(request.getParameter("id")),
				request.getParameter("name"), request.getParameter("description"), request.getParameter("image"),
				Double.parseDouble(request.getParameter("price")));
		dao.update(updated);

		response.sendRedirect(request.getContextPath() + "/h4_admin/food");
	}

}
