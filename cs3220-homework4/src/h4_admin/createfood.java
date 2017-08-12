package h4_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createfood
 */
@WebServlet("/h4_admin/foods/new")
public class createfood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createfood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/admin/create-food.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		FoodItemDAO dao = new FoodItemDAO();
		int id = dao.list().size();
		String name = request.getParameter("name");
		System.out.println(name);
		String url = request.getParameter("url");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		dao.add(new FoodItem(id, name, description, url, price));
		
		response.sendRedirect(request.getContextPath() + "/h4_admin/food");
	}

}
